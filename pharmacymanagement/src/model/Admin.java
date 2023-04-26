package model;

// Singleton Class- Design Pattern
public class Admin extends User {
    //int id;
    long phone;
    final String password="admin";

    private static volatile Admin o=null ;
    private Admin(){
        
    }
    public static synchronized Admin getObj(){
        if(o == null){
            o=new Admin();
        }
        return o;
    }
    
}
