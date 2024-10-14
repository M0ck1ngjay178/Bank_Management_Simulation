/****************************************/
/* BANK MANAGEMENT SYSTEM: ATM SIMULATOR*/
/* MARGO BONAL, AUG. 2024               */
/* PURPOSE: LEARN JAVA, LIBRAIES, MYSQL */
/****************************************/

/*********LIBRARIES**********/
import java.sql.*;
/***************************/
public class Conn {

    Connection c;
    Statement  s;
    
    public Conn(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "*******REDACTED PASSWORD*******");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);

        }
    }

    
}
/* -------------------MYSQL QUERY 1 ACTIONS: ----------------------------------
create database bankmanagementsystem;

show databases;

use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), lname varchar(20), dob varchar(20), gender varchar(20), email varchar(30), marital_status varchar(20), address varchar(40), city varchar(25), state varchar(25), zipcode varchar(20));

show tables;

select * from signup;

SHOW DATABASES LIKE 'bankmanagementsystem';

SHOW TABLES LIKE 'signup';

create table signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(20), phoneNumber varchar(20), seniorCitizen varchar(20), existingAcc varchar(20));
select * from signuptwo;

create table signupthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25), pin varchar(10), facility varchar(100));
select * from signupthree;

create table login(formno varchar(20), cardnumber varchar(25), pin varchar(10));
select * from login;

create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));
select * from bank;

drop table bank;*/

