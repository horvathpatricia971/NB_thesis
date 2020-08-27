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
public class Test {
    private int testID;
    private int topicID;
    
    public Test(int TestID, int TopicID){
        this.testID = TestID;
        this.topicID = TopicID;
    }
    
    public int getTestID(){
        return testID;
    }
    
    public void setTestID(int TestID){
        this.testID = TestID;
    }
    
    public int getTopicID(){
	return topicID;
    }

    public void setTopicID(int TopicId){
	this.topicID = TopicId;
    }
}
