
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JFrame;

 
public class Librarymanagementsystem {
  // private JLabel passlabel, passimage, welcome, mainmenu_image;
    //private JButton passbutton;
    // private JPasswordField passfield;
      
    public static void main(String[] args) {
       librarymanagement1 obj=new librarymanagement1();
      ///  class librarymanagement1 extends JFrame{
        obj.setTitle("LIBRARY MANAGEMENT SYSTEM : RAJSHAHI UNIVERSITY OF ENJINEERING AND TECNOLOGY");
         obj.setBounds(195, 22, 1010, 660);
         obj.setLayout(null);
         obj.setVisible(true);
         obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         obj.getContentPane().setBackground(Color.white);
       // w.setIconImage(null);
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        obj.setCursor(cur);
        
        
        
      /* JLabel passlabel = new JLabel();
        passlabel.setText("ENTER  YOUR  PASSWARD");
        Font pass_font = new Font("serif", Font.PLAIN, 15);
        passlabel.setFont(pass_font);
        passlabel.setBounds(627, 150, 200, 50);
        w.add(passlabel);

       final JPasswordField passfield = new JPasswordField(10);
        passfield.setBounds(610, 210, 218, 50);
        w.add(passfield);
       

        JButton passbutton = new JButton("OK");
        passbutton.setBounds(670, 310, 100, 50);
        w.add(passbutton);
        
         
       ///Icon a = new ImageIcon(w.getResource("library.jpg"));
     // JLabel passimage = new JLabel(a);
     // passimage.setIcon(a); 
       //passimage.setBounds(0, 0, 400, 700);
        //w.add(passimage);
      
        
        passbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String fn;
                String sn = "sawan";
                 
                fn = passfield.getText().toString();
                passfield.setText(null);
                 //if (fn.equals(sn)){
                
                
        
        librarymanagement ob = new librarymanagement();

        ob.setTitle("LIBRARY MANAGEMENT SYSTEM : RAJSHAHI UNIVERSITY OF ENJINEERING AND TECNOLOGY");
        ob.setBounds(200, 26, 1000, 700);
        ob.setLayout(null);
        ob.setVisible(true);
        ob.getContentPane().setBackground(Color.GREEN);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// }
                  /*else{
                final JFrame passwrdfrm=new JFrame();
                passwrdfrm.setTitle("passward field");
                passwrdfrm.setBounds(642, 325, 390, 100);
                passwrdfrm.getContentPane().setBackground(Color.red);
                passwrdfrm.setLayout(null);
                passwrdfrm.setVisible(true);
                
                JLabel newpassfrm;
                newpassfrm=new JLabel();
                newpassfrm.setText("     You've entered wrong passward");
                newpassfrm.setForeground(Color.WHITE);
                newpassfrm.setBounds(10, 10, 900, 40);
                passwrdfrm.add(newpassfrm);
                
                JButton pass_exit=new JButton("Exit");
                pass_exit.setBounds(270, 10, 80, 40);
                pass_exit.setForeground(Color.blue);
                passwrdfrm.add(pass_exit);
                
                pass_exit.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                passwrdfrm.dispose();
                
                
                }
                });
            }
        }
                }); */
        

    
}

     
}
