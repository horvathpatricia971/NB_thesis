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
    private AnchorPane mainPane;
    @FXML
    private Pane firstPane;
    @FXML
    private Label firstLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private Button answer1;
    @FXML
    private Button answer2;
    @FXML
    private Button answer3;
    @FXML
    private Label questionLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Button checkButton1;
    @FXML
    private Button nextButton;
    
    TestDAO testdao;
    TestQuestionDAO testquestiondao;
    TopicDAO topicdao;
    
    private Test test;
    private Topic topic;
    private List <TestQuestion> testQuestion;
    private TestQuestion currentTestQuestion;
    private int selectedAnswer;
    private int questionIndex;
    private int pont;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            Connection conn = DBConnection.getInstance();
            testdao = new TestDAO(conn);
            topicdao = new TopicDAO(conn);
            testquestiondao = new TestQuestionDAO(conn);
            test = testdao.findTestByTopicId(3).get(0); // TODO: 3-as helzére a topic!
            testQuestion = testquestiondao.findQuestionByTestId(test.getTestID());
        //    topic = topicdao.findTopicById(3).getTopic(0);
        //    titleLabel.setText("Teszt a "+ topic.getTopic() + " témakörben");
        } catch (SQLException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillTestData(0);
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
    private void beginAction(ActionEvent event) { 
        firstPane.setVisible(true);
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
        answer2.setDisable(true);
        answer3.setDisable(true);
        checkButton1.setDisable(false);
    }
    
    @FXML
    private void checkButtonAction1(ActionEvent event) {
        if (currentTestQuestion.getRightAnswer().equals(currentTestQuestion.getAnswer1())) {
        answer1.setStyle("-fx-background-color: #ACFBD5;");
        answer2.setStyle("-fx-background-color: #D44334;");
        answer3.setStyle("-fx-background-color: #D44334;");
            if (selectedAnswer == 1) {
                pont++;
            }
        } else if(currentTestQuestion.getRightAnswer().equals(currentTestQuestion.getAnswer2())){
            answer1.setStyle("-fx-background-color: #D44334;");
            answer2.setStyle("-fx-background-color: #ACFBD5;");
            answer3.setStyle("-fx-background-color: #D44334;");
            if (selectedAnswer == 2) {
                pont++;
            }
        } else if(currentTestQuestion.getRightAnswer().equals(currentTestQuestion.getAnswer3())){
            answer1.setStyle("-fx-background-color: #D44334;");
            answer2.setStyle("-fx-background-color: #D44334;");
            answer3.setStyle("-fx-background-color: #ACFBD5;");
            if (selectedAnswer == 3) {
                pont++;
            }
        }
        checkButton1.setDisable(true);
        nextButton.setDisable(false);
    }


    @FXML
    private void nextButtonAction(ActionEvent event) {
       questionIndex++;
       if (questionIndex == 10){
           // TODO: vége a tesztnek
       }
        fillTestData(questionIndex);
        nextButton.setDisable(true); 
        
    }
    
}
