
package seleniumpractice;
// Generates test data arrays for Selenium data-driven testing
public class TestDataGenerator {
    public static void main(String[] args) {
        // REAL: You need multiple test accounts
        String[] usernames = {"standard_user", "locked_user", "problem_user", "performance_user"};
        String password = "secret_sauce";
        
        System.out.println("🔧 GENERATING TEST DATA FOR SAUCE DEMO");
        System.out.println("=".repeat(50));
        
        // Generate test cases array
        Object[][] testCases = new Object[usernames.length][2];
        
        for (int i = 0; i < usernames.length; i++) {
            testCases[i][0] = usernames[i];
            testCases[i][1] = password;
            
            System.out.println("Test Case " + (i+1) + ":");
            System.out.println("  Username: " + testCases[i][0]);
            System.out.println("  Password: " + testCases[i][1]);
            
            // Control flow: Different actions based on user type
            if (usernames[i].contains("locked")) {
                System.out.println("  Expected: Login should FAIL (user locked)");
                System.out.println("  Action: Verify error message appears");
            } else if (usernames[i].contains("problem")) {
                System.out.println("  Expected: Login works but images might be broken");
                System.out.println("  Action: Check product images load correctly");
            } else {
                System.out.println("  Expected: Successful login");
                System.out.println("  Action: Verify dashboard loads");
            }
            System.out.println();
        }
        
        // Array: Page URLs to test
        String[] pagesToTest = {
            "/inventory.html",
            "/cart.html", 
            "/checkout-step-one.html",
            "/checkout-step-two.html",
            "/checkout-complete.html"
        };
        
        System.out.println("PAGES TO TEST:");
        for (String page : pagesToTest) {
            String fullUrl = "https://www.saucedemo.com" + page;
            System.out.println("  - " + page + " -> " + fullUrl);
        }
    }
}