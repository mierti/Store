
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = df.parse("2021-06-14");
        Date d2 = df.parse("2022-02-02");
        ProductImpl food = new Food("apple", "BrandA", 1.50, d1);
        ProductImpl beverage = new Beverage("milk", "BrandM", 0.99, d2);
        ProductImpl clothes = new Clothes("T-shirt", "BrandT", 15.99, Size.M, "violet");
        ProductImpl appliances = new Appliance("laptop", "BrandL", 2345, "ModelL", d1, 2);


        Cart apples = new Cart(food, 2.45);
        Cart milk = new Cart(beverage, 3);
        Cart tShirt = new Cart(clothes, 2);
        Cart laptop = new Cart(appliances, 1);


        List<Cart> carts = new ArrayList<>();
        carts.add(apples);
        carts.add(milk);
        carts.add(tShirt);
        carts.add(laptop);

        DateFormat dfpurchase = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        Date datePurchase = dfpurchase.parse("2021-06-14 12:34:56");
        Cashier cashier = new Cashier();
        System.out.println(cashier.printReceipt(carts, datePurchase));


    }
}
