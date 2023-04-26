package model;


public class LogIn {
    long phone;
    String password;
    boolean usr;
    
    public LogIn(long phone,String password,boolean usr){
        this.phone=phone;
        this.password= password;

        this.usr=usr;
    }
    public String getPass(){
         return password;
    }

    public boolean auth(){
        if(usr==true && password.compareTo("admin")==0)
            return true;
        return false;
    }
}
