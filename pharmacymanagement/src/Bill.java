

public class Bill {
    //int id;
	long phone;
	//String customerName;
	float amount;

    volatile DiscountFactory df= new DiscountFactory();
    volatile Discount d= df.createDiscount("offline");
    float discount=d.getDiscount();

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    private void Calc(){
        setAmount(getAmount()-getAmount()*discount);
    }

    public float getFinalAmt(){
        Calc();
        return amount;
    }
}
