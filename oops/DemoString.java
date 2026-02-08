package oops;

public class DemoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// string is a class -> 2 ways -> //1. String literal 2. Using New keyword
		
				/*Difference => Using 1. => s1 and s4 holds the same data then s4 is not create new object instead it points
								to the s1 object !
							   Using 2. => We are explicitly created new object so it will point to that object only.
			
				*/
				
				// String s1 = "QA Khushi Koli";
				// String s4 = "QA Khushi Koli";
				
				// new

				String s2 = new String("Welcome");
				String s3 = new String("Welcome");

				String s = "QA Khushi Koli";

				String[] splittedString = s.split("Khushi");

				System.out.println(splittedString[0]); //It split with the space 

				System.out.println(splittedString[1]);

				System.out.println(splittedString[1].trim()); //To remove extra space use trim method

					//Reverse the string
				for (int i = s.length() - 1; i >= 0; i--) {
					System.out.print(s.charAt(i));   //charAt() =>  return the character at a specific index in a String.
				}

	}

}
