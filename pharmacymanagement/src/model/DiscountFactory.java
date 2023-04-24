package model;
public class DiscountFactory {
    public Discount createDiscount(String s){
        if(s == null || s.isEmpty()){
            return null;
        }
        switch(s){
            case "offline": return new OfflineDiscount();

            case "online": return new OnlineDiscount();

            default:
                throw new IllegalArgumentException(s+" is an Unknown Discount !");
        }
    }
}
