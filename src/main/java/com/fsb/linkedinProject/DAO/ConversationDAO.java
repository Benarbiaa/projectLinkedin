package com.fsb.linkedinProject.DAO;

import com.fsb.linkedinProject.Models.Competence;
import com.fsb.linkedinProject.Models.User;
import com.fsb.linkedinProject.Models.Experience;
import com.fsb.linkedinProject.Models.Message;
import com.fsb.linkedinProject.utils.ConxDB;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConversationDAO {
    private static final Connection conn = ConxDB.getInstance();

    public static List<Message> getMessages(User sender , User receiver){
        ResultSet rs;

        int senderId = sender.getIdUser();
        int receiverId = receiver.getIdUser();
        List<Message> messagesList = new ArrayList<>();
        PreparedStatement ps = null;
        String SQL = "SELECT * FROM messages WHERE id_sender = ? AND id_receiver = ?;";

        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1,senderId);
            ps.setInt(2,receiverId);

            rs = ps.executeQuery();
            while(rs.next()) {
                int idMessage = rs.getInt(1);
                String text = rs.getString(4);
                LocalDateTime date = (LocalDateTime) rs.getObject(5);
                Message msg = new Message(idMessage,sender,receiver,text,date);
                messagesList.add(msg);


            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return messagesList;
    }

    public static int sendMessage(Message message) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO messages (id_sender,id_receiver,text,date) VALUES(?,?,?,?)";
        pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, message.getSender().getIdUser());
        pstmt.setInt(2, message.getReceiver().getIdUser());
        pstmt.setString(3, message.getText());
        pstmt.setObject(4, message.getDate());
        pstmt.executeUpdate();
        rs = pstmt.getGeneratedKeys();
        System.out.println(message.getSender());
        System.out.println(message.getReceiver());


        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
