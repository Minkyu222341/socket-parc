package prac.chat.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import prac.chat.dto.ChatMessageRequest;
import prac.chat.entity.ChatMessage;
import prac.chat.entity.ChatRoom;
import prac.chat.entity.Member;
import prac.chat.exception.ChatRoomNotFoundException;
import prac.chat.repository.ChatMessageRepository;
import prac.chat.repository.ChatRoomRepository;

/**
 * packageName    : prac.chat.service
 * fileName       : ChatMessageService
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@Service
@RequiredArgsConstructor
public class ChatMessageService {

	private final ChatRoomRepository chatRoomRepository;
	private final ChatMessageRepository chatMessageRepository;
	private final ChannelTopic channelTopic;
	private final RedisTemplate redisTemplate;

	@Transactional
	public void sendMessage(ChatMessageRequest chatMessageRequest, Member member) {
		// public List<ChatResponse> sendMessage(ChatMessageRequest chatMessageRequest, Member member) {
		ChatRoom chatRoom = chatRoomRepository.findById(chatMessageRequest.getRoomId()).orElseThrow(
			ChatRoomNotFoundException::new);

		//채팅 생성 및 저장
		ChatMessage chatMessage = ChatMessage.builder()
			.chatRoom(chatRoom)
			.member(member)
			.message(chatMessageRequest.getMessage())
			.build();

		System.err.println(chatMessageRequest.toString());

		chatMessageRepository.save(chatMessage);

		String topic = channelTopic.getTopic();

		// ChatMessageRequest에 유저정보, 현재시간 저장
		chatMessageRequest.setNickName(member.getName());
		chatMessageRequest.setMemberId(member.getId());

		redisTemplate.convertAndSend(topic, chatMessageRequest);

	}
}
