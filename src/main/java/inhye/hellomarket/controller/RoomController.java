package inhye.hellomarket.controller;

import inhye.hellomarket.security.CustomUserDetails;
import inhye.hellomarket.service.ChatRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        log.info("owner : "+accessId);
        model.addAttribute("roomList", chatRoomService.findAllChatroom(accessId));

        return "/chat/chatRooms";
    }

    //채팅방 개설
    @PostMapping(value = "/room")
    public String createRoom(@RequestParam String name, Model model){
        log.info("채팅방 개설");
        chatRoomService.createChatRoom(name);
        model.addAttribute("roomName", name);
        return "redirect:/chat/chatRooms";
    }

    //채팅방 입장
    @RequestMapping(value = "/room/{roomId}")
    public String enterChat(@PathVariable("roomId") int roomId, Model model) throws Exception {
        log.info("enter chat room.... roomId : "+ roomId);

        model.addAttribute("room", chatRoomService.findRoomById(roomId));
        return "/chat/room";
    }
}
