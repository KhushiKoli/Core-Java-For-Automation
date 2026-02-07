package seleniumpractice;

//Builds dynamic locators for multiple elements - REAL Selenium need!
public class DynamicLocatorBuilder {
 public static void main(String[] args) {
     // Scenario: You need to click ALL "Add to Cart" buttons
     String[] productNames = {"Tomato", "Potato", "Onion", "Carrot", "Beans"};
     
     System.out.println("Building dynamic XPaths for products:");
     
     // Array magic: Generate XPaths dynamically
     for (int i = 0; i < productNames.length; i++) {
         // Method 1: By exact text
         String xpath1 = "//button[text()='Add " + productNames[i] + " to Cart']";
         
         // Method 2: By contains text (more robust)
         String xpath2 = "//button[contains(text(),'" + productNames[i] + "')]";
         
         // Method 3: By attribute
         String css = "button[data-product='" + productNames[i].toLowerCase() + "']";
         
         System.out.println("\nProduct: " + productNames[i]);
         System.out.println("  XPath1: " + xpath1);
         System.out.println("  XPath2: " + xpath2);
         System.out.println("  CSS:    " + css);
     }
     
     // REAL USE: Handle dynamic table rows
     System.out.println("\n=== DYNAMIC TABLE HANDLING ===");
     int totalRows = 10;
     
     for (int row = 1; row <= totalRows; row++) {
         // Build XPath for each cell in row
         String nameCell = "//table//tr[" + row + "]/td[1]";
         String priceCell = "//table//tr[" + row + "]/td[2]";
         String buttonCell = "//table//tr[" + row + "]/td[3]/button";
         
         System.out.println("Row " + row + ": " + nameCell + " | " + priceCell + " | " + buttonCell);
     }
 }
}
