package prac.chat.exception;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName    : prac.chat.exception
 * fileName       : ErrorResponse
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@Getter
public class ErrorResponse {
	private String status;
	private String message;

	@Builder

	public ErrorResponse(String status, String message) {
		this.status = status;
		this.message = message;
	}
}
