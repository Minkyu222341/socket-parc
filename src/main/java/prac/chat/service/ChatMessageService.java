package prac.chat.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import prac.chat.dto.request.ChatMessageRequest;
import prac.chat.dto.request.RoomCreateRequest;
import prac.chat.entity.api.ChatRoom;
import prac.chat.entity.api.Member;
import prac.chat.entity.chat.ChatMessage;
import prac.chat.exception.ChatRoomNotFoundException;
import prac.chat.repository.api.ChatRoomRepository;
import prac.chat.repository.chat.ChattingMessageRepository;

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
	private final ChattingMessageRepository chatMessageRepository;
	// private final ChannelTopic channelTopic;
	// private final RedisTemplate redisTemplate;

	@Transactional
	public void sendMessage(ChatMessageRequest req, Member member) {
		// public List<ChatResponse> sendMessage(ChatMessageRequest chatMessageRequest, Member member) {
		ChatRoom chatRoom = chatRoomRepository.findById(req.getRoomId()).orElseThrow(
			ChatRoomNotFoundException::new);

		//채팅 생성 및 저장
		ChatMessage chatMessage = ChatMessage.builder()
			.chatRoom(chatRoom)
			.member(member)
			.message(req.getMessage())
			.build();

		chatMessageRepository.insert(chatMessage);

		// String topic = channelTopic.getTopic();

		// ChatMessageRequest에 유저정보, 현재시간 저장
		// req.setNickName(member.getName());
		// req.setMemberId(member.getId());

		// redisTemplate.convertAndSend(topic, chatMessageRequest);

	}

	public void createChattingRoom(RoomCreateRequest request) {

	}
}