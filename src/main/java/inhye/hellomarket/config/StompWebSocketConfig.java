package inhye.hellomarket.config;

import inhye.hellomarket.handler.ChatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker //Stomp를 사용하기위해 선언하는 어노테이션
//@RequiredArgsConstructor
//@EnableWebSocket
public class StompWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //WebSocket 핸드셰이크 커넥션을 생성할 경로이다.
        registry.addEndpoint("/stomp/chat")
        .setAllowedOrigins("http://localhost:8203");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        ///pub 경로로 시작하는 STOMP 메세지의 "destination" 헤더는 @Controller 객체의 @MessageMapping 메서드로 라우팅된다.
        //client에서 SEND 요청을 처리 Spring docs에서는 /topic, /queue로 나오나 편의상 /pub, /sub로 변경
        config.setApplicationDestinationPrefixes("/pub");
        //해당 경로로 SimpleBroker를 등록. SimpleBroker는 해당하는 경로를 SUBSCRIBE하는 Client에게 메세지를 전달하는 간단한 작업을 수행
        config.enableSimpleBroker("/sub");
    }
}
/*public class WebSocketConfig implements WebSocketConfigurer {
    private final ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
        registry.addHandler(chatHandler, "ws/chat")
                .setAllowedOrigins("http://localhost:8203");
    }
}*/
