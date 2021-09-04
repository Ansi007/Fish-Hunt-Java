

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAYYAB
 */

public class BucketData {
    
    int x , y,tempY;
    int radius = 20;
    Observer observer;
    int score = 0;
    int lives = 1;
    
    public BucketData(int x, int y) {
        this.x = x;
        this.y = y;      
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getLives() {
        return lives;
    }
        
    public void setScore(int s) {
        score = s;
    }
    
    public void setLives(int l) {
        lives = l;
    }
    
    public void setX(int x) {
        this.x = x;
        notifyObserver();
    }

    public void setY(int y) {
        this.y = y;
        notifyObserver();
    }
    
    public void registerObserver(Observer ob) {
        this.observer = ob;
    }
    
    public void notifyObserver() {
        if(observer == null) 
            return;
        observer.onObservableChange();
    }    
}
