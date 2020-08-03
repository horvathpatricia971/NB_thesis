/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author horvathpatricia
 */
public class Answer {
    //test_id int references tests(test_id), answer_number int primary key, answer varchar(20), right boolean
    
    public final SimpleIntegerProperty testId;
    public final SimpleIntegerProperty answerNumber;
    public final SimpleStringProperty answer;
    public final SimpleBooleanProperty right;
    
    public Answer(){
        this.testId = new SimpleIntegerProperty();
        this.answerNumber = new SimpleIntegerProperty(0);
        this.answer = new SimpleStringProperty("");
        this.right = new SimpleBooleanProperty();
    }
    
    public Answer(int tId, int aNumber, String answ, boolean rig){
        this.testId = new SimpleIntegerProperty(tId);
        this.answerNumber = new SimpleIntegerProperty(aNumber);
        this.answer = new SimpleStringProperty(answ);
        this.right = new SimpleBooleanProperty(rig);
    }
    
    public int getTestId(){
        return testId.get();
    }
    
    public void setTestId(int identity){
        testId.set(identity);
    }
    
    public int getAnswerNumber(){
        return answerNumber.get();
    }
    
    public void setAnswerNumber(int aNumber){
        answerNumber.set(aNumber);
    }
    
    public String getAnswer(){
        return answer.get();
    }
    
    public void setId(String ans){
        answer.set(ans);
    }
    
    public boolean getRight(){
        return right.get();
    }
    
    public void setRight(boolean rig){
        right.set(rig);
    }
}
