package view;

public class BillView {

	long phone;
	float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void View(){
        System.out.println("----Inventory generated----\n");
        System.out.println("Customer Phone: "+phone);
        System.out.println("Amount: "+amount);
        System.out.println("---------------------------\n");
    }

}
