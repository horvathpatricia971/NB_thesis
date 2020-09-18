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
    private int result;
    private Timestamp startTime;
    private Timestamp endTime;
    
    
    public TestAttempt(int TestAttemptID, int UserID, int TestID, int result, Timestamp StartTime, Timestamp EndTime){
        this.testAttemptID = TestAttemptID;
        this.userID = UserID;
        this.testID = TestID;
        this.result = result;
        this.startTime = StartTime;
        this.endTime = EndTime;
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
}