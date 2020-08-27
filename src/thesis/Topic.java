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
public class Topic {
    private int topicID;
    private String topic;
    private int numberOfWords;
    private Boolean images;
    private Boolean sound;
    private int difficulty;
    
    public Topic(int TopicId, String Topic, int NumberOfWords, boolean Images, boolean Sound ,int Diff){
        this.topicID = TopicId;
        this.topic = Topic;
        this.numberOfWords = NumberOfWords;
        this.images = Images;
        this.sound = Sound;
        this.difficulty = Diff;
    }
    
    
    public int getTopicID(){
	return topicID;
    }

    public void setTopicID(int TopicId){
	this.topicID = TopicId;
    }
    
    public String getTopic(){
        return topic;
    }
    
    public void setTopic(String Topic){
        this.topic = Topic;
    }
    
    public int getNumberOfWords(){
        return numberOfWords;
    }
    
    public void setNumberOfWords(int NumberOfWords){
        this.numberOfWords = NumberOfWords;
    }
    
    public boolean getImage(){
        return images;
    }
    
    public void setImage(boolean Images){
        this.images = Images;
    }
    
    public boolean getSound(){
        return sound;
    }
    
    public void setSound(boolean Sound){
        this.sound = Sound;
    }
    
    public int getDifficulty(){
        return difficulty;
    }
    
    public void setDifficulty(int Diff){
        this.difficulty = Diff;
    }
}
