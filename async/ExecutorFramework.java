import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Executor Framework
 */
public class ExecutorFramework {
    public static void main(String... args) throws Exception {
        ExecutorService es = Executors.newWorkStealingPool(2);
        try {
            es.execute(() -> System.out.println("Executor : 1, ThreadID : " + String.valueOf(Thread.currentThread().getId())));
            es.execute(() -> System.out.println("Executor : 2, ThreadID : " + String.valueOf(Thread.currentThread().getId())));
            es.execute(() -> System.out.println("Executor : 3, ThreadID : " + String.valueOf(Thread.currentThread().getId())));
            es.execute(() -> System.out.println("Executor : 4, ThreadID : " + String.valueOf(Thread.currentThread().getId())));
            es.execute(() -> System.out.println("Executor : 5, ThreadID : " + String.valueOf(Thread.currentThread().getId())));
            es.execute(() -> System.out.println("Executor : 6, ThreadID : " + String.valueOf(Thread.currentThread().getId())));
            es.execute(() -> System.out.println("Executor : 7, ThreadID : " + String.valueOf(Thread.currentThread().getId())));
            es.execute(() -> System.out.println("Executor : 8, ThreadID : " + String.valueOf(Thread.currentThread().getId())));
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            es.shutdown();
            es.awaitTermination(100, TimeUnit.SECONDS);
        }
    }
}
