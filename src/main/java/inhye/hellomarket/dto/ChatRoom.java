package inhye.hellomarket.dto;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

public class ChatRoom {
    public String username;
    public int roomId;
    public String name;
    private Set<WebSocketSession> sessions = new HashSet<>();
}
