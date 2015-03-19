import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class BackGroundPane extends JPanel {
    Image img = null;
    int scalex;

    BackGroundPane(String imagefile, int scale) {
        if(scale==1) scalex = 1;
        else scalex = 0;
        if (imagefile != null) {
            MediaTracker mt = new MediaTracker(this);
            img = Toolkit.getDefaultToolkit().getImage(imagefile);
            mt.addImage(img, 0);
            try {
                mt.waitForAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(scalex==1) g.drawImage(img,-85,-160,this);
        else g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }
}
