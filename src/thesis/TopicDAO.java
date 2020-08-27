/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author horvathpatricia
 */
public class TopicDAO {
    private Connection conn;
    private PreparedStatement topicInsert;
    private PreparedStatement topicDelete;
    private PreparedStatement topicUpdate;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    
    
    public TopicDAO(Connection conn) throws SQLException {
        this.conn = conn;
        // TODO: adatbázis és program legyen azonos:
        this.topicInsert = conn.prepareStatement("insert into topic (topic, numberOfWords, images, sound, difficulty) values (?,?,?,?,?)");
        this.topicDelete = conn.prepareStatement("DELETE FROM topic WHERE topicID = ?");
        this.topicUpdate = conn.prepareStatement("UPDATE topic SET numberOfWords = ?, ... WHERE topicID = ?");
        this.findAll = conn.prepareStatement("SELECT * FROM topic");
        this.findById = conn.prepareStatement("SELECT * FROM topic WHERE topicID = ?");
    }
    
    public void addTopic(Topic newTopic) throws SQLException {
        this.topicInsert.setString(1, newTopic.getTopic());
        this.topicInsert.setInt(2, newTopic.getNumberOfWords());
        this.topicInsert.setBoolean(3, newTopic.getImage());
        this.topicInsert.setBoolean(4, newTopic.getSound());
        this.topicInsert.setInt(5, newTopic.getDifficulty());
        this.topicInsert.executeUpdate();
    }
    
    public void deleteTopic(int topicID) throws SQLException {
        this.topicDelete.setInt(1, topicID);
        this.topicDelete.executeUpdate();
    }
     
    public void updateTopic(Topic topic) throws SQLException {
        this.topicUpdate.setString(1, topic.getTopic());
        this.topicUpdate.setInt(2, topic.getNumberOfWords());
        this.topicUpdate.setBoolean(3, topic.getImage());
        this.topicUpdate.setBoolean(4, topic.getSound());
        this.topicUpdate.setInt(5, topic.getDifficulty());
        this.topicUpdate.executeUpdate();
    }
    
    public List<Topic> findAllTopic() throws SQLException {
        List<Topic> ret = new ArrayList<>();
        ResultSet rs = this.findAll.executeQuery();
        while (rs.next()) {
            Topic topic = makeOneTopic(rs);
            ret.add(topic);
        }
        rs.close();
        return ret;
    }
    
    public Topic findTopicById(int topicID) throws SQLException {
        this.findById.setInt(1, topicID);
        ResultSet rs = this.findById.executeQuery();
        Topic ret = null;
        if (rs.next()) {
            ret = makeOneTopic(rs);
        }
        rs.close();
        return ret;
    }
    
    private Topic makeOneTopic(ResultSet rs) throws SQLException {
        int topicID = rs.getInt("topicID");
        String topic = rs.getString("topic");
        int numberOfWords = rs.getInt("numberOfWords");
        Boolean image = rs.getBoolean("image");
        Boolean sound = rs.getBoolean("sound");
        int difficulty = rs.getInt("difficulty");
        
        Topic topics = new Topic(topicID, topic, numberOfWords, image, sound, difficulty); 
        return topics;
    }
}
