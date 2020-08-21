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
public class Word {
    //serial_number int primary key, word varchar(20), word_class varchar(20), exercises_id int references exercises(exercises_id))
    private int serialNumber;
    private String word;
    private String wordClass;
    private int topicsID;

    public Word(int SerialNumber, String Word, String WordClass, int TopicsID){
        this.serialNumber = SerialNumber;
        this.word = Word;
        this.wordClass = WordClass;
        this.topicsID = TopicsID;
    }
    
    public int getSerialNumber(){
        return serialNumber;
    }
    
    public void setSerialNumber(int SerialNumber){
        this.serialNumber = SerialNumber;
    }
    public String getWord(){
        return word;
    }
    
    public void setWord(String Word){
        this.word = Word;
    }
    
    public String getWordClass(){
        return wordClass;
    }
    
    public void setWordClass(String WordClass){
        this.wordClass = WordClass;
    }
    
    public int getTopicsID(){
	return topicsID;
    }

    public void setExercisesId(int TopicsID){
	this.topicsID = TopicsID;
    }
}
