import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

/**
 * Fork / Join
 */
public  class ForkJoin extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 1L;

    private final int n;

    ForkJoin(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            ForkJoin f1 = new ForkJoin(n - 1);
            ForkJoin f2 = new ForkJoin(n - 2);

            f2.fork();
            return f1.compute() + f2.join();
        }
    }
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        System.out.println(pool.invoke(new ForkJoin(45)));
        long end = System.currentTimeMillis();
        System.out.println("It takes " + (end - start) + " msecs to complete FibonacciTaskNew.");
    }
}