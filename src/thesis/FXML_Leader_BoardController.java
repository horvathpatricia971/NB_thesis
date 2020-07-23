/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class FXML_Leader_BoardController implements Initializable {

    @FXML
    private TableView table;
    
    private User hierUser;
    
    private FXMLDocumentController_Login DocContLog;

    /**
     * Initializes the controller class.
     */
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
        
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
    //    table.setItems(DocContLog.getPersonData());
    }    
    public void SetDocControl(FXMLDocumentController_Login DocContLog){
        this.SetDocControl(DocContLog);
        table.setItems(DocContLog.getPersonData());
    }
}
