

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Beverage extends ProductImpl {
    private Date expirationDate;

    public Beverage(String name, String brand, double price, Date expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public Map<String, Double> calculatePrice(Date dateAndTimeOfPurchase, double price) {
        Map<String, Double> discountAndFinalPrice = new LinkedHashMap<>();
        long diff = this.expirationDate.getTime() - dateAndTimeOfPurchase.getTime();
        long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        if (diffDays == 0) {
            double discount = price * 0.5;
            discountAndFinalPrice.put("50%", discount);
        } else if (diffDays == -5) {
            double discount = price * 0.1;
            discountAndFinalPrice.put("10%", discount);
        }

        return discountAndFinalPrice;
    }
}
