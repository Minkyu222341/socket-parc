package prac.chat.dto.request;

import lombok.Getter;

/**
 * packageName    : prac.chat.dto.request
 * fileName       : RoomCreateRequest
 * author         : MinKyu Park
 * date           : 2023-09-12
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-12        MinKyu Park       최초 생성
 */
@Getter
public class RoomCreateRequest {
	private String requester;
	private String deliveryMan;
}
