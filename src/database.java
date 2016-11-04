
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sawan
 */
class database extends javax.swing.JFrame {
     private javax.swing.JTextField  lIssueofDate;
     private javax.swing.JTextField  lBookName;
     private javax.swing.JTextField  lAuthur;
     private javax.swing.JTextField  lExpirationDate;
     private javax.swing.JTextField lfee;
     private javax.swing.JTextField  lStudentName;
     private javax.swing.JTextField lRoll;
     private javax.swing.JTextField  lSem;
     private javax.swing.JTextField  ldep;
     private javax.swing.JTextField lCo_No;
    private javax.swing.JButton delete;
    private javax.swing.JButton insert;
      private javax.swing.JLabel  IssueofDate;
     private javax.swing.JLabel  BookName;
     private javax.swing.JLabel  Authur;
     private javax.swing.JLabel  ExpirationDate;
     private javax.swing.JLabel fee;
     private javax.swing.JLabel  StudentName;
     private javax.swing.JLabel Roll;
     private javax.swing.JLabel  Sem;
     private javax.swing.JLabel  dep;
     private javax.swing.JLabel Co_No;
    
    
      static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
  static final String DATABASE_URL="jdbc:mysql://localhost/library management system";
  Connection connection=null;
  Statement statement=null;
    

    public database() {
     try{
     Class.forName(JDBC_DRIVER);
     connection=(Connection)DriverManager.getConnection(DATABASE_URL,"root","");
     statement=(Statement)connection.createStatement();
     }catch(Exception e){
             e.printStackTrace();  
           }
          initComponents();
         
        }

    private void initComponents() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
 
   
    }
 
    

