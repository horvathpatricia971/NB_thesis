/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class FXMLController_Word_Health implements Initializable {
    
    
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
        
        firstButton.setStyle("-fx-background-color: #6AEA88");
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
        
        secondButton.setStyle("-fx-background-color: #6AEA88");
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
        
        thirdButton.setStyle("-fx-background-color: #6AEA88");
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
        
        fourthButton.setStyle("-fx-background-color: #6AEA88");
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
        
        fifthButton.setStyle("-fx-background-color: #6AEA88");
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
        
        sixthButton.setStyle("-fx-background-color: #6AEA88");
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
        
        seventhButton.setStyle("-fx-background-color: #6AEA88");
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
        
        eighthButton.setStyle("-fx-background-color: #6AEA88");
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
        
        ninthButton.setStyle("-fx-background-color: #6AEA88");
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
        
        tenthButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
   
    
}
