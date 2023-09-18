// package prac.chat.simple;
//
// import org.springframework.web.socket.CloseStatus;
// import org.springframework.web.socket.TextMessage;
// import org.springframework.web.socket.WebSocketSession;
// import org.springframework.web.socket.handler.TextWebSocketHandler;
//
// /**
//  * packageName    : prac.chat.text
//  * fileName       : MyHandler
//  * author         : MinKyu Park
//  * date           : 2023-09-08
//  * description    :
//  * ===========================================================
//  * DATE              AUTHOR             NOTE
//  * -----------------------------------------------------------
//  * 2023-09-08        MinKyu Park       최초 생성
//  */
// public class MyHandler extends TextWebSocketHandler {
// 	@Override
// 	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
// 		System.out.println(message);
// 		System.out.println(message.getPayload());
// 	}
//
// 	@Override
// 	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
// 		System.out.println("afterConnectionEstablished:" + session.toString());
// 	}
//
// 	@Override
// 	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
// 		super.afterConnectionClosed(session, status);
// 	}
// }
