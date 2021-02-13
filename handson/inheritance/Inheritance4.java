abstract class Parent {
    public String fieldA = "fieldA";

    public abstract String methodA();
}

class Child extends Parent {
    public String fieldB = "fieldB";

    @Override
    public String methodA(){
        return "methodA in Child";
    }

    public String methodB(){
        return "methodB";
    }
}

public class Inheritance4 {

    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(parent.fieldA); // field A
        System.out.println(parent.methodA()); // method A in Child
    }
}