package prac.chat.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import prac.chat.exception.ErrorResponse;

/**
 * packageName    : prac.chat.advice
 * fileName       : ExceptionAdvice
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> CustomException(RuntimeException e) {

		ErrorResponse body = ErrorResponse.builder()
			.status("500")
			.message(e.getMessage())
			.build();

		return ResponseEntity.status(500).body(body);
	}


}

