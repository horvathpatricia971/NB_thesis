/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

/**
 *
 * @author horvathpatricia
 */
public class TestAnswer {
    private int testAnswerID;
    private String userAnswer;
    private int userID;
    private int testQuestionID;
    
    public TestAnswer(int TestAnswerID, String UserAnswer, int UserID, int TestQuestionID){
        this.testAnswerID = TestAnswerID;
        this.userAnswer = UserAnswer;
        this.userID = UserID;
        this.testQuestionID = TestQuestionID;
    }
    
    public int getTestAnswerId(){
        return testAnswerID;
    }
    
    public void setAnswerId(int TestAnswerID){
        this.testAnswerID = TestAnswerID;
    }
    
    public String getUserAnswer(){
        return userAnswer;
    }
    
    public void setUserAnswer(String UserAnswer){
        this.userAnswer = UserAnswer;
    }
    
    public int getUserId(){
        return userID;
    }
    
    public void setUserId(int UserId){
        this.userID = UserId;
    }
    
    public int getTestQuestionId(){
        return testQuestionID;
    }
    
    public void setQuestionId(int TestQuestionID){
        this.testQuestionID = TestQuestionID;
    }
}
