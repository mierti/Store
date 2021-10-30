

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Appliance extends ProductImpl{
    private String model;
    private Date productionDate;
    private double weight;

    public Appliance(String name, String brand, double price, String model, Date productionDate, double weight) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Map<String, Double> calculatePrice(Date dateAndTimeOfPurchase, double price) {
        Map<String, Double> discountAndFinalPrice = new LinkedHashMap<>();

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateAndTimeOfPurchase);
        int day = cal.get(Calendar.DAY_OF_WEEK);

        if (price > 999 && (day == Calendar.SATURDAY || day == Calendar.SUNDAY)) {
            double discount = price * 0.05;
            discountAndFinalPrice.put("5%", discount);
        }

        return discountAndFinalPrice;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %s", this.getModel());
    }
}
