package javapractice;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    static class Value implements Delayed {
        private final String data;
        private final long expiryTimeInSecs;

        Value(String data, long expiryTimeInSecs) {
            this.data = data;
            this.expiryTimeInSecs = expiryTimeInSecs;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return expiryTimeInSecs - System.currentTimeMillis() / 1000;
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.SECONDS) - o.getDelay(TimeUnit.SECONDS));
        }

        @Override
        public String toString() {
            return "Value{" +
                    "data='" + data + '\'' +
                    ", expiryTime=" + expiryTimeInSecs +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Value> delayQueue = new DelayQueue<>();
        long currentTimeInSecs = System.currentTimeMillis() / 1000;
        delayQueue.offer(new Value("Khwaja", currentTimeInSecs + 10));
        delayQueue.offer(new Value("Vasim", currentTimeInSecs + 12));
        delayQueue.offer(new Value("Tanya", currentTimeInSecs + 14));
        delayQueue.offer(new Value("Ayush", currentTimeInSecs + 16));

        for (int i = 0; i < 4; i++) {
            System.out.println(delayQueue.poll(60, TimeUnit.SECONDS));
        }
    }
}
