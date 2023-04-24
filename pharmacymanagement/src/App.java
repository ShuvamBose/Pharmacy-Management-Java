import java.util.*;

import model.Admin;
import model.Bill;
import model.Cart;
import model.ConnectTodb;
import model.LogIn;
import model.Medicine;
import model.Payment;
import model.SignUp;
import model.db;
import model.proxy;
import view.LogInView;
import view.MedicineView;
import view.PayView;
import view.SignUpView;

public class App {
    public static boolean usr=false;
    static Admin admo = null;
    static String resp;
    static Scanner scanObj = new Scanner(System.in);
    public static void main(String args[]){
        
        
        l:{
        System.out.println("Enter your Choice: ");
        System.out.println("1.Admin\n2.Client");
        
        int ip=scanObj.nextInt();
        
        if(ip==1){
            System.out.println("1.Login \nEnter choics: ");
            int ip1=scanObj.nextInt();
            if(ip1==1){

                LogInView obj = new LogInView();
                new LogIn(obj.getPhone(),obj.getPass(),true);
                
                usr=true;
            }else break l;
                admo= Admin.getObj();
        }
        else if(ip==2){
                
                usr=false;
                System.out.println("1. SignUp \n2.Login \nEnter choics: ");
                int ip11=scanObj.nextInt();
                if(ip11==1){
                    SignUpView obj = new SignUpView();
                    new SignUp(obj.getName(), obj.getPhone(), obj.getPass(),ip);
                    usr=false;
                }
                else{
                    LogInView obj = new LogInView();
                    new LogIn(obj.getPhone(),obj.getPass(),usr);
                    usr=false;
                }
        }
        else{
            System.out.println("Enter valid option !");
            break l;
        }
        }
            
        do{
        int ipp=displayOpt(false);
        splitter(ipp);
        System.out.println("Do u want to continue ?(Y/N)");
        resp=scanObj.next();
        }
        while(resp.compareToIgnoreCase("Y")==0);
        
    }
    public static void PayCaller(){
        Payment p =new Payment();
        PayView pp = new PayView();
        p.computeAmt();
        
        Bill b=new Bill();
        b.setAmount(p.getAmount());
        //System.out.println(p.getAmount()+" "+b.getAmount()+" "+b.getAmount());
        pp.setAmount(b.getFinalAmt());
        pp.getResponse(p.pay(pp.Pay()));

    }

    public static int displayOpt(boolean usr){
        
        int ip=-1;
        System.out.println("--------------------------------------");
        System.out.println("Choose from options below:");
        if(admo != null){//admin
            //Scanner scanObj = new Scanner(System.in);
            System.out.println("1.Add Medicine\n2.Update\n3.Delete\n4.Display\n5.Exit\nEnter option: ");
            try{ip=scanObj.nextInt();
                scanObj.nextLine();

            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            //user
            //Scanner scanObj = new Scanner(System.in);
            System.out.println("1.Add medicine to cart\n2.DisplayCart\n3.Update Cart\n4.View Bill & Make Payment\n5.Exit\n6.Drop cart\nEnter option: ");
            try{ip=scanObj.nextInt();
                scanObj.nextLine();

            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        //scanObj.close();
        return ip;
    }

    public static void splitter(int ip){
        if(ip==-1){
            System.out.println("Retry wrong i/p !");
        }
        if(ip==5){
            System.out.println("Closing Sys.");
            db d = new ConnectTodb(null);
            d.close();
            d=new proxy();
            d.close();
            scanObj.close();
            System.exit(0);
        }
        
        if(admo !=null){ 
            MedicineView b=new MedicineView();
            
            switch(ip){
                case 1: 
                        b.set();
                        b.setPrice();
                        Medicine bb= new Medicine(b.getName(), b.getQuantity(), b.getPrice());
                        
                        bb.addItem();
                        break;
                case 2: 
                        b.set();
                        
                        Medicine bb1= new Medicine(b.getName(), b.getQuantity(), null);
                        bb1.updateQuantity("medicine");
                        break;
                case 3: ConnectTodb ob3 =new ConnectTodb(null);
                        b.setName();
                        ob3.delete(b.getName());
                        break;
                case 4: db ob4 =new ConnectTodb(null);
                        ob4.disp();
            }
        }
        if(admo == null){
        
            switch(ip){
                case 1: Cart c3 = new Cart();
                        c3.add();
                        break;
                case 2: Cart c2= new Cart();
                        c2.display();
                        break;
                case 3: Cart c1=new Cart();
                        c1.alter();
                        break;
                case 4: 
                        PayCaller();
                        break;
                case 6: Cart c =new Cart();
                        c.truncate();
                        break;
            }
        }
        
    }

}
