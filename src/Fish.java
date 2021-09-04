
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAYYAB
 */
    
public class Fish {
    int x,y;
    final int size = 30;
    Observer observer;
    String type;
    
    public Fish(){
        Random rnd = new Random();
        int r = (rnd.nextInt(6));
        if(r <= 4 ){
            type = "Fish";
        }
        
        else {
            type = "Octopus";
        }
    }
    
    public String getType(){
        return type;
    }
    

    public synchronized int getX(){
        return x;
    }

    public synchronized int getY(){
        return y;
    }
    
    public synchronized void setX(int x) {
        this.x = x;
        notifyObserver();
    }

    public synchronized void setY(int y) {
        this.y = y;
        notifyObserver();
    }
    
    public int getSize()
    {
        return size;
    }
    

    public void registerObserver(Observer ob)
    {
        this.observer = ob;
    }
    
    public void notifyObserver()
    {
        if(observer == null) 
            return;
        observer.onObservableChange();
    }
    
    
}
