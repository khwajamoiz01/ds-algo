package interview;

import java.util.concurrent.*;

public class IT2 {
    public static void main(String[] args) {
        IT2 it = new IT2();
        System.out.println(it.sumToN(3));
        System.out.println(it.sumToN(4));
        System.out.println(it.sumToN(5));
        System.out.println(it.sumToN(6));
        System.out.println(it.sumToN(7));
        System.out.println(it.sumToN(100000));
        //System.out.println(it.sumToN(Integer.MAX_VALUE));
    }

    static class MyCallable implements Callable<Long> {
        private final int offset;
        private final int lastValue;

        MyCallable(int offset, int lastValue) {
            this.offset = offset;
            this.lastValue = lastValue;
        }

        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (int i = offset; i <= lastValue; i = i + 3) {
                sum += i;
            }
            return sum;
        }
    }

    private long sumToN(int n) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Long> future1 = executorService.submit(new MyCallable(1, n));
        Future<Long> future2 = executorService.submit(new MyCallable(2, n));
        Future<Long> future3 = executorService.submit(new MyCallable(3, n));
        try {
            return future1.get() + future2.get() + future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        return -1;
    }
}
