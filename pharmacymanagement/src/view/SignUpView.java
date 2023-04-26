package view;

import java.util.*;

public class SignUpView {
    long phone;
    String password;
    Scanner sc=new Scanner(System.in);  

    public SignUpView(){
        System.out.println("Enter Phone: ");
        phone=sc.nextInt();
        System.out.println("Enter Password: ");
        password=sc.next();
    }

    public long getPhone(){

        return phone;
    }
    public String getPass(){
        return password;
    }
}
