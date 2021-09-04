
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class FishMainView {
    
    static int gamePanelWidth = 600, gamePanelHeight = 400;
    final FishView fishView;
    JLabel name,score, lives;
    BucketData bucket; 
    BucketView bv; 
    Image standardFish,octopus;
    JFrame fr;
    
    public FishMainView(FishCollection fc, BucketData B){
        
        bucket = B;
        fishView = new FishView(fc);
        standardFish = Toolkit.getDefaultToolkit().getImage("C:\\Users\\TAYYAB\\Desktop\\Java\\Fish Hunt\\Assets\\Material\\My Use\\fish.png");
        octopus = Toolkit.getDefaultToolkit().getImage("C:\\Users\\TAYYAB\\Desktop\\Java\\Fish Hunt\\Assets\\Material\\My Use\\octopus.png");
    }
    

    public void initGUI() {
         fr = new JFrame("Fish Hunt");
        fr.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        
        JPanel topBar = new JPanel();
        name = new JLabel("Fish Hunt ");
        name.setFont(new Font("Verdana", Font.PLAIN, 35));
        
        score = new JLabel(" Score: " + bucket.getScore());
        score.setFont(new Font("Verdana", Font.PLAIN, 35));
        
        lives = new JLabel("   Lives: " + bucket.getLives());
        lives.setFont(new Font("Verdana", Font.PLAIN, 35));
        
        
        topBar.add(name);
        topBar.add(score);
        topBar.add(lives);
        topBar.setBackground(Color.red);
        fr.add(topBar,c);
        
        c.gridy = 1;
        c.ipady = gamePanelHeight;
        fr.add(fishView,c);

        bv = new BucketView(bucket);
        fr.addKeyListener(new BucketController(gamePanelWidth, bucket));

        c.gridy = 2;
        c.ipady = 0;
        fr.add(bv,c);
               
        JPanel waterPanel = new JPanel();
        ImageIcon waterImg = new ImageIcon("C:\\Users\\TAYYAB\\Desktop\\Java\\Fish Hunt\\Assets\\Material\\My Use\\wave5.gif");
        JLabel water = new JLabel(waterImg);
        waterPanel.setBackground(Color.cyan);
        waterPanel.add(water);
        c.gridy = 3;
        fr.add(waterPanel,c);
        

        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public Observer getObserver()
    {
        return fishView;
    }
    
    public class FishView extends JPanel implements Observer {
        private final FishCollection fishes;

        
            
        public FishView(FishCollection f){
            this.fishes = f;
        }

           @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Fish f : fishes.getFishes())
        {
            if(f.getType().equals("Fish"))
                g.drawImage(standardFish, f.getX(), f.getY(), fishView);
            
            else if(f.getType().equals("Octopus"))
                g.drawImage(octopus, f.getX(), f.getY(), fishView);
            
        }    
    }
    
        @Override
        public void onObservableChange() {
            repaint();
        }
    
    
    }
    
}
