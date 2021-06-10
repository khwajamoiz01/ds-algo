package javapractice.concurrency;

import java.util.Random;
import java.util.concurrent.*;

public class ExecutorInterfaces {
    static class MyRunnable implements Runnable {
        private final int offset;
        private final int lastValue;

        MyRunnable(int offset, int lastValue) {
            this.offset = offset;
            this.lastValue = lastValue;
        }

        @Override
        public void run() {
            long sum = 0;
            for (int i = offset; i <= lastValue; i = i + 3) {
                sum += i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);
        }
    }

    public void tryExecutorService() throws ExecutionException, InterruptedException {
        System.out.println("tryExecutorService started");
        ExecutorService es = Executors.newFixedThreadPool(2);
        //Submits a Runnable task for execution and returns a Future representing that task.
        // The Future's get method will return null upon successful completion.
        final Future<?> submit = es.submit(new MyRunnable(1, 10));
        final Future<?> submit1 = es.submit(new MyRunnable(2, 10));
        final Future<?> submit2 = es.submit(new MyRunnable(3, 10));
        System.out.println(submit.get() + " " + submit1.get() + " " + submit2.get());
        //Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be acceptedes.shutdown();
    }

    public void tryScheduledExecutorService() throws ExecutionException, InterruptedException {
        System.out.println("tryScheduledExecutorService started");
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        final ScheduledFuture<Double> schedule = ses.schedule(Math::random, 1000, TimeUnit.MILLISECONDS);
        System.out.println(schedule.get());

        ScheduledFuture<?> scheduleWithFixedDelay = ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Math.random());
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
        scheduleWithFixedDelay.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorInterfaces ei = new ExecutorInterfaces();
        ei.tryExecutorService();

        ei.tryScheduledExecutorService();

    }
}