

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Cashier {


    public String printReceipt(List<Cart> cart, Date dateAndTimeOfPurchase) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(dateAndTimeOfPurchase);
        StringBuilder stringBuilder = new StringBuilder(strDate).append(System.lineSeparator()).append("---Products---")
                .append(System.lineSeparator()).append(System.lineSeparator());

        double totalPrice = 0.0;
        double totalDiscount = 0.0;
        for (Cart cart1 : cart) {
            double price = cart1.getQuantity() * cart1.getProduct().getPrice();
            totalPrice += price;
            String formatedPrice = String.format("%.2f", price);
            String productInfo = cart1.getProduct().toString();

            DecimalFormat format = new DecimalFormat("0.##");
            String productPriceInfo = format.format(cart1.getQuantity()) + " x $" + cart1.getProduct().getPrice() + " = $" + formatedPrice;

            Map<String, Double> discountAndFinalPrice = cart1.getProduct().calculatePrice(dateAndTimeOfPurchase, price);
            String discountAndPrice = "";

            for (Map.Entry<String, Double> pair : discountAndFinalPrice.entrySet()) {
                discountAndPrice = String.format("#discount %s -$%.2f%n", pair.getKey(), pair.getValue());
                totalDiscount += pair.getValue();
            }

            stringBuilder.append(productInfo).append(System.lineSeparator()).append(productPriceInfo).append(System.lineSeparator())
                    .append(discountAndPrice).append(System.lineSeparator());
        }
        String subTotal = String.format("SUBTOTAL: %.2f", totalPrice);
        String discount = String.format("DISCOUNT: %.2f", totalDiscount);
        String total = String.format("TOTAL: %.2f", totalPrice - totalDiscount);
        stringBuilder.append("-----------------------------------------").append(System.lineSeparator())
                .append(subTotal).append(System.lineSeparator()).append(discount).append(System.lineSeparator()).append(total)
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }

}
