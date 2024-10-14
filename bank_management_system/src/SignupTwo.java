import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pan, phoneNum; 
    JButton next;
    JRadioButton syes, sno, eyes, eno;
   
    JComboBox<String> religion, category, occupation, education, income ;
    String formno;

    SignupTwo(String formno){
        
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        //-------------PERSONAL DETAILS------------------------------
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        //-----------------------------------------------------------

        //-------------RELIGION--------------------------------------
        JLabel name = new JLabel("Language:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);

        String valReligion[] = {"English","Spanish", "French","Mandarin" ,"Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);


        //-----------------------------------------------------------

        //-------------CATEGORY--------------------------------------
        JLabel lname = new JLabel("Category:");
        lname.setFont(new Font("Raleway", Font.BOLD, 20));
        lname.setBounds(100,190,200,30);
        add(lname);

        String valCategory[] = {"Minor", "Over 18", "Independent", "Dependants","Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        //-----------------------------------------------------------

        //-------------INCOME----------------------------------------
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String valIncome[] = {"NULL","<30,000", "<50,000", "<100,000", "<300,000","Other"};
        income = new JComboBox<>(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        //-----------------------------------------------------------

        //-------------EDUCATION LABEL-------------------------------
        JLabel gender = new JLabel("Education");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

        //-----------------------------------------------------------

        //-------------QUALIFICATON----------------------------------
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);

        String valEducation[] = {"Non-Graduate","Graduate", "Masters", "Doctrate","Other"};
        education = new JComboBox<>(valEducation);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        //-----------------------------------------------------------

        //-------------OCCUPATION----------------------------------
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String valOccupation[] = {"Salary","Self-Enployed", "Bussiness", "Student","Non-Profit","Retired", "Other"};
        occupation = new JComboBox<>(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        //-----------------------------------------------------------

        //-------------PAN---------------------------------------
        JLabel address = new JLabel("PAN:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400,30);
        add(pan);
        //-----------------------------------------------------------

        //-------------PHONE NUM-------------------------------------
        JLabel city = new JLabel("Phone Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);

        phoneNum = new JTextField();
        phoneNum.setFont(new Font("Raleway", Font.BOLD, 14));
        phoneNum.setBounds(300, 490, 400,30);
        add(phoneNum);
        //-----------------------------------------------------------

        //-------------SENIOR CITIZEN--------------------------------
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        //-----------------------------------------------------------

        //-------------EXISTING ACC----------------------------------
        JLabel zipcode = new JLabel("Existing Account :");
        zipcode.setFont(new Font("Raleway", Font.BOLD, 20));
        zipcode.setBounds(100,590,200,30);
        add(zipcode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);

        
        //-----------------------------------------------------------

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true); 

    }

    //----------ACTION?---------------------------------------
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem(); //set text
        String scategory = (String) category.getSelectedItem();
        String sincome =  (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitzen = null;
        if (syes.isSelected()){
            seniorcitzen = "Yes";
        }else if (sno.isSelected()){
            seniorcitzen = "No";
        }

        String existingaccount = null;
        if (eyes.isSelected()){
            existingaccount = "Yes";
        }else if (eno.isSelected()){
            existingaccount = "No";
        }

        String span = pan.getText();
        String sphoneNum = phoneNum.getText();
        
        try{
            
            Conn c = new Conn();
            String query ="Insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+sphoneNum+"','"+seniorcitzen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            //Signup3 Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }

     }
     //--------------------------------------------------------

    
    //----------MAIN----------------------------

    public static void main(String args[]){
        new SignupTwo("");

    }
    //-----------------------------------------
}
