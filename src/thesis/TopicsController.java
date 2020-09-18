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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class TopicsController implements Initializable {

    @FXML
    private AnchorPane topicAnchorPane;
    @FXML
    private Button dataOut;
    @FXML
    private Pane beginPane;
    @FXML
    private Pane quitPane;
    @FXML
    private Pane errorPane;
    @FXML
    private Button buttonQuit;
    @FXML
    private Button buttonNoQuit;
    @FXML
    private Button topLeft;
    @FXML
    private Button topRight;
    @FXML
    private Button middleLeft;
    @FXML
    private Button middleRight;
    @FXML
    private Button bottomLeft;
    @FXML
    private Button bottomRight;
    @FXML
    private Button logOutButton;
    @FXML
    private Label firstErrorLabel;
    @FXML
    private Tooltip tool1;
    Connection conn;

    DBConnection dbconnection;
    
    WordDAO worddao;
    LearnDAO learndao;
    TopicDAO topicdao;
    
    private int userId;
    @FXML
    private Label secondErrorLabel;
    @FXML
    private Button buttonRight;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            conn = DBConnection.getInstance();
            System.out.println("Adatbáziskapcsolat létrehozva.");
            worddao = new WordDAO(conn);
            learndao = new LearnDAO(conn);
            topicdao = new TopicDAO(conn);
            List<Topic> t = topicdao.findAllTopic();
            //topLeft.setStyle(topLeft.getStyle() + ";-fx-background-color:" + t.get(0).getColour());
            topLeft.getStyleClass().add(t.get(0).getColour());
            topLeft.setText(t.get(0).getTopic());
            tool1.setText("A gomb megnyomásával a(z) " + t.get(0).getTopic() + " témakörben tanulhat.");
            //topRight.setStyle(topRight.getStyle() + ";-fx-background-color:" + t.get(1).getColour());
            topRight.getStyleClass().add(t.get(1).getColour());
            topRight.setText(t.get(1).getTopic());
           // middleLeft.setStyle(middleLeft.getStyle() + ";-fx-background-color:" + t.get(2).getColour());
            middleLeft.getStyleClass().add(t.get(2).getColour());
            middleLeft.setText(t.get(2).getTopic());
            //middleRight.setStyle(middleRight.getStyle() + ";-fx-background-color:" + t.get(3).getColour());
            middleRight.getStyleClass().add(t.get(3).getColour());
            middleRight.setText(t.get(3).getTopic());
            //bottomLeft.setStyle(bottomLeft.getStyle() + ";-fx-background-color:" + t.get(4).getColour());
            bottomLeft.getStyleClass().add(t.get(4).getColour());
            bottomLeft.setText(t.get(4).getTopic());
            //bottomRight.setStyle(bottomRight.getStyle() + ";-fx-background-color:" + t.get(5).getColour());
            bottomRight.getStyleClass().add(t.get(5).getColour());
            bottomRight.setText(t.get(5).getTopic());
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            beginPane.setDisable(true);
            firstErrorLabel.setText("Nem jött létre az adatbáziskapcsolat.");
            System.out.println(""+ex);
        }
    }  
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
            

    @FXML
    private void dataOutAction(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Results.fxml"));
        AnchorPane pane = loader.load();
        ResultController controller = loader.<ResultController>getController();
        controller.setUserId(this.userId);
        topicAnchorPane.getChildren().setAll(pane);
        
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        quitPane.setVisible(true);
        beginPane.setDisable(true);
        beginPane.setOpacity(0.5);
    }

    @FXML
    private void quitAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void noQuitAction(ActionEvent event) {
        quitPane.setVisible(false);
        beginPane.setDisable(false);
        beginPane.setOpacity(1);
    }

    @FXML
    private void loadTopLeft(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(1);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadTopRight(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(2);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadMiddleLeft(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(3);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadMiddleRight(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(4);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadBottomLeft(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();        
        controller.setUserId(this.userId);
        controller.setTopicId(5);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadBottomRight(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(6);
        topicAnchorPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void loadRight(ActionEvent event) {
        errorPane.setVisible(false);
        beginPane.setDisable(false);
    }
    

}
