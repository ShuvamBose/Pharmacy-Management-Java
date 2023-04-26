package view;
import java.util.*;

public class LogInView {
    long phone;
    String password;
    Scanner sc=new Scanner(System.in);  

    public LogInView(){
        System.out.println("Enter Phone: ");
        phone=sc.nextLong();
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
