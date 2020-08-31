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
public class TestQuestionDAO {
    private Connection conn;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    
    public TestQuestionDAO(Connection conn) throws SQLException {
        this.conn = conn;
        this.insert = conn.prepareStatement("insert into testQuestion (questionInHungarian, questionInEnglish, answer1, answer2, answer3, rightAnswer, testID) values (?,?,?,?,?,?,?)");
        this.delete = conn.prepareStatement("DELETE FROM testQuestion WHERE testQuestionID = ?");
        this.update = conn.prepareStatement("UPDATE testQuestion SET questionInHungarian = ?, questionInEnglish = ?, answer1 = ?, answer2 = ?, answer3 = ?, rightAnswer = ?, testID = ? WHERE testQuestionID = ?"); 
        this.findAll = conn.prepareStatement("SELECT * FROM testQuestion");
        this.findById = conn.prepareStatement("SELECT * FROM testQuestion WHERE testQuestionID = ?");
    }
    
    public void addQuestion(TestQuestion newQuestion) throws SQLException{
        this.insert.setString(1, newQuestion.getQuestionInHungarian());
        this.insert.setString(2, newQuestion.getQuestionInEnglish());
        this.insert.setString(3, newQuestion.getAnswer1());
        this.insert.setString(4, newQuestion.getAnswer2());
        this.insert.setString(5, newQuestion.getAnswer3());
        this.insert.setString(6, newQuestion.getRightAnswer());
        this.insert.setInt(7, newQuestion.getTestID());
        this.insert.executeUpdate();
    }
    
    public void deleteQuestion(int testQuestionID) throws SQLException {
        this.delete.setInt(1, testQuestionID);
        this.delete.executeUpdate();
    }
    
    public void updateQuestion(TestQuestion question) throws SQLException {
        this.update.setString(1, question.getQuestionInHungarian());
        this.update.setString(2, question.getQuestionInEnglish());
        this.update.setString(3, question.getAnswer1());
        this.update.setString(4, question.getAnswer2());
        this.update.setString(5, question.getAnswer3());
        this.update.setString(6, question.getRightAnswer());
        this.update.setInt(7, question.getTestID());
        this.update.setInt(8, question.getTestQuestionID());
        this.update.executeUpdate();
    }
    
    public List<TestQuestion> findAllQuestion() throws SQLException {
        List<TestQuestion> ret = new ArrayList<>();
        ResultSet rs = this.findAll.executeQuery();
        while (rs.next()) {
            TestQuestion question = makeOneQuestion(rs);
            ret.add(question);
        }
        rs.close();
        return ret;
    }
    
    public TestQuestion findQuestionById(int testQuestionID) throws SQLException {
        this.findById.setInt(1, testQuestionID);
        ResultSet rs = this.findById.executeQuery();
        TestQuestion ret = null;
        if (rs.next()) {
            ret = makeOneQuestion(rs);
        }
        rs.close();
        return ret;
    }
    
    private TestQuestion makeOneQuestion(ResultSet rs) throws SQLException {
        int testQuestionID = rs.getInt("testQuestionID");
        String questionInHungarian = rs.getString("questionInHungarian");
        String questionInEnglish = rs.getString("questionInEnglish");
        String answer1 = rs.getString("answer1");
        String answer2 = rs.getString("answer2");
        String answer3 = rs.getString("answer3");
        String rightAnswer = rs.getString("rightAnswer");
        int testID = rs.getInt("testID");
        TestQuestion question = new TestQuestion(testQuestionID, questionInHungarian, questionInEnglish, answer1, answer2, answer3, rightAnswer, testID); 
        return question;
    }
}
