public class ForkJoinCompare {
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // System.out.println(fib(45));
        fib(45);
        long end = System.currentTimeMillis();
        System.out.println("It takes " + (end - start) + " msecs to complete FibonacciTaskOld.");
    }
}
