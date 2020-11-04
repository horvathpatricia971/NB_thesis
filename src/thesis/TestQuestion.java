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
    private String answer1hun;
    private String answer2hun;
    private String answer3hun;
    private String picture1;
    private String picture2;
    private String picture3;
    private int testID;
    
    
    
    public TestQuestion(int TestQuestionID, String QuestionInHungarian, String QuestionInEnglish, String Answer1, String Answer2, String Answer3, String RightAnswer, String Answer1hun, String Answer2hun, String Answer3hun, String Picture1, String Picture2, String Picture3, int TestID){
        this.testQuestionID = TestQuestionID;
        this.questionInHungarian = QuestionInHungarian;
        this.questionInEnglish = QuestionInEnglish;
        this.answer1 = Answer1;
        this.answer2 = Answer2;
        this.answer3 = Answer3;
        this.rightAnswer = RightAnswer;
        this.answer1hun = Answer1hun;
        this.answer2hun = Answer2hun;
        this.answer3hun = Answer3hun;
        this.picture1 = Picture1;
        this.picture2 = Picture2;
        this.picture3 = Picture3;
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
    
    public String getAnswer(int count) {
        if (count < 1 || count > 3)
            return "";
        switch(count){
            case 1: return answer1;
            case 2: return answer2;
            case 3: return answer3;
            default: return "";
        }
    }
            
    
    public String getRightAnswer(){
        return rightAnswer;
    }
    
    public void setRightAnswer(String RightAnswer){
        this.rightAnswer = RightAnswer;
    }
    
    public String getAnswer1hun() {
        return answer1hun;
    }

    public void setAnswer1hun(String answer1hun) {
        this.answer1hun = answer1hun;
    }

    public String getAnswer2hun() {
        return answer2hun;
    }

    public void setAnswer2hun(String answer2hun) {
        this.answer2hun = answer2hun;
    }

    public String getAnswer3hun() {
        return answer3hun;
    }

    public void setAnswer3hun(String answer3hun) {
        this.answer3hun = answer3hun;
    }

    
    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }
    
    public int getTestID(){
        return testID;
    }
    
    public void setTestID(int TestID){
        this.testID = TestID;
    }
    
}
