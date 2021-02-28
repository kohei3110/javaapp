import java.util.stream.IntStream;

/**
 * ParallelStream
 * 並列プログラミングである点に注意
 */
public class ParallelStreamSample {
    public static void main(String... args) {
        IntStream.range(1, 10).boxed()
            .parallel()
            .map(x -> "task : " + x)
            .forEach(System.out::println);
    }
}