package model;

// Singleton Class- Design Pattern
public class Admin {
    //int id;
    long phone;
    String name;
    private static volatile Admin o=null ;
    private Admin(){
        
    }
    public static synchronized Admin getObj(){
        if(o == null){
            o=new Admin();
            //return o;
        }
        return o;
    }
    
}
