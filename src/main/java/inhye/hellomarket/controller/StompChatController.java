package inhye.hellomarket.controller;

import inhye.hellomarket.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor
public class StompChatController {

    //특정 broker로 메시지 전달
    private final SimpMessagingTemplate template;

    //client가 send할 수 있는 경로
    //stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    //"/pub/chat/enter" 발행 요청
    @MessageMapping("/chat/enter")
    public void enter(ChatMessage message){
        log.info("enter chat room.....");
        ///client에서 요청한 메세지를 처리하여 "/sub/chat/room/[roomId]"로 전송
        message.setMessage(message.getWriter() + "님이 채팅방에 참여했습니다.");
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping("/chat/message")
    public void message(ChatMessage message){
        //client에서 요청한 메세지를 처리하여 "/sub/chat/room/[roomId]"로 전송
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
