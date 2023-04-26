package model;
import java.util.*;
//import view.*;

import view.MedicineView;

public class Cart {
	String name;
	int qty;
	Scanner scanObj = new Scanner(System.in);
    
	public void add(){
		MedicineView b=new MedicineView();
		db o= new proxy(); 
		b.set();
        o.add(b.getName(), b.getQuantity());
        o.close();
	}

	public void display(){
		db o1= new proxy();
        o1.disp();
		o1.close();
	}

	public void truncate(){
		db o3 =new proxy();
		o3.truncate();
		o3.close();
	}

	public void alter(){
		MedicineView b=new MedicineView();
		db o2 =new proxy();
        b.set();
        o2.update(b.getName(), b.getQuantity(),"cart");
        o2.close();
	}
}
