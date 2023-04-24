package model;


public class SignUp {
    String name;
    long phone;
    //String location;
    String password;
    int flag;


    public SignUp(String name, long phone,String password,int flag ){
        //id= (int)(Math.random()*(19999-0+1)+0);
        this.name=name;
        this.phone=phone;
        this.password=password;
        this.flag=flag;
    }

    public int getUser(){
        if(flag==1){
            return 1;
        }
        else{
            return 0;
        }
    }
}
