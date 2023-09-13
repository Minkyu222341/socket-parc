package prac.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import prac.chat.dto.request.ChatMessageRequest;
import prac.chat.dto.request.RoomCreateRequest;
import prac.chat.entity.api.Member;
import prac.chat.exception.UserNotFoundException;
import prac.chat.repository.api.MemberRepository;
import prac.chat.service.ChatMessageService;

/**
 * packageName    : prac.chat.controller
 * fileName       : ChatMessageController
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@RequiredArgsConstructor
@Controller
public class ChatMessageController {

	private final ChatMessageService chatMessageService;
	private final MemberRepository memberRepository;
	private final SimpMessageSendingOperations sendingOperations;

	@MessageMapping("/chat/message")
	public void message(ChatMessageRequest chatMessageRequest) {

		Member member = memberRepository.findById(chatMessageRequest.getMemberId()).orElseThrow(UserNotFoundException::new);
		chatMessageService.sendMessage(chatMessageRequest, member);

		sendingOperations.convertAndSend("/sub/" + chatMessageRequest.getRoomId(), chatMessageRequest.getMessage());
	}

	@PostMapping("/room")
	public void createRoom(@RequestBody RoomCreateRequest request) {
		chatMessageService.createChattingRoom(request);
	}
}