/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.sql.Time;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author horvathpatricia
 */
public class Test {
    //create table tests (test_id int primary key, user_id int references users(id), exercise_id int references exercises(exercises_id), result int, start_time time, end_time time)
    
    private final SimpleIntegerProperty testId;
    private final SimpleIntegerProperty userId;
    private final SimpleIntegerProperty exerciseId;
    private final SimpleIntegerProperty testResult;
    private final Time startTime;
    private final Time endTime;
    
    
    public Test(){
        this.testId = new SimpleIntegerProperty();
        this.userId = new SimpleIntegerProperty();
        this.exerciseId = new SimpleIntegerProperty();
        this.testResult = new SimpleIntegerProperty(0);
        this.startTime = new Time(0);
        this.endTime = new Time(0);
    }
    
    public Test(int tId, int uId, int eId, int tResult, int sTime, int eTime){
        this.testId = new SimpleIntegerProperty(tId);
        this.userId = new SimpleIntegerProperty(uId);
        this.exerciseId = new SimpleIntegerProperty(eId);
        this.testResult = new SimpleIntegerProperty(tResult);
        this.startTime = new Time(sTime);
        this.endTime = new Time(eTime);
    }
    
    
    public int getTestId(){
        return testId.get();
    }
    
    public void setTestId(int identity){
        testId.set(identity);
    }
    
    public int getUserId(){
        return userId.get();
    }
    
    public void setUserId(int identity){
        userId.set(identity);
    }
    
    public int getExerciseId(){
        return exerciseId.get();
    }
    
    public void setExerciseId(int identity){
        exerciseId.set(identity);
    }
    
    public int getTestResult(){
        return testResult.get();
    }
    
    public void setTestResult(int tResult){
        testResult.set(tResult);
    }
    
    public int getStartTime(){
        return (int) startTime.getTime();
    }
    
    public void setStartTime(int sTime){
        startTime.setTime(sTime);
    }
    
    public int getEndTime(){
        return (int) endTime.getTime();
    }
    
    public void setEndTime(int eTime){
        endTime.setTime(eTime);
    }
}
