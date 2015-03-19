import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.event.*;
/*
 * Created by Jan Becker on Thu Feb 26 18:11:17 CET 2015
 */

/**
 * @author Jan Becker
 */
public class HF extends JFrame {
    public HF(String nameA, String pwA, int admin) {
        initComponents(nameA);
        initListener();
    }

    protected void initComponents(String name) {
        //BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        textField1 = new JTextField();
        panel2 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        panel3 = new JPanel();
        panel5 = new JPanel();
        comboBox1 = new JComboBox<>();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        scrollPane3 = new JScrollPane();
        table2 = new JTable();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        panel4 = new JPanel();
        panel6 = new JPanel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        button4 = new JButton();
        button5 = new JButton();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        namexx = name;
        button6 = new JButton();

        //======== this ========
        setContentPane(new BackGroundPane("Daten/HB.jpg",1));
        setTitle("Clashing Tribes \u00a9");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setIconImage(new ImageIcon("Daten/HICO2.png").getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        //setUndecorated(true);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(tabbedPane1.getFont().deriveFont(tabbedPane1.getFont().getSize() + 4f));
            tabbedPane1.setFocusable(false);

            //======== panel1 ========
            {
                panel1.setBackground(new Color(255, 255, 255, 0));
                panel1.setLayout(null);

                //======== panel8 ========
                {
                    panel8.setMaximumSize(new Dimension(30, 30));
                    panel8.setMinimumSize(new Dimension(30, 30));
                    panel8.setPreferredSize(new Dimension(30, 30));
                    panel8.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                    panel8.setOpaque(false);
                    panel8.setLayout(null);

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel8.getComponentCount(); i++) {
                            Rectangle bounds = panel8.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel8.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel8.setMinimumSize(preferredSize);
                        panel8.setPreferredSize(preferredSize);
                    }
                }
                JPanel bgPanel3 = new BgPanel();
                bgPanel3.setLayout(new BorderLayout());
                bgPanel3.add(panel8, BorderLayout.CENTER);
                panel1.add(bgPanel3);
                bgPanel3.setBounds(-5, -5, 560, 350);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Stamm  ", new ImageIcon("Daten/spielico.png"), panel1);
            tabbedPane1.setBackgroundAt(0, Color.lightGray);
            tabbedPane1.setForegroundAt(0, Color.black);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(255, 255, 255, 0));
                panel2.setLayout(null);

                //---- button1 ----
                button1.setText("text");
                panel2.add(button1);
                button1.setBounds(new Rectangle(new Point(30, 30), button1.getPreferredSize()));

                //---- button2 ----
                button2.setText("text");
                panel2.add(button2);
                button2.setBounds(new Rectangle(new Point(145, 30), button2.getPreferredSize()));

                //---- button3 ----
                button3.setText("text");
                panel2.add(button3);
                button3.setBounds(new Rectangle(new Point(255, 30), button3.getPreferredSize()));

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Shop  ", new ImageIcon("Daten/shopico.png"), panel2);
            tabbedPane1.setBackgroundAt(1, Color.lightGray);
            tabbedPane1.setForegroundAt(1, Color.black);

            //======== panel3 ========
            {
                panel3.setBackground(new Color(255, 255, 255, 0));
                panel3.setLayout(null);

                //======== panel5 ========
                {
                    panel5.setOpaque(false);
                    panel5.setPreferredSize(new Dimension(11, 11));
                    panel5.setBackground(Color.white);
                    panel5.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                    panel5.setLayout(null);

                    //---- comboBox1 ----
                    comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                                "(Bitte w\u00e4hlen)",
                                "[ATTACK] - Name1 vs. Name2",
                                "[DEFENSE] - Name1 vs. Name2"
                            }));
                    comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getSize() + 1f));
                    comboBox1.setBackground(UIManager.getColor("ScrollBar.background"));
                    comboBox1.setForeground(Color.black);
                    comboBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    comboBox1.setFocusable(false);
                    panel5.add(comboBox1);
                    comboBox1.setBounds(95, 30, 410, 25);

                    //======== scrollPane2 ========
                    {
                        objt1 = new Object[][] {{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},};

                        //---- table1 ----
                        table1.setModel(new DefaultTableModel(
                                objt1,
                                new String[] {
                                    "Einheit A", "Einheit B", "Einheit C", "Einheit D", "Einheit E"
                                }
                            ) {
                                Class<?>[] columnTypes = new Class<?>[] {
                                        Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
                                    };
                                boolean[] columnEditable = new boolean[] {
                                        false, false, false, false, false
                                    };
                                @Override
                                public Class<?> getColumnClass(int columnIndex) {
                                    return columnTypes[columnIndex];
                                }

                                @Override
                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return columnEditable[columnIndex];
                                }
                            });
                        {
                            TableColumnModel cm = table1.getColumnModel();
                            cm.getColumn(0).setResizable(false);
                            cm.getColumn(1).setResizable(false);
                            cm.getColumn(2).setResizable(false);
                            cm.getColumn(3).setResizable(false);
                            cm.getColumn(4).setResizable(false);
                        }
                        table1.setGridColor(Color.black);
                        table1.setEnabled(false);
                        table1.setForeground(Color.black);
                        table1.setRowSorter(null);
                        table1.setPreferredSize(new Dimension(375, 31));
                        table1.setBackground(UIManager.getColor("PasswordField.background"));
                        table1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                        table1.setFocusable(false);
                        table1.setSelectionForeground(Color.black);
                        table1.getTableHeader().setReorderingAllowed(false);
                        scrollPane2.setViewportView(table1);
                    }
                    panel5.add(scrollPane2);
                    scrollPane2.setBounds(85, 95, 440, 55);

                    //---- label1 ----
                    label1.setText("Einheit:");
                    label1.setForeground(Color.black);
                    //panel5.add(label1);
                    label1.setBounds(30, 95, 50, label1.getPreferredSize().height);

                    //---- label2 ----
                    label2.setText("Gesamt:");
                    label2.setForeground(Color.black);
                    panel5.add(label2);
                    label2.setBounds(30, 115, 50, label2.getPreferredSize().height);

                    //---- label3 ----
                    label3.setText("Tote:");
                    label3.setForeground(Color.black);
                    panel5.add(label3);
                    label3.setBounds(new Rectangle(new Point(30, 135), label3.getPreferredSize()));

                    //---- label4 ----
                    label4.setText("Einheit:");
                    label4.setForeground(Color.black);
                    //panel5.add(label4);
                    label4.setBounds(30, 190, 50, 16);

                    //---- label5 ----
                    label5.setText("Gesamt:");
                    label5.setForeground(Color.black);
                    panel5.add(label5);
                    label5.setBounds(30, 210, 50, 16);

                    //---- label6 ----
                    label6.setText("Tote:");
                    label6.setForeground(Color.black);
                    panel5.add(label6);
                    label6.setBounds(30, 230, 28, 16);

                    //---- label7 ----
                    label7.setText("Angreifer: NAME 1");
                    label7.setForeground(Color.black);
                    label7.setFont(new Font("Distant Galaxy", Font.PLAIN, 17));
                    panel5.add(label7);
                    label7.setBounds(new Rectangle(new Point(85, 70), label7.getPreferredSize()));

                    //---- label8 ----
                    label8.setText("Verteidiger: NAME 2");
                    label8.setForeground(Color.black);
                    label8.setFont(new Font("Distant Galaxy", Font.PLAIN, 17));
                    panel5.add(label8);
                    label8.setBounds(85, 165, 210, 17);

                    //======== scrollPane3 ========
                    {
                        objt2 = new Object[][] {{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},};

                        //---- table2 ----
                        table2.setModel(new DefaultTableModel(
                                objt2,
                                new String[] {
                                    "Einheit A", "Einheit B", "Einheit C", "Einheit D", "Einheit E"
                                }
                            ) {
                                Class<?>[] columnTypes = new Class<?>[] {
                                        Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
                                    };
                                boolean[] columnEditable = new boolean[] {
                                        false, false, false, false, false
                                    };
                                @Override
                                public Class<?> getColumnClass(int columnIndex) {
                                    return columnTypes[columnIndex];
                                }

                                @Override
                                public boolean isCellEditable(int rowIndex, int columnIndex) {
                                    return columnEditable[columnIndex];
                                }
                            });
                        {
                            TableColumnModel cm = table2.getColumnModel();
                            cm.getColumn(0).setResizable(false);
                            cm.getColumn(1).setResizable(false);
                            cm.getColumn(2).setResizable(false);
                            cm.getColumn(3).setResizable(false);
                            cm.getColumn(4).setResizable(false);
                        }
                        table2.setGridColor(Color.black);
                        table2.setEnabled(false);
                        table2.setForeground(Color.black);
                        table2.setRowSorter(null);
                        table2.setPreferredSize(new Dimension(375, 31));
                        table2.setBackground(UIManager.getColor("PasswordField.background"));
                        table2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                        table2.setFocusable(false);
                        table2.setSelectionForeground(Color.black);
                        table2.getTableHeader().setReorderingAllowed(false);
                        scrollPane3.setViewportView(table2);
                    }
                    panel5.add(scrollPane3);
                    scrollPane3.setBounds(85, 190, 440, 55);

                    //---- label9 ----
                    label9.setText("Der Angreifer(NAME 1) hat gewonnen und folgendes erbeutet:");
                    label9.setFont(new Font("DokChampa", Font.BOLD, 12));
                    label9.setForeground(Color.black);
                    panel5.add(label9);
                    label9.setBounds(35, 255, 405, 30);

                    //---- label10 ----
                    label10.setText("Gold: 2100");
                    label10.setForeground(Color.black);
                    panel5.add(label10);
                    label10.setBounds(80, 285, 165, label10.getPreferredSize().height);

                    //---- label11 ----
                    label11.setText("Rohstoffe: 4200");
                    label11.setForeground(Color.black);
                    panel5.add(label11);
                    label11.setBounds(80, 305, 165, 16);
                }
                JPanel bgPanel = new BgPanel();
                bgPanel.setLayout(new BorderLayout());
                bgPanel.add(panel5, BorderLayout.CENTER);
                panel3.add(bgPanel);
                bgPanel.setBounds(-5, -5, 560, 350);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("K\u00e4mpfe  ", new ImageIcon("Daten/kampfico.png"), panel3);
            tabbedPane1.setBackgroundAt(2, Color.lightGray);
            tabbedPane1.setForegroundAt(2, Color.black);

            //======== panel4 ========
            {
                panel4.setBackground(new Color(255, 255, 255, 0));
                panel4.setLayout(null);

                //======== panel6 ========
                {
                    panel6.setOpaque(false);
                    panel6.setPreferredSize(new Dimension(11, 11));
                    panel6.setBackground(Color.white);
                    panel6.setBorder(new EtchedBorder(EtchedBorder.RAISED));
                    panel6.setLayout(null);

                    //======== scrollPane1 ========
                    {
                        //---- list1 ----
                        list1.setModel(new AbstractListModel<String>() {
                                String[] values = mysql.gebeNamen(namexx);
                                @Override
                                public int getSize() { return values.length; }

                                @Override
                                public String getElementAt(int i) { return values[i]; }
                            });
                        list1.setFont(list1.getFont().deriveFont(list1.getFont().getSize() + 4f));
                        list1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        //list1.setDragEnabled(true);
                        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        list1.setBackground(UIManager.getColor("ScrollBar.background"));
                        list1.setSelectedIndex(0);
                        list1.setBorder(UIManager.getBorder("Tree.editorBorder"));
                        list1.setForeground(Color.black);
                        list1.setFocusable(false);
                        //list1.addListSelectionListener(e -> list1ValueChanged(e));
                        scrollPane1.setViewportView(list1);
                    }
                    panel6.add(scrollPane1);
                    scrollPane1.setBounds(45, 40, 245, 270);

                    //---- button4 ----
                    button4.setText("Angreifen");
                    button4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    button4.setForeground(Color.black);
                    button4.setFocusable(false);
                    panel6.add(button4);
                    button4.setBounds(370, 135, 95, 35);

                    //---- button5 ----
                    button5.setText("Unterst\u00fczen");
                    button5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    button5.setForeground(Color.black);
                    button5.setFocusable(false);
                    panel6.add(button5);
                    button5.setBounds(365, 190, 105, 35);

                    //---- label12 ----
                    label12.setText("Spieler Aktionen:");
                    label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 8f));
                    label12.setHorizontalAlignment(SwingConstants.CENTER);
                    label12.setForeground(Color.black);
                    panel6.add(label12);
                    label12.setBounds(335, 60, 165, 40);

                    //---- label13 ----
                    label13.setText("("+list1.getSelectedValue()+")");
                    label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 6f));
                    label13.setHorizontalAlignment(SwingConstants.CENTER);
                    label13.setForeground(Color.black);
                    panel6.add(label13);
                    label13.setBounds(335, 85, 165, 40);
                }
                JPanel bgPanel2 = new BgPanel();
                bgPanel2.setLayout(new BorderLayout());
                bgPanel2.add(panel6, BorderLayout.CENTER);
                panel4.add(bgPanel2);
                bgPanel2.setBounds(-5, -5, 560, 350);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Rangliste ", new ImageIcon("Daten/listeico.png"), panel4);
            tabbedPane1.setBackgroundAt(3, Color.lightGray);
            tabbedPane1.setForegroundAt(3, Color.black);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(115, 75, 555, 400);

        //---- label14 ----
        label14.setText("Login: "+name);
        contentPane.add(label14);
        label14.setBounds(5, 0, 105, 25);

        contentPane.setPreferredSize(new Dimension(775, 550));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(false);
        setResizable(false);
        //END:initComponents
    }

    protected void initListener()
    {
        //BEGIN:initListener

        //---- list1 ----
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent listSelectionEvent) {
                    label13.setText("("+list1.getSelectedValue()+")");
                }
            };
        list1.addListSelectionListener(listSelectionListener);

        comboBox1.addActionListener (new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    //---- table1 ----
                    if(comboBox1.getSelectedItem().toString()=="(Bitte wählen)") objt1 = new Object[][] {{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},};
                    else objt1 = new Object[][] {{200, 20, 0, 10, 55},{25, 20, 0, 10, 55},};

                    table1.setModel(new DefaultTableModel(
                            objt1,
                            new String[] {
                                "Einheit A", "Einheit B", "Einheit C", "Einheit D", "Einheit E"
                            }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[] {
                                    Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
                                };
                            boolean[] columnEditable = new boolean[] {
                                    false, false, false, false, false
                                };
                            @Override
                            public Class<?> getColumnClass(int columnIndex) {
                                return columnTypes[columnIndex];
                            }

                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return columnEditable[columnIndex];
                            }
                        });

                    //---- table2 ----
                    if(comboBox1.getSelectedItem().toString()=="(Bitte wählen)") objt2 = new Object[][] {{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},};
                    else objt2 = new Object[][] {{25, 20, 0, 10, 55},{25, 20, 0, 10, 55},};

                    table2.setModel(new DefaultTableModel(
                            objt2,
                            new String[] {
                                "Einheit A", "Einheit B", "Einheit C", "Einheit D", "Einheit E"
                            }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[] {
                                    Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
                                };
                            boolean[] columnEditable = new boolean[] {
                                    false, false, false, false, false
                                };
                            @Override
                            public Class<?> getColumnClass(int columnIndex) {
                                return columnTypes[columnIndex];
                            }

                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return columnEditable[columnIndex];
                            }
                        });
                }
            });

        //---- this ----
        this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent event) {
                    //closeApp();
                    //System.exit(1);
                }
            });

        bgPanelx.addMouseWheelListener(new MouseWheelListener() {
                public void mouseWheelMoved(MouseWheelEvent e) {
                    String message;
                    int notches = e.getWheelRotation();
                    if (notches < 0) {
                        message = "Mouse wheel moved UP "
                        + -notches + " notch(es)\n";
                        bgPanelx.setBounds(0, 0, 507, 306);
                    } else {
                        message = "Mouse wheel moved DOWN "
                        + notches + " notch(es)\n";
                        bgPanelx.setBounds(0, 0, 507, 296);
                    }
                    //System.out.println(message);
                }
            });

        //END:initListener
    }

    private void closeApp()
    {
        int ende = JOptionPane.showConfirmDialog(this, "Soll Clashing Tribes wirklich beendet werden?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(ende == 0) {
            System.exit(1);
        }    
    }

    //BEGIN:variables
    static private Canvas canvas;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel8;
    public JPanel panel9;
    private JPanel panel10;
    private JTextField textField1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel3;
    private JPanel panel5;
    private JComboBox<String> comboBox1;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JScrollPane scrollPane3;
    private JTable table2;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JPanel panel4;
    private JPanel panel6;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JButton button4;
    private JButton button5;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private String name;
    private MySQL mysql = new MySQL();
    private Object[][] objt1;
    private Object[][] objt2;
    private String namexx;
    private JPanel bgPanelx = new BgPanelx();
    private JButton button6;
    //END:variables
}

class BgPanel extends JPanel {
    Image bg = new ImageIcon("Daten/BG.png").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}

class BgPanelx extends JPanel {
    Image bg = new ImageIcon("Daten/HB.jpg").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
