package inhye.hellomarket.dto;

import org.springframework.web.socket.WebSocketSession;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class ChatRoom {
    public String username;
    public int roomId;
    public String artist;
    public int anum;
    public String fileName;
    private Timestamp createdDate;
    private String roomTitle;

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getAnum() {
        return anum;
    }

    public void setAnum(int anum) {
        this.anum = anum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    private Set<WebSocketSession> sessions = new HashSet<>();
}
