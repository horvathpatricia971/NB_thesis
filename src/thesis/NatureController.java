/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class NatureController implements Initializable {
    
    
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
    private Pane secondPane;
    @FXML
    private Pane thirdPane;
    @FXML
    private Pane fourthPane;
    @FXML
    private Pane fifthPane;
    @FXML
    private Pane sixthPane;
    @FXML
    private Pane seventhPane;
    @FXML
    private Pane eightPane;
    @FXML
    private Pane ninthPane;
    @FXML
    private Pane tenthPane;
    @FXML
    private Button testClick;
    
    @FXML
    private AnchorPane healthAnchorPane;
    
    private List<Boolean> testReady;
    
    @FXML
    private void firstWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_1_Health");
        //thirdMainPane.setCenter(view);
        
        firstPane.setVisible(true);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(false);
        ninthPane.setVisible(false);
        tenthPane.setVisible(false);
        
        firstButton.setStyle("-fx-background-color: #A0E5AA");
        
        if(!this.testReady.get(0)){
            this.testReady.set(0, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void secondWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_2_Vegetables");
        //thirdMainPane.setCenter(view);
        firstPane.setVisible(false);
        secondPane.setVisible(true);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(false);
        ninthPane.setVisible(false);
        tenthPane.setVisible(false);
        
        secondButton.setStyle("-fx-background-color: #A0E5AA");
        
        if(!this.testReady.get(1)){
            this.testReady.set(1, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void thirdWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_3_Fruit");
        //thirdMainPane.setCenter(view);
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(true);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(false);
        ninthPane.setVisible(false);
        tenthPane.setVisible(false);
        
        thirdButton.setStyle("-fx-background-color: #A0E5AA");
        if(!this.testReady.get(2)){
            this.testReady.set(2, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void fourtWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_4_Happy");
        //thirdMainPane.setCenter(view);
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(true);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(false);
        ninthPane.setVisible(false);
        tenthPane.setVisible(false);
        
        fourthButton.setStyle("-fx-background-color: #A0E5AA");
        if(!this.testReady.get(3)){
            this.testReady.set(3, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void fifthWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_5_Strong");
        //thirdMainPane.setCenter(view);
        
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(true);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(false);
        ninthPane.setVisible(false);
        tenthPane.setVisible(false);
        
        fifthButton.setStyle("-fx-background-color: #A0E5AA");
        if(!this.testReady.get(4)){
            this.testReady.set(4, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void sixthWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_6_Exercise");
        //thirdMainPane.setCenter(view);
        
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(true);
        seventhPane.setVisible(false);
        eightPane.setVisible(false);
        ninthPane.setVisible(false);
        tenthPane.setVisible(false);
        
        sixthButton.setStyle("-fx-background-color: #A0E5AA");
        if(!this.testReady.get(5)){
            this.testReady.set(5, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void seventhWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_7_Diet");
        //thirdMainPane.setCenter(view);
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(true);
        eightPane.setVisible(false);
        ninthPane.setVisible(false);
        tenthPane.setVisible(false);
        
        seventhButton.setStyle("-fx-background-color: #A0E5AA");
        
        if(!this.testReady.get(6)){
            this.testReady.set(6, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void eightWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_8_Home");
        //thirdMainPane.setCenter(view);
        
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(true);
        ninthPane.setVisible(false);
        tenthPane.setVisible(false);
        
        eighthButton.setStyle("-fx-background-color: #A0E5AA");
        
        if(!this.testReady.get(7)){
            this.testReady.set(7, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void ninthWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_9_Family");
        //thirdMainPane.setCenter(view);
        
        firstPane.setVisible(false);
        secondPane.setVisible(false);
        thirdPane.setVisible(false);
        fourthPane.setVisible(false);
        fifthPane.setVisible(false);
        sixthPane.setVisible(false);
        seventhPane.setVisible(false);
        eightPane.setVisible(false);
        ninthPane.setVisible(true);
        tenthPane.setVisible(false);
        
        ninthButton.setStyle("-fx-background-color: #A0E5AA");
        
        if(!this.testReady.get(8)){
            this.testReady.set(8, Boolean.TRUE);
            this.checkTestReady();
        }
    }
    
    @FXML
    private void tenthWordAction(ActionEvent Event){
        //FXMLLoadHealth object = new FXMLLoadHealth();
        //Pane view = object.getPage("FXML_Word_First_10_Love");
        //thirdMainPane.setCenter(view);
        
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
        
        tenthButton.setStyle("-fx-background-color: #A0E5AA");
        
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
    }

    @FXML
    private void testClickAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Test_Health.fxml"));
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