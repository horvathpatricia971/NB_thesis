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
        // TODO
        
  //      genericBox.setItems(list);
      genericBox.getItems().add("nő");
      genericBox.getItems().add("férfi");
    }   
    
    @FXML
    private void loadSecond(ActionEvent event) throws IOException {
       
       try {
        String username = inputUsername.getText();
        String gender = genericBox.getValue();
        int age = Integer.parseInt(inputAge.getText());
        
        if (username == null && username.isEmpty()){
           rightPane.setVisible(true);
           basePane.setDisable(true);
           basePane.setOpacity(0.3);
        }
        
        if (gender == null && gender.isEmpty()){
           rightPane.setVisible(true);
           basePane.setDisable(true);
           basePane.setOpacity(0.3);
        }
        
        if (age < 7 || age > 115){
           rightPane.setVisible(true);
           basePane.setDisable(true);
           basePane.setOpacity(0.3);
        }

        int id = Integer.parseInt((inputId.getText()));
        
        User newUser = new User(username, gender , age, id, 0, 0);
        data.add(newUser);
        db.addUser(newUser);
        inputUsername.clear();
        inputAge.clear();
        inputId.clear();
        db.getAllUsers();
       
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Topics.fxml"));
        rootPane.getChildren().setAll(pane);
        }catch(Exception e){
           rightPane.setVisible(true);
           basePane.setDisable(true);
           basePane.setOpacity(0.3);

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
        rightPane.setVisible(false);
        basePane.setDisable(false);
        basePane.setOpacity(1);
    }

}
