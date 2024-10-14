import java.awt.*;
import java.awt.event.*;
//import java.sql.*;
//import java.util.Date;
import javax.swing.*;


public class PinChange extends JFrame implements ActionListener {

    JButton back, change ;
    JLabel pintext,text,repintext;
    String pinnumber;
    JPasswordField pin, repin;

    PinChange(String pinnumber){

        this.pinnumber = pinnumber;
        
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2_edit.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text = new JLabel("Change Account Pin");
        text.setBounds(250, 280, 500, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        pintext = new JLabel("New Pin");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);


        repintext = new JLabel("Re-Enter New Pin");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);


        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

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
        if(ae.getSource() == change)
        {
            try{
                char[] pass1Array = pin.getPassword();
                String npin = new String(pass1Array);
                //String npin = pin.getPassword();
                //String rpin = pin.getText();
                char[] pass2Array =repin.getPassword();
                String rpin = new String(pass2Array);
    
                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "PIN does not match");
                    return;
                    
                }

                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter new PIN");
                    return;
                }

                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    return; 
                }
                

                Conn conn = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

    
            }catch (Exception e){System.out.println(e);}
    
        } else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }
        
        
    }

    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}

