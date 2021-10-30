

import java.util.Calendar;
import java.util.Date;

public class Cart {
    private ProductImpl product;
    private double quantity;

    public Cart(ProductImpl product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductImpl getProduct() {
        return product;
    }

    public void setProduct(ProductImpl product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return product.getClass().getSimpleName() + " " + quantity;
    }
}
