package com.sidhuharry.moosewalatheapp.core;

/**
 * @author Harvinder_Sidhu
 */
public class QuizController {
    
    private int score;
    
    private int noOfQueCompleted;
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getNoOfQueCompleted() {
        return noOfQueCompleted;
    }
    
    public void setNoOfQueCompleted(int noOfQueCompleted) {
        this.noOfQueCompleted = noOfQueCompleted;
    }
    
    public boolean isAllQuestionCompleted() {
        return noOfQueCompleted == 5;
    }
    
}
