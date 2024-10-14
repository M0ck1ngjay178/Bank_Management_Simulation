/****************************************/
/* BANK MANAGEMENT SYSTEM: ATM SIMULATOR*/
/* MARGO BONAL, AUG. 2024               */
/* PURPOSE: LEARN JAVA, LIBRAIES, MYSQL */
/****************************************/

/*********LIBRARIES**********/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
/***************************/

public class BalanceEnquiry extends JFrame implements ActionListener{

    //----------GLOBAL VARIABLES--------------
    JButton deposit, back;
    JTextField amount;
    String pinnumber;
    JLabel text;
    //---------------------------------------

    BalanceEnquiry(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);

        //--------------------BACKGROUND IMAGE: ATM-----------------------------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2_edit.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        //----------------------------------------------------------------------------------------

       //----------------BACK BUTTON---------------------
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        //-----------------------------------------------

        //-----------------------ESTABLISH CONNECTION TO SQL-----------------------------
        Conn c = new Conn();
        int balance = 0;
           
           try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
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
            }catch(Exception e){System.out.println(e);}

            text = new JLabel("Current Account Balance: $" + balance);
            text.setBounds(170, 300, 400, 30);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("System", Font.BOLD, 16));
            image.add(text);
            //----------------------------------------------------------------------------

        //--------WINDOW CONFIGURATION-------------
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        //--------END WINDOW CONFIGURATION---------
    }

    //-----------------ACTION HANDLER------------------------
    public void actionPerformed(ActionEvent ae){

        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    //---------------END ACTIONS-----------------------------

    //----------------MAIN------------------
    public static void main(String[] args) {
        new BalanceEnquiry("");

    }
    //--------------------------------------
    
}

