import java.util.concurrent.*;

public class NoSetDaemon implements Runnable {
    final int num;
    public NoSetDaemon(int n) {
        this.num = n;
    }
    @Override
    public void run() {
        int c = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + ":" + this.num + ":" + c);
            c++;
            try {
                Thread.sleep(1000);
            } catch(Exception ignore) {
            }
        }
    }
    public static void main(String[] args) {
        (new Thread(new NoSetDaemon(10))).start();
        ExecutorService s = Executors.newSingleThreadExecutor();
        s.submit(new NoSetDaemon(20));
        try {
            Thread.sleep(3000);
        } catch(Exception ignore) {
        }
        System.out.println("end of main():" + Thread.currentThread().getName());
    }
}