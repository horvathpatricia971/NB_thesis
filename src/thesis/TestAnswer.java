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
    private int isRight;
    private int testAttemptID;
    private int testQuestionID;
    
    public TestAnswer(int TestAnswerID, String UserAnswer, int IsRight,  int TestAttemptID, int TestQuestionID){
        this.testAnswerID = TestAnswerID;
        this.userAnswer = UserAnswer;
        this.isRight = IsRight;
        this.testAttemptID = TestAttemptID;
        this.testQuestionID = TestQuestionID;
    }
    
    public int getTestAnswerID(){
        return testAnswerID;
    }
    
    public void setAnswerID(int TestAnswerID){
        this.testAnswerID = TestAnswerID;
    }
    
    public String getUserAnswer(){
        return userAnswer;
    }
    
    public void setUserAnswer(String UserAnswer){
        this.userAnswer = UserAnswer;
    }
    
    public int getIsRight() {
        return isRight;
    }

    public void setIsRight(int isRight) {
        this.isRight = isRight;
    }
    
    public int getTestAttemptID(){
        return testAttemptID;
    }
    
    public void setTestAttemptID(int TestAttemptID){
        this.testAttemptID = TestAttemptID;
    }

    public int getTestQuestionID() {
        return testQuestionID;
    }

    public void setTestQuestionID(int testQuestionID) {
        this.testQuestionID = testQuestionID;
    }
}
