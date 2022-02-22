package inhye.hellomarket.mapper;

import inhye.hellomarket.dto.ChatRoom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ChatRoomMapper {

    List<ChatRoom> findAllChatroom(String username);
}
