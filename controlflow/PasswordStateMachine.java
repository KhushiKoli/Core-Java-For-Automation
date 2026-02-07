package controlflow;

public class PasswordStateMachine {
    public static void main(String[] args) {
        String[] passwords = {"weak", "Medium1", "STRONG@2024", "Short1", "NoNumber!", "Valid123@"};
        
        System.out.println("PASSWORD STRENGTH VALIDATOR");
        System.out.println("=".repeat(50));
        
        for (String password : passwords) {
            System.out.printf("Testing: '%-15s' -> ", password);
            analyzePassword(password);
        }
    }
    
    static void analyzePassword(String password) {
        // State tracking
        boolean hasUpper = false, hasLower = false;
        boolean hasDigit = false, hasSpecial = false;
        int score = 0;
        
        // Finite State Machine: Check each character
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch) && !hasUpper) {
                hasUpper = true;
                score += 20;
            } else if (Character.isLowerCase(ch) && !hasLower) {
                hasLower = true;
                score += 20;
            } else if (Character.isDigit(ch) && !hasDigit) {
                hasDigit = true;
                score += 20;
            } else if (!Character.isLetterOrDigit(ch) && !hasSpecial) {
                hasSpecial = true;
                score += 25;
            }
        }
        
        // Length bonus (non-linear scaling)
        if (password.length() >= 12) score += 30;
        else if (password.length() >= 8) score += 20;
        else if (password.length() >= 6) score += 10;
        
        // Control flow decision tree
        String strength;
        if (score >= 85 && password.length() >= 8 && hasUpper && hasLower && hasDigit) {
            strength = "STRONG";
        } else if (score >= 60 && password.length() >= 6 && (hasUpper || hasLower) && hasDigit) {
            strength = "MEDIUM";
        } else {
            strength = "WEAK";
            
            // Detailed feedback
            System.out.print("WEAK - Missing: ");
            if (password.length() < 6) System.out.print("[Length<6] ");
            if (!hasUpper) System.out.print("[No Uppercase] ");
            if (!hasLower) System.out.print("[No Lowercase] ");
            if (!hasDigit) System.out.print("[No Digit] ");
            System.out.println();
            return;
        }
        
        // Success case
        System.out.printf("%s (Score: %d/100)%n", strength, Math.min(score, 100));
        if (score > 85) {
            System.out.println("   Bonus: Contains special character");
        }
    }
}
