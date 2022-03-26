package inhye.hellomarket.service;

import inhye.hellomarket.dto.ChatMessage;
import inhye.hellomarket.dto.ChatRoom;
import inhye.hellomarket.mapper.ChatRoomMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ChatRoomService {
    @Autowired
    ChatRoomMapper chatRoomMapper;

    @Value("${spring.servlet.multipart.location}")
    String fileUploadPath;

    public List<ChatRoom> findAllChatroom(String username){
        log.info(username+"의 채팅목록 조회");
        return chatRoomMapper.findAllChatroom(username);
    }

    public ChatRoom checkChatRoom(String username, String artist, int anum) throws IOException {
        //해당 의뢰건에 대해 사용자와 작가간에 채팅창이 있다면 만들지 않고 입장
        if(chatRoomMapper.findRoomByRoomInfo(username, artist, anum) == null){
            chatRoomMapper.createChatRoom(username, artist, anum);
            createChatFile(username, artist, anum);
        }
        return chatRoomMapper.findRoomByRoomInfo(username, artist, anum);
    }

    private void createChatFile(String username, String artist, int anum) throws IOException {
        String fileName = username + "_" + artist + "_" + anum + ".txt";
        String pathName = fileUploadPath + fileName;
        //File 클래스에 pathName 할당

        log.info("fileUploadPath : " + fileUploadPath);
        log.info("pathName : " + pathName);
        File txtFile = new File(pathName);
        //로컬경로에 파일 생성
        txtFile.createNewFile();
        updateFileName(fileName, username, artist, anum);
    }

    public void updateFileName(String fileName, String username, String artist, int anum) {
        chatRoomMapper.updateFileName(fileName, username, artist, anum);
    }

    public ChatRoom findRoomById(int roomId) throws Exception{
        return chatRoomMapper.findRoomById(roomId);
    }

    public List<ChatMessage> readChatHistory(ChatRoom chatRoom) throws IOException {
        String pathName = fileUploadPath + chatRoom.getFileName();

        log.info("채팅 히스토리 불러오기 : "+pathName);

        BufferedReader br = new BufferedReader(new FileReader(pathName));
        ChatMessage MessageLines = new ChatMessage();
        List<ChatMessage> chatHistory = new ArrayList<ChatMessage>();

        String chatLine;
        int idx = 1;

        while ((chatLine = br.readLine())!= null) {
            int answer = idx % 2;
            if (answer == 1) {
                //보낸사람
                MessageLines.setWriter(chatLine);
                log.info("writer : "+chatLine);
                idx++;
            } else {
                //메시지내용
                MessageLines.setMessage(chatLine);
                log.info("message : " + chatLine);
                chatHistory.add(MessageLines);
                MessageLines = new ChatMessage();
                idx = 1;
            }
        }
        return chatHistory;
    }

    public void appendMessage(ChatMessage message) throws IOException{
        int roomId = Integer.parseInt(message.getRoomId());

        ChatRoom chatRoomAppend = chatRoomMapper.findRoomById(roomId);

        String pathName = fileUploadPath + chatRoomAppend.getFileName();

        FileOutputStream fos = new FileOutputStream(pathName, true);
        String content = message.getMessage();
        String senderName = message.getWriter();

        log.info(senderName +" : " + content);

        String writeContent = senderName + "\n" + content + "\n";

        byte[] b = writeContent.getBytes(StandardCharsets.UTF_8);
        fos.write(b);
        fos.close();
    }
}
