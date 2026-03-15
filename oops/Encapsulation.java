package oops;

// Encapsulation: hide internal data, expose controlled access via getters/setters
public class Encapsulation {

    // private = only accessible within this class
    private String name;
    private int    age;
    private double salary;

    public Encapsulation(String name, int age, double salary) {
        this.name   = name;
        setAge(age);       // use setter for validation
        setSalary(salary);
    }

    // Getter - read-only access
    public String getName()   { return name; }
    public int    getAge()    { return age; }
    public double getSalary() { return salary; }

    // Setter with validation
    public void setAge(int age) {
        if (age > 0 && age < 120)
            this.age = age;
        else
            System.out.println("Invalid age: " + age);
    }

    public void setSalary(double salary) {
        if (salary >= 0)
            this.salary = salary;
        else
            System.out.println("Salary cannot be negative");
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
    }

    public static void main(String[] args) {
        Encapsulation emp = new Encapsulation("Alice", 28, 50000);

        System.out.println(emp.getName());    // Alice
        System.out.println(emp.getAge());     // 28
        System.out.println(emp.getSalary());  // 50000.0

        emp.setAge(-5);       // Invalid age: -5  (blocked)
        emp.setSalary(60000); // valid update
        System.out.println(emp.getSalary());  // 60000.0

        // emp.age = 100;  // ❌ Compile error - field is private
    }
}
