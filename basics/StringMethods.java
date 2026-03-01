package basics;

public class StringMethods {
    public static void main(String[] args) {
        String str = "Hello Java World";

        System.out.println("Original: " + str);
        System.out.println("Length: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Substring(6,10): " + str.substring(6, 10));
        System.out.println("Replace: " + str.replace("Java", "Selenium"));
        System.out.println("Contains 'Java': " + str.contains("Java"));
        System.out.println("StartsWith 'Hello': " + str.startsWith("Hello"));
        System.out.println("IndexOf 'World': " + str.indexOf("World"));
        System.out.println("Trim: " + "  Hello  ".trim());
        System.out.println("CharAt(0): " + str.charAt(0));
        System.out.println("isEmpty: " + str.isEmpty());
    }
}