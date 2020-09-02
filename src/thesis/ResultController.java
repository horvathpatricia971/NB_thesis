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
        
        TableColumn userName = new TableColumn("Felhasználónév");
        userName.setMinWidth(100);
        userName.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn topic = new TableColumn("Téma");
        topic.setMinWidth(100);
        topic.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn difficulty = new TableColumn("Nehézség");
        difficulty.setMinWidth(20);
        difficulty.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn result = new TableColumn("Eredmény");
        result.setMinWidth(50);
        result.setCellFactory(TextFieldTableCell.forTableColumn());
        
        TableColumn time = new TableColumn("Idő");
        time.setMinWidth(50);
        time.setCellFactory(TextFieldTableCell.forTableColumn());

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
