import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
public class expenditure_program{
    public static void main(String[] args){
        try{
            Connection con;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String username="project",password="project";
            con=DriverManager.getConnection(url,username,password);
            System.out.println("connected");
            JFrame f1=new JFrame();
            JLabel l1=new JLabel("Hello welcome to expenditure tracking program");
            f1.setLayout(null);
            f1.setTitle("Expenditure System");
            f1.setBounds(100,0,1280,720);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            l1.setHorizontalAlignment(JLabel.CENTER);
            l1.setSize(1000,100);
            f1.add(l1);

            JLabel parts=new JLabel("Particular:");
            parts.setBounds(15,100,200,20);
            JTextField particulars=new JTextField("Enter particular name");
            particulars.setBounds(80, 100, 200, 20);
            f1.add(particulars);
            f1.add(parts);

            JButton sub=new JButton("Submit");
            sub.setBounds(10,130,95,20);
            f1.add(sub);
            
            f1.setVisible(true);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}