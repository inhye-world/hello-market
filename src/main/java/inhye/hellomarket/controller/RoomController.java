package inhye.hellomarket.controller;

import inhye.hellomarket.dto.ChatRoom;
import inhye.hellomarket.security.CustomUserDetails;
import inhye.hellomarket.service.ChatRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        String accessId = principal.getUsername();

        model.addAttribute("accessId", accessId);
        model.addAttribute("roomList", chatRoomService.findAllChatroom(accessId));

        return "/chat/chatRooms";
    }

    //제품 정보 창에서 채팅방 개설 name은 작가의 닉네임
    @RequestMapping(value = "/create/room/{anum}/{artist}")
    public String createRoom(@AuthenticationPrincipal CustomUserDetails principal, @PathVariable("artist") String artist, @PathVariable("anum") int anum, Model model) throws Exception {
        String username = principal.getUsername();

        ChatRoom room = chatRoomService.checkChatRoom(username, artist, anum);
        int roomId = room.getRoomId();
        log.info("rooId 확인...."+roomId);
        model.addAttribute("room", chatRoomService.findRoomById(roomId));
        return "/chat/room";
    }

    //채팅방 입장
    @RequestMapping(value = "/room/{roomId}")
    public String enterChat(@PathVariable("roomId") int roomId, Model model) throws Exception {
        log.info("enter chat room.... roomId : "+ roomId);

        model.addAttribute("room", chatRoomService.findRoomById(roomId));

        //List<ChatRoom> chatHistory = chatRoomService.readChatHistory(chatRoomService.findRoomById(roomId));
        //model.addAttribute("chatHistory", chatHistory);
        return "/chat/room";
    }
}
