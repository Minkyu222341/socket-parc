package prac.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import lombok.RequiredArgsConstructor;

/**
 * packageName    : prac.chat.stomp
 * fileName       : WebSocketConfig
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	// private final StompHandler

	// STOMP 엔드포인트를 등록하는 메서드
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat").setAllowedOriginPatterns("*");
	}

	// 메시지 브로커를 구성하는 메서드
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/sub");//발행자가 "/topic"의 경로로 메시지를 주면 구독자들에게 전달
		config.setApplicationDestinationPrefixes("/pub");  // 발행자가 "/app"의 경로로 메시지를 주면 가공을 해서 구독자들에게 전달
	}

	// 클라이언트 인바운드 채널을 구성하는 메서드
	// @Override
	// public void configureClientInboundChannel(ChannelRegistration registration) {
	// 	// stompHandler를 인터셉터로 등록하여 STOMP 메시지 핸들링을 수행
	// 	registration.interceptors(stompHandler);
	// }

	// STOMP에서 64KB 이상의 데이터 전송을 못하는 문제 해결
	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
		registry.setMessageSizeLimit(160 * 64 * 1024);
		registry.setSendTimeLimit(100 * 10000);
		registry.setSendBufferSizeLimit(3 * 512 * 1024);
	}

}