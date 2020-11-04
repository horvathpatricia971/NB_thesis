/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author horvathpatricia
 */
public class LearnDAO {
    private Connection conn;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    private PreparedStatement saveWords;
    
    public LearnDAO(Connection conn) throws SQLException {
        this.conn = conn;
        this.insert = conn.prepareStatement("INSERT INTO learn (startLearnTime, endLearnTime, userID, topicID) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        this.delete = conn.prepareStatement("DELETE FROM learn WHERE learnID = ?");
        this.update = conn.prepareStatement("UPDATE learn SET startLearnTime =?, endLearnTime = ?, userID = ?, topicID = ? WHERE learnID = ?");
        this.findAll = conn.prepareStatement("SELECT * FROM learn");
        this.findById = conn.prepareStatement("SELECT * FROM learn WHERE learnID = ?");
        this.saveWords = conn.prepareStatement("INSERT INTO learnWord (learnID, wordID) VALUES (?,?)");
    }
    
    public void addLearn(Learn learn) throws SQLException {
        this.insert.setTimestamp(1, learn.getStartLearnTime());
        this.insert.setTimestamp(2, learn.getEndLearnTime());
        this.insert.setInt(3, learn.getUserId());
        this.insert.setInt(4, learn.getTopicId());
        this.insert.executeUpdate();
        try (ResultSet keys = this.insert.getGeneratedKeys()) {
            if (keys.next())
                learn.setLearnId(keys.getInt(1));
            else
                throw new SQLException("Learn ID setting failed.");
        }
    }
    
    public void deleteLearn(int learnID) throws SQLException {
        this.delete.setInt(1, learnID);
        this.delete.executeUpdate();
    }
    
    public void updateLearn(Learn learn) throws SQLException {
        this.update.setTimestamp(1, learn.getStartLearnTime());
        this.update.setTimestamp(2, learn.getEndLearnTime());
        this.update.setInt(3, learn.getUserId());
        this.update.setInt(4, learn.getTopicId());
        this.update.setInt(5, learn.getLearnId());
        this.update.executeUpdate();
    }
    
    public List<Learn> findAllLearn() throws SQLException {
        List<Learn> ret = new ArrayList<>();
        ResultSet rs = this.findAll.executeQuery();
        while (rs.next()) {
            Learn learn = makeOneLearn(rs);
            ret.add(learn);
        }
        rs.close();
        return ret;
    }
    
    public Learn findTestById(int learnID) throws SQLException {
        this.findById.setInt(1, learnID);
        ResultSet rs = this.findById.executeQuery();
        Learn ret = null;
        if (rs.next()) {
            ret = makeOneLearn(rs);
        }
        rs.close();
        return ret;
    }
    
    private Learn makeOneLearn(ResultSet rs) throws SQLException {
        int learnID = rs.getInt("learnID");
        Timestamp startLearnTime = rs.getTimestamp("startLearnTime");
        Timestamp endLearnTime = rs.getTimestamp("endLearnTime");
        int userID = rs.getInt("userID");
        int topicID = rs.getInt("topicID");
        Learn learn = new Learn(learnID, startLearnTime, endLearnTime, userID, topicID); 
        return learn;
    }

    public void saveWords(int learnId, List<Word> words) throws SQLException {
        for (Word word : words) {
            this.saveWords.setInt(1, learnId);
            this.saveWords.setInt(2, word.getWordID());
            this.saveWords.executeUpdate();
        }
    }
}
