
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAYYAB
 */

public class fileHandler {
    
    int score;
    public fileHandler(){
    }
    
    public void checkHighest(int s){
        score = s;
        if(readScore() < s){
            updateScore(s);
        }
    }
    
    public void updateScore(int s) {
        
        try {
            File f = new File("highscore.data");
            FileWriter fw = new FileWriter(f,false);     // 'true'  for append mode
            PrintWriter pw = new PrintWriter(fw);
            pw.println(s);
            pw.close();
            fw.close();
            
        } 
        
        catch (Exception ex) {
            ex.printStackTrace();
       }
    }
    
    public int readScore(){
     try {
            File f = new File("highscore.data");		//create a file 'data.data' in project directory
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String hS =  br.readLine();
            int highScore = Integer.parseInt(hS);
            br.close();
            fr.close();
            return highScore;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     return 0;
    }
}
