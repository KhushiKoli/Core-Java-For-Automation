package oops;

import java.util.ArrayList;
import java.util.List;

/**
 * DEMONSTRATES: Encapsulation + Abstraction + Polymorphism
 * REAL-WORLD USE: E-commerce product catalog with different product types
 * Key OOP Concepts Demonstrated:

Encapsulation: Private fields with public getters/setters, data validation

Abstraction: Abstract class with abstract methods, hiding implementation details

Polymorphism: Method overriding, treating subclasses as parent type

Static vs Instance: Understanding class-level vs object-level members

Factory Pattern: Creating objects without exposing instantiation logic
 */

// 1. ABSTRACT CLASS (Abstraction)
abstract class Product {
    // ENCAPSULATION: Private fields with controlled access
    private String productId;
    private String name;
    private double basePrice;
    private int quantityInStock;
    private static int totalProducts = 0; // Static variable
    
    // Constructor
    public Product(String productId, String name, double basePrice, int quantityInStock) {
        this.productId = productId;
        this.name = name;
        setBasePrice(basePrice); // Using setter in constructor
        setQuantityInStock(quantityInStock);
        totalProducts++;
    }
    
    // ENCAPSULATION: Controlled getters and setters
    public String getProductId() { 
        return productId; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public double getBasePrice() { 
        return basePrice; 
    }
    
    public void setBasePrice(double price) {
        if(price >= 0) {
            this.basePrice = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
    
    public int getQuantityInStock() { 
        return quantityInStock; 
    }
    
    public void setQuantityInStock(int quantity) {
        if(quantity >= 0) {
            this.quantityInStock = quantity;
        }
    }
    
    public static int getTotalProducts() {
        return totalProducts;
    }
    
    // ABSTRACT METHODS (Abstraction)
    public abstract double calculateTax();
    public abstract double calculateShippingCost();
    
    // TEMPLATE METHOD PATTERN (Behavioral pattern using abstraction)
    public final double getFinalPrice(int quantity) {
        if(quantity > quantityInStock) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        
        double subtotal = basePrice * quantity;
        double tax = calculateTax() * quantity;
        double shipping = calculateShippingCost();
        
        return subtotal + tax + shipping;
    }
    
    // POLYMORPHISM: Method that can be overridden
    public String getProductDetails() {
        return String.format("ID: %s | Name: %s | Price: $%.2f | Stock: %d", 
                           productId, name, basePrice, quantityInStock);
    }
    
    // Factory Method Pattern
    public static Product createProduct(String type, String id, String name, 
                                       double price, int stock, Object... params) {
        switch(type.toLowerCase()) {
            case "book":
                return new Book(id, name, price, stock, 
                              (String)params[0], (String)params[1]);
            case "electronics":
                return new Electronics(id, name, price, stock, 
                                     (String)params[0], (int)params[1]);
            default:
                throw new IllegalArgumentException("Unknown product type");
        }
    }
}

// 2. CONCRETE CLASSES (Inheritance)
class Book extends Product {
    private String author;
    private String isbn;
    private static final double BOOK_TAX_RATE = 0.05; // 5%
    private static final double BOOK_SHIPPING = 2.99;
    
    public Book(String productId, String name, double basePrice, int quantityInStock,
                String author, String isbn) {
        super(productId, name, basePrice, quantityInStock);
        this.author = author;
        this.isbn = isbn;
    }
    
    // Implementing abstract methods
    @Override
    public double calculateTax() {
        return getBasePrice() * BOOK_TAX_RATE;
    }
    
    @Override
    public double calculateShippingCost() {
        return BOOK_SHIPPING;
    }
    
    // POLYMORPHISM: Overriding parent method
    @Override
    public String getProductDetails() {
        return super.getProductDetails() + 
               String.format(" | Author: %s | ISBN: %s", author, isbn);
    }
    
    // Additional method specific to Book
    public String getCitation() {
        return String.format("%s. \"%s\". ISBN: %s", author, getName(), isbn);
    }
}

class Electronics extends Product {
    private String brand;
    private int warrantyMonths;
    private static final double ELECTRONICS_TAX_RATE = 0.08; // 8%
    
    public Electronics(String productId, String name, double basePrice, int quantityInStock,
                       String brand, int warrantyMonths) {
        super(productId, name, basePrice, quantityInStock);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }
    
    @Override
    public double calculateTax() {
        return getBasePrice() * ELECTRONICS_TAX_RATE;
    }
    
    @Override
    public double calculateShippingCost() {
        // Dynamic shipping based on price
        double price = getBasePrice();
        if(price > 500) {
            return 0; // Free shipping for expensive items
        } else if(price > 100) {
            return 5.99;
        } else {
            return 8.99;
        }
    }
    
    // METHOD OVERLOADING (Compile-time polymorphism)
    public void extendWarranty() {
        warrantyMonths += 12;
    }
    
    public void extendWarranty(int additionalMonths) {
        warrantyMonths += additionalMonths;
    }
    
    @Override
    public String getProductDetails() {
        return super.getProductDetails() + 
               String.format(" | Brand: %s | Warranty: %d months", brand, warrantyMonths);
    }
}

// 3. COMPOSITION: Shopping Cart
class ShoppingCart {
    private List<Product> items;
    private String cartId;
    private double cartDiscount;
    
    public ShoppingCart(String cartId) {
        this.cartId = cartId;
        this.items = new ArrayList<>();
        this.cartDiscount = 0.0;
    }
    
    // COMPOSITION: ShoppingCart "has-a" list of Products
    public void addItem(Product product, int quantity) {
        if(quantity <= product.getQuantityInStock()) {
            for(int i = 0; i < quantity; i++) {
                items.add(product);
            }
            product.setQuantityInStock(product.getQuantityInStock() - quantity);
        } else {
            System.out.println("Cannot add " + quantity + " of " + product.getName() + 
                             ". Only " + product.getQuantityInStock() + " in stock.");
        }
    }
    
    // POLYMORPHISM: Process different product types through common interface
    public double calculateTotal() {
        double total = 0;
        for(Product item : items) {
            total += item.getBasePrice();
        }
        return total - (total * cartDiscount);
    }
    
    public void applyDiscount(double discountPercentage) {
        if(discountPercentage >= 0 && discountPercentage <= 0.5) { // Max 50% discount
            this.cartDiscount = discountPercentage;
        }
    }
    
    public void displayCart() {
        System.out.println("\n=== Shopping Cart Contents ===");
        for(Product item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getBasePrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

// 4. MAIN CLASS to demonstrate everything
public class ProductSystem {
    public static void main(String[] args) {
        System.out.println("=== OOP CONCEPTS DEMONSTRATION ===\n");
        
        // Using Factory Method
        Product book = Product.createProduct("book", "B001", 
            "Clean Code", 45.99, 10, "Robert Martin", "978-0132350884");
        
        Product laptop = Product.createProduct("electronics", "E001", 
            "Gaming Laptop", 1299.99, 5, "Dell", 24);
        
        // POLYMORPHISM: Treating different objects as Product
        List<Product> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(laptop);
        
        // Demonstrating polymorphism in action
        System.out.println("=== Product Catalog ===");
        for(Product product : catalog) {
            System.out.println(product.getProductDetails());
            System.out.println("Final price for 1 item: $" + product.getFinalPrice(1));
            System.out.println("---");
        }
        
        // ENCAPSULATION demonstration
        System.out.println("\n=== Encapsulation Test ===");
        System.out.println("Total products created: " + Product.getTotalProducts());
        
        // Try to set negative price (should throw exception or be prevented)
        try {
            book.setBasePrice(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Encapsulation working: " + e.getMessage());
        }
        
        // Shopping Cart with Composition
        ShoppingCart cart = new ShoppingCart("CART001");
        cart.addItem(book, 2);
        cart.addItem(laptop, 1);
        cart.applyDiscount(0.10); // 10% discount
        cart.displayCart();
        
        // Demonstrate method overriding
        System.out.println("\n=== Method Overriding Demo ===");
        System.out.println("Book details: " + book.getProductDetails());
        System.out.println("Electronics details: " + laptop.getProductDetails());
        
        // Demonstrate static vs instance
        System.out.println("\n=== Static vs Instance ===");
        System.out.println("Instance field (Book name): " + book.getName());
        System.out.println("Static field (Total products): " + Product.getTotalProducts());
    }
}