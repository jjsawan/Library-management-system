
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sawan
 */
public class librarymanagement extends JFrame implements ActionListener {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/library management system";
    Connection connection = null;
    Statement statement = null;
    private JLabel lIssueofDate, lBookName, lAuthur, lExpirationDate, llibrary_acc_no, lStudentName, lRoll, lSem, ldep, lCo_No, imge,m,ac,ac1,ac2,hd;
    private JTextField IssueofDate, BookName, Authur, ExpirationDate, library_acc_no, StudentName, Roll, Sem, dep, Co_No;
    private JButton show, search, delete, exit, insert,check;    
    private JMenu menu1, menu2,menu3,menu4;
    private JMenuBar menuBar, menuBar1;
    private JMenuItem menuItemB, menuItemS, menuItemT, menuItemA, menuItemE, menuItemH, menuItemAl,menuItemlc;
    Cursor cur;
    JOptionPane jp;

    public librarymanagement() {
        
        
        
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");            
            statement = (Statement) connection.createStatement();            
        } catch (Exception e) {
            e.printStackTrace();            
        }
        
        
        
        
        jp = new JOptionPane();
        cur = new Cursor(Cursor.HAND_CURSOR);
        setCursor(cur);
        
        
        
        menuBar = new JMenuBar();
        //setJMenuBar(menuBar);
        add(menuBar);
        menuBar.setBounds(0, 0, 1000, 20);
        menuBar.setBackground(Color.GREEN);
        menuBar1 = new JMenuBar();        
        setJMenuBar(menuBar1);
        
        
        
        menu1 = new JMenu("HOME");
       // menu1.setBackground(Color.BLUE);
        menu1.setMnemonic('H');
         menu1.setForeground(Color.RED);
        menu2 = new JMenu("Any Help");        
        menu2.setMnemonic('A');
        //menu2.setBackground(Color.white);
        menu2.setForeground(Color.red);
        menu1.setMnemonic(KeyEvent.VK_D);
      
        menu3=new JMenu("About library");
        menu3.setMnemonic('A');
       // menu3.setBackground(Color.white);
        menu3.setMnemonic(KeyEvent.VK_D);
        menu3.setForeground(Color.red);
        
        menu4=new JMenu("library account");
        menu4.setForeground(Color.red);
        
        
        menuItemB = new JMenuItem("BOOK");
        menuItemB.setBackground(Color.white);
        menuItemB.setMnemonic('B');
        menuItemB.setForeground(Color.MAGENTA);
        menuItemS = new JMenuItem("Student list");
        menuItemS.setBackground(Color.white);
        menuItemS.setMnemonic('S');
         menuItemS.setForeground(Color.MAGENTA);
        menuItemT = new JMenuItem("Teacher List");
        menuItemT.setBackground(Color.white);
        menuItemT.setMnemonic('T');
         menuItemT.setForeground(Color.MAGENTA);
        menuItemA = new JMenuItem("Admin");
        menuItemA.setBackground(Color.white);
        menuItemA.setMnemonic('A');
         menuItemA.setForeground(Color.MAGENTA);
        menuItemE = new JMenuItem("Exit");
        menuItemE.setBackground(Color.white);
        menuItemE.setMnemonic('E');
         menuItemE.setForeground(Color.MAGENTA);
        
        menuItemH = new JMenuItem("Help library");
        menuItemH.setBackground(Color.white);
        menuItemH.setMnemonic('E');
        menuItemH.setForeground(Color.MAGENTA);
        menuItemAl = new JMenuItem("About Library");
        menuItemAl.setForeground(Color.MAGENTA);
        menuItemlc = new JMenuItem("opening account");
        menuItemlc.setForeground(Color.MAGENTA);
        menu1.add(menuItemB);
        menu1.add(menuItemS);
        menu1.add(menuItemT);
        menu1.add(menuItemA);
        menu1.add(menuItemE);
        menuBar.add(menu1);
        
        menu2.add(menuItemH);
        menu3.add(menuItemAl);
        menu4.add(menuItemlc);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
          
        menuItemB.addActionListener(this);
        menuItemS.addActionListener(this);
        menuItemT.addActionListener(this);
        menuItemA.addActionListener(this);
        menuItemE.addActionListener(this);
        menuItemH.addActionListener(this);
        menuItemAl.addActionListener(this);
         menuItemlc.addActionListener(this);
        // JLabel IssueofDate,BookName,Authur,ExpirationDate,fee,StudentName,Roll,Sem,dep,Co_No;
        
       ac=new JLabel("If you want to");
        ac.setBounds(200, 40, 200, 25);
        Font k = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 30);
         ac.setFont(k);
        ac.setForeground(Color.BLACK);
        add( ac);
         ac1=new JLabel("check ur account");
        ac1.setBounds(200, 70, 240, 25);
        Font i = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 30);
         ac1.setFont(i);
        ac1.setForeground(Color.BLACK);
        add( ac1);
         ac2=new JLabel("plz click HERE :");
        ac2.setBounds(200, 100, 240, 30);
        Font q = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 30);
         ac2.setFont(q);
        ac2.setForeground(Color.BLACK);
        add( ac2);
        m=new JLabel("*******************************************************************************************************************************************************************************************************************************************************************************");
        m.setBounds(0, 160, 1000, 10);
        m.setForeground(Color.BLACK);
        add(m);
        JButton check=new JButton("check");
        check.setBounds(500, 65, 80, 50);
        check.setBackground(Color.red);
        check.setForeground(Color.white);
        add(check);
        check.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               final JFrame newwindw = new JFrame();
                newwindw.setTitle("Account checking ");
                newwindw.setBounds(250, 40, 400, 190);
                newwindw.setVisible(true);
                newwindw.setLayout(null);
                newwindw.getContentPane().setBackground(Color.white);
                
                 JLabel srch=new JLabel("Enter your account no:");
                   srch.setBounds(50, 35, 135, 30);
                    newwindw.add(srch);
                     
                    final JTextField s=new JTextField();
                    s.setBounds(200, 35, 135, 30);
                    newwindw.add(s);
                    s.setToolTipText("check account");
                    JButton ok=new JButton("ok");
                    ok.setBounds(200, 75, 50, 30);
                    newwindw.add(ok);
                     JButton exit=new JButton("exit");
                    exit.setBounds(290, 110, 70, 40);
                    newwindw.add(exit);
                     exit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                 newwindw.dispose();
                
            }
        });
              ok.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                         
                    final JFrame newwindw = new JFrame();
                    newwindw.setTitle("checking account no");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.white);
                          JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "studentNname", "roll", "dep", "sem", "accountno", "co_no"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                     
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();                        
                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT studentNname,roll,dep,sem,accountno,co_no from bankaccount where accountno=('" + s.getText().toString() + "' )");
                        s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1); 
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                        }
                });
              
                     
            }
        });
        
        hd=new JLabel("***** Issue book here *****");
        hd.setBounds(290, 180, 500, 30);
        hd.setForeground(Color.black);
        add(hd);
        Font y = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 30);
         hd.setFont(y);
        
        lIssueofDate = new JLabel("Issue Of Date :");        
        lIssueofDate.setBounds(170, 240, 150, 45);
        lIssueofDate.setForeground(Color.black);
        add(lIssueofDate);
        lBookName = new JLabel(" Book Name:");        
        lBookName.setBounds(170, 280, 150, 45);
        lBookName.setForeground(Color.black);
        add(lBookName);
        lAuthur = new JLabel("Authur:");        
        lAuthur.setBounds(170, 320, 150, 45);
        lAuthur.setForeground(Color.black);
        add(lAuthur);
        lExpirationDate = new JLabel("Exparation Date :");        
        lExpirationDate.setBounds(170, 360, 150, 45);
        lExpirationDate.setForeground(Color.black);
        add(lExpirationDate);
        llibrary_acc_no = new JLabel("library_acc_no :");
        llibrary_acc_no.setBounds(170, 400, 150, 45);
        llibrary_acc_no.setForeground(Color.black);
        add(llibrary_acc_no);
        lStudentName = new JLabel("Student Name :");        
        lStudentName.setBounds(520, 240, 150, 45);
        lStudentName.setForeground(Color.black);
        add(lStudentName);
        lRoll = new JLabel("Roll :");        
        lRoll.setBounds(520, 280, 150, 45);
        lRoll.setForeground(Color.black);
        add(lRoll);
        lSem = new JLabel("Sem :");        
        lSem.setBounds(520, 320, 150, 45);
        lSem.setForeground(Color.black);
        add(lSem);
        ldep = new JLabel("dep. :");
        ldep.setBounds(520, 360, 150, 45);
        ldep.setForeground(Color.black);
        add(ldep);
        lCo_No = new JLabel("Fees :");        
        lCo_No.setBounds(520, 400, 150, 45);
        lCo_No.setForeground(Color.black);
        add(lCo_No);
        
        
        
        
        IssueofDate = new JTextField();
        IssueofDate.setForeground(Color.black);
        IssueofDate.setBackground(Color.white);
        IssueofDate.setBounds(270, 250, 150, 25);
        add(IssueofDate);
        BookName = new JTextField();
        BookName.setForeground(Color.black);
        BookName.setBackground(Color.white);
        BookName.setBounds(270, 290, 150, 25);
        add(BookName);
        Authur = new JTextField();
        Authur.setForeground(Color.black);
        Authur.setBackground(Color.white);
        Authur.setBounds(270, 330, 150, 25);
        add(Authur);
        ExpirationDate = new JTextField();
        ExpirationDate.setForeground(Color.black);
        ExpirationDate.setBackground(Color.white);
        ExpirationDate.setBounds(270, 370, 150, 25);
        add(ExpirationDate);
        library_acc_no = new JTextField();
        library_acc_no.setForeground(Color.black);
        library_acc_no.setBackground(Color.WHITE);
        library_acc_no.setBounds(270, 410, 150, 25);
        add(library_acc_no);
        StudentName = new JTextField();
        StudentName.setForeground(Color.black);
        StudentName.setBackground(Color.white);
        StudentName.setBounds(620, 250, 150, 25);
        add(StudentName);
        Roll = new JTextField();
        Roll.setForeground(Color.black);
        Roll.setBackground(Color.white);
        Roll.setBounds(620, 290, 150, 25);
        add(Roll);
        Sem = new JTextField();
        Sem.setForeground(Color.black);
        Sem.setBackground(Color.white);
        Sem.setBounds(620, 330, 150, 25);
        add(Sem);
        dep = new JTextField();
        dep.setForeground(Color.black);
        dep.setBackground(Color.WHITE);
        dep.setBounds(620, 370, 150, 25);
        add(dep);
        Co_No = new JTextField();
        Co_No.setForeground(Color.black);
        Co_No.setBackground(Color.white);
        Co_No.setBounds(620, 410, 150, 25);
        add(Co_No);
        
        
        
        show = new JButton("show");
        show.setBounds(170, 500, 100, 30);
        show.setBackground(Color.red);        
        show.setForeground(Color.white);
        add(show);
        show.addActionListener(this);
        
        
        search = new JButton("search");
        search.setBounds(300, 500, 100, 30);
        search.setBackground(Color.red);        
        search.setForeground(Color.white);
        add(search);
        
        insert = new JButton("insert");
        insert.setBounds(430, 500, 100, 30);
        insert.setBackground(Color.red);        
        insert.setForeground(Color.white);
        add(insert);
        insert.addActionListener(this);
        
        delete = new JButton("Delete");
        delete.setBounds(560, 500, 100, 30);
        delete.setBackground(Color.red);        
        delete.setForeground(Color.white);
        add(delete);
        
        exit = new JButton("Exit");
        exit.setBounds(690, 500, 100, 30);
        exit.setBackground(Color.red);        
        exit.setForeground(Color.white);
        add(exit);
          
       // Icon a = new ImageIcon(getClass().getResource("library.jpg"));
        //JLabel passimage = new JLabel(a);
        //passimage.getClass().getResource("Forest.JPEG");
      //  passimage.setBounds(0, 0, 1000, 700);
       // add(passimage);

         
        exit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                
            }
        });
        
        show.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                final JFrame newwindw = new JFrame();
                newwindw.setTitle("showing book issue information");
                newwindw.setBounds(250, 40, 800, 300);
                newwindw.setVisible(true);
                newwindw.setLayout(null);
                newwindw.getContentPane().setBackground(Color.WHITE);
           
                JTable mytable = new JTable();
                JScrollPane jScrollPane1 = new JScrollPane();
                mytable.setVisible(true);
                mytable.setBackground(Color.CYAN);
                JLabel jLabel1 = new JLabel();

                //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                
                mytable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null}
                        },
                        new String[]{
                            "IssueofDate", "BookName", "Authur", "ExpirationDate", "library_account_no", "StudentName", "Roll", "Sem", "dep", "Fees"
                        }));
                jScrollPane1.setViewportView(mytable);
                
                jLabel1.setText("my table");
                show.add(jLabel1);
                
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                newwindw.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                 
                try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();
                                        
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT IssueofDate,BookName,Authur,ExpirationDate,library_account_no,StudentName,Roll,Sem,dep,Fees from bookissue");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    mytable.setModel(dtm);
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
                
                show.add(jScrollPane1);
                 JButton exit=new JButton("exit");
                exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
            }
              
        });
        
        search.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFrame newwindw = new JFrame();
                newwindw.setTitle("showing book issue information ");
                newwindw.setBounds(250, 40, 400, 190);
                newwindw.setVisible(true);
                newwindw.setLayout(null);
                newwindw.getContentPane().setBackground(Color.white);
                //newwindw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 JLabel srch=new JLabel("Enter your text:");
                   srch.setBounds(80, 35, 100, 30);
                    newwindw.add(srch);
                    JLabel srchw=new JLabel("Search with:");
                   srchw.setBounds(80, 70, 100, 30);
                    newwindw.add(srchw);
                    final JTextField s=new JTextField();
                    s.setBounds(200, 35, 135, 30);
                    newwindw.add(s);
                    s.setToolTipText("search book");
                    JRadioButton lAn=new JRadioButton("lAn");
                    lAn.setBounds(200, 75, 60, 20);
                    lAn.setBackground(Color.cyan);
                    newwindw.add(lAn);
                    JRadioButton roll=new JRadioButton("Roll");
                     roll.setBounds(270, 75, 60, 20);
                     roll.setBackground(Color.cyan);
                    newwindw.add(roll);
                   ButtonGroup rn=new ButtonGroup();
                   rn.add(lAn);
                   rn.add(roll);
                JButton exit=new JButton("exit");
                exit.setBounds(260, 110, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                lAn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame newwindw = new JFrame();
                newwindw.setTitle("showing book issue information by library account no ");
                newwindw.setBounds(250, 40, 800, 600);
                newwindw.setVisible(true);
                newwindw.setLayout(null);
                newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                     JTable mytable = new JTable();
                JScrollPane jScrollPane1 = new JScrollPane();
                mytable.setVisible(true);
                JLabel jLabel1 = new JLabel();

                //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                
                mytable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null}
                        },
                        new String[]{
                            "IssueofDate", "BookName", "Authur", "ExpirationDate", "library_account_no", "StudentName", "Roll", "Sem", "dep", "Fees"
                        }));
                jScrollPane1.setViewportView(mytable);
                
                jLabel1.setText("my table");
                show.add(jLabel1);
                
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                newwindw.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                
                
                
                try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();                    
                    
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT IssueofDate,BookName,Authur,ExpirationDate,library_account_no,StudentName,Roll,Sem,dep,Fees from bookissue where library_account_no=('" + s.getText().toString() + "')");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    mytable.setModel(dtm);
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
                
                show.add(jScrollPane1);   
                    }
                });
                
                roll.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame newwindw = new JFrame();
                newwindw.setTitle("showing book issue information by Roll");
                newwindw.setBounds(250, 40, 800, 600);
                newwindw.setVisible(true);
                newwindw.setLayout(null);
                newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                        JTable mytable = new JTable();
                JScrollPane jScrollPane1 = new JScrollPane();
                mytable.setVisible(true);
                JLabel jLabel1 = new JLabel();

                //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                
                mytable.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null},
                            {null, null, null, null, null, null}
                        },
                        new String[]{
                            "IssueofDate", "BookName", "Authur", "ExpirationDate", "library_account_no", "StudentName", "Roll", "Sem", "dep", "Fees"
                        }));
                jScrollPane1.setViewportView(mytable);
                
                jLabel1.setText("my table");
                show.add(jLabel1);
                
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                newwindw.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                
                
                
                try {
                    Class.forName(JDBC_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                    
                    statement = (Statement) connection.createStatement();                    
                    
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT IssueofDate,BookName,Authur,ExpirationDate,library_account_no,StudentName,Roll,Sem,dep,Fees from bookissue where Roll=('" + s.getText().toString() + "')");
                    java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();                    
                    DefaultTableModel dtm = new DefaultTableModel();
                    Vector column_name = new Vector();
                    Vector data_rows = new Vector();
                    for (int i = 1; i <= numberOfColumns; i++) {
                        column_name.addElement(metaData.getColumnName(i));                        
                    }
                    dtm.setColumnIdentifiers(column_name);
                    while (resultSet.next()) {
                        data_rows = new Vector();
                        for (int j = 1; j <= numberOfColumns; j++) {
                            data_rows.addElement(resultSet.getString(j));
                        }
                        dtm.addRow(data_rows);
                    }
                    mytable.setModel(dtm);
                } catch (Exception x) {
                    x.printStackTrace();                    
                }
                
                show.add(jScrollPane1);
                    }
                });
                 
            }
        });
        
        
        
        
        insert.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // TODO add your handling code here:
                    
                    String query = "insert into bookissue values('" + IssueofDate.getText().toString() + "','" + BookName.getText().toString() + "','" + Authur.getText().toString() + "','" + ExpirationDate.getText().toString() + "','" + library_acc_no.getText().toString() + "','" + StudentName.getText().toString() + "','" + Roll.getText().toString() + "','" + Sem.getText().toString() + "','" + dep.getText().toString() + "','" + Co_No.getText().toString() + "')";                    
                    
                    statement.execute(query);
                    IssueofDate.setText(null);
                    BookName.setText(null);
                    Authur.setText(null);
                    ExpirationDate.setText(null);
                    library_acc_no.setText(null);
                    StudentName.setText(null);
                    Roll.setText(null);
                    Sem.setText(null);
                    dep.setText(null);
                    Co_No.setText(null);
                } catch (SQLException ex) {
                    Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        delete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    String query = "delete from bookissue where IssueofDate=('" + IssueofDate.getText().toString() + "')";
                    statement.execute(query);
                    IssueofDate.setText(null);
                } catch (SQLException ex) {
                    Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String str1 = (String) e.getActionCommand();
        Object source = e.getSource();
        
        if (source == menuItemE) {
            System.exit(0);
            jp = new JOptionPane();
        }        
        
        if (source == menuItemS) {
            final JFrame newwindw = new JFrame();
            newwindw.setTitle("Student list");
            newwindw.setBounds(250, 40, 800, 600);
            newwindw.setVisible(true);
            newwindw.setLayout(null);
            newwindw.getContentPane().setBackground(Color.WHITE);
            //newwindw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel lsn = new JLabel("studentname:");
            lsn.setBounds(200, 100, 150, 45);
            lsn.setForeground(Color.black);
            newwindw.add(lsn);
            
            JLabel lsi = new JLabel("studentid:");
            lsi.setBounds(200, 140, 150, 45);
            lsi.setForeground(Color.black);
            newwindw.add(lsi);
            
            
            JLabel ld = new JLabel("depertment");
            ld.setBounds(200, 180, 150, 45);
            ld.setForeground(Color.black);
            newwindw.add(ld);
            
            JLabel lroll = new JLabel("Roll");
            lroll.setBounds(200, 220, 150, 45);
            lroll.setForeground(Color.black);
            newwindw.add(lroll);
            
            JLabel lsem = new JLabel("semester");
            lsem.setBounds(200, 260, 150, 45);
            lsem.setForeground(Color.black);
            newwindw.add(lsem);            
            
            JLabel lla = new JLabel("library account");
            lla.setBounds(200, 300, 150, 45);
            lla.setForeground(Color.black);
            newwindw.add(lla);
            
            JLabel lcn = new JLabel("contactno");
            lcn.setBounds(200, 340, 150, 45);
            lcn.setForeground(Color.black);
            newwindw.add(lcn);
            
            JLabel hd=new JLabel("***** student information *****");
        hd.setBounds(190, 30, 500, 30);
        hd.setForeground(Color.black);
        newwindw.add(hd);
        Font u = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 30);
         hd.setFont(u);
            
            final JTextField sn, si, d, roll, sem, la, cn;
            sn = new JTextField();
            sn.setBounds(500, 100, 150, 35);
            sn.setForeground(Color.BLACK);
            newwindw.add(sn);
            // sn.setText("");
            
            si = new JTextField();
            si.setBounds(500, 140, 150, 35);
            si.setForeground(Color.BLACK);
            newwindw.add(si);
            
            
            d = new JTextField();
            d.setBounds(500, 180, 150, 35);
            d.setForeground(Color.BLACK);
            newwindw.add(d);
            
            roll = new JTextField();
            roll.setBounds(500, 220, 150, 35);
            roll.setForeground(Color.BLACK);
            newwindw.add(roll);
            
            sem = new JTextField();
            sem.setBounds(500, 260, 150, 35);
            sem.setForeground(Color.BLACK);
            newwindw.add(sem);            
            
            la = new JTextField();
            la.setBounds(500, 300, 150, 35);
            la.setForeground(Color.BLACK);
            newwindw.add(la);
            
            cn = new JTextField();
            cn.setBounds(500, 340, 150, 35);
            cn.setForeground(Color.BLACK);
            newwindw.add(cn);
            
            final JButton show, search, delete, Exit, insert;
            show = new JButton("show");
            show.setBounds(130, 500, 100, 30);
            show.setBackground(Color.red);            
            show.setForeground(Color.white);
            newwindw.add(show);
            
            search = new JButton("search");
            search.setBounds(260, 500, 100, 30);
            search.setBackground(Color.red);            
            search.setForeground(Color.white);
            newwindw.add(search);
            
            insert = new JButton("insert");
            insert.setBounds(390, 500, 100, 30);
            insert.setBackground(Color.red);            
            insert.setForeground(Color.white);
            newwindw.add(insert);
            //insert.addActionListener(this);                         
            delete = new JButton("Delete");
            delete.setBounds(520, 500, 100, 30);
            delete.setBackground(Color.red);            
            delete.setForeground(Color.white);
            newwindw.add(delete);
            
            Exit = new JButton("Exit");
            Exit.setBounds(650, 500, 100, 30);
            Exit.setBackground(Color.red);            
            Exit.setForeground(Color.white);
            newwindw.add(Exit);
            
            Exit.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    //System.exit(0);
                    newwindw.dispose();
                }
            });
            
            
            show.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    final JFrame newwindw = new JFrame();
                    newwindw.setTitle("showing student list");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.white);
                    
                    
                    
                    
                    JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "Student_Name", "Student_ID", "Department", "RollNo", "Semester", "LibraryAccountNO", "ContactNo"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                    
                    
                    
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();




                        // create Statement for querying database


                        // query database                                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT Student_Name,Student_ID,Department,RollNo,Semester,LibraryAccountNO,ContactNo from student");
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1); 
                    JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                }
            });
            
            search.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    final JFrame newwindw = new JFrame();
                    newwindw.setTitle("searching student information");
                    newwindw.setBounds(250, 40, 400, 190);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.white);
                  // newwindw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JLabel srch=new JLabel("Enter your text:");
                   srch.setBounds(80, 35, 100, 30);
                    newwindw.add(srch);
                    JLabel srchw=new JLabel("Search with:");
                   srchw.setBounds(80, 70, 100, 30);
                    newwindw.add(srchw);
                    final JTextField s=new JTextField();
                    s.setBounds(200, 35, 120, 30);
                    newwindw.add(s); 
                    JRadioButton name=new JRadioButton("name");
                    name.setBounds(200, 75, 60, 20);
                    name.setBackground(Color.cyan);
                    newwindw.add(name);
                    JRadioButton roll=new JRadioButton("Roll");
                     roll.setBounds(270, 75, 60, 20);
                     roll.setBackground(Color.cyan);
                    newwindw.add(roll);
                   ButtonGroup rn=new ButtonGroup();
                   rn.add(name);
                   rn.add(roll);
                   JButton exit=new JButton("exit");
                exit.setBounds(260, 110, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                    
                    name.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                           final JFrame newwindw = new JFrame();
                    newwindw.setTitle("showing student's information by name");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200)); 
                    JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "Student_Name", "Student_ID", "Department", "RollNo", "Semester", "LibraryAccountNO", "ContactNo"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                    
                    
                    
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();

                                  
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT Student_Name,Student_ID,Department,RollNo,Semester,LibraryAccountNO,ContactNo from student where Student_Name=('" + s.getText().toString() + "') ");
                         s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1);
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                        }
                    });
                    roll.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            final JFrame newwindw = new JFrame();
                    newwindw.setTitle("showing student's information by roll");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200)); 
                            JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "Student_Name", "Student_ID", "Department", "RollNo", "Semester", "LibraryAccountNO", "ContactNo"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                    
                    
                    
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();

                                  
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT Student_Name,Student_ID,Department,RollNo,Semester,LibraryAccountNO,ContactNo from student where RollNo=('" + s.getText().toString() + "') ");
                         s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1);
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                        }
                    });
                   
                }
            });
            
    
            insert.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // TODO add your handling code here:
                        //JTextField sn,si,d,roll,sem,la,cn;
                        String query = "insert into student values('" + sn.getText().toString() + "','" + si.getText().toString() + "','" + d.getText().toString() + "','" + roll.getText().toString() + "','" + sem.getText().toString() + "','" + la.getText().toString() + "','" + cn.getText().toString() + "')";                        
                 
                        statement.execute(query);
                        sn.setText(null);
                        si.setText(null);
                        d.setText(null);
                        roll.setText(null);
                        sem.setText(null);
                        la.setText(null);
                        cn.setText(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
            delete.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String query = "delete from student where Student_Name=('" + sn.getText().toString() + "')";
                        statement.execute(query);
                        sn.setText(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
           // Icon a = new ImageIcon(getClass().getResource("library.jpg"));
       // JLabel passimage = new JLabel(a);
         
        //passimage.setBounds(0, 0, 1000, 700);
        // newwindw.add(passimage);     
                                                   
        }
        
        if (source == menuItemT) {
            final JFrame newwindw = new JFrame();
            newwindw.setTitle(" teacher list");
            newwindw.setBounds(250, 40, 800, 600);
            newwindw.setVisible(true);
            newwindw.setLayout(null);
            newwindw.getContentPane().setBackground(Color.white);
            
            JLabel ltn = new JLabel("teachername:");
            ltn.setBounds(200, 180, 150, 45);
            ltn.setForeground(Color.black);
            newwindw.add(ltn);
            
            JLabel lde = new JLabel("depertment:");
            lde.setBounds(200, 230, 150, 45);
            lde.setForeground(Color.black);
            newwindw.add(lde);
            
            
            JLabel lr = new JLabel("Rank");
            lr.setBounds(200, 280, 150, 45);
            lr.setForeground(Color.black);
            newwindw.add(lr);
            
            
            
            JLabel lcon = new JLabel("contactno");
            lcon.setBounds(200, 330, 150, 45);
            lcon.setForeground(Color.black);
            newwindw.add(lcon);
            
            JLabel hd=new JLabel("***** Teacher's information *****");
        hd.setBounds(190, 60, 500, 30);
        hd.setForeground(Color.black);
        newwindw.add(hd);
        Font u = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 30);
         hd.setFont(u);
            
            
            final JTextField tn, de, r, con;
            tn = new JTextField();
            tn.setBounds(500, 180, 150, 35);
            tn.setForeground(Color.BLACK);
            newwindw.add(tn);
            
            de = new JTextField();
            de.setBounds(500, 230, 150, 35);
            de.setForeground(Color.BLACK);
            newwindw.add(de);
            
            
            r = new JTextField();
            r.setBounds(500, 280, 150, 35);
            r.setForeground(Color.BLACK);
            newwindw.add(r);
            
            con = new JTextField();
            con.setBounds(500, 330, 150, 35);
            con.setForeground(Color.BLACK);
            newwindw.add(con);
            
            final JButton show, search, delete, Exit, insert;
            show = new JButton("show");
            show.setBounds(130, 500, 100, 30);
            show.setBackground(Color.red);            
            show.setForeground(Color.white);
            newwindw.add(show);
            
            
            
            search = new JButton("search");
            search.setBounds(260, 500, 100, 30);
            search.setBackground(Color.red);            
            search.setForeground(Color.white);
            newwindw.add(search);
            
            insert = new JButton("insert");
            insert.setBounds(390, 500, 100, 30);
            insert.setBackground(Color.red);            
            insert.setForeground(Color.white);
            newwindw.add(insert);
            //insert.addActionListener(this);
            
            delete = new JButton("Delete");
            delete.setBounds(520, 500, 100, 30);
            delete.setBackground(Color.red);            
            delete.setForeground(Color.white);
            newwindw.add(delete);
            
            Exit = new JButton("Exit");
            Exit.setBounds(650, 500, 100, 30);
            Exit.setBackground(Color.red);            
            Exit.setForeground(Color.white);
            newwindw.add(Exit);
            
            
            Exit.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    newwindw.dispose();
                }
            });
            show.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    final JFrame newwindw = new JFrame();
                    newwindw.setTitle("showing teacher list");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                    
                    JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "TeacherName", "Department", "Rank", "ContactNo"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                    
                     
                    
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();                        
                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT TeacherName, Department, Rank, ContactNo from teacher");
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1);
                    JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                }); 
                }
            });
            
            search.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    final JFrame newwindw = new JFrame();
                    newwindw.setTitle("searching teacher's information");
                    newwindw.setBounds(250, 40, 400, 190);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.white);
                  //  newwindw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     JLabel srch=new JLabel("Enter your text:");
                   srch.setBounds(80, 35, 100, 30);
                    newwindw.add(srch);
                    JLabel srchw=new JLabel("Search with:");
                   srchw.setBounds(80, 70, 100, 30);
                    newwindw.add(srchw);
                    final JTextField s=new JTextField();
                    s.setBounds(200, 35, 120, 30);
                    newwindw.add(s); 
                    JRadioButton name=new JRadioButton("name");
                    name.setBounds(200, 75, 60, 20);
                    name.setBackground(Color.cyan);
                    newwindw.add(name);
                    JRadioButton dep=new JRadioButton("Dep");
                     dep.setBounds(270, 75, 60, 20);
                     dep.setBackground(Color.cyan);
                    newwindw.add(dep);
                   ButtonGroup rn=new ButtonGroup();
                   rn.add(name);
                   rn.add(dep);
                   JButton exit=new JButton("exit");
                exit.setBounds(260, 110, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                   name.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                              final JFrame newwindw = new JFrame();
                    newwindw.setTitle("search with teacher name");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                           JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "TeacherName", "Department", "Rank", "ContactNo"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                    
                    
                    
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();                        
                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT TeacherName, Department, Rank, ContactNo from teacher where TeacherName=('" + s.getText().toString() + "')");
                         s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1); 
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                        }
                    });
                      dep.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                             final JFrame newwindw = new JFrame();
                    newwindw.setTitle("search teacher's information,Dep wise");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                           JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "TeacherName", "Department", "Rank", "ContactNo"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                    
                    
                    
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();                        
                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT TeacherName, Department, Rank, ContactNo from teacher where Department=('" + s.getText().toString() + "')");
                         s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1); 
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                        }
                    });
                      
                    
                }
            });
            
            
            
            insert.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                         
                        String query = "insert into teacher values('" + tn.getText().toString() + "','" + de.getText().toString() + "','" + r.getText().toString() + "','" + con.getText().toString() + "')";                        
                        
                        statement.execute(query);
                        tn.setText(null);
                        de.setText(null);
                        r.setText(null);
                        con.setText(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            delete.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String query = "delete from TEACHER where TeacherName=('" + tn.getText().toString() + "')";
                        statement.execute(query);
                          tn.setText(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
             //Icon a = new ImageIcon(getClass().getResource("library.jpg"));
       // JLabel passimage = new JLabel(a);
       //passimage.setBounds(0, 0, 1000, 700);
        // newwindw.add(passimage);   
        }
        
        if (source == menuItemA) {
            final JFrame newwindw = new JFrame();
            newwindw.setTitle("Admin");
            newwindw.setBounds(250, 40, 800, 600);
            newwindw.setVisible(true);
            newwindw.setLayout(null);
            newwindw.getContentPane().setBackground(Color.white);
            
            
            JLabel lan = new JLabel("adminname:");
            lan.setBounds(200, 180, 150, 45);
            lan.setForeground(Color.black);
            newwindw.add(lan);
            
            JLabel lrn = new JLabel("Rank:");
            lrn.setBounds(200, 230, 150, 45);
            lrn.setForeground(Color.black);
            newwindw.add(lrn);
            
            JLabel lcont = new JLabel("contactno");
            lcont.setBounds(200, 280, 150, 45);
            lcont.setForeground(Color.black);
            newwindw.add(lcont);
            
            JLabel hd=new JLabel("***** student information *****");
        hd.setBounds(190, 60, 500, 30);
        hd.setForeground(Color.black);
        newwindw.add(hd);
        Font u = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 30);
         hd.setFont(u);
            
            final JTextField an, rn, cont;
            an = new JTextField();
            an.setBounds(500, 180, 150, 35);
            an.setForeground(Color.BLACK);
            newwindw.add(an);
            
            rn = new JTextField();
            rn.setBounds(500, 230, 150, 35);
            rn.setForeground(Color.BLACK);
            newwindw.add(rn);
            
            cont = new JTextField();
            cont.setBounds(500, 280, 150, 35);
            cont.setForeground(Color.BLACK);
            newwindw.add(cont);
            
            final JButton search, show, update, delete, Exit, insert;
            search = new JButton("search");
            search.setBounds(130, 500, 100, 30);
            search.setBackground(Color.red);            
            search.setForeground(Color.white);
            newwindw.add(search);
            
            show = new JButton("show");
            show.setBounds(260, 500, 100, 30);
            show.setBackground(Color.red);            
            show.setForeground(Color.white);
            newwindw.add(show);
            
            insert = new JButton("insert");
            insert.setBounds(390, 500, 100, 30);
            insert.setBackground(Color.red);            
            insert.setForeground(Color.white);
            newwindw.add(insert);
            //insert.addActionListener(this);
            
            delete = new JButton("Delete");
            delete.setBounds(520, 500, 100, 30);
            delete.setBackground(Color.red);            
            delete.setForeground(Color.white);
            newwindw.add(delete);
            
            Exit = new JButton("Exit");
            Exit.setBounds(650, 500, 100, 30);
            Exit.setBackground(Color.red);            
            Exit.setForeground(Color.white);
            newwindw.add(Exit);
            
            
            Exit.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    newwindw.dispose();
                }
            });
            
            insert.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // TODO add your handling code here:
                        //JTextField sn,si,d,roll,sem,la,cn;tn,de,r,con
                        String query = "insert into admin values('" + an.getText().toString() + "','" + rn.getText().toString() + "','" + cont.getText().toString() + "')";                        
                        
                        statement.execute(query);
                        an.setText(null);
                        rn.setText(null);
                        cont.setText(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            delete.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String query = "delete from admin where Name=('" + an.getText().toString() + "')";
                        statement.execute(query);
                        an.setText(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            search.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    final JFrame newwindw = new JFrame();
                    newwindw.setTitle("search Admin's information");
                    newwindw.setBounds(250, 40, 400, 190);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.white);
                    //newwindw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  JLabel srch=new JLabel("Enter your text:");
                   srch.setBounds(80, 35, 100, 30);
                    newwindw.add(srch);
                    JLabel srchw=new JLabel("Search by:");
                   srchw.setBounds(80, 70, 100, 30);
                    newwindw.add(srchw);
                    final JTextField s=new JTextField();
                    s.setBounds(200, 35, 120, 30);
                    newwindw.add(s); 
                    JRadioButton name=new JRadioButton("name");
                    name.setBounds(200, 75, 60, 20);
                    name.setBackground(Color.cyan);
                    newwindw.add(name);
                    JRadioButton rank=new JRadioButton("Rank");
                     rank.setBounds(270, 75, 60, 20);
                       rank.setBackground(Color.cyan);
                    newwindw.add(rank);
                   ButtonGroup rn=new ButtonGroup();
                   rn.add(name);
                   rn.add(rank);
                   JButton exit=new JButton("exit");
                exit.setBounds(260, 110, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                   name.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                         final JFrame newwindw = new JFrame();
                    newwindw.setTitle("search Admin's information by name");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));    
                   JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();
                    
                    

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "Name", "Rank", "ContactNo"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                    
                    
                    
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();
 
                        // create Statement for querying database


                        // query database                                        
                        ResultSet resultSet = statement.executeQuery(
                               "SELECT Name,Rank, ContactNo from admin where Name=('" + s.getText().toString() + "' )");
                        // "SELECT Name,Rank, ContactNo from admin where Name like '%s'=('" + s.getText().toString() + "' )");
                         s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1); 
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                        }
                    });
                   
                     rank.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            final JFrame newwindw = new JFrame();
                    newwindw.setTitle("search Admin's information by rank");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));    
                   JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "Name", "Rank", "ContactNo"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                    
                    
                    
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();




                        // create Statement for querying database


                        // query database                                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT Name,Rank, ContactNo from admin where Rank=('" + s.getText().toString() + "' )");
                        s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1); 
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                        }
                    });
                     
                
                }
            });
            
            show.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    final JFrame newwindw = new JFrame();
                    newwindw.setTitle("search Admin list");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                    
                    
                    
                    
                    JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "Name", "Rank", "ContactNo"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                    
                    
                    
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();
                                       
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT Name,Rank, ContactNo from admin");
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1);
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                }
            });
             //Icon a = new ImageIcon(getClass().getResource("library.jpg"));
        // JLabel passimage = new JLabel(a);
        // passimage.setBounds(0, 0, 1000, 700);
        // newwindw.add(passimage);   
           
        }
        
        if (source == menuItemH) {
            JFrame newwindw = new JFrame();
            newwindw.setTitle("Help");
            //newwindw.setBounds(250,40,800,600);

            //JLabel text=new JLabel("for any kind of help please contact with admin.");
            //newwindw.getContentPane().add(text);
            //text.setForeground(Color.black);
            //text.setBounds(20, 20, 1000, 80);
            JTextPane pa = new JTextPane();
            String s = "For any kind of help contact with admin";
            pa.setText(s);
            pa.setEditable(false);
            newwindw.add(pa);
            newwindw.setSize(400, 300);
            newwindw.setVisible(true);
            //newwindw.setLayout(null);
           // newwindw.getContentPane().setBackground(Color.BLUE);
             
        }
        if (source == menuItemAl) {
            JFrame newwindw = new JFrame();
            newwindw.setTitle("About Library");
           // newwindw.setBounds(250, 40, 800, 600);
            newwindw.setVisible(true);
           // newwindw.setLayout(null);
            //newwindw.getContentPane().setBackground(Color.WHITE);
            //JLabel text = new JLabel("It is a rental library of cse department in ruet.");
           // newwindw.getContentPane().add(text);
           // text.setForeground(Color.black);
            //text.setBounds(20, 20, 1000, 80);
             JTextPane pa = new JTextPane();
            String s = "It is a rental library of cse depertment of RUET";
            pa.setText(s);
            pa.setEditable(false);
            newwindw.add(pa);
            newwindw.setSize(400, 300);
            newwindw.setVisible(true);
            newwindw.setBackground(Color.BLUE);
              
            
        }
        if (source == menuItemB) {
            final JFrame newwindw = new JFrame();
            newwindw.setTitle("Book list");
            newwindw.setBounds(250, 40, 800, 600);
            newwindw.setVisible(true);
            newwindw.setLayout(null);
            newwindw.getContentPane().setBackground(Color. white);
            
            JLabel lbn = new JLabel("Bookname:");
            lbn.setBounds(200, 100, 150, 45);
            lbn.setForeground(Color.black);
            newwindw.add(lbn);
            
            JLabel la = new JLabel("Author:");
            la.setBounds(200, 140, 150, 45);
            la.setForeground(Color.black);
            newwindw.add(la);
            
            
            JLabel lrd = new JLabel("RelatedDep");
            lrd.setBounds(200, 180, 150, 45);
            lrd.setForeground(Color.black);
            newwindw.add(lrd);
            
            JLabel lrs = new JLabel("RelatedSemester");
            lrs.setBounds(200, 220, 150, 45);
            lrs.setForeground(Color.black);
            newwindw.add(lrs);
            
            JLabel lnc = new JLabel("NoOfCopy");
            lnc.setBounds(200, 260, 150, 45);
            lnc.setForeground(Color.black);
            newwindw.add(lnc);            
            
            JLabel lac = new JLabel("AvailabelCopy");
            lac.setBounds(200, 300, 150, 45);
            lac.setForeground(Color.black);
            newwindw.add(lac);
            
            JLabel llc = new JLabel("Location");
            llc.setBounds(200, 340, 150, 45);
            llc.setForeground(Color.black);
            newwindw.add(llc);
            
              JLabel hd=new JLabel("***** Book information *****");
        hd.setBounds(190, 30, 500, 30);
        hd.setForeground(Color.black);
        newwindw.add(hd);
        Font u = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 30);
         hd.setFont(u);       

            
            final JTextField bn, a, rd, rs, nc, ac, lc;
            bn = new JTextField();
            bn.setBounds(500, 100, 150, 35);
            bn.setForeground(Color.BLACK);
            newwindw.add(bn);
            // sn.setText("");
            
            a = new JTextField();
            a.setBounds(500, 140, 150, 35);
            a.setForeground(Color.BLACK);
            newwindw.add(a);
            
            
            rd = new JTextField();
            rd.setBounds(500, 180, 150, 35);
            rd.setForeground(Color.BLACK);
            newwindw.add(rd);
            
            rs = new JTextField();
            rs.setBounds(500, 220, 150, 35);
            rs.setForeground(Color.BLACK);
            newwindw.add(rs);
            
            nc = new JTextField();
            nc.setBounds(500, 260, 150, 35);
            nc.setForeground(Color.BLACK);
            newwindw.add(nc);            
            
            ac = new JTextField();
            ac.setBounds(500, 300, 150, 35);
            ac.setForeground(Color.BLACK);
            newwindw.add(ac);
            
            lc = new JTextField();
            lc.setBounds(500, 340, 150, 35);
            lc.setForeground(Color.BLACK);
            newwindw.add(lc);
            
            final JButton show, search, delete, Exit, insert,update;
            show = new JButton("show");
            show.setBounds(135, 500, 100, 30);
            show.setBackground(Color.red);            
            show.setForeground(Color.white);
            newwindw.add(show);
            
            search = new JButton("search");
            search.setBounds(265, 500, 100, 30);
            search.setBackground(Color.red);            
            search.setForeground(Color.white);
            newwindw.add(search);
            
            insert = new JButton("insert");
            insert.setBounds(395, 500, 100, 30);
            insert.setBackground(Color.red);            
            insert.setForeground(Color.white);
            insert.setToolTipText("insert here");
            newwindw.add(insert);
            //insert.addActionListener(this);                         
            delete = new JButton("Delete");
            delete.setBounds(525, 500, 100, 30);
            delete.setBackground(Color.red);            
            delete.setForeground(Color.white);
            newwindw.add(delete);
            
            Exit = new JButton("Exit");
            Exit.setBounds(655, 500, 100, 30);
            Exit.setBackground(Color.red);            
            Exit.setForeground(Color.white);
            newwindw.add(Exit);
            
             update = new JButton("update");
            update.setBounds(5, 500, 100, 30);
           update.setBackground(Color.red);            
            update.setForeground(Color.white);
            newwindw.add(update);
            
         /*   update.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   try {
                        
                         String query = "update booklist set Author=''" + a.getText().toString() + "'',RelatedDep=''" + rd.getText().toString() + "'',RelatedSemester=''" + rs.getText().toString() + "'',NoOfCopy=''" + nc.getText().toString() + "'',AvailableCopy=''" + ac.getText().toString() + "'',Location=''" + lc.getText().toString() + "'' where BookName=('" + bn.getText().toString() + "')";                        
                        statement.execute(query);
                         //bn.setText(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            });*/
            
            
            Exit.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    newwindw.dispose();
                }
            });
            
            show.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    final JFrame newwindw = new JFrame();
                    newwindw.setTitle("showing student list");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                     
                    JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();
  //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "BookName", "Author", "RelatedDep", "RelatedSemester", "NoOfCopy", "AvailableCopy", "Location"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                     
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();                        
                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT BookName,Author,RelatedDep,RelatedSemester,NoOfCopy,AvailableCopy,Location from booklist");
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1);
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                }
            });
            
            search.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    final JFrame newwindw = new JFrame();
                    newwindw.setTitle("searching book from Book list");
                    newwindw.setBounds(250, 40, 500, 190);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.white);
                     JLabel srch=new JLabel("Enter your text:");
                   srch.setBounds(80, 35, 100, 30);
                    newwindw.add(srch);
                    JLabel srchw=new JLabel("Search by:");
                   srchw.setBounds(80, 70, 100, 30);
                    newwindw.add(srchw);
                    final JTextField s=new JTextField();
                    s.setBounds(200, 35, 160, 30);
                    newwindw.add(s); 
                    JRadioButton name=new JRadioButton("Bookname");
                    name.setBounds(200, 75, 80, 20);
                      name.setBackground(Color.cyan);
                    newwindw.add(name);
                    JRadioButton a=new JRadioButton("Authur");
                     a.setBounds(290, 75, 80, 20);
                       a.setBackground(Color.cyan);
                    newwindw.add(a);
                   ButtonGroup rn=new ButtonGroup();
                   rn.add(name);
                   rn.add(a);
                    JButton exit=new JButton("exit");
                exit.setBounds(260, 110, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                    name.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                             final JFrame newwindw = new JFrame();
                    newwindw.setTitle("searching book from Book list");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                          JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "BookName", "Author", "RelatedDep", "RelatedSemester", "NoOfCopy", "AvailableCopy", "Location"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                     
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();                        
                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT BookName,Author,RelatedDep,RelatedSemester,NoOfCopy,AvailableCopy,Location from booklist where BookName=('" + s.getText().toString() + "' )");
                        s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1); 
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                        }
                    });
                    a.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                             final JFrame newwindw = new JFrame();
                    newwindw.setTitle("searching book from Book list by Authur name");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                             JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();
   //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "BookName", "Author", "RelatedDep", "RelatedSemester", "NoOfCopy", "AvailableCopy", "Location"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                     
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();                        
                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT BookName,Author,RelatedDep,RelatedSemester,NoOfCopy,AvailableCopy,Location from booklist where Author=('" + s.getText().toString() + "' )");
                        s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1);
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                        }
                    });
                    
                }
            });
            insert.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String query = "insert into booklist values('" + bn.getText().toString() + "','" + a.getText().toString() + "','" + rd.getText().toString() + "','" + rs.getText().toString() + "','" + nc.getText().toString() + "','" + ac.getText().toString() + "','" + lc.getText().toString() + "')";                        
                        
                        statement.execute(query);
                        bn.setText(null);
                        a.setText(null);
                        rd.setText(null);
                        rs.setText(null);
                        nc.setText(null);
                        ac.setText(null);
                        lc.setText(null);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
             
            delete.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String query = "delete from booklist where BookName=('" + bn.getText().toString() + "')";
                        statement.execute(query);
                         bn.setText(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                          
                    }
                }
            });
            
            //Icon p = new ImageIcon(getClass().getResource("library.jpg"));
        //JLabel passimage = new JLabel(p);
        //passimage.getClass().getResource("Forest.JPEG");
        //passimage.setBounds(0, 0, 1000, 700);
        // newwindw.add(passimage);    
            
        }
        if (source == menuItemlc){
        final JFrame newwindw = new JFrame();
            newwindw.setTitle("opening library account");
            newwindw.setBounds(250, 40, 800, 600);
            newwindw.setVisible(true);
            newwindw.setLayout(null);
            newwindw.getContentPane().setBackground(Color.white);
            
            JLabel hd=new JLabel("***** Create library account *****");
        hd.setBounds(190, 30, 500, 30);
        hd.setForeground(Color.black);
        newwindw.add(hd);
        Font u = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 30);
         hd.setFont(u);
            
            JLabel lbn = new JLabel("studentname:");
            lbn.setBounds(200, 100, 150, 45);
            lbn.setForeground(Color.black);
            newwindw.add(lbn);
            
            JLabel la = new JLabel("roll:");
            la.setBounds(200, 140, 150, 45);
            la.setForeground(Color.black);
            newwindw.add(la);
            
            
            JLabel lrd = new JLabel("dep:");
            lrd.setBounds(200, 180, 150, 45);
            lrd.setForeground(Color.black);
            newwindw.add(lrd);
            
            JLabel lrs = new JLabel("sem:");
            lrs.setBounds(200, 220, 150, 45);
            lrs.setForeground(Color.black);
            newwindw.add(lrs);
            
            JLabel lnc = new JLabel("account no:");
            lnc.setBounds(200, 260, 150, 45);
            lnc.setForeground(Color.black);
            newwindw.add(lnc);            
            
            JLabel lac = new JLabel("co_no");
            lac.setBounds(200, 300, 150, 45);
            lac.setForeground(Color.black);
            newwindw.add(lac);
            
            
            
            final JTextField bn, a, rd, rs, nc, ac;
            bn = new JTextField();
            bn.setBounds(500, 100, 150, 35);
            bn.setForeground(Color.BLACK);
            newwindw.add(bn);
            // sn.setText("");
            
            a = new JTextField();
            a.setBounds(500, 140, 150, 35);
            a.setForeground(Color.BLACK);
            newwindw.add(a);
            
            
            rd = new JTextField();
            rd.setBounds(500, 180, 150, 35);
            rd.setForeground(Color.BLACK);
            newwindw.add(rd);
            
            rs = new JTextField();
            rs.setBounds(500, 220, 150, 35);
            rs.setForeground(Color.BLACK);
            newwindw.add(rs);
            
            nc = new JTextField();
            nc.setBounds(500, 260, 150, 35);
            nc.setForeground(Color.BLACK);
            newwindw.add(nc);            
            
            ac = new JTextField();
            ac.setBounds(500, 300, 150, 35);
            ac.setForeground(Color.BLACK);
            newwindw.add(ac);
            
            
            final JButton show, search, delete, Exit, insert,update;
            show = new JButton("show");
            show.setBounds(135, 500, 100, 30);
            show.setBackground(Color.red);            
            show.setForeground(Color.white);
            newwindw.add(show);
             
            insert = new JButton("insert");
            insert.setBounds(265, 500, 100, 30);
            insert.setBackground(Color.red);            
            insert.setForeground(Color.white);
            insert.setToolTipText("insert here");
            newwindw.add(insert);
            //insert.addActionListener(this);                         
            delete = new JButton("Delete");
            delete.setBounds(395, 500, 100, 30);
            delete.setBackground(Color.red);            
            delete.setForeground(Color.white);
            newwindw.add(delete);
            
            Exit = new JButton("Exit");
            Exit.setBounds(525, 500, 100, 30);
            Exit.setBackground(Color.red);            
            Exit.setForeground(Color.white);
            newwindw.add(Exit);
            
              
            Exit.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    newwindw.dispose();
                }
            });
            
            show.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                     final JFrame newwindw = new JFrame();
                    newwindw.setTitle("checking account no");
                    newwindw.setBounds(250, 40, 800, 300);
                    newwindw.setVisible(true);
                    newwindw.setLayout(null);
                    newwindw.getContentPane().setBackground(Color.getHSBColor(120, 240, 200));
                          JTable mytable = new JTable();
                    JScrollPane jScrollPane1 = new JScrollPane();
                    mytable.setVisible(true);
                    JLabel jLabel1 = new JLabel();

                    //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    
                    mytable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                            },
                            new String[]{
                                "studentNname", "roll", "dep", "sem", "accountno", "co_no"
                            }));
                    jScrollPane1.setViewportView(mytable);
                    
                    jLabel1.setText("my table");
                    show.add(jLabel1);
                    
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(newwindw.getContentPane());
                    newwindw.getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(8, 8, 8).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));
                     
                    try {
                        Class.forName(JDBC_DRIVER);
                        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");                        
                        statement = (Statement) connection.createStatement();                        
                        
                        ResultSet resultSet = statement.executeQuery(
                                "SELECT studentNname,roll,dep,sem,accountno,co_no from bankaccount");
                       // s.setText(null);
                        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                        int numberOfColumns = metaData.getColumnCount();                        
                        DefaultTableModel dtm = new DefaultTableModel();
                        Vector column_name = new Vector();
                        Vector data_rows = new Vector();
                        for (int i = 1; i <= numberOfColumns; i++) {
                            column_name.addElement(metaData.getColumnName(i));                            
                        }
                        dtm.setColumnIdentifiers(column_name);
                        while (resultSet.next()) {
                            data_rows = new Vector();
                            for (int j = 1; j <= numberOfColumns; j++) {
                                data_rows.addElement(resultSet.getString(j));
                            }
                            dtm.addRow(data_rows);
                        }
                        mytable.setModel(dtm);
                    } catch (Exception x) {
                        x.printStackTrace();                        
                    }
                    
                    show.add(jScrollPane1); 
                     JButton exit=new JButton("exit");
                     exit.setBounds(700, 210, 55, 30);
                exit.setBackground(Color.red);
                newwindw.add(exit);
                exit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newwindw.dispose();  
                    }
                });
                }
            });
            
            
            insert.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String query = "insert into bankaccount values('" + bn.getText().toString() + "','" + a.getText().toString() + "','" + rd.getText().toString() + "','" + rs.getText().toString() + "','" + nc.getText().toString() + "','" + ac.getText().toString() + "')";                        
                        
                        statement.execute(query);
                        bn.setText(null);
                        a.setText(null);
                        rd.setText(null);
                        rs.setText(null);
                        nc.setText(null);
                        ac.setText(null);
                        
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
             
            delete.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                        String query = "delete from bankaccount where accountno=('" + nc.getText().toString() + "')";
                        statement.execute(query);
                         bn.setText(null);
                    } catch (SQLException ex) {
                        Logger.getLogger(librarymanagement.class.getName()).log(Level.SEVERE, null, ex);
                          
                    }
                }
            });
            
           // Icon p = new ImageIcon(getClass().getResource("library.jpg"));
       // JLabel passimage = new JLabel(p);
        //passimage.getClass().getResource("Forest.JPEG");
       // passimage.setBounds(0, 0, 1000, 700);
        // newwindw.add(passimage);    
        }
        
        
    }
}
