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
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */


    
public class LearnController implements Initializable {
    @FXML
    private Pane mainPane;
    
    @FXML
    private Pane firstPane;
    
    @FXML
    private Pane errorPane;
    
    @FXML
    private VBox vbox;
    
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
    private Button testClick;
    
    @FXML
    private AnchorPane healthAnchorPane;
    
    @FXML
    private ImageView picture;
    @FXML
    private ImageView soundImage;
    
    @FXML
    private ImageView slowSoundImage;
    
    private MediaPlayer mediaPlayer;
    
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
    private Label topicLabel;
    
    @FXML
    private Label firstErrorLabel;
    
    private Word currentWord;
    
    private int topicId;
    
    private int userId;
    
    private Learn learn;
    
    private WordDAO worddao;
    
    private TopicDAO topicdao;
    
    private LearnDAO learndao;
    
    private UserDAO userdao;
    
    private Topic topic;
    
    private List<Word> words;
    
    private User user;
    
    private List<Boolean> testReady;

    @FXML
    private Label secondErrorLabel;
    @FXML
    private Button buttonRight;
    @FXML
    private Pane quitPane;
    @FXML
    private Button buttonQuit;
    @FXML
    private Button buttonNoQuit;
    @FXML
    private Label nameLabel;
    
    private void fillLearnData(int number){
        Word w = words.get(number);
        currentWord = w;
        titleLabel.setText(w.getWord() + " - " + w.getWordInEng());
        firstLabel.setText(w.getSentenceHun1());
        secondLabel.setText(w.getSentenceEng1());
        thirdLabel.setText(w.getSentenceHun2());
        fourthLabel.setText(w.getSentenceEng2());
        
        try {
            FileInputStream fis = new FileInputStream("images/" + w.getImage());
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
        try {
            learn = new Learn(0, new java.sql.Timestamp(new java.util.Date().getTime()), null, this.userId, this.topicId);
            learndao.addLearn(learn);
            learndao.saveWords(learn.getLearnId(), words);
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            firstPane.setDisable(true);
            mainPane.setVisible(true);
            vbox.setVisible(true);
            firstErrorLabel.setText("Probléma a tanulási fázis hozzáadásakor.");
            System.out.println(""+ex);
            // TODO Alert ablak, hogz lássuk, mi történt
            // DBConnection.exceptionHanlder(ex)
        }
    }
    
    private void fillFrame(){
        try {
            topic = topicdao.findTopicById(topicId);
            words = worddao.findRandom10WordsByTopicId(topicId);
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
            errorPane.setVisible(true);
            firstPane.setDisable(true);
            firstErrorLabel.setText("Hiányzó elem az adatbázisban.");
            System.out.println(""+ex);
            Logger.getLogger(LearnController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    // eyt kell előbb meghívni, utána a setTopicId-t
    public void setUserId(int userId) throws SQLException {
        this.userId = userId;
        user = userdao.findByIdUser(userId);
        nameLabel.setText("Kedves " + user.getUsername() +"!");
    }
    
         
    
    private void checkTestReady() {
        boolean ready = true;
        for (Boolean b : this.testReady){
            if(!b)ready = false;
        }
        if(ready) this.testClick.setDisable(!ready);
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

    public void initialize(URL url, ResourceBundle rb) {
        
        firstButton.getStyleClass().add("button-words");
        secondButton.getStyleClass().add("button-words");
        thirdButton.getStyleClass().add("button-words");
        fourthButton.getStyleClass().add("button-words");
        fifthButton.getStyleClass().add("button-words");
        sixthButton.getStyleClass().add("button-words");
        seventhButton.getStyleClass().add("button-words");
        eighthButton.getStyleClass().add("button-words");
        ninthButton.getStyleClass().add("button-words");
        tenthButton.getStyleClass().add("button-words");
        
        
        
        this.testReady = new ArrayList<Boolean>();
        for (int i = 0; i < 10; i++){
            this.testReady.add(Boolean.FALSE);
        }  
        
        try {
            Connection conn = DBConnection.getInstance();
            System.out.println("Adatbáziskapcsolat létrehozva.");
            worddao = new WordDAO(conn);
            topicdao = new TopicDAO(conn);
            learndao = new LearnDAO(conn);
            userdao = new UserDAO(conn);
            
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            firstPane.setDisable(true);
            mainPane.setVisible(true);
            vbox.setVisible(true);
            firstErrorLabel.setText("Nem jött létre az adatbáziskapcsolat.");
            System.out.println(""+ex);
        }
        
        Tooltip tooltip1 = new Tooltip("Hang lejátszása normál tempóban.");
        tooltip1.setStyle("-fx-font-size: 24px; fx-position: absolute;");
        Tooltip.install(soundImage, tooltip1);
        
        Tooltip tooltip2 = new Tooltip("Hang lejátszása lassítva.");
        tooltip2.setStyle("-fx-font-size: 24px; fx-position: absolute;");
        Tooltip.install(slowSoundImage, tooltip2);
    }
    @FXML
    private void testClickAction(ActionEvent event) throws IOException, SQLException {
        learn.setEndLearnTime(new java.sql.Timestamp(new java.util.Date().getTime()));
        try {
            learndao.updateLearn(learn);
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            mainPane.setVisible(true);
            vbox.setVisible(true);
            firstPane.setDisable(true);
            firstErrorLabel.setText("Probléma a befejezési idő tárolásánál.");
            Logger.getLogger(LearnController.class.getName()).log(Level.SEVERE, null, ex);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Test.fxml"));
        AnchorPane pane = loader.load();
        TestController controller = loader.<TestController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(this.topicId);
        healthAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        quitPane.setVisible(true);
        mainPane.setDisable(true);
        firstPane.setDisable(true);
        vbox.setDisable(true);
        mainPane.setOpacity(0.5);
        firstPane.setOpacity(0.8);
        vbox.setOpacity(0.5);
    }
    
    @FXML
    private void loadRight(ActionEvent event) {
        errorPane.setVisible(false);
        mainPane.setDisable(false);
        mainPane.setVisible(false);
        vbox.setVisible(false);
    }

    @FXML
    private void quitAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Topics.fxml"));
        AnchorPane pane = loader.load();
        TopicsController controller = loader.<TopicsController>getController();
        controller.setUserId(this.userId);
        healthAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void noQuitAction(ActionEvent event) {
        quitPane.setVisible(false);
        mainPane.setDisable(false);
        firstPane.setDisable(false);
        vbox.setDisable(false);
        mainPane.setOpacity(1);
        firstPane.setOpacity(1);
        vbox.setOpacity(1);
    }

    @FXML
    private void voiceClick(MouseEvent event) {
        String mp3 = "mp3/" + currentWord.getAudio(); //fájl 
        Media sound = new Media(new File(mp3).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
        
}