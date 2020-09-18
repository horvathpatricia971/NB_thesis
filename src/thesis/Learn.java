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
public class Learn {
    private int learnID;
    private Timestamp startLearnTime;
    private Timestamp endLearnTime;
    private int userID;
    private int topicID;
    
    public Learn(int LearnID, Timestamp StartLearnTime, Timestamp EndLearnTime, int UserID, int TopicID){
        this.learnID = LearnID;
        this.startLearnTime = StartLearnTime;
        this.endLearnTime = EndLearnTime;
        this.userID = UserID;
        this.topicID = TopicID;
    }
    
    public int getLearnId(){
        return learnID;
    }
    
    public void setLearnId(int LearnID){
        this.learnID = LearnID;
    }
    
    public Timestamp getStartLearnTime(){
        return startLearnTime;
    }
    
    public void setStartLearnTime(Timestamp StartLearnTime){
        this.startLearnTime = StartLearnTime;
    }
    
    public Timestamp getEndLearnTime(){
        return endLearnTime;
    }
    
    public void setEndLearnTime(Timestamp EndLearnTime){
        this.endLearnTime = EndLearnTime;
    }
      
    public int getUserId(){
        return userID;
    }
    
    public void setUserId(int UserId){
        this.userID = UserId;
    }
    
    public int getTopicId(){
        return topicID;
    }
    
    public void setTopicId(int TopicId){
        this.topicID = TopicId;
    }
}
