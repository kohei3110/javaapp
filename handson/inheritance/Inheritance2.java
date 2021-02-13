class Parent {
    public String fieldA = "fieldA";

    public String methodA(){
        return "methodA";
    }
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

public class Inheritance2 {

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.fieldA); // field A
        System.out.println(child.fieldB); // field B
        System.out.println(child.methodA()); // method A in Child
        System.out.println(child.methodB()); // method B
    }
}