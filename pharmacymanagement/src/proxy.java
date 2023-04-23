
public class proxy implements db {
    String tbname="cart";
    db oo= new ConnectTodb(tbname);
    ConnectTodb o =new ConnectTodb(tbname);

    @Override
    public void update(String s,int qty,String t){
        oo.update(s,qty,t);
    }

    @Override
    public void add(String s,int qty) {
        if(o.getData(s,tbname)){
            System.out.println("Data Already added!");
            return;
        }
        else
            oo.add(s,qty);
        return;
    }
    @Override
    public void disp(){
        oo.disp();
        return ;
    }
    @Override
    public void truncate(){
        oo.truncate();
    }

    @Override
    public void close(){
        oo.close();
    }
    
}
