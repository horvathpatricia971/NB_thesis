/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.sql.Timestamp;

/**
 *
 * @author horvathpatricia
 */
public class TestAttempt {
    private int testAttemptID;
    private int userID;
    private int testID;
    private int questionNum;
    private int rightAnswerNum;
    private int result;
    private Timestamp startTime;
    private Timestamp endTime;
    private String prize;
    private int testType;
    
    public TestAttempt(int TestAttemptID, int UserID, int TestID, int result, int QuestionNum, int RightAnswerNum, Timestamp StartTime, Timestamp EndTime, String Prize, int TestType){
        this.testAttemptID = TestAttemptID;
        this.userID = UserID;
        this.testID = TestID;
        this.questionNum = QuestionNum;
        this.rightAnswerNum = RightAnswerNum;
        this.result = result;
        this.startTime = StartTime;
        this.endTime = EndTime;
        this.prize = Prize;
        this.testType = TestType;
    }
    
    public int getTestAttemptID(){
        return testAttemptID;
    }
    
    public void setTestAttemptID(int TestAttemptID){
        this.testAttemptID = TestAttemptID;
    }
    
    public int getUserId(){
        return userID;
    }
    
    public void setUserId(int UserID){
        this.userID = UserID;
    }
    
    public int getTestId(){
        return testID;
    }
    
    public void setTestId(int TestID){
        this.testID = TestID;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public int getRightAnswerNum() {
        return rightAnswerNum;
    }

    public void setRightAnswerNum(int rightAnswerNum) {
        this.rightAnswerNum = rightAnswerNum;
    }
    
    public int getResult(){
        return result;
    }
    
    public void setResult(int result){
        this.result = result;
    }
    
    public Timestamp getStartTime(){
        return startTime;
    }
    
    public void setStartTime(Timestamp StartTime){
        this.startTime = StartTime;
    }
    
    public Timestamp getEndTime(){
        return endTime;
    }
    
    public void setEndTime(Timestamp EndTime){
        this.endTime = EndTime;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public int getTestType() {
        return testType;
    }

    public void setTestType(int testType) {
        this.testType = testType;
    }
    
}