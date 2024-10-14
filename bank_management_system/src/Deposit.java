/****************************************/
/* BANK MANAGEMENT SYSTEM: ATM SIMULATOR*/
/* MARGO BONAL, AUG. 2024               */
/* PURPOSE: LEARN JAVA, LIBRAIES, MYSQL */
/****************************************/

/*********LIBRARIES**********/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/***************************/

public class Deposit extends JFrame implements ActionListener{

    //----------GLOBAL VARIABLES--------------
    JButton deposit, back;
    JTextField amount;
    String pinnumber;
    //----------------------------------------

    Deposit(String pinnumber){

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

        //------------------AMOUNT LABEL--------------------------
        JLabel text = new JLabel("Enter Deposit Amount: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 25);
        image.add(text);
        //--------------------------------------------------------

        //----------------ENTRY BOX: AMOUNT------------------------
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        //----------------------------------------------------------

        //---------------DEPOSIT BUTTON----------------------------
        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        //---------------------------------------------------------

        //---------------BACK BUTTON----------------------------
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        //-----------------------------------------------------

        //--------WINDOW CONFIGURATION-------------
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        //--------END WINDOW CONFIGURATION---------
    }

    //------------------------ACTION HANDLER-------------------------------------------------------
    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == deposit){

            String number = amount.getText(); //get amount
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Deposit");
            } else{
                try{

                    Conn conn = new Conn(); //create new connection to sql
                    String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Deposit', '"+number+"')"; //insert into query
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs" +number+ "Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }

        }else if(ae.getSource() == back){
            new Transactions(pinnumber).setVisible(true);
        }
    }
    //------------------------END ACTION HANDLER-------------------------------------------------------

    //---------------MAIN-----------------------------
    public static void main(String[] args) {
        new Deposit("");

    }
    //--------------END MAIN---------------------------
    
}
