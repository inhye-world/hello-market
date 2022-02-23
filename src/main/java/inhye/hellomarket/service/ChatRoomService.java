package inhye.hellomarket.service;

import inhye.hellomarket.dto.ChatRoom;
import inhye.hellomarket.mapper.ChatRoomMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ChatRoomService {
    @Autowired
    ChatRoomMapper chatRoomMapper;

    public List<ChatRoom> findAllChatroom(String username){
        log.info(username,"의 채팅목록 조회");
        return chatRoomMapper.findAllChatroom(username);
    }

    public void createChatRoom(String name) {
    }

    public ChatRoom findRoomById(int roomId) throws Exception{
        log.info("채팅방 보기");
        return chatRoomMapper.findRoomById(roomId);
    }
}
