/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.sql.Date;

/**
 *
 * @author horvathpatricia
 */
public class TestAttempt {
    private int testAttemptID;
    private int userID;
    private int testID;
    private int result;
    private Date startTime;
    private Date endTime;
    
    
    public TestAttempt(int TestAttemptID, int UserID, int TestID, int result, Date StartTime, Date EndTime){
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
    
    public Date getStartTime(){
        return startTime;
    }
    
    public void setStartTime(Date StartTime){
        this.startTime = StartTime;
    }
    
    public Date getEndTime(){
        return endTime;
    }
    
    public void setEndTime(Date EndTime){
        this.endTime = EndTime;
    }
}