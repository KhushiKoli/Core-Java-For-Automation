package basics;

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   int[] numbers = {10,20,30,40,50};
		   
	        //Printing first and last element of array
	        System.out.println("First Element is " + numbers[0]);
	        System.out.println("Last Element is " + numbers[4]);
	        int count=0;
	        
	        //Reverse Order
	        System.out.println("Reverse Order : ");
	        for(int i=4;i>=0;i--)
	        {
	            System.out.println(numbers[i]);
	            count++;
	        }
	        //printing count of array
	        System.out.println(count + " Number of elements present in the array");
	}

}
