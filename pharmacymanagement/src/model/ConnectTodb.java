package model;
import view.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;


public class ConnectTodb implements db {
    String tblename="medicine"; 
    String dbname="javapharmacy";
    Statement stmt=null;
    ResultSet rs=null;
    String url="jdbc:mysql://localhost:3306/"+dbname;
    public static Connection getConnObj=null;

    public ConnectTodb(String tblename){
        if(tblename != null)
            this.tblename=tblename;
        else 
            this.tblename="medicine";
        
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            getConnObj=DriverManager.getConnection(url,"root","");   
            stmt=getConnObj.createStatement();  
        }
        catch(Exception e){
        System.out.println(e);
        } 
    }

    @Override
    public void disp(){
        try{
            rs=stmt.executeQuery("select * from "+tblename);
            while(rs.next())  
            System.out.println(rs.getString(1)+"  "+rs.getFloat(2)+"  "+rs.getInt(3)+"\n");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return;
    }

    @Override
    public void truncate(){
        try{
            stmt.execute("truncate table cart");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void add(String name,int qty){
        
        try{
            MedicineView temp =new MedicineView();
            temp=getFields(name);

            if(qty<=temp.getQuantity()){

            PreparedStatement preparedStmt = getConnObj.prepareStatement("insert into "+"cart"+" (Name,Price,Qty)"+"values( \'"+temp.getName()+"\' , "+temp.getPrice()+" , "+qty+" );");
            preparedStmt.execute();
            }
            else{
                System.out.println("Qty not in stock");
            }
        }
        catch(Exception e){
                System.out.println(e);
        }

    }


    @Override
    public void close() {
        try{
        stmt.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    } 

    @Override //qty update only
    public void update(String medname,int qty,String t){
        
        try{
            PreparedStatement preparedStmt = getConnObj.prepareStatement("update "+tblename+" set Qty= ? where name= ? ");//+"values(?,?);");
            preparedStmt.setInt(1,qty);
            preparedStmt.setString(2,medname);
            preparedStmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void addMedicine(String s,float Price,int Qty){
        try{
            PreparedStatement preparedStmt = getConnObj.prepareStatement("insert into "+tblename+" (Name,Price,Qty)"+"values(?,?,?);");
            preparedStmt.setString(1,s);
            preparedStmt.setFloat(2,Price);
            preparedStmt.setInt(3,Qty);
            preparedStmt.execute();
        }
        catch(Exception e){
                System.out.println(e);
        }
        return;
    }
    
    public void delete(String s){
        try{
            stmt.executeUpdate("delete from "+tblename+" where name like \'%"+s+"%\';");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public MedicineView getFields(String name){
        MedicineView temp =new MedicineView();
        
        try {
            rs=stmt.executeQuery("select * from medicine where Name like \"%"+name+"%\"");
            if(rs.next()){
            temp.setInName(rs.getString(1));
            temp.setInPrice(rs.getFloat(2));
            temp.setInQty(rs.getInt(3));
            return temp;
            }else{
                return null;
            }
            
        } catch (Exception e) {
            
            System.out. println(e);
        }
        return null;
    }
    
    public float getAmt(){
        Float f=0.0f;

        try {
            rs=stmt.executeQuery("select * from "+tblename);
            while(rs.next()){
                f=f+rs.getFloat(2)*rs.getInt(3);
            }
            return f;
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
        
    }

    public boolean getData(String ss,String tbl){
        
        try{
            rs=stmt.executeQuery("select name from "+tbl+" where name like \"%"+ss+"%\"");
           
            while(rs.next()){
                if(ss.equals(rs.getString(1)))
                    return true;
            }  
            
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

}
