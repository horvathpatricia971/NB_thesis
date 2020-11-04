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
    private PreparedStatement findByTestId;
    private PreparedStatement findByLastLearn;
    private PreparedStatement findWrongByTestAttemptId;
    
    public TestQuestionDAO(Connection conn) throws SQLException {
        this.conn = conn;
        this.insert = conn.prepareStatement("insert into testQuestion (questionInHungarian, questionInEnglish, answer1, answer2, answer3, rightAnswer, answer1hun, answer2hun, answer3hun, picture1, picture2, picture3, testID) values (?,?,?,?,?,?,?,?)");
        this.delete = conn.prepareStatement("DELETE FROM testQuestion WHERE testQuestionID = ?");
        this.update = conn.prepareStatement("UPDATE testQuestion SET questionInHungarian = ?, questionInEnglish = ?, answer1 = ?, answer2 = ?, answer3 = ?, rightAnswer = ?, answer1hun = ?, answer2hun = ?, answer3hun = ?, rightAnswerHun = ?, questionNum =?, testID = ? WHERE testQuestionID = ?"); 
        this.findAll = conn.prepareStatement("SELECT * FROM testQuestion");
        this.findById = conn.prepareStatement("SELECT * FROM testQuestion WHERE testQuestionID = ?");
        this.findByTestId = conn.prepareStatement("SELECT * FROM testQuestion WHERE testID = ?");
        this.findByLastLearn = conn.prepareStatement(
                "SELECT * FROM (SELECT * from language_db.learn WHERE userID = ? AND topicID = ? ORDER BY learnID DESC LIMIT 1) as learn1 "
                        + "JOIN learnWord ON learn1.learnID = learnWord.learnID "
                        + "JOIN word ON learnWord.wordID = word.wordID "
                        + "JOIN wordTestQuestion ON word.wordID = wordTestQuestion.wordID "
                        + "JOIN testQuestion ON wordTestQuestion.testQuestionID = testQuestion.testQuestionID");
        this.findWrongByTestAttemptId = conn.prepareStatement(
                "SELECT * FROM testAnswer JOIN testQuestion ON testAnswer.testQuestionID = testQuestion.testQuestionID "
                        + "WHERE testAnswer.isRight = 0 AND testAnswer.testAttemptID = ?");
    }
    
    public void addQuestion(TestQuestion newQuestion) throws SQLException{
        this.insert.setString(1, newQuestion.getQuestionInHungarian());
        this.insert.setString(2, newQuestion.getQuestionInEnglish());
        this.insert.setString(3, newQuestion.getAnswer1());
        this.insert.setString(4, newQuestion.getAnswer2());
        this.insert.setString(5, newQuestion.getAnswer3());
        this.insert.setString(6, newQuestion.getRightAnswer());
        this.insert.setString(7, newQuestion.getAnswer1hun());
        this.insert.setString(8, newQuestion.getAnswer2hun());
        this.insert.setString(9, newQuestion.getAnswer3hun());
        this.insert.setString(10, newQuestion.getPicture1());
        this.insert.setString(11, newQuestion.getPicture2());
        this.insert.setString(12, newQuestion.getPicture3());
        this.insert.setInt(13, newQuestion.getTestID());
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
        this.update.setString(7, question.getAnswer1hun());
        this.update.setString(8, question.getAnswer2hun());
        this.update.setString(9, question.getAnswer3hun());
        this.insert.setString(10, question.getPicture1());
        this.insert.setString(11, question.getPicture2());
        this.insert.setString(12, question.getPicture3());
        this.update.setInt(13, question.getTestID());
        this.update.setInt(14, question.getTestQuestionID());
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
    
    public List<TestQuestion>  findQuestionByTestId(int testID) throws SQLException {
        List<TestQuestion> ret = new ArrayList<>();
        this.findByTestId.setInt(1, testID);
        ResultSet rs = this.findByTestId.executeQuery();
        
        while (rs.next()) {
            ret.add(makeOneQuestion(rs));
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
        String answer1hun = rs.getString("answer1hun");
        String answer2hun = rs.getString("answer2hun");
        String answer3hun = rs.getString("answer3hun");
        String picture1 = rs.getString("picture1");
        String picture2 = rs.getString("picture2");
        String picture3 = rs.getString("picture3");
        int testID = rs.getInt("testID");
        TestQuestion question = new TestQuestion(testQuestionID, questionInHungarian, questionInEnglish, answer1, answer2, answer3, rightAnswer, answer1hun, answer2hun, answer3hun, picture1, picture2, picture3, testID); 
        return question;
    }

    public List<TestQuestion> findQuestionByLastLearn(int userId, int topicId) throws SQLException {
        List<TestQuestion> ret = new ArrayList<>();
        this.findByLastLearn.setInt(1, userId);
        this.findByLastLearn.setInt(2, topicId);
        ResultSet rs = this.findByLastLearn.executeQuery();
        while (rs.next()) {
            ret.add(makeOneQuestion(rs));
        }
        rs.close();
        return ret;
    }
    
    public List<TestQuestion> findWrongByTestAttempt(int testAttemptId) throws SQLException {
        List<TestQuestion> ret = new ArrayList<>();
        this.findWrongByTestAttemptId.setInt(1, testAttemptId);
        ResultSet rs = this.findWrongByTestAttemptId.executeQuery();
        while (rs.next()) {
            ret.add(makeOneQuestion(rs));
        }
        rs.close();
        return ret;
    }
}
