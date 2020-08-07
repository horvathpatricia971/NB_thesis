/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author horvathpatricia
 */
public class LoginController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Pane rightPane;
    
    @FXML
    private Pane basePane;
    
    @FXML
    TextField inputUsername;
    
    @FXML
    private ChoiceBox<String> genericBox;
    
    @FXML
    TextField inputAge;
    
    @FXML
    TextField inputId;
    
    @FXML
    private Button buttonRight;
    
    
    
    DB db = new DB();
    
    
  //  private final ObservableList<String> list = FXCollections.observableArrayList("nő", "férfi");


    public final ObservableList<User> data = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  //  genericBox.setItems(list);
      genericBox.getItems().add("nő");
      genericBox.getItems().add("férfi");
    }
    
    @FXML
    private void loadSecond(ActionEvent event) throws IOException {
       
       try {
        String username = inputUsername.getText();
        String gender = genericBox.getValue();
        String ageText = inputAge.getText();
        String idText = inputId.getText();
        
        if(username == null || gender == null || ageText == null || idText == null){
            
            this.isFailedValidation();
            
        }else if(username.equals("") || gender.equals("") || ageText.equals("") || idText.equals("")){
            
            this.isFailedValidation();
            
        }else if (Integer.parseInt(ageText) < 7 || Integer.parseInt(ageText) > 115 ){
          
            this.isFailedValidation();
           
        }else{
            
        int age = Integer.parseInt(ageText);
        int id = Integer.parseInt(idText);
        
        User newUser = new User(username, gender , age, id, 0, 0);
        data.add(newUser);
        db.addUser(newUser);
        inputUsername.clear();
        inputAge.clear();
        inputId.clear();
        db.getAllUsers();
       
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Topics.fxml"));
        rootPane.getChildren().setAll(pane);
        }
        }catch(Exception e){
           this.isFailedValidation();
           e.printStackTrace();
        }
    }
    
    public ObservableList<User> getPersonData() {
		return data;
    }
    
    
   /* public void showContent() {
    try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("thesis/FXML_Leader_BoardController.fxml"));
        Pane content = (Pane) loader.load();
    }*/
    
    

    @FXML
    private void loadRight(ActionEvent event) {
        this.isEnablePanel();
    }
    
    private void isFailedValidation() {
        rightPane.setVisible(true);
        basePane.setDisable(true);
    }
    
    private void isEnablePanel() {
        rightPane.setVisible(false);
        basePane.setDisable(false);
    }

}
