package javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolDemo {
    static class MyRecursiveAction extends RecursiveAction {
        private final int workload;

        MyRecursiveAction(int workload) {
            this.workload = workload;
        }

        @Override
        protected void compute() {
            if (workload <= 16) {
                System.out.println("Processing workload : " + workload);
                return;
            }
            new MyRecursiveAction(this.workload / 2).fork();
            new MyRecursiveAction(this.workload - (this.workload / 2)).fork();
        }
    }

    static class MyRecursiveTask extends RecursiveTask<Long> {
        private final int start;
        private final int end;

        MyRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start + 1 <= 10000) {
                long sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            }
            int mid = (start + end) / 2;
            //Method invoke() is semantically equivalent to fork(); join() but always attempts to begin execution in the current thread.
            //Approach#1
            ForkJoinTask<Long> left = new MyRecursiveTask(start, mid).fork();
            ForkJoinTask<Long> right = new MyRecursiveTask(mid + 1, end).fork();
            return left.join() + right.join();
            //Approach#2
            //return new MyRecursiveTask(start, mid).invoke() + new MyRecursiveTask(mid + 1, end).invoke();
        }
    }

    //TODO join vs get
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();//new ForkJoinPool(4);
        forkJoinPool.invoke(new MyRecursiveAction(64));

        int num = Integer.MAX_VALUE / 2;
        System.out.println("Number is: " + num);

        long t1 = System.currentTimeMillis();
        Long sum = forkJoinPool.invoke(new MyRecursiveTask(1, num));//you can also just invoke/fork a RTask which will use commonPool to get executed
        System.out.println("MyRecursiveTask sum: " + sum + ", time taken: " + (System.currentTimeMillis() - t1));
        forkJoinPool.shutdown();

        long t2 = System.currentTimeMillis();
        System.out.println("SingleThread sum:    " + getSum(num) + ", time taken: " + (System.currentTimeMillis() - t2));
    }

    private static Long getSum(int num) {
        long sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
    void test() {
        List<String> l = new ArrayList<>();
        l.listIterator();
    }
}
