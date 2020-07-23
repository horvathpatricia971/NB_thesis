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
    private BorderPane thirdMainPane;
    
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
    private void firstWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_1_Health");
        thirdMainPane.setCenter(view);
        
        firstButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    @FXML
    private void secondWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_2_Vegetables");
        thirdMainPane.setCenter(view);
        
        secondButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    @FXML
    private void thirdWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_3_Fruit");
        thirdMainPane.setCenter(view);
        
        thirdButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    @FXML
    private void fourtWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_4_Happy");
        thirdMainPane.setCenter(view);
        
        fourthButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    @FXML
    private void fifthWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_5_Strong");
        thirdMainPane.setCenter(view);
        
        fifthButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    @FXML
    private void sixthWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_6_Exercise");
        thirdMainPane.setCenter(view);
        
        sixthButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    @FXML
    private void seventhWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_7_Diet");
        thirdMainPane.setCenter(view);
        
        seventhButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    @FXML
    private void eightWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_8_Home");
        thirdMainPane.setCenter(view);
        
        eighthButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    @FXML
    private void ninthWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_9_Family");
        thirdMainPane.setCenter(view);
        
        ninthButton.setStyle("-fx-background-color: #6AEA88");
    }
    
    @FXML
    private void tenthWordAction(ActionEvent Event){
        FXMLLoadHealth object = new FXMLLoadHealth();
        Pane view = object.getPage("FXML_Word_First_10_Love");
        thirdMainPane.setCenter(view);
        
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
