package prac.chat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
