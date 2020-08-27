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
public class TestQuestion {
    private int testQuestionID;
    private String questionInHungarian;
    private String questionInEnglish;
    private String answer1;
    private String answer2;
    private String answer3;
    private String rightAnswer;
    private int testID;
    
    
    
    public TestQuestion(int TestQuestionID, String QuestionInHungarian, String QuestionInEnglish, String Answer1, String Answer2, String Answer3, String RightAnswer, int TestID){
        this.testQuestionID = TestQuestionID;
        this.questionInHungarian = QuestionInHungarian;
        this.questionInEnglish = QuestionInEnglish;
        this.answer1 = Answer1;
        this.answer2 = Answer2;
        this.answer3 = Answer3;
        this.rightAnswer = RightAnswer;
        this.testID = TestID;
    }
    
    public int getTestQuestionID(){
        return testQuestionID;
    }
    
    public void setQuestionID(int TestQuestionID){
        this.testQuestionID = TestQuestionID;
    }
    
    public String getQuestionInHungarian(){
        return questionInHungarian;
    }
    
    public void setQuestionInHungarian(String QuestionInHungarian){
        this.questionInHungarian = QuestionInHungarian;
    }
    
    public String getQuestionInEnglish(){
        return questionInEnglish;
    }
    
    public void setQuestionInEnglish(String QuestionInEnglish){
        this.questionInEnglish = QuestionInEnglish;
    }
    
    public String getAnswer1(){
        return answer1;
    }
    
    public void setAnswer1(String Answer1){
        this.answer1 = Answer1;
    }
    
    public String getAnswer2(){
        return answer2;
    }
    
    public void setAnswer2(String Answer2){
        this.answer2 = Answer2;
    }
    
    public String getAnswer3(){
        return answer3;
    }
    
    public void setAnswer3(String Answer3){
        this.answer3 = Answer3;
    }
    
    public String getRightAnswer(){
        return rightAnswer;
    }
    
    public void setRightAnswer(String RightAnswer){
        this.rightAnswer = RightAnswer;
    }
    
    public int getTestID(){
        return testID;
    }
    
    public void setTestID(int TestID){
        this.testID = TestID;
    }
    
}
