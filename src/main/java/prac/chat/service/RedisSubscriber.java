package prac.chat.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import prac.chat.dto.request.ChatMessageRequest;
import prac.chat.dto.response.GetChatMessageResponse;
import prac.chat.entity.enumfoler.MessageType;
import prac.chat.exception.ChatMessageNotFoundException;

/**
 * packageName    : prac.chat.service
 * fileName       : RedisSubscriber
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class RedisSubscriber implements MessageListener {
	private final ObjectMapper objectMapper;
	private final RedisTemplate redisTemplate;
	private final SimpMessageSendingOperations messagingTemplate;

	@Override
	public void onMessage(Message message, byte[] pattern) {
		try {
			String publishMessage = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());

			ChatMessageRequest roomMessage = objectMapper.readValue(publishMessage, ChatMessageRequest.class);

			if (roomMessage.getType().equals(MessageType.TALK)) {
				GetChatMessageResponse chatMessageResponse = new GetChatMessageResponse(roomMessage);
				messagingTemplate.convertAndSend("/sub/chat/room/" + roomMessage.getRoomId(), chatMessageResponse);
			}


		} catch (Exception e) {
			throw new ChatMessageNotFoundException();
		}
	}
}