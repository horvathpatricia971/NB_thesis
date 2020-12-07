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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class ResultController implements Initializable {

    @FXML
    private AnchorPane resultAnchor;
    @FXML
    private Pane errorPane;
    @FXML
    private TableView table;
    @FXML
    private Label firstErrorLabel;
    @FXML
    private Label secondErrorLabel;
    @FXML
    private Button buttonRight;
    @FXML
    private Label name;
    
    public final ObservableList<User> data = FXCollections.observableArrayList();
    private ResultDAO resultdao;
    private UserDAO userdao;
    private int userId;
    private User user;
    List<Result> results;
    Result result;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection conn = DBConnection.getInstance();
            System.out.println("Adatbáziskapcsolat létrehozva.");
            resultdao = new ResultDAO(conn);
            userdao = new UserDAO(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TableColumn topic = new TableColumn("Téma");
        topic.setCellValueFactory(new PropertyValueFactory<>("topic"));
        topic.setMinWidth(120);
        
        TableColumn difficulty = new TableColumn("Szint");
        difficulty.setMinWidth(73);
        difficulty.setCellValueFactory(new PropertyValueFactory<>("difficulty"));
        
        TableColumn result = new TableColumn("Eredmény (%)");
        result.setMinWidth(139);
        result.setCellValueFactory(new PropertyValueFactory<>("result"));
        
        TableColumn time = new TableColumn("Idő");
        time.setMinWidth(74);
        time.setCellValueFactory(new PropertyValueFactory<>("timeStr"));

        TableColumn prize = new TableColumn("Nyeremény");
        prize.setCellValueFactory(new PropertyValueFactory<>("prize"));
        prize.setMinWidth(140);
        
        table.getColumns().addAll(topic, difficulty, result, time, prize);
    }
    
    public void setUserId(int userId) throws SQLException {
        this.userId = userId;
        user = userdao.findByIdUser(userId);
        name.setText(user.getUsername() + " összes eredménye");
        try {
            results = resultdao.findResultByUserId(userId);
            ObservableList<Result> obsList = FXCollections.observableArrayList(results);
            table.setItems(obsList);
        } catch (SQLException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void logOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Topics.fxml"));
        AnchorPane pane = loader.load();
        TopicsController controller = loader.<TopicsController>getController();
        controller.setUserId(this.userId);
        resultAnchor.getChildren().setAll(pane);
    }

    @FXML
    private void loadRight(ActionEvent event) {
    }
}
