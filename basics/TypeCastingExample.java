package basics;

public class TypeCastingExample {

    public static void main(String[] args) {

        double price = 199.99;

        int roundedPrice = (int) price; // explicit casting

        System.out.println("Original price: " + price);
        System.out.println("Rounded price: " + roundedPrice);

        int quantity = 3;

        double totalAmount = price * quantity; // implicit casting

        System.out.println("Total amount: " + totalAmount);
    }
}

