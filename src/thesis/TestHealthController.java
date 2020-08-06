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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class TestHealthController implements Initializable {

    @FXML
    private AnchorPane testAnchor;
    @FXML
    private Pane firstPane;
    @FXML
    private Pane secondPane;
    @FXML
    private Button firstButton;
    @FXML
    private Button secondButton;
    @FXML
    private Pane thirdPane;
    @FXML
    private Button thirdButton;
    @FXML
    private Pane fourthPane;
    @FXML
    private Button fourthButton;
    @FXML
    private Pane fifthPane;
    @FXML
    private Button fifthButton;
    @FXML
    private Pane sixthPane;
    @FXML
    private Button seventhButton;
    @FXML
    private Pane seventhPane;
    @FXML
    private Pane eightPane;
    @FXML
    private Button eightButton;
    @FXML
    private Pane ninthPane;
    @FXML
    private Button ninthButton;
    @FXML
    private Pane tenthPane;
    @FXML
    private Pane basePane;
    @FXML
    private Button tenthButton;
    @FXML
    private Button sixthButton;
    @FXML
    private Pane quitPane;
    @FXML
    private Button buttonQuit;
    @FXML
    private Button buttonNoQuit;

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
    }

    @FXML
    private void firstButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(true);
    }

    @FXML
    private void secondButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(true);
    }

    @FXML
    private void thirdButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(true);
    }

    @FXML
    private void fourthButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(true);
    }

    @FXML
    private void fifthButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(true);
    }

    @FXML
    private void sixthButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(true);
    }

    @FXML
    private void seventhButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(true);
    }

    @FXML
    private void eightButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(false);
        ninthPane.setVisible(true);
    }

    @FXML
    private void ninthButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(false);
        ninthPane.setVisible(false);
        tenthPane.setVisible(true);
    }

    @FXML
    private void tenthButtonAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Leader_Board.fxml"));
        testAnchor.getChildren().setAll(pane);
    }
    
    @FXML
    private void logOut(ActionEvent event) {
        quitPane.setVisible(true);
        basePane.setDisable(true);
        basePane.setOpacity(0.2);
    }

    @FXML
    private void quitAction(ActionEvent event) throws IOException  {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Topics.fxml"));
        testAnchor.getChildren().setAll(pane);
        
    }

    @FXML
    private void noQuitAction(ActionEvent event) {
        quitPane.setVisible(false);
        basePane.setDisable(false);
        basePane.setOpacity(1);
    }
    
}
