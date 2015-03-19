import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/*
 * Created by Jan Becker on Thu Feb 26 18:33:17 CET 2015
 */

/**
 * @author Jan Becker
 */
public class LF extends JDialog {
    public LF(Frame owner) {
        super(owner);
        initComponents();
        initListener();
        loadSaved(1);
    }

    public LF(Dialog owner) {
        super(owner);
        initComponents();
        initListener();
        loadSaved(1);
    }

    private void initComponents() {
        //BEGIN:initComponents
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setResizable(false);
        setContentPane(new BackGroundPane("Daten/LB2.jpg",0));
        setTitle("Clashing Tribes");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setFont(this.getFont().deriveFont(this.getFont().getSize() - 1f));
        //setAlwaysOnTop(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- textField1 ----
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(textField1);
        textField1.setBounds(15, 25, 130, textField1.getPreferredSize().height);

        //---- passwordField1 ----
        passwordField1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(passwordField1);
        passwordField1.setBounds(15, 70, 130, passwordField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Name");
        label1.setForeground(Color.white);
        contentPane.add(label1);
        label1.setBounds(65, 5, 55, 20);

        //---- label2 ----
        label2.setText("Passwort");
        label2.setForeground(Color.white);
        contentPane.add(label2);
        label2.setBounds(55, 50, 80, 19);

        //---- button1 ----
        button1.setText("Login");
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button1.setFocusPainted(false);
        contentPane.add(button1);
        button1.setBounds(45, 100, 70, 30);

        //---- button2 ----
        button2.setText("Register");
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button2.setFocusPainted(false);
        contentPane.add(button2);
        button2.setBounds(35, 140, 90, 25);

        contentPane.setPreferredSize(new Dimension(160, 180));
        pack();
        setLocationRelativeTo(getOwner());
        //setResizable(false);
        setVisible(true);
        //END:initComponents
    }

    private void initListener()
    {
        //BEGIN:initListener

        //---- button1 ----
        button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    String nameA = new String(textField1.getText());
                    String pwA = new String(passwordField1.getPassword());

                    int admin = 0;
                    int richtig = 0;

                    MySQL mysql1 = new MySQL();
                    int data = mysql1.loginCheck(nameA, pwA);
                    //System.out.println(data);

                    if(data==11)
                    {
                        admin = 1;
                        richtig = 1;
                    }
                    if(data==10) richtig = 1;

                    if(richtig == 1)
                    {
                        String[] nameUpw = loadSaved(0);
                        String nameL = new String(nameUpw[0]);
                        String pwL = new String(nameUpw[1]);

                        if(!nameA.equals(nameL) && !pwA.equals(pwL))
                        {
                            String nameAEncr = encrypter.encrypt(nameA);
                            String pwAEncr = encrypter.encrypt(pwA);

                            textausgabe = "=============== Saved Settings ===============\r\n\r\n"+"Name: "+nameAEncr+"\r\nPasswort: "+pwAEncr;
                            int save = JOptionPane.showConfirmDialog(null, "Sollen deine Daten gespeichert werden?\r\n       (Natürlich verschlüsselt)", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if(save == 0) {
                                ausgabe.schreiben("Daten/Settings.ini",textausgabe);
                            }
                        }
                        
                        setVisible(false);
                        Engine hauptx = new Engine(nameA, pwA, admin);
                        //hauptx.setVisible(true);
                        //new GF(hauptx);
                        //new TestCamerax(hauptx.panel9);
                    }
                    else JOptionPane.showMessageDialog(null, "Name oder Passwort falsch!", "", JOptionPane.WARNING_MESSAGE);
                }
            });

        //---- button2 ----
        button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {

                }
            });

        //---- this ----
        this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent event) {
                    closeApp();
                    //System.exit(1);
                }
            }
        );

        //END:initListener
    }

    private String[] loadSaved(int set)
    {
        String[] zeileArr = new String[10];
        String[] namepw = new String[2];
        int i = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader("Daten/Settings.ini"));
            String zeile = null;

            while ((zeile = in.readLine()) != null) {
                zeileArr[i] = zeile;
                i++;
            }
            String[] namearr = zeileArr[2].split(" ");
            String[] pwarr = zeileArr[3].split(" ");
            String nameAEncr = encrypter.decrypt(namearr[1]);
            String pwAEncr = encrypter.decrypt(pwarr[1]);

            if(set==1)
            {
                textField1.setText(nameAEncr);
                passwordField1.setText(pwAEncr);
            }

            namepw[0] = nameAEncr;
            namepw[1] = pwAEncr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return namepw;
    }

    private void closeApp()
    {
        int ende = JOptionPane.showConfirmDialog(this, "Soll Clashing Tribes wirklich beendet werden?", "Beenden", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(ende == 0) {
            System.exit(1);
        }    
    }

    //BEGIN:variables
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private DateiSchreibenClass ausgabe = new DateiSchreibenClass();
    private String textausgabe;
    Encrypter encrypter = new Encrypter("lafa");
    //END:variables
}
