/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author horvathpatricia
 */
public class Exercise {
    //exercises_id int primary key, topic varchar(20), number_of_words int, pictures boolean, sound boolean, difficulty int
    private final SimpleIntegerProperty exercisesId;
    private final SimpleStringProperty topic;
    private final SimpleIntegerProperty numberOfWords;
    private final SimpleBooleanProperty pictures;
    private final SimpleBooleanProperty sound;
    private final SimpleIntegerProperty difficulty;
    
    public Exercise(int id, String top, int now, boolean pic, boolean sou,int diff){
        this.exercisesId = new SimpleIntegerProperty(id);
        this.topic = new SimpleStringProperty(top);
        this.numberOfWords = new SimpleIntegerProperty(now);
        this.pictures = new SimpleBooleanProperty(pic);
        this.sound = new SimpleBooleanProperty(sou);
        this.difficulty = new SimpleIntegerProperty(diff);
    }
    
    
    public int getExercisesId(){
	return exercisesId.get();
    }

    public void setExercisesId(int exId){
	exercisesId.set(exId);
    }
    
    public String getTopic(){
        return topic.get();
    }
    
    public void setTopic(String top){
        topic.set(top);
    }
    
    public int getNumberOfWords(){
        return numberOfWords.get();
    }
    
    public void setNumberOfWords(int num){
        numberOfWords.set(num);
    }
    
    public boolean getPictures(){
        return pictures.get();
    }
    
    public void setPictures(boolean pic){
        pictures.set(pic);
    }
    
    public boolean getSound(){
        return sound.get();
    }
    
    public void setSound(boolean sou){
        sound.set(sou);
    }
    
    public int getDifficulty(){
        return difficulty.get();
    }
    
    public void setDifficulty(int diff){
        difficulty.set(diff);
    }
}
