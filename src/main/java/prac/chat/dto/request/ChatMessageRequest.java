package prac.chat.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import prac.chat.entity.enumfoler.MessageType;

/**
 * packageName    : prac.chat.dto
 * fileName       : ChatMessageRequest
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@Getter
@Setter
@ToString
public class ChatMessageRequest {
	private String roomId;
	private String message;
	private MessageType type;
	private String nickName;
	private Long memberId;

}
