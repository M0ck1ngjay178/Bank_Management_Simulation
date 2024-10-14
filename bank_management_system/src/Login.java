
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {

        //-----------------TITLE------------------------------
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        //----------------------------------------------------

        //----------------LOGIN WINDOW------------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/likeThis.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        //----------------------------------------------------

        //---------------------ATM----------------------------
        JLabel text = new JLabel("ATM Login:");
        text.setFont(new Font("Oswald", Font.BOLD, 38));
        //text.setBounds(200, 40, 400, 40);
        text.setBounds(300, 40, 400, 45);
        add(text);
        //----------------------------------------------------

        //---------------------CARD---------------------------
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        //----------------------------------------------------

        //---------------------PIN----------------------------
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        //----------------------------------------------------

        //-------------SIGN IN BUTTON-------------------------
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        //----------------------------------------------------

        //-------------CLEAR BUTTON---------------------------
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        //----------------------------------------------------

        //-------------SIGNUP BUTTON---------------------------
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
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

            //LOGIN CREDIDENTIALS
            //CARD NO- 5040935940385971
            //PIN - 4317 -> changed to 1234 ->4321



       } else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);

       }
    }
    //--------------------------------------------------------
    //----------MAIN------------------------------------------
    public static void main(String[] args){
       new Login();
    }
    //--------------------------------------------------------
}
