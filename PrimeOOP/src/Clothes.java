

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Clothes extends ProductImpl {
    private String color;
    private Size size;

    public Clothes(String name, String brand, double price, Size size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    public Size getSize(){
        return this.size;
    }


    public String getColor()
    {
        return this.color;
    }

    @Override
    public Map<String, Double> calculatePrice(Date dateAndTimeOfPurchase, double price) {
        Map<String, Double> discountAndFinalPrice = new LinkedHashMap<>();

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateAndTimeOfPurchase);
        int day = cal.get(Calendar.DAY_OF_WEEK);

        if (day != Calendar.SATURDAY && day != Calendar.SUNDAY) {
            double discount = price * 0.1;
            discountAndFinalPrice.put("10%", discount);
        }
        return discountAndFinalPrice;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %s %s", this.getSize(), this.getColor());
    }

}
