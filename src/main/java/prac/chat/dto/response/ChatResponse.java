package prac.chat.dto.response;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName    : prac.chat.dto
 * fileName       : ChatResponse
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@Getter
public class ChatResponse {
	private String name;
	private String message;

	@Builder

	public ChatResponse(String name, String message) {
		this.name = name;
		this.message = message;
	}
}
