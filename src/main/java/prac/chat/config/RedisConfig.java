package prac.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import prac.chat.service.RedisSubscriber;

/**
 * packageName    : prac.chat.config
 * fileName       : RedisConfig
 * author         : MinKyu Park
 * date           : 2023-09-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-09-08        MinKyu Park       최초 생성
 */
@Configuration
public class RedisConfig {

	/**
	 * (1) RedisMessageListenerContainer는 Redis Channel(Topic)로 부터 메시지를 받고,
	 * 주입된 리스너들에게 비동기적으로 dispatch 하는 역할을 수행하는 컨테이너이다.
	 * 즉, 발행된 메시지 처리를 위한 리스너들을 설정할 수 있다.
	 * */
	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory,
		                                                               MessageListenerAdapter listenerAdapter,
																	   ChannelTopic channelTopic) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, channelTopic);

		return container;
	}

	/**
	 * (2) MessageListenerAdaper에서는 RedisMessageListenerContainer로부터 메시지를 dispatch 받고,
	 * 실제 메시지를 처리하는 비즈니스 로직이 담긴 Subscriber Bean을 추가해준다.
	 * */
	@Bean
	public MessageListenerAdapter listenerAdapter(RedisSubscriber subscriber) {
		return new MessageListenerAdapter(subscriber, "onMessage");
	}


	/**
	 * 3) Redis서버와 상호작용하기 위한 RedisTemplate 관련 설정을 해준다. Redis 서버에는 bytes 코드만이 저장되므로 key와 value에 Serializer를 설정해준다.
	 * Json 포맷 형식으로 메시지를 교환하기 위해 ValueSerializer에 Jackson2JsonRedisSerializer로 설정해준다.
	 * */
	@Bean
	public RedisTemplate<String, Object> redisTemplate
		(RedisConnectionFactory connectionFactory) { // (3)
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(String.class));
		return redisTemplate;
	}

	/**
	 * (4) Topic 공유를 위해 Channel Topic을 빈으로 등록해 단일화 시켜준다.
	 * */
	@Bean
	public ChannelTopic channelTopic() { // (4)
		return new ChannelTopic("chatroom");
	}
}
