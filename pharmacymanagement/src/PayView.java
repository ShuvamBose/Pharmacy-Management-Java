import java.util.Scanner;

public class PayView {
    String transactionId;
	float amount;
    
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    Scanner sc=new Scanner(System.in);

    String Pay(){
        System.out.println("transactionId: "+transactionId);
        System.out.println("Amount: "+amount);
        
        try {
            
            System.out.println("Enter choice Y|N for paying: ");
            //System.out.println(System.in.available());
            String k="";
            //sc.nextLine();
            if(sc.hasNext()){
                k= sc.next();
                }
                //sc.close();
                return k;
        } catch (Exception e) {

            System.out.println(e);
        }
        return "N";
    }
    void getResponse(boolean b){
            if(b==false){
                System.out.println("Payment failed !!");
            }
            else System.out.println("Payment Successful");
    }
}
