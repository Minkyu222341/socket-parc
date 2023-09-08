package prac.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prac.chat.entity.ChatMessage;

/**
 * packageName    : prac.chat.repository
 * fileName       : ChatMessageRepository
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {
}
