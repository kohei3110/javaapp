public class SimpleThread {
    public static void main(String... args) {
        System.out.println("This is the main thread.");
        for (int i = 0; i < 10000; i++) {
            Runnable runnable = new MyRunnable();
            new Thread(runnable).start();
        }
    }
}

class MyRunnable implements Runnable {
    
    @Override
    public void run() {
        // Do something
        System.out.print("hey");
    }
}