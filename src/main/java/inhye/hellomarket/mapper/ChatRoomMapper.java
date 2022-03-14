package inhye.hellomarket.mapper;

import inhye.hellomarket.dto.ChatRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@Mapper
public interface ChatRoomMapper {

    List<ChatRoom> findAllChatroom(String username);

    ChatRoom findRoomById(int roomId);

    void createChatRoom(@Param("username") String username, @Param("artist") String artist, @Param("anum") int anum);

    ChatRoom findRoomByRoomInfo(@Param("username") String username, @Param("artist") String artist, @Param("anum") int anum);

    void updateFileName(@Param("fileName") String fileName, @Param("username") String username, @Param("artist") String artist, @Param("anum") int anum);
}
