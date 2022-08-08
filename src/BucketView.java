    
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
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

public class BucketView extends JLabel implements Observer {
    
    BucketData bucket;
    Image bucketImage = Toolkit.getDefaultToolkit().getImage("D:\\Game Development\\Java\\Fish-Hunt-Java\\bucket.png");

    public BucketView(BucketData b) {
        bucket = b;
        initGUI();
    }
    
    void initGUI(){
        setIcon(new ImageIcon(bucketImage));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.repaint();
        g.drawImage(bucketImage, bucket.getX(), bucket.getY(), this);
        
    }

    @Override
    public void onObservableChange() {
        repaint();
    }
}
