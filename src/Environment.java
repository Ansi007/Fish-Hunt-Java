
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAYYAB
 */

public class Environment {

    public Environment() {
    


        mainMenu();
                   
    }
    
    public void mainMenu(){
        
        JFrame fr = new JFrame("Main Menu");
        fr.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        JLabel ownerLabel1 = new JLabel();
        JLabel gameLabel = new JLabel();
        
        ownerLabel1.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        ownerLabel1.setForeground(new java.awt.Color(255, 102, 0));
        ownerLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ownerLabel1.setText("Sevens Studios Presents");
        fr.add(ownerLabel1,c);
        
        gameLabel.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        gameLabel.setForeground(new java.awt.Color(255, 102, 0));
        gameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameLabel.setText("Fish Hunt");
        
        c.gridy++;
        fr.add(gameLabel,c);
        
        
        JLabel fishIcon = new javax.swing.JLabel();
        Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\TAYYAB\\Desktop\\Java\\Fish Hunt\\Assets\\Material\\Original\\fish.png");
        fishIcon.setIcon(new javax.swing.ImageIcon(img)); // NOI18N
        fishIcon.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridy++;
        fr.add(fishIcon,c);
        
        JLabel playButton = new javax.swing.JLabel();
        playButton.setFont(new java.awt.Font("Calibri", 1, 72)); // NOI18N
        playButton.setForeground(new java.awt.Color(0, 255, 51));
        playButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playButton.setText("PLAY");
        playButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fr.dispose();                
                playGame g = new playGame();
            }
        });
        
        c.gridx = 0;
        c.gridy++;
        fr.add(playButton,c);
        
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
