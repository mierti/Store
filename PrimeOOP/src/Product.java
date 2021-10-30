

import java.util.Date;
import java.util.Map;

public interface Product {

    Map<String, Double> calculatePrice(Date dateAndTimeOfPurchase, double price);
}
