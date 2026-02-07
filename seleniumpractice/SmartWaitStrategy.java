package seleniumpractice;

//Chooses the RIGHT wait strategy based on element type - CRITICAL for Selenium!
public class SmartWaitStrategy {
 public static void main(String[] args) {
     String[] elementTypes = {"button", "dropdown", "modal", "toast", "loader", "input"};
     
     System.out.println("SMART WAIT STRATEGY SELECTOR");
     System.out.println("=".repeat(50));
     
     for (String elementType : elementTypes) {
         System.out.print("For " + elementType.toUpperCase() + ": ");
         
         // REAL Selenium logic: Different waits for different elements
         switch (elementType.toLowerCase()) {
             case "button":
                 System.out.println("Wait for elementToBeClickable (10 seconds)");
                 System.out.println("  -> driver.findElement(By.xpath(\"...\")).click();");
                 break;
                 
             case "dropdown":
                 System.out.println("Wait for presenceOfElement (5 seconds)");
                 System.out.println("  -> new Select(driver.findElement(...)).selectByValue(...);");
                 break;
                 
             case "modal":
                 System.out.println("Wait for visibilityOfElement + invisibilityOfElement");
                 System.out.println("  -> Wait for modal to appear, then disappear");
                 break;
                 
             case "toast":
                 System.out.println("Wait for visibility (2s) then invisibility (5s)");
                 System.out.println("  -> toast appears briefly, must wait for it to disappear");
                 break;
                 
             case "loader":
                 System.out.println("Wait for invisibilityOfElement (15 seconds)");
                 System.out.println("  -> Don't proceed until loader disappears!");
                 break;
                 
             case "input":
                 System.out.println("Wait for elementToBeClickable then sendKeys");
                 System.out.println("  -> element.click(); element.clear(); element.sendKeys(text);");
                 break;
                 
             default:
                 System.out.println("Default: Wait for presenceOfElement (10 seconds)");
         }
         System.out.println();
     }
     
     // REAL SCENARIO: Handling AJAX loading
     System.out.println("=== AJAX LOADING HANDLER ===");
     int maxAttempts = 3;
     boolean dataLoaded;
     
     for (int attempt = 1; attempt <= maxAttempts; attempt++) {
         System.out.println("Attempt " + attempt + " to load data...");
         
         // Simulate checking if data loaded
         if (attempt == 2) { // On 2nd attempt, data loads
        	 
             dataLoaded = true;
             System.out.println("Data loaded successfully!");
             break;
         }
         
         if (attempt == maxAttempts) {
             System.out.println("Failed to load data after " + maxAttempts + " attempts");
             // Take screenshot, log error
         }
     }
 }
}