/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class TestController implements Initializable {

    @FXML
    private Pane basePane;
    @FXML
    private Pane errorPane;
    @FXML
    private Pane testPane;
    @FXML
    private Pane resultPane;
    @FXML
    private Pane practicePane;
    @FXML
    private Label firstLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private Label resultLabel;
    @FXML
    private Label firstErrorLabel;
    @FXML
    private Label questionLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Button answer1;
    @FXML
    private Button answer2;
    @FXML
    private Button answer3;
    @FXML
    private Button checkButton;
    @FXML
    private Button nextButton;
    
   
    
    private Topic topic;
    private List <TestQuestion> testQuestion;
    private List<TestQuestion> wrongQuestions;
    private TestQuestion currentTestQuestion;
    private TestQuestion wrongQuestionData;
    private List<Word> wrongWord;
    private Word wrongOneWord;
    private TestAttempt testAttempt;
    private Test test;// test.getTestID()
    private User user;
    
    private TopicDAO topicdao;
    private TestQuestionDAO testquestiondao;
    private TestAttemptDAO testattemptdao;
    private TestDAO testdao;
    private TestAnswerDAO testanswerdao;
    private WordDAO worddao;
    private UserDAO userdao;
    
    private int topicId;
    private int testQuestionId;
    private int userId;

    private int selectedAnswer;
    private int questionIndex;
    private int questionIndex2;
    private int questionIndex3;
    private int score;
    private int score2;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button nextButton1;
    @FXML
    private Label answerHun1;
    @FXML
    private Label answerHun2;
    @FXML
    private Label answerHun3;
    @FXML
    private Label secondErrorLabel;
    @FXML
    private Button buttonRight;
    @FXML
    private ImageView right1;
    @FXML
    private ImageView false1;
    @FXML
    private ImageView right2;
    @FXML
    private ImageView false2;
    @FXML
    private ImageView right3;
    @FXML
    private ImageView false3;
    @FXML
    private Label victoryLabel;
    @FXML
    private ImageView victoryPicture;
    @FXML
    private ImageView victorySlice;
    @FXML
    private ImageView victoryBonbon;
    @FXML
    private Button practiceBegin;
    
    @FXML
    private Button practiceCheck;
    @FXML
    private Button nextButtonPractice;
    @FXML
    private Pane firstPane1;
    @FXML
    private ImageView picture;
    @FXML
    private Label titleLabelWord;
    @FXML
    private Label firstSentence;
    @FXML
    private Label secondSentence;
    @FXML
    private Label thirdSentence;
    @FXML
    private Label fourthSentence;
    int serialNum = 0;
    int practiceIndex;
    @FXML
    private Label question;
    @FXML
    private ImageView leftPicture;
    @FXML
    private ImageView middlePicture;
    @FXML
    private ImageView rightPicture;
    @FXML
    private Button leftButton;
    @FXML
    private Button middleButton;
    @FXML
    private Button rightButton;
    @FXML
    private ImageView rightPic1;
    @FXML
    private ImageView rightPic2;
    @FXML
    private ImageView falsePic1;
    @FXML
    private ImageView falsePic2;
    @FXML
    private ImageView rightPic3;
    @FXML
    private ImageView falsePic3;
    private Button sourceButton;
    @FXML
    private Button nextButtonRepeat;
    @FXML
    private Button repetationEndButton;
    @FXML
    private Label endRep1;
    @FXML
    private Label endRep2;
    @FXML
    private ImageView voicePicture;
    @FXML
    private ImageView slowVoice;
    @FXML
    private Button repetationEndButton1;
    @FXML
    private Label endRep11;
    @FXML
    private Label endRep21;
    @FXML
    private Button repetationButton;
    @FXML
    private Label hunAnswer1;
    @FXML
    private Label hunAnswer2;
    @FXML
    private Label hunAnswer3;
    @FXML
    private Label endTest1;
    @FXML
    private Label endTest2;
    @FXML
    private Button testEndButton;
    @FXML
    private Label nameLabel1;
    @FXML
    private Label nameLabel;
    @FXML
    private ImageView victoryBonbon1;
    @FXML
    private ImageView victorySlice1;
    @FXML
    private ImageView victoryPicture1;
    private MediaPlayer mediaPlayer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            Connection conn = DBConnection.getInstance();
            System.out.println("Adatbáziskapcsolat létrehozva.");
            testdao = new TestDAO(conn);
            topicdao = new TopicDAO(conn);
            testquestiondao = new TestQuestionDAO(conn);
            testattemptdao = new TestAttemptDAO(conn);
            testanswerdao = new TestAnswerDAO(conn);
            worddao = new WordDAO(conn);
            userdao = new UserDAO(conn);
        } catch (SQLException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Nem jött létre az adatbáziskapcsolat.");
            System.out.println(""+ex);
        }
        
    }  

    public void setTopicId(int topicId) {
        this.topicId = topicId;
        serialNum = 1;
        fillFrame();
        fillTestData(0);
    }

    public void setUserId(int userId) throws SQLException {
        this.userId = userId;
        user = userdao.findByIdUser(userId);
        nameLabel1.setText("Kedves " + user.getUsername() + "!");
    }

    public void setTestQuestionId(int testQuestionId) {
        this.testQuestionId = testQuestionId;
    }
    
    
       
    private void fillFrame(){
        try {
            test = testdao.findTestByTopicId(this.topicId).get(0);
            testQuestion = testquestiondao.findQuestionByLastLearn(this.userId, this.topicId);
            topic = topicdao.findTopicById(this.topicId);
            titleLabel.setText("Teszt a(z) " + topic.getTopic() + " témakörben");
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Nem jött létre az adatbáziskapcsolat./Ehhez a témához nem kapcsolódik teszt.");
            System.out.println(""+ex);
            Logger.getLogger(LearnController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void beginTestAction(ActionEvent event) { 
        testAttempt = new TestAttempt(0, this.userId, this.test.getTestID(), 0, 0, 0, new java.sql.Timestamp(new java.util.Date().getTime()), null, " ", 0);
        try {
            testattemptdao.addTestAttempt(testAttempt);
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Probléma a tesztkitöltés hozzáadásakor.");
            System.out.println(""+ex);
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        testPane.setVisible(true);
        checkButton.setDisable(true);
        nextButton.setDisable(true);
    }
    
    private void fillTestData(int number){
        TestQuestion testq = testQuestion.get(number);
        currentTestQuestion = testq;
        firstLabel.setText(testq.getQuestionInHungarian());
        secondLabel.setText(testq.getQuestionInEnglish());
        questionLabel.setText(serialNum + ". kérdés");
        numberLabel.setText(serialNum + "/10"); //ahány kérdés van topic NumberOfWords
        answer1.setText(testq.getAnswer1());
        answer2.setText(testq.getAnswer2());
        answer3.setText(testq.getAnswer3());
        
        answer1.setStyle("-fx-background-color: #8AD1FA;");
        answer2.setStyle("-fx-background-color: #8AD1FA;");
        answer3.setStyle("-fx-background-color: #8AD1FA;");

        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        
        answerHun1.setVisible(false);
        answerHun1.setText(testq.getAnswer1hun() +" - ");
        answerHun2.setVisible(false);
        answerHun2.setText(testq.getAnswer2hun() + " - ");
        answerHun3.setVisible(false);
        answerHun3.setText(testq.getAnswer3hun() + " - ");
    }
    
    
    
    @FXML
    private void answerButtonAction(ActionEvent event){
        if (event.getSource() == answer1){
            answer1.setStyle("-fx-background-color: #34CBD4;");
            selectedAnswer = 1;
            
        }else if(event.getSource() == answer2){
            answer2.setStyle("-fx-background-color: #34CBD4;");
            selectedAnswer = 2;
            
        } else if (event.getSource() == answer3) {
            answer3.setStyle("-fx-background-color: #34CBD4;");
            selectedAnswer = 3;
        }
        answer1.setDisable(true);
        answer1.setOpacity(0.9);
        answer2.setDisable(true);
        answer2.setOpacity(0.9);
        answer3.setDisable(true);
        answer3.setOpacity(0.9);
        checkButton.setDisable(false);
    }
    
    @FXML
    private void checkButtonAction(ActionEvent event) {
        int isRight = 0;
        if (currentTestQuestion.getRightAnswer().equals(currentTestQuestion.getAnswer1())) {
        answer1.setStyle("-fx-background-color: #ACFBD5;");
        answer2.setStyle("-fx-background-color: #FF7370;");
        answer3.setStyle("-fx-background-color: #FF7370;");
            switch (selectedAnswer) {
                case 1:
                    score++;
                    isRight = 1;
                    right1.setVisible(true);
                    break;
                case 2:
                    false2.setVisible(true);
                    break;
                case 3:
                    false3.setVisible(true);
                    break;
                default:
                    break;
            }
        } else if(currentTestQuestion.getRightAnswer().equals(currentTestQuestion.getAnswer2())){
            answer1.setStyle("-fx-background-color: #FF7370;");
            answer2.setStyle("-fx-background-color: #ACFBD5;");
            answer3.setStyle("-fx-background-color: #FF7370;");
            switch (selectedAnswer) {
                case 2:
                    score++;
                    isRight = 1;
                    right2.setVisible(true);
                    break;
                case 1:
                    false1.setVisible(true);
                    break;
                case 3:
                    false3.setVisible(true);
                    break;
                default:
                    break;
            }
        } else if(currentTestQuestion.getRightAnswer().equals(currentTestQuestion.getAnswer3())){
            answer1.setStyle("-fx-background-color: #FF7370;");
            answer2.setStyle("-fx-background-color: #FF7370;");
            answer3.setStyle("-fx-background-color: #ACFBD5;");
            switch (selectedAnswer) {
                case 3:
                    score++;
                    isRight = 1;
                    right3.setVisible(true);
                    break;
                case 1:
                    false1.setVisible(true);
                    break;
                case 2:
                    false2.setVisible(true);
                    break;
                default:
                    break;
            }
        }
        checkButton.setDisable(true);
        nextButton.setDisable(false);
        answerHun1.setVisible(true);
        answerHun2.setVisible(true);
        answerHun3.setVisible(true);
        
        TestAnswer testAnswer = new TestAnswer(0, currentTestQuestion.getAnswer(selectedAnswer), isRight, this.testAttempt.getTestAttemptID(), this.currentTestQuestion.getTestQuestionID());
        try {
            testanswerdao.addAnswer(testAnswer);
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Probléma a válasz hozzáadásakor.");
            System.out.println(""+ex);
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void nextButtonAction(ActionEvent event) throws SQLException {
        serialNum ++;
        questionIndex++;
        switch (questionIndex) {
            case 9:
                fillTestData(questionIndex);
                answer1.setOpacity(1);
                answer2.setOpacity(1);
                answer3.setOpacity(1);
                nextButton.setDisable(true);
                right1.setVisible(false);
                right2.setVisible(false);
                right3.setVisible(false);
                false1.setVisible(false);
                false2.setVisible(false);
                false3.setVisible(false);
                nextButton.setText("Befejezés");
                break;
            case 10:
                // TODO: vége a tesztnek
                
                testAttempt.setEndTime(new java.sql.Timestamp(new java.util.Date().getTime()));
                testAttempt.setRightAnswerNum(score);
                testAttempt.setQuestionNum(questionIndex);
                int result = (int) (((float)score / (float)questionIndex) * 100);
                testAttempt.setResult(result);
                try {
                    testattemptdao.updateTestAttempt(testAttempt);
                } catch (SQLException ex) {
                    errorPane.setVisible(true);
                    basePane.setDisable(true);
                    firstErrorLabel.setText("Probléma a befejezési idő tárolásánál.");
                    Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
                }
                testPane.setVisible(false);
                resultPane.setVisible(true);
                titleLabel.setText("A teszt eredménye");
                nameLabel.setText("Kedves " + user.getUsername() + "!");
                if(result == 100){
                    repetationButton.setDisable(true);
                    practiceBegin.setDisable(true);
                }
                resultLabel.setText("10/" + score);
                if (result < 40){
                    victoryLabel.setText("Virtuális nyereménye egy csoki bonbon.");
                    repetationButton.setDisable(false);
                    practiceBegin.setDisable(false);
                    testAttempt.setPrize("bonbon");
                    testattemptdao.updateTestAttempt(testAttempt);
                    try {
                        FileInputStream fis = new FileInputStream("images/bonbon.png");
                        victoryBonbon.setImage(new Image(fis));
                    } catch (FileNotFoundException ex) {
                        // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
                    }
                } else if (result >= 70) {
                    victoryLabel.setText("Virtuális nyereménye egy tábla csoki.");
                    testAttempt.setPrize("tábla csoki");
                    testattemptdao.updateTestAttempt(testAttempt);
                    try {
                        FileInputStream fis = new FileInputStream("images/chocolate.png");
                        victoryPicture.setImage(new Image(fis));
                        
                    } catch (FileNotFoundException ex) {
                        // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
                    }
                } else {
                    victoryLabel.setText("Virtuális nyereménye egy szelet csoki.");
                    repetationButton.setDisable(false);
                    practiceBegin.setDisable(false);
                    testAttempt.setPrize("szelet csoki");
                    testattemptdao.updateTestAttempt(testAttempt);
                    try {
                        FileInputStream fis = new FileInputStream("images/slice2.png");
                        victorySlice.setImage(new Image(fis));
                    } catch (FileNotFoundException ex) {
                        // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
                    }
                }
                break;
            default:
                fillTestData(questionIndex);
                answer1.setOpacity(1);
                answer2.setOpacity(1);
                answer3.setOpacity(1);
                right1.setVisible(false);
                right2.setVisible(false);
                right3.setVisible(false);
                false1.setVisible(false);
                false2.setVisible(false);
                false3.setVisible(false);
                nextButton.setDisable(true);
                break;
        }
        
    }
    
    @FXML
    private void loadRight(ActionEvent event) {
        errorPane.setVisible(false);
        basePane.setDisable(false);
    }
    
    @FXML
    private void repetationBegin(ActionEvent event) throws SQLException {
        titleLabel.setText("Ismétlés a(z) " + topic.getTopic() + " témakörben");
        firstPane1.setVisible(true);
        practicePane.setVisible(false);
        testPane.setVisible(false);
        resultPane.setVisible(false);
        wrongWord = worddao.findWrongWordByTestAttempt(this.testAttempt.getTestAttemptID());
        titleLabelWord.setVisible(true);
        firstSentence.setVisible(true);
        secondSentence.setVisible(true);
        thirdSentence.setVisible(true);
        fourthSentence.setVisible(true);
        nextButtonRepeat.setVisible(true);
        picture.setVisible(true);
        voicePicture.setVisible(true);
        slowVoice.setVisible(true);
        repetationEndButton.setVisible(false);
        endRep1.setVisible(false);
        endRep2.setVisible(false);
        fillWords(0);
    }
    
    @FXML
    private void nextButtonRepeatAction(ActionEvent event) {
        questionIndex3++;
        if (questionIndex3 < wrongWord.size()){
            fillWords(questionIndex3);
        } else {
            titleLabelWord.setVisible(false);
            firstSentence.setVisible(false);
            secondSentence.setVisible(false);
            thirdSentence.setVisible(false);
            fourthSentence.setVisible(false);
            nextButtonRepeat.setVisible(false);
            picture.setVisible(false);
            voicePicture.setVisible(false);
            slowVoice.setVisible(false);
            repetationEndButton.setVisible(true);
            endRep1.setVisible(true);
            endRep2.setVisible(true);
        }
    }

    @FXML
    private void voiceClick(MouseEvent event) {
        String mp3 = "mp3/" + wrongOneWord.getAudio(); //fájl 
        Media sound = new Media(new File(mp3).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    
    private void fillWords(int index){
        wrongOneWord = wrongWord.get(index);
        titleLabelWord.setText(wrongOneWord.getWord() + " - " + wrongOneWord.getWordInEng());
        firstSentence.setText(wrongOneWord.getSentenceHun1());
        secondSentence.setText(wrongOneWord.getSentenceEng1());
        thirdSentence.setText(wrongOneWord.getSentenceHun2());
        fourthSentence.setText(wrongOneWord.getSentenceEng2());
        try {
            FileInputStream fis = new FileInputStream("images/" + wrongOneWord.getImage());
            picture.setImage(new Image(fis));
        } catch (FileNotFoundException ex) {
            // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void repetationEnd(ActionEvent event) throws SQLException {
        resultPane.setVisible(true);
        firstPane1.setVisible(false);
        questionIndex3 = 0;
    }

    @FXML
    private void practiceBegin(ActionEvent event) {
        try {
            titleLabel.setText("Gyakorló teszt");
            wrongWord = worddao.findWrongWordByTestAttempt(this.testAttempt.getTestAttemptID());
            wrongQuestions = testquestiondao.findWrongByTestAttempt(this.testAttempt.getTestAttemptID());
            testAttempt = new TestAttempt(0, this.userId, this.test.getTestID(), 0, 0, 0, new java.sql.Timestamp(new java.util.Date().getTime()), null, " ", 1);
            testattemptdao.addTestAttempt(testAttempt);
            victorySlice.setVisible(false);
            fillWrongQuestionsData(0);
            practicePane.setVisible(true);
            resultPane.setVisible(false);
            nextButtonPractice.setDisable(true);
            practiceCheck.setDisable(true);
            
            leftPicture.setVisible(true);
            middlePicture.setVisible(true);
            rightPicture.setVisible(true);
            leftButton.setVisible(true);
            middleButton.setVisible(true);
            rightButton.setVisible(true);
            question.setVisible(true);
            practiceCheck.setVisible(true);
            nextButtonPractice.setVisible(true);
            endTest1.setVisible(false);
            endTest2.setVisible(false);
            testEndButton.setVisible(false);
            score2 = 0;
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            resultPane.setDisable(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Probléma a hibásan kitöltött kérdések beolvasásakor.");
            System.out.println(""+ex);
        }
        
    }
    
    private void fillWrongQuestionsData(int index) {
        wrongOneWord = wrongWord.get(index);
        // TODO question kitöltése DB alapján
        question.setText("Melyik a(z) " + wrongOneWord.getWord() + "?");
        wrongQuestionData = wrongQuestions.get(index);
        try {
            FileInputStream fis = new FileInputStream("images/" + wrongQuestionData.getPicture1());
            leftPicture.setImage(new Image(fis));
        } catch (FileNotFoundException ex) {
            // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            ex.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream("images/" + wrongQuestionData.getPicture2());
            middlePicture.setImage(new Image(fis));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
        }
        try {
            FileInputStream fis = new FileInputStream("images/" + wrongQuestionData.getPicture3());
            rightPicture.setImage(new Image(fis));
        } catch (FileNotFoundException ex) {
            // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            ex.printStackTrace();
        }
        leftButton.setText(wrongQuestionData.getAnswer1());
        middleButton.setText(wrongQuestionData.getAnswer2());
        rightButton.setText(wrongQuestionData.getAnswer3());
    }
    
    @FXML
    private void answerButtonAct(ActionEvent event) {
        if (event.getSource() == leftButton){
            leftButton.setStyle("-fx-background-color: #34CBD4;");
            sourceButton = leftButton;
        }else if(event.getSource() == middleButton){
            middleButton.setStyle("-fx-background-color: #34CBD4;");
            sourceButton = middleButton;
        } else if (event.getSource() == rightButton) {
            rightButton.setStyle("-fx-background-color: #34CBD4;");
            sourceButton = rightButton;
        }
        leftButton.setDisable(true);
        leftButton.setOpacity(0.9);
        middleButton.setDisable(true);
        middleButton.setOpacity(0.9);
        rightButton.setDisable(true);
        rightButton.setOpacity(0.9);
        practiceCheck.setDisable(false);
    }
    
    @FXML
    private void practiceCheckAction(ActionEvent event) {
        practiceCheck.setDisable(true);
        nextButtonPractice.setDisable(false);
        List<Button> allButtons = Arrays.asList(leftButton, middleButton, rightButton);
        //Button sourceButton = (Button)event.getSource();
        List<Button> nonClickedButtons = new ArrayList<>(allButtons);
        nonClickedButtons.remove(sourceButton);
        List<Button> incorrectButtons = new ArrayList<>(allButtons);
        Button correctButton = null;
        Iterator<Button> iter = incorrectButtons.iterator();
        while (iter.hasNext()) {
            Button b = iter.next();
            if (b.getText().equals(wrongQuestionData.getRightAnswer())) {
                correctButton = b;
                iter.remove();
            }
        }
        
        correctButton.setStyle("-fx-background-color: #ACFBD5;");
        for (Button other : incorrectButtons) {
            other.setStyle("-fx-background-color: #FF7370;");
        }
        int isRight = 0;
        if (correctButton == sourceButton) {
            score2++;
            isRight = 1;
            if (correctButton == allButtons.get(0)){
                rightPic1.setVisible(true);
            } else if (correctButton == allButtons.get(1)){
                rightPic2.setVisible(true);
            } else {
                rightPic3.setVisible(true);
            }
        } else {
            if (sourceButton == leftButton){
                falsePic1.setVisible(true);
            } else if (sourceButton == middleButton){
                falsePic2.setVisible(true);
            } else{
                falsePic3.setVisible(true);
            }
        }
        nextButtonPractice.setDisable(false);
        hunAnswer1.setVisible(true);
        hunAnswer2.setVisible(true);
        hunAnswer3.setVisible(true);
        hunAnswer1.setText(wrongQuestionData.getAnswer1hun());
        hunAnswer2.setText(wrongQuestionData.getAnswer2hun());
        hunAnswer3.setText(wrongQuestionData.getAnswer3hun());
        TestAnswer testAnswer = new TestAnswer(0, 
                wrongQuestionData.getAnswer(allButtons.indexOf(sourceButton)+1), 
                isRight, this.testAttempt.getTestAttemptID(), 
                this.wrongQuestionData.getTestQuestionID());
        try {
            testanswerdao.addAnswer(testAnswer);
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Probléma a válasz hozzáadásakor.");
            System.out.println(""+ex);
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void nextButtonPracticeAction(ActionEvent event) {
        
        leftButton.setStyle("-fx-background-color: #8AD1FA;");
        middleButton.setStyle("-fx-background-color: #8AD1FA;");
        rightButton.setStyle("-fx-background-color: #8AD1FA;");
        rightPic1.setVisible(false);
        rightPic2.setVisible(false);
        rightPic3.setVisible(false);
        falsePic1.setVisible(false);
        falsePic2.setVisible(false);
        falsePic3.setVisible(false);
        hunAnswer1.setVisible(false);
        hunAnswer2.setVisible(false);
        hunAnswer3.setVisible(false);
        leftButton.setDisable(false);
        middleButton.setDisable(false);
        rightButton.setDisable(false);
        practiceCheck.setDisable(true);
        
        questionIndex2++;
        if (questionIndex2 < wrongQuestions.size()){
            fillWrongQuestionsData(questionIndex2);
            nextButtonPractice.setDisable(true);
        }else {
            rightPic1.setVisible(false);
            rightPic2.setVisible(false);
            rightPic3.setVisible(false);
            falsePic1.setVisible(false);
            falsePic2.setVisible(false);
            falsePic3.setVisible(false);
            leftPicture.setVisible(false);
            middlePicture.setVisible(false);
            rightPicture.setVisible(false);
            hunAnswer1.setVisible(false);
            hunAnswer2.setVisible(false);
            hunAnswer3.setVisible(false);
            leftButton.setVisible(false);
            middleButton.setVisible(false);
            rightButton.setVisible(false);
            question.setVisible(false);
            practiceCheck.setVisible(false);
            nextButtonPractice.setVisible(false);
            endTest1.setVisible(true);
            endTest2.setVisible(true);
            testEndButton.setVisible(true);
        }
        
    }

    @FXML
    private void pictureTestEnd(ActionEvent event) throws SQLException {
        testAttempt.setEndTime(new java.sql.Timestamp(new java.util.Date().getTime()));
        testAttempt.setRightAnswerNum(score2);
        testAttempt.setQuestionNum(questionIndex2);
        int result2 = (int) (((float)score2 / (float)questionIndex2) * 100);
        testAttempt.setResult(result2);
        try {
            testattemptdao.updateTestAttempt(testAttempt);
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            basePane.setDisable(true);
            firstErrorLabel.setText("Probléma a befejezési idő tárolásánál.");
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultLabel.setText(questionIndex2 + "/" + score2);  
        practicePane.setVisible(false);
        resultPane.setVisible(true);
        victoryBonbon.setVisible(false);
        victoryPicture.setVisible(false);
        victorySlice.setVisible(false);
        if(result2 == 100){
            repetationButton.setDisable(true);
            practiceBegin.setDisable(true);
                }
        if (result2 < 40){
            victoryLabel.setText("Virtuális nyereménye egy csoki bonbon.");
            repetationButton.setDisable(false);
            practiceBegin.setDisable(false);
            testAttempt.setPrize("bonbon");
            testattemptdao.updateTestAttempt(testAttempt);
            try {
                victoryBonbon.setVisible(true);
                FileInputStream fis = new FileInputStream("images/bonbon.png");
                victoryBonbon.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            }
         } else if (result2 >= 70) {
            victoryLabel.setText("Virtuális nyereménye egy tábla csoki.");
            testAttempt.setPrize("tábla csoki");
            testattemptdao.updateTestAttempt(testAttempt);
            try {
                victoryPicture.setVisible(true);
                FileInputStream fis = new FileInputStream("images/chocolate.png");
                victoryPicture.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            }
        } else {
            victoryLabel.setText("Virtuális nyereménye egy szelet csoki.");
            repetationButton.setDisable(false);
            practiceBegin.setDisable(false);
            testAttempt.setPrize("szelet csoki");
            testattemptdao.updateTestAttempt(testAttempt);
            try {
                victorySlice.setVisible(true);
                FileInputStream fis = new FileInputStream("images/slice2.png");
                victorySlice.setImage(new Image(fis));
             } catch (FileNotFoundException ex) {
                // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            }
        }
        firstPane1.setVisible(false);
        testPane.setVisible(false);
        questionIndex2 = 0;
    }
    
   @FXML
    private void loadResult(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Results.fxml"));
        AnchorPane pane = loader.load();
        ResultController controller = loader.<ResultController>getController();
        controller.setUserId(this.userId);
        mainPane.getChildren().setAll(pane);
        
    } 

    @FXML
    private void slowVoiceClick(MouseEvent event) {
        String mp3 = "mp3/" + wrongOneWord.getSlowAudio();
        Media sound = new Media(new File(mp3).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
