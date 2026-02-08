package oops;

public class DemoClass1 extends DemoClass2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Method can not create inside main block
		
		DemoClass1 d = new DemoClass1();  //To access our own method have to create an object then access method

		String name = d.getData();

		System.out.println(name);

		DemoClass2 d1 = new DemoClass2();

		d1.getUserData();
		d.getUserData();   //Inheriting DataClass2 having the method and access by DataClass object

		getData2();     //Access method in same class without creation of object if it is static method.
	}

	public String getData()
	{
		System.out.println("hello world");

		return "Khushi Koli - Data1";
	}

	public static String getData2()
	{

		System.out.println("hello world");

		return "Khushi Koli - Data2";
	}

}
