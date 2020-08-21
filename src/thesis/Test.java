/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.sql.Time;

/**
 *
 * @author horvathpatricia
 */
public class Test {
    private int testID;
    private int userID;
    private int topicID;
    private int testResult;
    private Time startTime;
    private Time endTime;
    
    
    public Test(int TestID, int UserID, int TopicID, int TestResult, Time StartTime, Time EndTime){
        this.testID = TestID;
        this.userID = UserID;
        this.topicID = TopicID;
        this.testResult = TestResult;
        this.startTime = StartTime;
        this.endTime = EndTime;
    }
    
    public int getTestId(){
        return testID;
    }
    
    public void setTestId(int TestID){
        this.testID = TestID;
    }
    
    public int getUserId(){
        return userID;
    }
    
    public void setUserId(int UserID){
        this.userID = UserID;
    }
    
    public int getTopicID(){
        return topicID;
    }
    
    public void setTopicID(int TopicID){
        this.topicID = TopicID;
    }
    
    public int getTestResult(){
        return testResult;
    }
    
    public void setTestResult(int TestResult){
        this.testResult = TestResult;
    }
    
    public Time getStartTime(){
        return startTime;
    }
    
    public void setStartTime(Time StartTime){
        this.startTime = StartTime;
    }
    
    public Time getEndTime(){
        return endTime;
    }
    
    public void setEndTime(Time EndTime){
        this.endTime = EndTime;
    }
}