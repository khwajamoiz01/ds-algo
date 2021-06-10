package javapractice;

import java.util.concurrent.*;

//https://www.javacodemonk.com/implement-custom-thread-pool-in-java-without-executor-framework-ca10e61d
public class CustomThreadPoolDemo {
    public static void main(String[] args) {
        final int nThreads = 5;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Executors.newFixedThreadPool(5);
    }
}

class CustomThreadPool {

    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] workerThreads;

    static class WorkerThread extends Thread {
        private final String name;
        private final BlockingQueue<Runnable> taskQueue;

        WorkerThread(String name, BlockingQueue<Runnable> taskQueue) {
            this.name = name;
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    taskQueue.take().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    CustomThreadPool(final int numOfThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {
            workerThreads[i] = new WorkerThread("Worker-Thread-" + (i + 1), taskQueue);
            workerThreads[i].start();
        }
    }
    public void submit(Runnable task) {
        if (task == null)
            throw new NullPointerException();
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
