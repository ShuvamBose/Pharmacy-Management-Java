package view;

import java.util.*;

public class MedicineView {
    //int id;
	String name="";
	int quantity=0;
	Float price=0.0f;
    Scanner sc1=new Scanner(System.in);

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Float getPrice() {
        return price;
    }

	void display(int quantity,double price){
        System.out.println("Name: "+name);
        System.out.println("Amount:(per unit) "+price);
    }

    public void setInName(String s){
        this.name=s;
    }
    public void setInQty(int i){
        this.quantity=i;
    }
    public void setInPrice(Float f){
        this.price=f;
    }

    public void setName(){

        System.out.println("Enter the medicine name: \n");
        // try{
            
            //sc1.nextLine();
            //if(sc.hasNext()){
                name=sc1.nextLine();
                //System.out.println("I am Name");
            //}
            //sc1.close();
        // }
        // catch(Exception e){
        //     System.out.println(e);
        //     setName();
        //     return;
        // }
    }

    void setQty(){
        //Scanner sc=new Scanner(System.in);
        System.out.println("Enter Qty: (int) ");
        try{
            if(sc1.hasNextInt()){
                quantity = sc1.nextInt();
                //System.out.println("I am Qty");
            }
            
            //sc1.close();

        }
        catch(Exception e){
            System.out.println(e);
            setQty();
        }
    }
    public void setPrice(){
        //Scanner sc=new Scanner(System.in);
        System.out.println("Enter Price/unit: (float) ");
        Float p=(float) 0.0;
        try {
            if(sc1.hasNextFloat()){
                p=sc1.nextFloat();
                price=p;
            }
           // sc1.close();
        } catch (Exception e) {
            System.out.println(e);
            setPrice();
        }
        
    }

    public void set(){
        setName();
        setQty();
    }
}
