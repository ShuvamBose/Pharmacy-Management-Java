import java.util.*;

public class LogInView {
    long phone;
    String password;
    Scanner sc=new Scanner(System.in);  

    LogInView(){
        System.out.println("Enter Phone: ");
        phone=sc.nextLong();
        System.out.println("Enter Password: ");
        password=sc.next();
    }
    long getPhone(){
        return phone;
    }
    String getPass(){
        return password;
    }
}
