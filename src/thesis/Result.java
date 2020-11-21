/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

/**
 *
 * @author horvathpatricia
 */
public class Result {
    private String userName;
    private String topic;
    private int difficulty;
    private int result;
    private int time;
    private String prize;
    
    public Result(String userName, String topic, int difficulty, int result, int time, String prize){
        this.userName = userName;
        this.topic = topic;
        this.difficulty = difficulty;
        this.result = result;
        this.time = time;
        this.prize = prize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    public String getTimeStr(){
        return String.format("%02d:%02d", time/60,time%60);
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String victory) {
        this.prize = victory;
    }
}
