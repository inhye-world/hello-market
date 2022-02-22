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
        return chatRoomMapper.findAllChatroom(username);
    }
}
