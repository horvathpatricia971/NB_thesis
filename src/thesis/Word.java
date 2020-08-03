/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author horvathpatricia
 */
public class Word {
    //serial_number int primary key, word varchar(20), word_class varchar(20), exercises_id int references exercises(exercises_id))
    private final SimpleIntegerProperty serialNumber;
    private final SimpleStringProperty word;
    private final SimpleStringProperty wordClass;
    private final SimpleIntegerProperty exercisesId;

    public Word(int sNumber, String wor, String wClass, int exId){
        this.serialNumber = new SimpleIntegerProperty(sNumber);
        this.word = new SimpleStringProperty(wor);
        this.wordClass = new SimpleStringProperty(wClass);
        this.exercisesId = new SimpleIntegerProperty(exId);
    }
    
    public int getSerialNumber(){
        return serialNumber.get();
    }
    
    public void setSerialNumber(int serNum){
        serialNumber.set(serNum);
    }
    public String getWord(){
        return word.get();
    }
    
    public void setWord(String wor){
        word.set(wor);
    }
    
    public String getWordClass(){
        return wordClass.get();
    }
    
    public void setWordClass(String wClass){
        wordClass.set(wClass);
    }
    
    public int getExercisesId(){
	return exercisesId.get();
    }

    public void setExercisesId(int exId){
	exercisesId.set(exId);
    }
}
