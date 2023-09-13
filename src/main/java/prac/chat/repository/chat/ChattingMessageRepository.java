package prac.chat.repository.chat;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import prac.chat.entity.chat.ChatMessage;

/**
 * packageName    : prac.chat.repository.chat
 * fileName       : ChattingRepository
 * author         : MinKyu Park
 * date           : 2023-09-13
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-13        MinKyu Park       최초 생성
 */
@Repository
public interface ChattingMessageRepository extends MongoRepository<ChatMessage,String> {
}
