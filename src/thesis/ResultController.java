/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class ResultController implements Initializable {

    @FXML
    private AnchorPane resultAnchor;
    @FXML
    private TableView table;
    @FXML
    private User hierUser;
    @FXML
    private LoginController DocContLog;
    
    public final ObservableList<User> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    
    
     
    
    public void initialize(URL url, ResourceBundle rb) {
        
        UserService us = new UserService();
        //table.setItems(us.getUserList());
        TableColumn userName = new TableColumn("Felhasználónév");
        userName.setMinWidth(100);
        userName.setCellFactory(TextFieldTableCell.forTableColumn());
        userName.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        
        TableColumn gender = new TableColumn("Nem");
        gender.setMinWidth(40);
        gender.setCellFactory(TextFieldTableCell.forTableColumn());
        gender.setCellValueFactory(new PropertyValueFactory<User, String>("gender"));
        
        TableColumn age = new TableColumn("Kor");
        age.setMinWidth(20);
        age.setCellFactory(TextFieldTableCell.forTableColumn());
        age.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));
        
        TableColumn id = new TableColumn("Id");
        id.setMinWidth(100);
        id.setCellFactory(TextFieldTableCell.forTableColumn());
        id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        
        TableColumn excercisesNumber = new TableColumn("Feladatszam");
        excercisesNumber.setMinWidth(50);
        excercisesNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        excercisesNumber.setCellValueFactory(new PropertyValueFactory<User, Integer>("excercisesNumber"));
        
        TableColumn userResult = new TableColumn("Eredmény");
        userResult.setMinWidth(50);
        userResult.setCellFactory(TextFieldTableCell.forTableColumn());
        userResult.setCellValueFactory(new PropertyValueFactory<User, Integer>("userResult"));
        
        table.getColumns().addAll(userName, gender, age, id, excercisesNumber, userResult);
        //LoginController cl = new LoginController();
        try{
        ArrayList<User> newList = us.getList();
        table.getItems();
        table.setItems(us.getUserList(newList));
        }catch(Exception e){
            e.printStackTrace();
        }
        /*for(User user: us.getUserList()){
            table.getItems().add(user);
        }*/
        // table.getItems(cl.data);
    }
   
/*public static ArrayList<User> searchUsers() throws SQLException, ClassNotFoundException {
        String selectUser = "SELECT * FROM users";
        ArrayList<User> users = null;
        ResultSet rsUsers = DB().createStatement.executeQuery(selectUser);
        users = new ArrayList();
         table.setItems((ObservableList) users);
         return users;
        
    }*/
    
    public void SetDocControl(LoginController DocContLog){
        this.SetDocControl(DocContLog);
        table.setItems(DocContLog.getPersonData());  
    }
    
    @FXML
    private void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Topics.fxml"));
        resultAnchor.getChildren().setAll(pane);
    }
}
