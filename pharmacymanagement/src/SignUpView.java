
import java.util.*;

public class SignUpView {
    long phone;
    String name;
    String password;
    Scanner sc=new Scanner(System.in);  

    SignUpView(){
        System.out.println("Enter Name: ");
        name=sc.next();
        System.out.println("Enter Phone: ");
        phone=sc.nextInt();
        System.out.println("Enter Password: ");
        password=sc.next();
    }
    String getName(){
        
        return name;
    }
    long getPhone(){

        return phone;
    }
    String getPass(){
        return password;
    }
}
