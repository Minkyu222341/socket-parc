package prac.chat.stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


/**
 * packageName    : prac.chat.stomp
 * fileName       : ChatController
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */


@Controller
public class ChatController {

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public ChatMessage sendMessage(ChatMessage message) {
		System.out.println(message);
		return message;
	}
}
