
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAYYAB
 */

public class BucketController implements KeyListener {

    int maxX;
    BucketData bucket;
    int speed = 10;
    
    public BucketController(int x, BucketData b) {
        maxX = x;
        bucket = b;
    }

    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case 37: {
                int newX = bucket.getX() - speed;
                if(newX >= 0){
                    bucket.setX(newX);
                }
                
                
                break;
            }
            
            case 39: {
                  int newX = bucket.getX() + speed;
                if(newX <= maxX - 50){
                    bucket.setX(newX);
                }
            break;
                 }
        }        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
    
    
}
