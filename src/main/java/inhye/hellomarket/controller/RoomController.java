package inhye.hellomarket.controller;

import inhye.hellomarket.dto.ChatRoom;
import inhye.hellomarket.security.CustomUserDetails;
import inhye.hellomarket.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Slf4j
public class RoomController {

    ChatRoomService chatRoomService;

    //채팅방 목록조회
    @GetMapping(value = "/rooms")
    public String rooms(@AuthenticationPrincipal CustomUserDetails principal, Model model){
        log.info("# All Chat Rooms");
        String accessId = principal.getUsername();

        List<ChatRoom> chatRoom = chatRoomService.findAllChatroom(accessId);
        model.addAttribute("roomList", chatRoom);

        return "/chat/chatRooms";
    }
}
