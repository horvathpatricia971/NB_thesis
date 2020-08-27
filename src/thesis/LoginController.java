/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
    TextField inputUsername;
    
    @FXML
    private ChoiceBox<String> genericBox1;
    
    @FXML
    private ChoiceBox<String> genericBox2;
     
    @FXML
    private ChoiceBox<String> genericBox3;
    
    @FXML
    private ChoiceBox<String> genericBox4;
    
    @FXML
    private ChoiceBox<String> genericBox5;
    
    @FXML
    TextField inputAge;

    public final ObservableList<User> data = FXCollections.observableArrayList();

    Connection conn;

    UserDAO userDAO;
    DBConnection dbconnection;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
        //    dbconnection.getInstance();
            conn = DBConnection.getInstance();
            System.out.println("A híd létrejött");
            userDAO = new UserDAO(conn);
        } catch (SQLException ex) {
            
            System.out.println("Valami nem jó a connection létrehozásakor");
            System.out.println(""+ex);
        }
        

      genericBox1.getItems().add("nő");
      genericBox1.getItems().add("férfi");
      
      genericBox2.getItems().add("általános iskola");
      genericBox2.getItems().add("középfokú");
      genericBox2.getItems().add("felsőfokú");
      
      genericBox3.getItems().add("igen");
      genericBox3.getItems().add("nem");
      
      genericBox4.getItems().add("igen");
      genericBox4.getItems().add("nem");
      
      genericBox5.getItems().add("igen");
      genericBox5.getItems().add("nem");
    }
    
    @FXML
    private void loadSecond(ActionEvent event) throws IOException {
       
       try {
        String username = inputUsername.getText();
        String gender = genericBox1.getValue();
        String ageText = inputAge.getText();
        String education = genericBox2.getValue();
        String desease = genericBox3.getValue();
        String hearing = genericBox4.getValue();
        String seeing = genericBox5.getValue();
        
        if(username == null || gender == null || ageText == null || education == null || desease == null || hearing ==null || seeing == null){
            
            this.isFailedValidation();
            
        }else if(username.equals("") || gender.equals("") || ageText.equals("") || education.equals("") || desease.equals("") || hearing.equals("") || seeing.equals("")){
            
            this.isFailedValidation();
            
        }else if (Integer.parseInt(ageText) < 7 || Integer.parseInt(ageText) > 115 ){
          
            this.isFailedValidation();
           
        }else{
            
            int age = Integer.parseInt(ageText);
        
        User newUser = new User(0, username, gender , age, education, desease, hearing, seeing, 0, 0);
        data.add(newUser);
        userDAO.addUser(newUser);
        inputUsername.clear();
        inputAge.clear();
       
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
