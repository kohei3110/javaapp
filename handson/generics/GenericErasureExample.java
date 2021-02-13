import java.util.ArrayList;
import java.util.List;

class Foo<E> {
    private List<E> values = new ArrayList<>();

    public void add(E value) {
        values.add(value);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}

public class GenericErasureExample {

    public static void main(String... args) {
        Foo<String> foo1 = new Foo<>();
        Foo<Integer> foo2 = new Foo<>();
        Foo fooRaw = new Foo();

        foo2.add(1234);
        ((Foo<String>)((Foo)foo2)).add("abcd"); // 大丈夫!?!?
        System.out.println(foo2); // [1234, abcd]と表示する
    }
}