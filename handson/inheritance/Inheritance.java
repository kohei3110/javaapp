class Parent {
    public String fieldA = "fieldA";

    public String methodA(){
        return "methodA";
    }
}

class Child extends Parent {
    public String fieldB = "fieldB";

    public String methodB(){
        return "methodB";
    }
}

public class Inheritance {

    public static void main(String[] args){
        Child child = new Child();
        System.out.println(child.fieldA);  // fieldA
        System.out.println(child.fieldB);  // fieldB
        System.out.println(child.methodA());  // methodA
        System.out.println(child.methodB());  // methodB
    }
}