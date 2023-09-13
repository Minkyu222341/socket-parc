package prac.chat.entity.chat;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import prac.chat.entity.api.ChatRoom;
import prac.chat.entity.api.Member;

/**
 * packageName    : prac.chat.entity
 * fileName       : ChatMessage
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@Document(collation = "chat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessage {
	@Id
	private String id;
	private String message;
	private String sender;
	@ManyToOne
	private ChatRoom chatRoom;
	@ManyToOne
	private Member member;

	@Builder
	public ChatMessage(String message, String sender, ChatRoom chatRoom, Member member) {
		this.message = message;
		this.sender = sender;
		this.chatRoom = chatRoom;
		this.member = member;
	}
}
