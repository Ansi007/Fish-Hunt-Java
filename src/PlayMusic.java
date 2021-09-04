
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAYYAB
 */


public class PlayMusic {
    
    
    
    public PlayMusic(){}
    
    public void playMusicLoop(String MusicPath){
        try {
            
            File musicPath = new File(MusicPath);
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {}
            
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public void playMusicOnce(String MusicPath){
        try {
            File musicPath = new File(MusicPath);
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else {}
            
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
}
