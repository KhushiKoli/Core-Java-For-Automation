package oops;

class Parent {
    public void show() {
        System.out.println("Parent method");
    }
}

public class InheritanceExample extends Parent {

    public static void main(String[] args) {
        InheritanceExample obj = new InheritanceExample();
        obj.show();
    }
}
