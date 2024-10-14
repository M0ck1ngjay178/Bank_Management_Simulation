/*****************************************/
/* BANK MANAGEMENT SYSTEM: ATM SIMULATOR */
/* MARGO BONAL, AUG. 2024                */
/* PURPOSE: LEARN JAVA, LIBRARIES, MYSQL */
/*****************************************/

/*********LIBRARIES**********/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/***************************/

public class newLogin extends JFrame implements ActionListener{

    //----------GLOBAL VARIABLES--------------
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    //----------------------------------------

    newLogin() {

        //-----------------TITLE------------------------------
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        //----------------------------------------------------

        //----------------LOGIN WINDOW------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/gray.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 400, 480);
        add(label);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/likeThis.png"));
        Image a2 = a1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel label2 = new JLabel(a3);
        label2.setBounds(100, 100, 200, 200);
        label.add(label2);

        ImageIcon login1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image login2 = login1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon login3 = new ImageIcon(login2);
        JLabel label3 = new JLabel(login3);
        label3.setBounds(515, 30, 200, 100);
        add(label3);
        //----------------------------------------------------

        //---------------------ATM----------------------------
        /*JLabel text = new JLabel("Login:");
        text.setFont(new Font("Raleway", Font.BOLD, 38));
        //text.setBounds(200, 40, 400, 40);
        text.setBounds(530, 40, 400, 45);
        add(text);*/
        //----------------------------------------------------

        //---------------------CARD---------------------------
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 15));
        cardno.setBounds(430, 150, 150, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(500, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        //----------------------------------------------------

        //---------------------PIN----------------------------
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 15));
        pin.setBounds(430, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(500, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        //----------------------------------------------------

        //-------------SIGN IN BUTTON-------------------------
        login = new JButton("SIGN IN");
        login.setBounds(500, 300, 100, 30);
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        //----------------------------------------------------

        //-------------CLEAR BUTTON---------------------------
        clear = new JButton("CLEAR");
        clear.setBounds(630, 300, 100, 30);
        clear.setBackground(Color.DARK_GRAY);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        //----------------------------------------------------

        //-------------SIGNUP BUTTON---------------------------
        signup = new JButton("SIGN UP");
        signup.setBounds(500, 350, 230, 30);
        signup.setBackground(Color.DARK_GRAY);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        //----------------------------------------------------
        
        
        //-----------CONFIG BACKGROUND/COLOR------------------
        //getContentPane().setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350, 200);
        //----------------------------------------------------

    }

    //----------ACTION?---------------------------------------
    public void actionPerformed(ActionEvent ae){
       if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
       } else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
           // String pinnumber = pinTextField.getText();
           char[] pinArray = pinTextField.getPassword();
           String pinnumber = new String(pinArray);
           String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '" +pinnumber+"' ";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            }catch (Exception e){
                System.out.println(e);
            }

            //======LOGIN CREDIDENTIALS===========
            //CARD NO- 5040935940385971
            //PIN - 4317 -> changed to 1234 ->4321
            //====================================


       } else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);

       }
    }
    //--------------------------------------------------------
    //----------MAIN------------------------------------------
    public static void main(String[] args){
       new newLogin();
    }
    //--------------------------------------------------------
}

