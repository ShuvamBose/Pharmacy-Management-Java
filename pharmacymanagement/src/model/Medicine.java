package model;


public class Medicine {
    //int id;
	String name;
	int quantity;
	Float price;

    public Medicine(String name,int qty,Float price){
        this.price=price;
        this.name=name;
        this.quantity=qty;
    }

	public void addItem(){//(String name,int quantity,Float price){
        ConnectTodb o =new ConnectTodb("medicine");
        o.addMedicine(name, price, quantity); 
    }

	void removeItem(String name){
        ConnectTodb o =new ConnectTodb("medicine");
        o.delete(name);
    }

	// void updatePrice(String name,double price){
        
    // }
    
	public void updateQuantity(String table){
        ConnectTodb ob2= new ConnectTodb(null);
        ob2.update(name, quantity,table);
    }
}
