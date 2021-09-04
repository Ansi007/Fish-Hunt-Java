/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAYYAB
 */

public class playGame implements Runnable{

    static int gamePanelWidth = 600, gamePanelHeight = 400;
    static int bucketX = gamePanelWidth / 2, bucketY = 0;
    FishMainView fmv;
    FishCollection fishes;
    BucketData bucket;
    Thread t;
    boolean gameOver = true;
    public playGame() {
        fishes = new FishCollection();
        bucket = new BucketData(bucketX, bucketY);
        fmv = new FishMainView(fishes,bucket);
        t = new Thread(this);
        t.start();
    }
    
    
    
    @Override
    public void run() {
        
        fmv.initGUI();
        while(gameOver) {
            Fish f = new Fish();
            fishes.addFish(f);
            f.registerObserver(fmv.getObserver());
            new FishController(f, gamePanelWidth, gamePanelHeight, bucket, fmv,gameOver);
            
             try {
                Thread.sleep(2000,500);
            } catch (Exception e) {
                e.printStackTrace();
            }
             
        }
    }    
}
