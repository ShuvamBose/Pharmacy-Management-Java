package model;


public class SignUp {

    long phone;
    //String location;
    String password;
    int flag;


    public SignUp(long phone,String password,int flag ){
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
