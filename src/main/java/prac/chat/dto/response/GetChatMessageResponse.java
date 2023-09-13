package prac.chat.dto.response;

import lombok.Getter;
import prac.chat.dto.request.ChatMessageRequest;

/**
 * packageName    : prac.chat.dto
 * fileName       : GetChatMessageResponse
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@Getter
public class GetChatMessageResponse {
	private String roomId;
	private String message;
	private Long memberId;
	private String nickName;

	public GetChatMessageResponse(ChatMessageRequest roomMessage) {
		this.roomId = roomMessage.getRoomId();
		this.message = roomMessage.getMessage();
		this.memberId = roomMessage.getMemberId();
		this.nickName = roomMessage.getNickName();
	}
}
