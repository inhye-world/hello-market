package inhye.hellomarket.controller;

import inhye.hellomarket.handler.ChatHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    private static final Logger logger = LoggerFactory.getLogger(ChatHandler.class);

    @GetMapping("/chat")
    public String chatGET(){
        logger.info("@ChatController, chatGET()");

        return "chat/chat";
    }
}
