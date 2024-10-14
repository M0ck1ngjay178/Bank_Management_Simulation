/****************************************/
/* BANK MANAGEMENT SYSTEM: ATM SIMULATOR*/
/* MARGO BONAL, AUG. 2024               */
/* PURPOSE: LEARN JAVA, LIBRAIES, MYSQL */
/****************************************/

/*********LIBRARIES**********/
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;
/***************************/

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdraw, ministatement, pinchange, fastcash, balanceenquiry, back;
    String pinnumber;

    FastCash(String pinnumber){

        this.pinnumber = pinnumber;
        
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2_edit.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Select Withdraw Amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("$20");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("$50");
        withdraw.setBounds(355, 415, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("$80");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("$100");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("$300");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("$500");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);



        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
           String amount = ((JButton) ae.getSource()).getText().substring(1); //500
           Conn c = new Conn();
           
           try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while(rs.next())
            {
                if (rs.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null , "Insufficient Balance");
                return;
            }

            Date date = new Date();
            String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"' )";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "$" +amount+ "Debited Successfully");
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
           }catch(Exception e){System.out.println(e);}
        }
    }

    public static void main(String args[]){
        new FastCash("");
    }
}
