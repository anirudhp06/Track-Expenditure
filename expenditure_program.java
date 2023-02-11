import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class expenditure_program {
    public static void main(String[] args) {
        try {
            Connection con;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "project", password = "project";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            JFrame f1 = new JFrame();
            JLabel l1 = new JLabel("Hello welcome to expenditure tracking program");
            f1.setLayout(null);
            f1.setTitle("Expenditure System");
            f1.setBounds(100, 0, 1280, 720);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            l1.setHorizontalAlignment(JLabel.CENTER);
            l1.setSize(1000, 100);
            f1.add(l1);

            JLabel parts = new JLabel("Particular:");
            parts.setBounds(15, 100, 200, 20);

            JTextField particulars = new JTextField("Enter particular name");
            particulars.setBounds(80, 100, 200, 20);
            f1.add(particulars);
            f1.add(parts);

            JLabel rt = new JLabel("Rate:");
            rt.setBounds(15, 140, 200, 20);
            f1.add(rt);

            JTextField rate = new JTextField("Enter rate of product");
            rate.setBounds(80, 140, 200, 20);
            f1.add(rate);

            JButton sub = new JButton("Submit");
            sub.setBounds(10, 200, 95, 20);
            sub.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Submitting...");
                    try {
                        
                          String sql="insert into expenditure values(?,?)";
                          PreparedStatement ps=con.prepareStatement(sql);
                          ps.setString(1,particulars.getText());
                          ps.setString(2,rate.getText());
                          ps.executeUpdate();
                        
                        System.out.println("Submitted");

                        JFrame prompt = new JFrame("Submitted");
                        prompt.setLayout(null);
                        prompt.setBounds(200, 200, 260, 200);

                        JLabel l = new JLabel("Submitted");
                        l.setHorizontalAlignment(JLabel.CENTER);
                        prompt.add(l);

                        JLabel success = new JLabel("Successfully added record");
                        success.setBounds(30, 80, 200, 20);

                        JButton ok = new JButton("OK");
                        ok.setBounds(50, 100, 100, 20);
                        ok.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                prompt.dispose();
                            }
                        });
                        prompt.add(success);
                        prompt.add(ok);
                        prompt.setVisible(true);

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            f1.add(sub);

            JButton view = new JButton("View Transactions");
            view.setBounds(140, 200, 200, 20);
            view.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Transactions Generating...");
                }
            });
            f1.add(view);

            f1.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}