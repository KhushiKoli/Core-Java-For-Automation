package controlflow;

public class IfElseExample {
    public static void main(String[] args) {

        // Basic if-else
        int age = 20;
        if (age >= 18) {
            System.out.println("You are eligible to vote");
        } else {
            System.out.println("You are not eligible to vote");
        }

        // if-else ladder
        int marks = 75;
        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }

        // Nested if-else
        int salary = 50000;
        boolean hasExperience = true;
        if (salary > 30000) {
            if (hasExperience) {
                System.out.println("Eligible for Senior Role");
            } else {
                System.out.println("Eligible for Junior Role");
            }
        } else {
            System.out.println("Not Eligible");
        }
    }
}