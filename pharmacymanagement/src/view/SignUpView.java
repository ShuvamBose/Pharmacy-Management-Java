package view;

import java.util.*;

public class SignUpView {
    long phone;
    String name;
    String password;
    Scanner sc=new Scanner(System.in);  

    public SignUpView(){
        System.out.println("Enter Name: ");
        name=sc.next();
        System.out.println("Enter Phone: ");
        phone=sc.nextInt();
        System.out.println("Enter Password: ");
        password=sc.next();
    }
    public String getName(){
        
        return name;
    }
    public long getPhone(){

        return phone;
    }
    public String getPass(){
        return password;
    }
}
