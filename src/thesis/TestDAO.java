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
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author horvathpatricia
 */
public class TestDAO {
    private Connection testConn;
    private PreparedStatement testInsert;
    private PreparedStatement testDelete;
    private PreparedStatement testUpdate;
    private PreparedStatement testFindAll;
    private PreparedStatement testFindById;
    
    private Connection questionConn;
    private PreparedStatement questionInsert;
    private PreparedStatement questionDelete;
    private PreparedStatement questionUpdate;
    private PreparedStatement questionFindAll;
    private PreparedStatement questionFindById;
    
    private Connection answerConn;
    private PreparedStatement answerInsert;
    private PreparedStatement answerDelete;
    private PreparedStatement answerUpdate;
    private PreparedStatement answerFindAll;
    private PreparedStatement answerFindById;
    
    public TestDAO(Connection testConn) throws SQLException{
        this.testConn = testConn;
        this.testInsert = testConn.prepareStatement("insert into tests (userID, topicID, testResult, startTime, endTime) values (?,?,?,?,?)");
        this.testDelete = testConn.prepareStatement("DELETE FROM tests WHERE testID = ?");
        this.testUpdate = testConn.prepareStatement("UPDATE tests SET testResult = ?, ... WHERE testID = ?");
        this.testFindAll = testConn.prepareStatement("SELECT * FROM tests");
        this.testFindById = testConn.prepareStatement("SELECT * FROM tests WHERE testID = ?");
        
        this.questionConn = testConn;
        this.questionInsert = testConn.prepareStatement("insert into testQuestions (testQuestionID, questionInHungarian, questionInEnglish, answer1, answer2, answer3, rightAnswer, testID)");
        this.questionDelete = testConn.prepareStatement("DELETE FROM testQuestions WHERE testQuestionID = ?");
        this.questionUpdate = testConn.prepareStatement("UPDATE testQuestions SET rightAnswer = ?, ... WHERE testQuestionID = ?");
        this.questionFindAll = testConn.prepareStatement("SELECT * FROM testQuestions");
        this.questionFindById = testConn.prepareStatement("SELECT * FROM testQuestions WHERE testQuestionID = ?");
        
        this.answerConn = testConn;
        this.answerInsert = testConn.prepareStatement("insert into testAnswers (testAnswerID, userAnswer, userID, testQuestionID)");
        this.answerDelete = testConn.prepareStatement("DELETE FROM testAnswers WHERE testAnswerID = ?");
        this.answerUpdate = testConn.prepareStatement("UPDATE tests SET userAnswer = ?, ... WHERE testAnswerID = ?");
        this.answerFindAll = testConn.prepareStatement("SELECT * FROM testAnswers");
        this.answerFindById = testConn.prepareStatement("SELECT * FROM testAnswers WHERE testAnswerID = ?");
    }
    
    //test DAO
    public void addTest(Test newTest) throws SQLException {
        this.testInsert.setInt(1, newTest.getUserId());
        this.testInsert.setInt(2, newTest.getTopicID());
        this.testInsert.setInt(3, newTest.getTestResult());
        this.testInsert.setTime(4, newTest.getStartTime());
        this.testInsert.setTime(5, newTest.getEndTime());
        this.testInsert.executeUpdate();
    }
    
    public void deleteTest(int testID) throws SQLException {
        this.testDelete.setInt(1, testID);
        this.testDelete.executeUpdate();
    }
    
    public void updateTest(Test test) throws SQLException {
        this.testUpdate.setInt(1, test.getUserId());
        this.testUpdate.setInt(2, test.getTopicID());
        this.testUpdate.setInt(3, test.getTestResult());
        this.testUpdate.setTime(4, test.getStartTime());
        this.testUpdate.setTime(5, test.getEndTime());
        this.testUpdate.executeUpdate();
    }
    
    public List<Test> findAllTest() throws SQLException {
        List<Test> ret = new ArrayList<>();
        ResultSet rs = this.testFindAll.executeQuery();
        while (rs.next()) {
            Test test = makeOneTest(rs);
            ret.add(test);
        }
        rs.close();
        return ret;
    }
    
    public Test findTestById(int testID) throws SQLException {
        this.testFindById.setInt(1, testID);
        ResultSet rs = this.testFindById.executeQuery();
        Test ret = null;
        if (rs.next()) {
            ret = makeOneTest(rs);
        }
        rs.close();
        return ret;
    }
    
    private Test makeOneTest(ResultSet rs) throws SQLException {
        int testID = rs.getInt("testID");
        int userID = rs.getInt("userID");
        int topicID = rs.getInt("topicID");
        int testResult = rs.getInt("testResult");
        Time startTime = rs.getTime("startTime");
        Time endTime = rs.getTime("endTime");
        
        Test test = new Test(testID, userID, topicID, testResult, startTime, endTime); 
        return test;
    }
    
    //question DAO
    
    public void addQuestion(TestQuestion newQuestion) throws SQLException{
        this.questionInsert.setString(1, newQuestion.getQuestionInHungarian());
        this.questionInsert.setString(2, newQuestion.getQuestionInEnglish());
        this.questionInsert.setString(3, newQuestion.getAnswer1());
        this.questionInsert.setString(4, newQuestion.getAnswer2());
        this.questionInsert.setString(5, newQuestion.getAnswer3());
        this.questionInsert.setString(6, newQuestion.getRightAnswer());
        this.questionInsert.setInt(7, newQuestion.getTestID());
    }
    
    public void deleteQuestion(int testQuestionID) throws SQLException {
        this.questionDelete.setInt(1, testQuestionID);
        this.questionDelete.executeUpdate();
    }
    
    public void updateQuestion(TestQuestion question) throws SQLException {
        this.questionUpdate.setString(1, question.getQuestionInHungarian());
        this.questionUpdate.setString(2, question.getQuestionInEnglish());
        this.questionUpdate.setString(3, question.getAnswer1());
        this.questionUpdate.setString(4, question.getAnswer2());
        this.questionUpdate.setString(5, question.getAnswer3());
        this.questionUpdate.setString(6, question.getRightAnswer());
        this.questionUpdate.setInt(7, question.getTestID());
        this.questionUpdate.executeUpdate();
    }
    
    public List<TestQuestion> findAllQuestion() throws SQLException {
        List<TestQuestion> ret = new ArrayList<>();
        ResultSet rs = this.questionFindAll.executeQuery();
        while (rs.next()) {
            TestQuestion question = makeOneQuestion(rs);
            ret.add(question);
        }
        rs.close();
        return ret;
    }
    
    public TestQuestion findQuestionById(int testQuestionID) throws SQLException {
        this.questionFindById.setInt(1, testQuestionID);
        ResultSet rs = this.questionFindById.executeQuery();
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
    
    //answer DAO
    public void addAnswer(TestAnswer newAnswer) throws SQLException {
        this.answerInsert.setString(1, newAnswer.getUserAnswer());
        this.answerInsert.setInt(2, newAnswer.getUserId());
        this.answerInsert.setInt(3, newAnswer.getTestQuestionId());
        this.answerInsert.executeUpdate();
    }
    
        
    public void deleteAnswer(int testAnswerID) throws SQLException {
        this.answerDelete.setInt(1, testAnswerID);
        this.answerDelete.executeUpdate();
    }
    
    public void updateTest(TestAnswer answer) throws SQLException {
        this.answerUpdate.setString(1, answer.getUserAnswer());
        this.answerUpdate.setInt(2, answer.getUserId());
        this.answerUpdate.setInt(3, answer.getTestQuestionId());
        this.answerUpdate.executeUpdate();
    }
    
    public List<TestAnswer> findAllAnswer() throws SQLException {
        List<TestAnswer> ret = new ArrayList<>();
        ResultSet rs = this.answerFindAll.executeQuery();
        while (rs.next()) {
            TestAnswer answer = makeOneAnswer(rs);
            ret.add(answer);
        }
        rs.close();
        return ret;
    }
    
    public TestAnswer findAnswerById(int testAnswerID) throws SQLException {
        this.answerFindById.setInt(1, testAnswerID);
        ResultSet rs = this.answerFindById.executeQuery();
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
        int userID = rs.getInt("userID");
        int testQuestionID = rs.getInt("testQuestionID");
        
        TestAnswer answer = new TestAnswer(testAnswerID, userAnswer, userID, testQuestionID); 
        return answer;
    }
}
