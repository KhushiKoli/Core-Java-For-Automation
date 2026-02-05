
package basics;

public class ValidationUtils {

    public static boolean isTextMatching(String actual, String expected) {
        return actual.equalsIgnoreCase(expected);
    }

    public static void main(String[] args) {

        String actualText = "Login Successful";
        String expectedText = "login successful";

        if (isTextMatching(actualText, expectedText)) {
            System.out.println("Validation Passed");
        } else {
            System.out.println("Validation Failed");
        }
    }
}
