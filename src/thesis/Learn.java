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
public class Learn {
    private int learnID;
    private Date startLearnTime;
    private Date endLearnTime;
    private int userID;
    private int topicID;
    
    public Learn(int LearnID, Date StartLearnTime, Date EndLearnTime, int UserID, int TopicID){
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
    
    public Date getStartLearnTime(){
        return startLearnTime;
    }
    
    public void setStartLearnTime(Date StartLearnTime){
        this.startLearnTime = StartLearnTime;
    }
    
    public Date getEndLearnTime(){
        return endLearnTime;
    }
    
    public void setEndLearnTime(Date EndLearnTime){
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
