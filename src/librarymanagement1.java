
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sawan
 */
public class librarymanagement1 extends JFrame{
    
    public librarymanagement1()
    {
    super("LIBRARY MANAGEMENT SYSTEM : RAJSHAHI UNIVERSITY OF ENJINEERING AND TECNOLOGY");
    setLayout(new FlowLayout());
    JLabel passlabel = new JLabel();
        passlabel.setText("ENTER  YOUR  PASSWARD");
        Font pass_font = new Font("serif", Font.ITALIC, 18);
        passlabel.setFont(pass_font);      
        passlabel.setForeground(Color.black);
        passlabel.setBounds(610, 150, 230, 50);
        add(passlabel);
        
        JLabel w=new JLabel();
        w.setText("WELCOME ");
         Font h = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 50);
         w.setFont(h);
          w.setForeground(Color.BLACK);
          w.setBounds(180, 170, 400, 40);
         add(w);
          JLabel t=new JLabel();
        t.setText("       TO    ");
         Font j = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 50);
         t.setFont(j);
          t.setForeground(Color.black);
          t.setBounds(180, 230, 400, 40);
         add(t);
          JLabel k=new JLabel();
        k.setText("     OUR  ");
         Font o = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 50);
         k.setFont(o);
          k.setForeground(Color.black);
          k.setBounds(180, 290, 400, 40);
         add(k);
          JLabel s=new JLabel();
        s.setText(" LIBRARY !!");
         Font p = new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 50);
         s.setFont(p);
          s.setForeground(Color.black);
          s.setBounds(180, 350, 400, 40);
         add(s);
         
       final JPasswordField passfield = new JPasswordField(10);
        passfield.setBounds(610, 210, 218, 50);
        add(passfield);
       
        Icon a = new ImageIcon(getClass().getResource("images.jpg"));
        JButton passbutton = new JButton(a);
        passbutton.setBounds(670, 310, 100, 50);     
        add(passbutton);
        
         
      // Icon q = new ImageIcon(getClass().getResource("lll.jpg"));
     //JLabel passimage = new JLabel(q);
     // passimage.setIcon(a); 
      // passimage.setBounds(0, 0, 1010, 660);
      // add(passimage);
      
        
        passbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String fn;
                String sn = "sawan";
                 
                fn = passfield.getText().toString();
                passfield.setText(null);
                 if (fn.equals(sn)){
                
              dispose();
        
        librarymanagement ob = new librarymanagement();

        ob.setTitle("LIBRARY MANAGEMENT SYSTEM : RAJSHAHI UNIVERSITY OF ENJINEERING AND TECNOLOGY");
        ob.setBounds(200, 26, 1000, 700);
        ob.setLayout(null);
        ob.setVisible(true);
        ob.getContentPane().setBackground(Color.white);
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
                  else{
                   JOptionPane.showMessageDialog(null, "Please enter correct passward"); 
              
           }
        }
                }); 
        
    
    } 
        }
                