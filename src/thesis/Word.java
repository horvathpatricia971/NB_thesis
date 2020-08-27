/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author horvathpatricia
 */
public class Word {
    private int wordID;
    private String wordInHun;
    private String wordInEng;
    private String wordClass;
    private SerialBlob image;
    private SerialBlob audio;
    private String sentenceHun1;
    private String sentenceEng1;
    private String sentenceHun2;
    private String sentenceEng2;
    private int topicID;

    public Word(int WordID, String WordInHun, String WordInEng, String WordClass, SerialBlob Image, SerialBlob Audio, String SentenceHun1, String SentenceEng1, String SentenceHun2, String SentenceEng2, int TopicID){
        this.wordID = WordID;
        this.wordInHun = WordInHun;
        this.wordInEng = WordInEng;
        this.wordClass = WordClass;
        this.image = Image;
        this.audio = Audio;
        this.sentenceHun1 = SentenceHun1;
        this.sentenceEng1 = SentenceEng1;
        this.sentenceHun2 = SentenceHun2;
        this.sentenceEng2 = SentenceEng2;
        this.topicID = TopicID;
    }
    
    public int getWordID(){
        return wordID;
    }
    
    public void setWordID(int WordID){
        this.wordID = WordID;
    }
    
    public String getWord(){
        return wordInHun;
    }
    
    public void setWord(String Word){
        this.wordInHun = Word;
    }
    
    public String getWordInEng(){
        return wordInEng;
    }
    
    public void setWordInEng(String Word){
        this.wordInEng = Word;
    }
    
    public String getWordClass(){
        return wordClass;
    }
    
    public void setWordClass(String WordClass){
        this.wordClass = WordClass;
    }
    
    public SerialBlob getImage(){
        return image;
    }
    
    public void setImage(SerialBlob Image){
        this.image = Image;
    }
    
    public SerialBlob getAudio(){
        return audio;
    }
    
    public void setAudio(SerialBlob Audio){
        this.audio = Audio;
    }
    
    public String getSentenceHun1(){
        return sentenceHun1;
    }
    
    public void setSentenceHun1(String SentenceHun1){
        this.sentenceHun1 = SentenceHun1;
    }
    
    public String getSentenceEng1(){
        return sentenceEng1;
    }
    
    public void setSentenceEng1(String SentenceEng1){
        this.sentenceEng1 = SentenceEng1;
    }
    
    public String getSentenceHun2(){
        return sentenceHun2;
    }
    
    public void setSentenceHun2(String SentenceHun2){
        this.sentenceHun2 = SentenceHun2;
    }
    
    public String getSentenceEng2(){
        return sentenceEng2;
    }
    
    public void setSentenceEng2(String SentenceEng2){
        this.sentenceEng2 = SentenceEng2;
    }
    
    public int getTopicID(){
	return topicID;
    }

    public void setExercisesId(int TopicID){
	this.topicID = TopicID;
    }
}
