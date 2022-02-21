package inhye.hellomarket.controller;

import inhye.hellomarket.security.CustomUserDetails;
import inhye.hellomarket.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ChatController {

    @Autowired
    MemberService memberService;

    @GetMapping("/chat")
    public String chatGET(@AuthenticationPrincipal CustomUserDetails principal, Model model){
        log.info("@ChatController, chatGET()");
        String accessId = principal.getUsername();
        log.info("accessId......"+accessId);

        model.addAttribute("username", accessId);

        return "chat/chat";
    }
}
