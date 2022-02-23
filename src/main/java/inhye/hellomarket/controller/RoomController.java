package inhye.hellomarket.controller;

import inhye.hellomarket.dto.ChatRoom;
import inhye.hellomarket.security.CustomUserDetails;
import inhye.hellomarket.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/chat")
@Slf4j
public class RoomController {

    @Autowired
    ChatRoomService chatRoomService;

    //채팅방 목록조회
    @GetMapping(value = "/rooms")
    public String rooms(@AuthenticationPrincipal CustomUserDetails principal, Model model){
        log.info("# All Chat Rooms");
        String accessId = principal.getUsername();

        model.addAttribute("roomList", chatRoomService.findAllChatroom(accessId));

        return "/chat/chatRooms";
    }

    //채팅방 개설
    @PostMapping(value = "/room")
    public String createRoom(@RequestParam String name, RedirectAttributes rttr){
        log.info("채팅방 개설");
        chatRoomService.createChatRoom(name);
        rttr.addAttribute("roomName", name);
        return "redirect:/chat/chatRooms";
    }

    //채팅방 입장
    @RequestMapping(value = "/enterRoom/{roomId}")
    public String enterChat(@PathVariable("roomId") int roomId, Model model) throws Exception {
        log.info("enter chat room.... roomId : "+ roomId);

        model.addAttribute("room", chatRoomService.findRoomById(roomId));
        return "/chat/chatRoom";
    }
}
