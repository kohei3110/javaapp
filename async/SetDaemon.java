import java.util.concurrent.*;

public class SetDaemon implements Runnable, ThreadFactory {
    final int num;
    public SetDaemon(int n) {
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
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
    public static void main(String[] args) {
        Thread t = new Thread(new SetDaemon(10));
        t.setDaemon(true);
        t.start();
        ExecutorService s = Executors.newSingleThreadExecutor(new SetDaemon(0));
        s.submit(new SetDaemon(20));
        try {
            Thread.sleep(3000);
        } catch(Exception ignore) {
        }
        System.out.println("end of main():" + Thread.currentThread().getName());
    }
}