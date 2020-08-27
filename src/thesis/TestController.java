/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    private Button nextButton1;
    @FXML
    private Button checkButton1;
    @FXML
    private Button checkButton2;
    @FXML
    private Button checkButton3;
    @FXML
    private Button checkButton4;
    @FXML
    private Button checkButton5;
    @FXML
    private Button checkButton6;
    @FXML
    private Button checkButton7;
    @FXML
    private Button checkButton8;
    @FXML
    private Button checkButton9;
    @FXML
    private Button checkButton10;
    @FXML
    private Button nextButton2;
    @FXML
    private Button nextButton3;
    @FXML
    private Button nextButton4;
    @FXML
    private Button nextButton5;
    @FXML
    private Button nextButton6;
    @FXML
    private Button nextButton7;
    @FXML
    private Button nextButton8;
    @FXML
    private Button nextButton9;
    @FXML
    private Button nextButton10;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void beginAction(ActionEvent event) { 
        firstPane.setVisible(true);
        answer1.setText("wald");
        answer2.setText("tree");
        answer3.setText("sugar");
        firstLabel.setText("Ez egy magas FA.");
        secondLabel.setText("It is a tall ...");
        questionLabel.setText("1. kérdés");
        numberLabel.setText("1/10");
        checkButton1.setDisable(true);
        nextButton1.setDisable(true);
        checkButton2.setVisible(false);
        checkButton3.setVisible(false);
        checkButton4.setVisible(false);
        checkButton5.setVisible(false);
        checkButton6.setVisible(false);
        checkButton7.setVisible(false);
        checkButton8.setVisible(false);
        checkButton9.setVisible(false);
        checkButton10.setVisible(false);
        nextButton2.setVisible(false);
        nextButton3.setVisible(false);
        nextButton4.setVisible(false);
        nextButton5.setVisible(false);
        nextButton6.setVisible(false);
        nextButton7.setVisible(false);
        nextButton8.setVisible(false);
        nextButton9.setVisible(false);
        nextButton10.setVisible(false);
        
    }
    
    @FXML
    private void answerButtonAction(ActionEvent event){
        if (event.getSource() == answer1){
            answer1.setStyle("-fx-background-color: #34CBD4;");
            answer2.setDisable(true);
            answer3.setDisable(true);
            checkButton1.setDisable(false);
            checkButton2.setDisable(false);
            checkButton3.setDisable(false);
            checkButton4.setDisable(false);
            checkButton5.setDisable(false);
            checkButton6.setDisable(false);
            checkButton7.setDisable(false);
            checkButton8.setDisable(false);
            checkButton9.setDisable(false);
            checkButton10.setDisable(false);
        }else if(event.getSource() == answer2){
            answer2.setStyle("-fx-background-color: #34CBD4;");
            answer1.setDisable(true);
            answer3.setDisable(true);
            checkButton1.setDisable(false);
            checkButton2.setDisable(false);
            checkButton3.setDisable(false);
            checkButton4.setDisable(false);
            checkButton5.setDisable(false);
            checkButton6.setDisable(false);
            checkButton7.setDisable(false);
            checkButton8.setDisable(false);
            checkButton9.setDisable(false);
            checkButton10.setDisable(false);
        } else if (event.getSource() == answer3) {
            answer3.setStyle("-fx-background-color: #34CBD4;");
            answer1.setDisable(true);
            answer2.setDisable(true);
            checkButton1.setDisable(false);
            checkButton2.setDisable(false);
            checkButton3.setDisable(false);
            checkButton4.setDisable(false);
            checkButton5.setDisable(false);
            checkButton6.setDisable(false);
            checkButton7.setDisable(false);
            checkButton8.setDisable(false);
            checkButton9.setDisable(false);
            checkButton10.setDisable(false);
        }
    }
    
    @FXML
    private void checkButtonAction1(ActionEvent event) {
        nextButton1.setDisable(false);
        answer1.setStyle("-fx-background-color: #D44334;");
        answer2.setStyle("-fx-background-color: #ACFBD5;");
        answer3.setStyle("-fx-background-color: #D44334;");
    }
    
    @FXML
    private void nextButtonAction1(ActionEvent event){
        firstLabel.setText("FRISS halat akarok enni.");
        secondLabel.setText("I want to eat ... fish.");
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");
        questionLabel.setText("2. kérdés");
        numberLabel.setText("2/10");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer1.setText("fresh");
        answer2.setText("smart");
        answer3.setText("high");
        checkButton1.setVisible(false);
        nextButton1.setVisible(false);
        nextButton2.setVisible(true);
        nextButton2.setDisable(true);
        checkButton2.setVisible(true);
        checkButton2.setDisable(true);
    }
    
    @FXML
    private void checkButtonAction2(ActionEvent event) {
        nextButton2.setDisable(false);
        answer1.setStyle("-fx-background-color: #ACFBD5;");
        answer2.setStyle("-fx-background-color: #D44334;");
        answer3.setStyle("-fx-background-color: #D44334;");
    }

    @FXML
    private void nextButtonAction2(ActionEvent event) {
        firstLabel.setText("Ő (lány) sétál a FŰben. ");
        secondLabel.setText("She walks in the ...");
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");
        questionLabel.setText("3. kérdés");
        numberLabel.setText("3/10");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer1.setText("sun");
        answer2.setText("grass");
        answer3.setText("profile");
        checkButton2.setVisible(false);
        nextButton2.setVisible(false);
        nextButton3.setVisible(true);
        nextButton3.setDisable(true);
        checkButton3.setVisible(true);
        checkButton3.setDisable(true);
    }

    @FXML
    private void checkButtonAction3(ActionEvent event) {
        nextButton3.setDisable(false);
        answer1.setStyle("-fx-background-color: #D44334;");
        answer2.setStyle("-fx-background-color: #ACFBD5;");
        answer3.setStyle("-fx-background-color: #D44334;");
    }

    @FXML
    private void nextButtonAction3(ActionEvent event) {
        firstLabel.setText("Szeretnénk napozni.");
        secondLabel.setText("We would like ...");
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");
        questionLabel.setText("4. kérdés");
        numberLabel.setText("4/10");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer1.setText("to go");
        answer2.setText("to see");
        answer3.setText("to sunbathe");
        checkButton3.setVisible(false);
        nextButton3.setVisible(false);
        nextButton4.setVisible(true);
        nextButton4.setDisable(true);
        checkButton4.setVisible(true);
        checkButton4.setDisable(true);
    }
    
    @FXML
    private void checkButtonAction4(ActionEvent event) {
        nextButton4.setDisable(false);
        answer1.setStyle("-fx-background-color: #D44334;");
        answer2.setStyle("-fx-background-color: #D44334;");
        answer3.setStyle("-fx-background-color: #ACFBD5;");
    }
    
    @FXML
    private void nextButtonAction4(ActionEvent event) {
        firstLabel.setText("Ez egy felhős nap.");
        secondLabel.setText("This is a cloudy day.");
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");
        questionLabel.setText("5. kérdés");
        numberLabel.setText("5/10");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer1.setText("cloudy");
        answer2.setText("delicious");
        answer3.setText("sweet");
        checkButton4.setVisible(false);
        nextButton4.setVisible(false);
        nextButton5.setVisible(true);
        nextButton5.setDisable(true);
        checkButton5.setVisible(true);
        checkButton5.setDisable(true);
    }
    
    @FXML
    private void checkButtonAction5(ActionEvent event) {
        nextButton5.setDisable(false);
        answer1.setStyle("-fx-background-color: #ACFBD5;");
        answer2.setStyle("-fx-background-color: #D44334;");
        answer3.setStyle("-fx-background-color: #D44334;");
    }

     @FXML
    private void nextButtonAction5(ActionEvent event) {
        firstLabel.setText("A jég elolvad a NAPon.");
        secondLabel.setText("Ice melts in the ...");
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");
        questionLabel.setText("6. kérdés");
        numberLabel.setText("6/10");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer1.setText("sun");
        answer2.setText("chair");
        answer3.setText("salt");
        checkButton5.setVisible(false);
        nextButton5.setVisible(false);
        nextButton6.setVisible(true);
        nextButton6.setDisable(true);
        checkButton6.setVisible(true);
        checkButton6.setDisable(true);
    }
    
    @FXML
    private void checkButtonAction6(ActionEvent event) {
        nextButton6.setDisable(false);
        answer1.setStyle("-fx-background-color: #ACFBD5;");
        answer2.setStyle("-fx-background-color: #D44334;");
        answer3.setStyle("-fx-background-color: #D44334;");
    }

    @FXML
    private void nextButtonAction6(ActionEvent event) {
        firstLabel.setText("Kőszegen TÚRÁZunk.");
        secondLabel.setText("We ... in Kőszeg.");
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");
        questionLabel.setText("7. kérdés");
        numberLabel.setText("7/10");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer1.setText("go");
        answer2.setText("hike");
        answer3.setText("alive");
        checkButton6.setVisible(false);
        nextButton6.setVisible(false);
        nextButton7.setVisible(true);
        nextButton7.setDisable(true);
        checkButton7.setVisible(true);
        checkButton7.setDisable(true);
    }
    
    @FXML
    private void checkButtonAction7(ActionEvent event) {
        nextButton7.setDisable(false);
        answer1.setStyle("-fx-background-color: #D44334;");
        answer2.setStyle("-fx-background-color: #ACFBD5;");
        answer3.setStyle("-fx-background-color: #D44334;");
    }

    @FXML
    private void nextButtonAction7(ActionEvent event) {
        firstLabel.setText("A macskák ÁLLATOK.");
        secondLabel.setText("Cats are ...");
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");
        questionLabel.setText("8. kérdés");
        numberLabel.setText("8/10");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer1.setText("televisions");
        answer2.setText("dolphins");
        answer3.setText("animals");
        checkButton7.setVisible(false);
        nextButton7.setVisible(false);
        nextButton8.setVisible(true);
        nextButton8.setDisable(true);
        checkButton8.setVisible(true);
        checkButton8.setDisable(true);
    }
    
    @FXML
    private void checkButtonAction8(ActionEvent event) {
        nextButton8.setDisable(false);
        answer1.setStyle("-fx-background-color: #D44334;");
        answer2.setStyle("-fx-background-color: #D44334;");
        answer3.setStyle("-fx-background-color: #ACFBD5;");
    }
    
    @FXML
    private void nextButtonAction8(ActionEvent event) {
        firstLabel.setText("A KERTed tele van fákkal.");
        secondLabel.setText("Your ... is full of trees.");
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");
        questionLabel.setText("9. kérdés");
        numberLabel.setText("9/10");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer1.setText("garage");
        answer2.setText("garden");
        answer3.setText("kitchen");
        checkButton8.setVisible(false);
        nextButton8.setVisible(false);
        nextButton9.setVisible(true);
        nextButton9.setDisable(true);
        checkButton9.setVisible(true);
        checkButton9.setDisable(true);
    }
    
    @FXML
    private void checkButtonAction9(ActionEvent event) {
        nextButton9.setDisable(false);
        answer1.setStyle("-fx-background-color: #D44334;");
        answer2.setStyle("-fx-background-color: #ACFBD5;");
        answer3.setStyle("-fx-background-color: #D44334;");
    }

    @FXML
    private void nextButtonAction9(ActionEvent event) {
        firstLabel.setText("A saláta ZÖLD.");
        secondLabel.setText("Salad is ...");
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");
        questionLabel.setText("10. kérdés");
        numberLabel.setText("10/10");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer1.setText("blue");
        answer2.setText("green");
        answer3.setText("red");
        checkButton9.setVisible(false);
        nextButton9.setVisible(false);
        nextButton10.setVisible(true);
        nextButton10.setDisable(true);
        checkButton10.setVisible(true);
        checkButton10.setDisable(true);
    }
    
    @FXML
    private void checkButtonAction10(ActionEvent event) {
        nextButton10.setDisable(false);
        answer1.setStyle("-fx-background-color: #D44334;");
        answer2.setStyle("-fx-background-color: #ACFBD5;");
        answer3.setStyle("-fx-background-color: #D44334;");
    }

    @FXML
    private void nextButtonAction10(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Leader_Board.fxml"));
        mainPane.getChildren().setAll(pane);
    }
    
}
