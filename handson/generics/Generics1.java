import java.util.List;
import java.util.ArrayList;

class Generics1 {
    public static void main(String... args){
        List<Integer> intList = new ArrayList<>();
        List<Number> numList = new ArrayList<>();
        List<Number> anotherList = new ArrayList<>();
        numList = anotherList;
//        numList = intList;  // Compile Error
    }
}