// package prac.chat.simple;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.socket.WebSocketHandler;
// import org.springframework.web.socket.config.annotation.EnableWebSocket;
// import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
// import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
// /**
//  * packageName    : prac.chat.text
//  * fileName       : PureWebSocketConfig
//  * author         : MinKyu Park
//  * date           : 2023-09-08
//  * description    :
//  * ===========================================================
//  * DATE              AUTHOR             NOTE
//  * -----------------------------------------------------------
//  * 2023-09-08        MinKyu Park       최초 생성
//  */
// @Configuration
// @EnableWebSocket
// public class PureWebSocketConfig implements WebSocketConfigurer {
// 	@Override
// 	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
// 		registry.addHandler(myHandler(), "/myHandler");
// 	}
//
// 	@Bean
// 	public WebSocketHandler myHandler() {
// 		return new MyHandler();
// 	}
// }