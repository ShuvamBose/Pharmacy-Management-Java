package model;


public class Payment {
    String transactionId;
	float amount;

	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount=amount;
	}

	public void computeAmt(){
		ConnectTodb temp = new ConnectTodb("cart");
		setAmount(temp.getAmt());
	}

	public boolean pay(String s){
        if(s.compareToIgnoreCase("Y")==0){
			db t=new proxy();
			t.truncate();
			return true;
		}
			
		return false;
	}
}
