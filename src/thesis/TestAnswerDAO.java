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
public class TestAnswerDAO {
    private Connection conn;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    
    public TestAnswerDAO(Connection conn) throws SQLException{
        this.conn = conn;
        this.insert = conn.prepareStatement("INSERT INTO testAnswer (userAnswer, isRight, testAttemptID, testQuestionID) values (?,?,?,?)");
        this.delete = conn.prepareStatement("DELETE FROM testAnswer WHERE testAnswerID = ?");
        this.update = conn.prepareStatement("UPDATE tests SET userAnswer = ?, isRight = ?, testAttemptID = ?, testQuestionID = ? WHERE testAnswerID = ?");
        this.findAll = conn.prepareStatement("SELECT * FROM testAnswer");
        this.findById = conn.prepareStatement("SELECT * FROM testAnswer WHERE testAnswerID = ?");
    }
    
    public void addAnswer(TestAnswer newAnswer) throws SQLException {
        this.insert.setString(1, newAnswer.getUserAnswer());
        this.insert.setInt(2, newAnswer.getIsRight());
        this.insert.setInt(3, newAnswer.getTestAttemptID());
        this.insert.setInt(4, newAnswer.getTestQuestionID());
        this.insert.executeUpdate();
    }
        
    public void deleteAnswer(int testAnswerID) throws SQLException {
        this.delete.setInt(1, testAnswerID);
        this.delete.executeUpdate();
    }
    
    public void updateAnswer(TestAnswer answer) throws SQLException {
        this.update.setString(1, answer.getUserAnswer());
        this.update.setInt(2, answer.getIsRight());
        this.update.setInt(3, answer.getTestAttemptID());
        this.update.setInt(4, answer.getTestQuestionID());
        this.update.setInt(5, answer.getTestAnswerID());
        this.update.executeUpdate();
    }
    
    public List<TestAnswer> findAllAnswer() throws SQLException {
        List<TestAnswer> ret = new ArrayList<>();
        ResultSet rs = this.findAll.executeQuery();
        while (rs.next()) {
            TestAnswer answer = makeOneAnswer(rs);
            ret.add(answer);
        }
        rs.close();
        return ret;
    }
    
    public TestAnswer findAnswerById(int testAnswerID) throws SQLException {
        this.findById.setInt(1, testAnswerID);
        ResultSet rs = this.findById.executeQuery();
        TestAnswer ret = null;
        if (rs.next()) {
            ret = makeOneAnswer(rs);
        }
        rs.close();
        return ret;
    }
    
    private TestAnswer makeOneAnswer(ResultSet rs) throws SQLException {
        int testAnswerID = rs.getInt("testAnswerID");
        String userAnswer = rs.getString("userAnswer");
        int isRight = rs.getInt("isRight");
        int testAttemptID = rs.getInt("testAttemptID");
        int testQuestionID = rs.getInt("testQuestionID");
        
        TestAnswer answer = new TestAnswer(testAnswerID, userAnswer, isRight, testAttemptID, testQuestionID); 
        return answer;
    }
}
