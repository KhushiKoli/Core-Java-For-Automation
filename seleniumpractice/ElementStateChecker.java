package seleniumpractice;
//Checks element states - CRITICAL for robust tests
public class ElementStateChecker {
 public static void main(String[] args) {
     // Array of element states you'll encounter
     String[] elements = {
         "login_button:enabled",
         "remember_me:checked", 
         "newsletter:unchecked",
         "submit_button:disabled",
         "dropdown:expanded",
         "modal:visible"
     };
     
     System.out.println("ELEMENT STATE VALIDATION");
     System.out.println("=".repeat(40));
     
     for (String element : elements) {
         String[] parts = element.split(":");
         String elementName = parts[0];
         String expectedState = parts[1];
         
         System.out.print("Checking " + elementName + " -> ");
         
         // Control flow: Validate each state
         switch (expectedState) {
             case "enabled":
                 System.out.println("Verify isEnabled() returns true");
                 System.out.println("  if(!element.isEnabled()) throw error");
                 break;
                 
             case "disabled":
                 System.out.println("Verify isEnabled() returns false");
                 System.out.println("  if(element.isEnabled()) throw error");
                 break;
                 
             case "checked":
                 System.out.println("Verify isSelected() returns true");
                 System.out.println("  if(!element.isSelected()) click() to check");
                 break;
                 
             case "unchecked":
                 System.out.println("Verify isSelected() returns false");
                 System.out.println("  if(element.isSelected()) click() to uncheck");
                 break;
                 
             case "visible":
                 System.out.println("Verify isDisplayed() returns true");
                 System.out.println("  if(!element.isDisplayed()) wait then retry");
                 break;
                 
             case "expanded":
                 System.out.println("Check for 'aria-expanded=true' attribute");
                 System.out.println("  element.getAttribute('aria-expanded')");
                 break;
         }
     }
 }
}
