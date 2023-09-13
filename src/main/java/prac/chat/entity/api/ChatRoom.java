package prac.chat.entity.api;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * packageName    : prac.chat.entity
 * fileName       : ChatRoom
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
public class ChatRoom {
	@Id
	private String roomId;
}
