import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Der Starter.
 * 
 * @author Jan Becker
 * @version v1
 */
public class Start
{
    public static final int version = 2;
    public static JFrame frame;

    public static void main(String[] args)
    {
        //System.out.println('\u000C');
        frame = new JFrame();
        frame.setVisible(false);
        frame.setContentPane(new BackGroundPane("Daten/HB.jpg",1));
        frame.setTitle("Clashing Tribes \u00a9");
        frame.setIconImage(new ImageIcon("Daten/HICO2.png").getImage());
        frame.pack();
        frame.setVisible(false);
        frame.setResizable(false);
        
        //new Splash2(frame, "Clahing Tribes", "splash.jpg");

        try {
            if (Integer.parseInt(Updater.getLatestVersion()) > version) {
                new UpdateInfo(Updater.getWhatsNew());
            }
            else { 
                JOptionPane.showMessageDialog(null, "Neuste Version vorhanden: v"+(version-1));
                new Start(frame);
                //System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Start(JFrame frame)
    {
        LF login = new LF(frame);
    }
}
