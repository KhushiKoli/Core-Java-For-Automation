package controlflow;

import java.util.ArrayList;
import java.util.Arrays;



public class ArraysList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			//Need -> Normal array is always fixed size, ArrayList is enhanced version of array.
			//	   -> It dynamically store the data, reduce and increase size as per need.
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("");
		a.add("Khushi");
		a.add("Koli");
		a.add("QA");
		
		//Extract 
		System.out.println(a.get(0));
//		To remove anything Use remove(index)
//		a.remove(0);
		
		//Iterating the array
		
		for (int i=0;i<a.size();i++)
		{
			System.out.print(i);
			System.out.println(a.get(i));
		}
		System.out.println("Using Enhanced For Loop : ");
		//enhanced for loop
		for(String s:a)
		{
			System.out.println(s);
		}
		//Item present in array -> Contains
		boolean val =  a.contains("Khushi");
		System.out.println(val);
		
		//Convert Normal Array to ArrayList
		String clr[] = {"Black", "Green", "Red", "Blue", "Pink"};
		java.util.List<String> lst = Arrays.asList(clr);
		
		System.out.println(lst.contains("Black"));
		
		
		
	}

}
