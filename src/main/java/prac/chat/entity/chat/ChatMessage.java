package prac.chat.entity.chat;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
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
@Document(collation = "chat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessage {
	@Id
	private String id;
	private Integer chatRoomNo;
	private Integer senderNo;
	private String senderName;
	private String contentType;
	private String content;
	private LocalDateTime sendDate;
	private long readCount;

	@Builder
	public ChatMessage(String id, Integer chatRoomNo, Integer senderNo, String senderName, String contentType,
		String content, LocalDateTime sendDate, long readCount) {
		this.id = id;
		this.chatRoomNo = chatRoomNo;
		this.senderNo = senderNo;
		this.senderName = senderName;
		this.contentType = contentType;
		this.content = content;
		this.sendDate = sendDate;
		this.readCount = readCount;
	}

}
