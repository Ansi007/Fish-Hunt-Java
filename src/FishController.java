
import java.util.Random;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAYYAB
 */

public class FishController implements Runnable {

    final Fish fish;    //single fish
    final BucketData bucket;
    final int maxX,maxY; // dispose after that
    final Random rnd;   //spawn randomly
    static final int speed = 1, delay = 10;
    boolean exit = false;
    JLabel scoreLabel, liveLabel;
    PlayMusic p = new PlayMusic();
    Thread t;
    FishMainView fmV;
    boolean gameOver;
    public FishController(Fish f,  int x, int y, BucketData b, FishMainView fmv, boolean g) {
        this.fish = f;
        this.maxX = x;
        this.maxY = y;
        this.bucket = b;
        this.scoreLabel = fmv.score;
        this.liveLabel = fmv.lives;
        fmV = fmv;
        gameOver = g;
        rnd = new Random();
        fish.setX(rnd.nextInt(this.maxX - fish.getSize())); //what?
        fish.setY(30);
        t = new Thread(this);
        t.start();   
    }
    
    @Override
    public void run() {
        
        while(!exit){
            int newY = fish.getY() + speed;
            
            //Case 1: Did not caught and fell in the water.
            if(fish.getY() >= maxY){
                p.playMusicOnce("C:\\Users\\TAYYAB\\Desktop\\Java\\Fish Hunt\\Assets\\Sound\\splash.wav");
                if(fish.getType().equals("Fish")){
                    int score = bucket.getScore() - 1;
                if(score >= 0){
                    bucket.setScore(score);
                    scoreLabel.setText("Score: " + score);;
                }
            }
                fish.setX(9999);    //----------------------------------------------------------------------------
                exit = true;
                t = null;
      }
            
            //Case 2: Caught in bucket.    
            if(fish.getY()>= 380 && (fish.getX() >= bucket.getX() - bucket.getRadius() && fish.getX() <= bucket.getX() + bucket.getRadius() + 10)){
                    
                if(fish.type.equals("Octopus")){
                    p.playMusicOnce("C:\\Users\\TAYYAB\\Desktop\\Java\\Fish Hunt\\Assets\\Sound\\hit2.wav");
                    int lives = bucket.getLives() - 1;
                    if(lives > 0) {
                        bucket.setLives(lives);
                        liveLabel.setText("   Lives: " + lives);
                        fish.setX(9999);    //----------------------------------------------------------------------------
                        exit = true;
                        t = null;
                    }    
                    
                    else {
                        exit = true;
                        gameOver = false;
                        fmV.fr.dispose();
                        GameOver g = new GameOver(bucket.getScore());
                        g.setVisible(true);
                        break;
                    }
                }
                
                else {
                p.playMusicOnce("C:\\Users\\TAYYAB\\Desktop\\Java\\Fish Hunt\\Assets\\Sound\\fishPicked2.wav");
                int score = bucket.getScore() + 1;
                bucket.setScore(score);
                scoreLabel.setText("Score: " + score);;
                fish.setX(9999);    //----------------------------------------------------------------------------
                exit = true;
                t = null;
            }
        }
            
            fish.setY(newY);
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
}
