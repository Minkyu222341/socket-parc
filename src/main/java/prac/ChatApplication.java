package prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
// @EnableJpaRepositories(basePackages = "prac.chat.repository.api")
@EnableMongoRepositories(basePackages = "prac.chat.repository.chat")
public class ChatApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

}


// TODO :
//  1. PostgreSQL 과  MongoDB MultiConnection
//  2. Websocket , Stomp 를 이용해서 실시간 채팅 기능 구현
//  3. Member 및 Room의 정보는 PostgreSQL에 저장 , 채팅 메시지에 대한 정보는 MongoDB에 저장
//      -> 현재는 어플리케이션을 분리하지 않았지만 실제 프로젝트에서는 채팅 서버를 별도로 만들어서
//        USER - ELB -  CLIENT - ELB
//                                 - SocketServer - MongoDB
//                     			   - APIServer - PostgreSQL
//    위의 구조로 구성할 예정
//      -> 최초 채팅방이 개설 될 때 해당 정보는 RDB에 저장 ,
//         IO가 빈번한 채팅 메시지에 대한 정보는 SocketServer 를 호출 하여 MongoDB에 저장
