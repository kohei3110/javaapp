import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureSample {
    public static void main(String... args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(3);

        // Simple async task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "heavy process", es);
        Thread.sleep(1);
        System.out.println(future.get());

        // 合成
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "task1", es);
        CompletableFuture<String> f2 = f1.thenApply((x) -> x + " & task2");
        System.out.println(f2.get());

        // List に詰めたパターン
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final int n = i;
            futures.add(CompletableFuture.runAsync(() -> System.out.println("task : " + n + " & " + Thread.currentThread().getName()), es));
        }

        // 一括処理
        CompletableFuture<Void> cfs = CompletableFuture.allOf(futures.toArray(new CompletableFuture[]{}));
        cfs.get();

        System.out.println("mainメソッドの終了");
    }
}
