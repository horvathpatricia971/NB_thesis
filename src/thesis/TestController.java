/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class TestController implements Initializable {

    @FXML
    private Pane basePane;
    @FXML
    private Pane errorPane;
    @FXML
    private Pane firstPane;
    @FXML
    private Pane resultPane;
    @FXML
    private Label firstLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private Label resultLabel;
    @FXML
    private Label firstErrorLabel;
    @FXML
    private Label questionLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Button answer1;
    @FXML
    private Button answer2;
    @FXML
    private Button answer3;
    @FXML
    private Button checkButton1;
    @FXML
    private Button nextButton;
    
   
    
    private Topic topic;
    private List <TestQuestion> testQuestion;
    private TestQuestion currentTestQuestion;
    private TestAttempt testAttempt;
    private Test test; // test.getTestID()
    
    private TopicDAO topicdao;
    private TestQuestionDAO testquestiondao;
    private TestAttemptDAO testattemptdao;
    private TestDAO testdao;
    private TestAnswerDAO testanswerdao;
    
    private int topicId;
    private int testQuestionId;
    private int testAttemptId;
    private int userId;

    private int selectedAnswer;
    private int questionIndex;
    private int score;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button nextButton1;
    @FXML
    private Label secondErrorLabel;
    @FXML
    private Button buttonRight;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            Connection conn = DBConnection.getInstance();
            System.out.println("Adatbáziskapcsolat létrehozva.");
            testdao = new TestDAO(conn);
            topicdao = new TopicDAO(conn);
            testquestiondao = new TestQuestionDAO(conn);
            testattemptdao = new TestAttemptDAO(conn);
            testanswerdao = new TestAnswerDAO(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Nem jött létre az adatbáziskapcsolat.");
            System.out.println(""+ex);
        }
        
    }  

    public void setTopicId(int topicId) {
        this.topicId = topicId;
        fillFrame();
        fillTestData(0);
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTestAttemptId(int testAttemptId) {
        this.testAttemptId = testAttemptId;
    }

    public void setTestQuestionId(int testQuestionId) {
        this.testQuestionId = testQuestionId;
    }
    
    
       
    private void fillFrame(){
        try {
            test = testdao.findTestByTopicId(this.topicId).get(0);
            testQuestion = testquestiondao.findQuestionByTestId(test.getTestID());
            topic = topicdao.findTopicById(this.topicId);
            titleLabel.setText("Teszt a(z) "+ topic.getTopic() + " témakörben");
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Nem jött létre az adatbáziskapcsolat./Ehhez a témához nem kapcsolódik teszt.");
            System.out.println(""+ex);
            Logger.getLogger(LearnController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void beginAction(ActionEvent event) { 
        testAttempt = new TestAttempt(0, this.userId, this.test.getTestID(), 0, new java.sql.Timestamp(new java.util.Date().getTime()), null);
        try {
            testattemptdao.addTestAttempt(testAttempt);
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Probléma a tesztkitöltés hozzáadásakor.");
            System.out.println(""+ex);
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        firstPane.setVisible(true);
        checkButton1.setDisable(true);
        nextButton.setDisable(true);
    }
    
    private void fillTestData(int number){
        TestQuestion testq = testQuestion.get(number);
        currentTestQuestion = testq;
        firstLabel.setText(testq.getQuestionInHungarian());
        secondLabel.setText(testq.getQuestionInEnglish());
        questionLabel.setText(testq.getQuestionNum() + ". kérdés");
        numberLabel.setText(testq.getQuestionNum() + "/10"); //ahány kérdés van topic NumberOfWords
        answer1.setText(testq.getAnswer1());
        answer2.setText(testq.getAnswer2());
        answer3.setText(testq.getAnswer3());
        
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");

        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        
    }
    
    
    
    @FXML
    private void answerButtonAction(ActionEvent event){
        if (event.getSource() == answer1){
            answer1.setStyle("-fx-background-color: #34CBD4;");
            selectedAnswer = 1;
            
        }else if(event.getSource() == answer2){
            answer2.setStyle("-fx-background-color: #34CBD4;");
            selectedAnswer = 2;
            
        } else if (event.getSource() == answer3) {
            answer3.setStyle("-fx-background-color: #34CBD4;");
            selectedAnswer = 3;
        }
        answer1.setDisable(true);
        answer1.setOpacity(0.8);
        answer2.setDisable(true);
        answer2.setOpacity(0.8);
        answer3.setDisable(true);
        answer3.setOpacity(0.8);
        checkButton1.setDisable(false);
    }
    
    @FXML
    private void checkButtonAction1(ActionEvent event) {
        int isRight = 0;
        if (currentTestQuestion.getRightAnswer().equals(currentTestQuestion.getAnswer1())) {
        answer1.setStyle("-fx-background-color: #ACFBD5;");
        answer2.setStyle("-fx-background-color: #D44334;");
        answer3.setStyle("-fx-background-color: #D44334;");
            if (selectedAnswer == 1) {
                score++;
                isRight = 1;
            }
        } else if(currentTestQuestion.getRightAnswer().equals(currentTestQuestion.getAnswer2())){
            answer1.setStyle("-fx-background-color: #D44334;");
            answer2.setStyle("-fx-background-color: #ACFBD5;");
            answer3.setStyle("-fx-background-color: #D44334;");
            if (selectedAnswer == 2) {
                score++;
                isRight = 1;
            }
        } else if(currentTestQuestion.getRightAnswer().equals(currentTestQuestion.getAnswer3())){
            answer1.setStyle("-fx-background-color: #D44334;");
            answer2.setStyle("-fx-background-color: #D44334;");
            answer3.setStyle("-fx-background-color: #ACFBD5;");
            if (selectedAnswer == 3) {
                score++;
                isRight = 1;
            }
        }
        checkButton1.setDisable(true);
        nextButton.setDisable(false);
        
        TestAnswer testAnswer = new TestAnswer(0, currentTestQuestion.getAnswer(selectedAnswer), isRight, this.testAttempt.getTestAttemptID(), this.currentTestQuestion.getTestQuestionID());
        try {
            testanswerdao.addAnswer(testAnswer);
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Probléma a válasz hozzáadásakor.");
            System.out.println(""+ex);
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void nextButtonAction(ActionEvent event) {
       questionIndex++;
        switch (questionIndex) {
            case 9:
                fillTestData(questionIndex);
                answer1.setOpacity(1);
                answer2.setOpacity(1);
                answer3.setOpacity(1);
                nextButton.setDisable(true);
                nextButton.setText("Befejezés");
                break;
            case 10:
                // TODO: vége a tesztnek
                
                testAttempt.setEndTime(new java.sql.Timestamp(new java.util.Date().getTime()));
                testAttempt.setResult(score);
                try {
                    testattemptdao.updateTestAttempt(testAttempt);
                } catch (SQLException ex) {
                    errorPane.setVisible(true);
                    basePane.setDisable(true);
                    firstErrorLabel.setText("Probléma a befejezési idő tárolásánál.");
                    Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
                }    resultPane.setVisible(true);
                resultLabel.setText("10/" + score);
                break;
            default:
                fillTestData(questionIndex);
                answer1.setOpacity(1);
                answer2.setOpacity(1);
                answer3.setOpacity(1);
                nextButton.setDisable(true);
                break;
        }
        
    }
    
    @FXML
    private void loadRight(ActionEvent event) {
        errorPane.setVisible(false);
        basePane.setDisable(false);
    }

    @FXML
    private void loadResult(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Results.fxml"));
        AnchorPane pane = loader.load();
        ResultController controller = loader.<ResultController>getController();
        controller.setUserId(this.userId);
        mainPane.getChildren().setAll(pane);
        
    }
    
}
