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
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author horvathpatricia
 */
public class LoginController implements Initializable {
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Pane rightPane;
    
    @FXML
    private Pane basePane;
    
    @FXML
    private TextField inputUsername;
    
    @FXML
    private TextField inputAge;
    
    @FXML
    private Label firstErrorLabel;
    
    @FXML
    private Label secondErrorLabel;
    
    @FXML
    private ChoiceBox<String> genderBox;
    
    @FXML
    private ChoiceBox<String> educationBox;
     
    @FXML
    private ChoiceBox<String> deseaseBox;
    
    @FXML
    private ChoiceBox<String> hearingBox;
    
    @FXML
    private ChoiceBox<String> seeingBox;

    public final ObservableList<User> data = FXCollections.observableArrayList();

    Connection conn;

    UserDAO userDAO;
    
    DBConnection dbconnection;
    
    Tooltip tool;
    
@Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            conn = DBConnection.getInstance();
            System.out.println("Adatbáziskapcsolat létrehozva.");
            userDAO = new UserDAO(conn);
        } catch (SQLException ex) {
            this.isFailedValidation();
            firstErrorLabel.setText("Nem jött létre az adatbáziskapcsolat.");
            System.out.println(""+ex);
        }
        
        inputUsername.getStyleClass().add("textfield-choicebox");
        inputAge.getStyleClass().add("textfield-choicebox");

        genderBox.getItems().add("nő");
        genderBox.getItems().add("férfi");
        genderBox.getStyleClass().add("textfield-choicebox");
      
        educationBox.getItems().add("általános iskola");
        educationBox.getItems().add("középfokú");
        educationBox.getItems().add("felsőfokú");
        educationBox.getStyleClass().add("textfield-choicebox");
      
        deseaseBox.getItems().add("igen");
        deseaseBox.getItems().add("nem");
        deseaseBox.getStyleClass().add("textfield-choicebox");
      
        hearingBox.getItems().add("igen");
        hearingBox.getItems().add("nem");
        hearingBox.getStyleClass().add("textfield-choicebox");
      
        seeingBox.getItems().add("igen");
        seeingBox.getItems().add("nem");
        seeingBox.getStyleClass().add("textfield-choicebox");
    }
    
    @FXML
    private void loadTopics(ActionEvent event) throws IOException {
       
       try {
        String username = inputUsername.getText();
        String gender = genderBox.getValue();
        String ageText = inputAge.getText();
        String education = educationBox.getValue();
        String desease = deseaseBox.getValue();
        String hearing = hearingBox.getValue();
        String seeing = seeingBox.getValue();
        
        if(username == null || gender == null || ageText == null || education == null || desease == null || hearing ==null || seeing == null){
            
            this.isFailedValidation();
            firstErrorLabel.setText("Valamely adatot nem adott meg!");
            
        }else if(username.equals("") || gender.equals("") || ageText.equals("") || education.equals("") || desease.equals("") || hearing.equals("") || seeing.equals("")){
            
            this.isFailedValidation();
            firstErrorLabel.setText("Valamely adatot nem adott meg!");
            
        }else if (Integer.parseInt(ageText) < 7 || Integer.parseInt(ageText) > 115 ){
          
            this.isFailedValidation();
            firstErrorLabel.setText("Helytelenül adta meg az életkorát!");
            secondErrorLabel.setText("Életkor 6 és 116 közötti érték lehet.");
            
        }else{
            
            int age = Integer.parseInt(ageText);
        
        User newUser = new User(0, username, gender , age, education, desease, hearing, seeing, 0, 0);
        data.add(newUser);
        userDAO.addUser(newUser);
        inputUsername.clear();
        inputAge.clear();
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Topics.fxml"));
        AnchorPane pane = loader.load();
        TopicsController controller = loader.<TopicsController>getController();
        controller.setUserId(newUser.getUserID());
        rootPane.getChildren().setAll(pane);
        }
        }catch(Exception e){
          this.isFailedValidation();
          firstErrorLabel.setText("Valamely adatot helytelenül adott meg!");
           e.printStackTrace();
        }
    }
    
    public ObservableList<User> getPersonData() {
		return data;
    }
    
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
        firstErrorLabel.setText("");
        secondErrorLabel.setText("");
    }

}
