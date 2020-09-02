/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
    
    private MediaPlayer mediaPlayer;
    @FXML
    private Button soundButton;
    
    private Word currentWord;
    private int topicId;
    
    private void fillLearnData(int number){
        Word w = words.get(number);
        currentWord = w;
        titleLabel.setText(w.getWord() + " - " + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun2());
        fourthLabel.setText(w.getSentenceEng2());
        
        try {
            FileInputStream fis = new FileInputStream("src/thesis/" + w.getImage());
            picture.setImage(new Image(fis));
        } catch (FileNotFoundException ex) {
            // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
        }
        
        firstPane.setVisible(true);
        
        if(!this.testReady.get(number)){
            this.testReady.set(number, Boolean.TRUE);
            this.checkTestReady();
        }
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
        fillFrame();
    }
    
    private void fillFrame(){
        try {
            topic = topicdao.findTopicById(topicId);
            words = worddao.findByTopicID(topicId);
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
            Logger.getLogger(LearnController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
            
    @FXML
    private void firstWordAction(ActionEvent Event){
        fillLearnData(0);
        firstButton.setStyle("-fx-background-color: #A0E5AA");
    }
    
    @FXML
    private void secondWordAction(ActionEvent Event){
        fillLearnData(1);
        secondButton.setStyle("-fx-background-color: #A0E5AA");
    }
    
    @FXML
    private void thirdWordAction(ActionEvent Event){
        fillLearnData(2);
        thirdButton.setStyle("-fx-background-color: #A0E5AA");
    }
    
    @FXML
    private void fourtWordAction(ActionEvent Event){
        fillLearnData(3);
        fourthButton.setStyle("-fx-background-color: #A0E5AA");
    }
    
    @FXML
    private void fifthWordAction(ActionEvent Event){
        fillLearnData(4);
        fifthButton.setStyle("-fx-background-color: #A0E5AA");
    }
    
    @FXML
    private void sixthWordAction(ActionEvent Event){
        fillLearnData(5);
        sixthButton.setStyle("-fx-background-color: #A0E5AA");
    }
    
    @FXML
    private void seventhWordAction(ActionEvent Event){
        fillLearnData(6);
        seventhButton.setStyle(("-fx-background-color: #A0E5AA"));
    }
    
    @FXML
    private void eightWordAction(ActionEvent Event){
        fillLearnData(7);
        eighthButton.setStyle(("-fx-background-color: #A0E5AA"));
    }
    
    @FXML
    private void ninthWordAction(ActionEvent Event){
        fillLearnData(8);
        ninthButton.setStyle(("-fx-background-color: #A0E5AA"));
    }
    
    @FXML
    private void tenthWordAction(ActionEvent Event){
        fillLearnData(9);
        tenthButton.setStyle(("-fx-background-color: #A0E5AA"));
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

    @FXML
    private void soundAction(ActionEvent event) {
        String mp3 = currentWord.getAudio(); //fájl 
        Media sound = new Media(new File(mp3).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
        
}