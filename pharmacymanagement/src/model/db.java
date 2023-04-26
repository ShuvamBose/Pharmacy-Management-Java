package model;
//import com.mysql.cj.xdevapi.Statement;

public interface db {
    public void add(String name,int qty);
    public void disp();
    public void close();
    public void update(String medname,int qty,String t);
    public void truncate();
    //public boolean getData(String s);
}
