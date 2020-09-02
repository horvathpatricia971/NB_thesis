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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class TopicsController implements Initializable {

    @FXML
    private AnchorPane secondAnchorPane;
    @FXML
    private Button dataOut;
    @FXML
    private Pane beginPane;
    @FXML
    private Pane quitPane;
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
    
    Connection conn;

    WordDAO worddao;
    LearnDAO learndao;
    DBConnection dbconnection;
    TopicDAO topicdao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            conn = DBConnection.getInstance();
            System.out.println("A híd létrejött");
            worddao = new WordDAO(conn);
            learndao = new LearnDAO(conn);
            topicdao = new TopicDAO(conn);
            List<Topic> t = topicdao.findAllTopic();
            topLeft.setStyle(topLeft.getStyle()+";-fx-background-color: " + t.get(0).getColour());
            topLeft.setText(t.get(0).getTopic());
            topRight.setStyle(topRight.getStyle()+";-fx-background-color: " + t.get(1).getColour());
            topRight.setText(t.get(1).getTopic());
            middleLeft.setStyle(middleLeft.getStyle()+";-fx-background-color: " + t.get(2).getColour());
            middleLeft.setText(t.get(2).getTopic());
            middleRight.setStyle(middleRight.getStyle()+";-fx-background-color: " + t.get(3).getColour());
            middleRight.setText(t.get(3).getTopic());
            bottomLeft.setStyle(bottomLeft.getStyle()+";-fx-background-color: " + t.get(4).getColour());
            bottomLeft.setText(t.get(4).getTopic());
            bottomRight.setStyle(bottomRight.getStyle()+";-fx-background-color: " + t.get(5).getColour());
            bottomRight.setText(t.get(5).getTopic());
            
        } catch (SQLException ex) {
            
            System.out.println("Valami nem jó a connection létrehozásakor");
            System.out.println(""+ex);
        }
    }    

    @FXML
    private void dataOutAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Results.fxml"));
        secondAnchorPane.getChildren().setAll(pane);
       
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        quitPane.setVisible(true);
        beginPane.setDisable(true);
        beginPane.setOpacity(0.2);
    }

    @FXML
    private void quitAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));
        secondAnchorPane.getChildren().setAll(pane);
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
        controller.setTopicId(1);
        secondAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadTopRight(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setTopicId(2);
        secondAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadMiddleLeft(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setTopicId(3);
        secondAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadMiddleRight(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setTopicId(4);
        secondAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadBottomLeft(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setTopicId(5);
        secondAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadBottomRight(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setTopicId(6);
        secondAnchorPane.getChildren().setAll(pane);
    }
}
