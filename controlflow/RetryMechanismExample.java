package controlflow;

public class RetryMechanismExample {

    public static void main(String[] args) {

        int maxRetry = 3;
        boolean isSuccess = false;

        for (int attempt = 1; attempt <= maxRetry; attempt++) {
            System.out.println("Attempt: " + attempt);

            // Getting success on 3rd attempt
            if (attempt == 3) {
                isSuccess = true;
                break;
            }
        }

        if (isSuccess) {
            System.out.println("Operation completed successfully");
        } else {
            System.out.println("Operation failed after retries");
        }
    }
}