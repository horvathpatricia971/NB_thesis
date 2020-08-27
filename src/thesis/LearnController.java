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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */


    
public class LearnController implements Initializable {
    
    
    @FXML
    private Button firstButton;
    
    @FXML 
    private Button secondButton;
    
    @FXML
    private Button thirdButton;
    
    @FXML
    private Button fourthButton;
    
    @FXML
    private Button fifthButton;
    
    @FXML
    private Button sixthButton;
    
    @FXML
    private Button seventhButton;
    
    @FXML
    private Button eighthButton;
    
    @FXML
    private Button ninthButton;
    
    @FXML
    private Button tenthButton;
    @FXML
    private Pane firstPane;

    @FXML
    private Button testClick;
    @FXML
    private Label topicLabel;
    @FXML
    private AnchorPane healthAnchorPane;
    
    private List<Boolean> testReady;
    private WordDAO worddao;
    private TopicDAO topicdao;
    private Topic topic;
    private List<Word> words;
    @FXML
    private ImageView picture;
    @FXML
    private Label firstLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private Label thirdLabel;
    @FXML
    private Label fourthLabel;
    
    @FXML
    private void firstWordAction(ActionEvent Event){
        
        firstButton.setStyle("-fx-background-color: #A0E5AA");
        
        firstPane.setVisible(true);
        Word w = words.get(0);
        titleLabel.setText(w.getWord() + "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(0)){
            this.testReady.set(0, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void secondWordAction(ActionEvent Event){
        
        secondButton.setStyle("-fx-background-color: #A0E5AA");
        
        Word w = words.get(1);
        titleLabel.setText(w.getWord() + "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(1)){
            this.testReady.set(1, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void thirdWordAction(ActionEvent Event){
        
        thirdButton.setStyle("-fx-background-color: #A0E5AA");
        
        Word w = words.get(2);
        titleLabel.setText(w.getWord() +  "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(2)){
            this.testReady.set(2, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void fourtWordAction(ActionEvent Event){

        fourthButton.setStyle("-fx-background-color: #A0E5AA");
        
        Word w = words.get(3);
        titleLabel.setText(w.getWord() +  "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(3)){
            this.testReady.set(3, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void fifthWordAction(ActionEvent Event){
        
        fifthButton.setStyle("-fx-background-color: #A0E5AA");
        
        Word w = words.get(4);
        titleLabel.setText(w.getWord() +  "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(4)){
            this.testReady.set(4, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void sixthWordAction(ActionEvent Event){
        
        sixthButton.setStyle("-fx-background-color: #A0E5AA");
        
        Word w = words.get(5);
        titleLabel.setText(w.getWord() +  "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(5)){
            this.testReady.set(5, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void seventhWordAction(ActionEvent Event){
        
        seventhButton.setStyle("-fx-background-color: #A0E5AA");
        
        Word w = words.get(6);
        titleLabel.setText(w.getWord() +  "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(6)){
            this.testReady.set(6, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void eightWordAction(ActionEvent Event){
        eighthButton.setStyle("-fx-background-color: #A0E5AA");
        
        Word w = words.get(7);
        titleLabel.setText(w.getWord() +  "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(7)){
            this.testReady.set(7, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void ninthWordAction(ActionEvent Event){
        
        ninthButton.setStyle("-fx-background-color: #A0E5AA");
        
        Word w = words.get(8);
        titleLabel.setText(w.getWord() +  "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(8)){
            this.testReady.set(8, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void tenthWordAction(ActionEvent Event){
        
        tenthButton.setStyle("-fx-background-color: #A0E5AA");
        
        Word w = words.get(9);
        titleLabel.setText(w.getWord() +  "-" + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun1());
        fourthLabel.setText(w.getSentenceEng2());
        
        if(!this.testReady.get(9)){
            this.testReady.set(9, Boolean.TRUE);
            this.checkTestReady();
        }
        
    }
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        
        this.testReady = new ArrayList<Boolean>();
        for (int i = 0; i < 10; i++){
            this.testReady.add(Boolean.FALSE);
        }  
        
         try {
            Connection conn = DBConnection.getInstance();
            System.out.println("A híd létrejött");
            worddao = new WordDAO(conn);
            topicdao = new TopicDAO(conn);
            topic = topicdao.findTopicById(3);
            words = worddao.findByTopicID(3);
            topicLabel.setText(topic.getTopic() + " témakör");
            firstButton.setText(words.get(0).getWord());
            secondButton.setText(words.get(1).getWord());
            thirdButton.setText(words.get(2).getWord());
            fourthButton.setText(words.get(3).getWord());
            fifthButton.setText(words.get(4).getWord());
            sixthButton.setText(words.get(5).getWord());
            seventhButton.setText(words.get(6).getWord());
            eighthButton.setText(words.get(7).getWord());
            ninthButton.setText(words.get(8).getWord());
            tenthButton.setText(words.get(9).getWord());
        } catch (SQLException ex) {
            
            System.out.println("Valami nem jó a connection létrehozásakor");
            System.out.println(""+ex);
        }
    }

    @FXML
    private void testClickAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Test.fxml"));
        healthAnchorPane.getChildren().setAll(pane);
        
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Topics.fxml"));
        healthAnchorPane.getChildren().setAll(pane);
    }
    
    private void checkTestReady() {
        boolean ready = true;
        for (Boolean b : this.testReady){
            if(!b)ready = false;
        }
        if(ready) this.testClick.setDisable(!ready);
    }
        
}