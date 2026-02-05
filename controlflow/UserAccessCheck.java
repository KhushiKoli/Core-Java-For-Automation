package controlflow;

public class UserAccessCheck {

    public static void main(String[] args) {

        String userRole = "ADMIN";

        if (userRole.equals("ADMIN")) {
            System.out.println("Access granted to admin dashboard");
        } else if (userRole.equals("USER")) {
            System.out.println("Access granted to user homepage");
        } else {
            System.out.println("Access denied");
        }
    }
}