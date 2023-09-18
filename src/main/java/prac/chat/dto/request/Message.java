package prac.chat.dto.request;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import prac.chat.entity.chat.ChatMessage;

/**
 * packageName    : prac.chat.dto.request
 * fileName       : Message
 * author         : MinKyu Park
 * date           : 2023-09-18
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-18        MinKyu Park       최초 생성
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

	private String id;

	@NotNull
	private Integer chatNo;

	@NotNull
	private String contentType;

	@NotNull
	private String content;

	private String senderName;

	private Integer senderNo;

	@NotNull
	private Integer saleNo;

	private long sendTime;
	private Integer readCount;
	private String senderEmail;

	public void setSendTimeAndSender(LocalDateTime sendTime, Integer senderNo, String senderName, Integer readCount) {
		this.senderName = senderName;
		this.sendTime = sendTime.atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli();
		this.senderNo = senderNo;
		this.readCount = readCount;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ChatMessage convertEntity() {
		return ChatMessage.builder()
			.senderName(senderName)
			.senderNo(senderNo)
			.chatRoomNo(chatNo)
			.contentType(contentType)
			.content(content)
			.sendDate(Instant.ofEpochMilli(sendTime).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime())
			.readCount(readCount)
			.build();
	}
}