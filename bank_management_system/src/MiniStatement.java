import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.sql.*;


public class MiniStatement extends JFrame {

    JLabel text, bank, mini, card, balance;
    String pinnumber;

    MiniStatement(String pinnumber){

        setLayout(null);
        setTitle("Mini Statement");

        mini = new JLabel();
        add(mini);

        bank = new JLabel("Mini Statement");
        bank.setFont(new Font("System", Font.BOLD, 20));
        bank.setBounds(115, 20, 200, 20);
        add(bank);

        card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        balance = new JLabel();
        balance.setBounds(20, 600, 300, 20);
        balance.setFont(new Font("System", Font.BOLD, 14));
        add(balance);



        try{

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            //ResultSet rs = conn.s.executeQuery("select * from login where pin = '2724'"); //test pin

            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4)+ "XXXXXXXX"+  rs.getString("cardnumber").substring(12));
            }

        }catch(Exception e){System.out.println(e);}


        try{

           int  bal = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                
                if (rs.getString("type").equals("Deposit"))
                {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else
                {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            
            }
            balance.setText("Current Balance: $" + bal);
        }catch(Exception e){System.out.println(e);}

        mini.setBounds(20, 140, 400, 400);




        setSize(400, 700);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);



    }


















    public static void main(String[] args) {
        new MiniStatement("");
    }
    
}
