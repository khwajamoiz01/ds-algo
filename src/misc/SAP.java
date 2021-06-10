package misc;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class SAP {
    public volatile boolean pr = true;
    public volatile boolean co = false;

    //offer, add, put, put()
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);
        new SAP().pc();
    }

    void pc() {
        Queue<Integer> queue = new ArrayDeque<>(10);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                while (true) {
                    if (pr) {
                        System.out.println("produced message: " + i);
                        queue.offer(i);
                        pr = false;
                        co = true;
                        break;
                    }
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                if (co) {
                    System.out.println("consumed message : " + queue.poll());
                    pr = true;
                    co = false;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }

    private void produce(Queue<Integer> queue, int i) {

    }

    //multiple - 3 -> fizz,
    // 5 -> buzz, both -> fizzbuzz
    //7 -> fuzz 11 -> bizz
    void test(int n) {
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "fizz");
        map.put(5, "buzz");
        map.put(7, "fuzz");
        map.put(11, "bizz");


        for (int i = 0; i < n; i++) {
            Result res = multiples(i);
            StringBuilder sb = new StringBuilder();
            if (res.is3)
                sb.append(map.get(3));
            if (res.is5)
                sb.append(map.get(5));
            if (res.is7)
                sb.append(map.get(7));
            if (res.is11)
                sb.append(map.get(11));
            String sbres = sb.toString();
            System.out.println(sbres.equals("") ? i : sbres);
        }
    }

    private Result multiples(int i) {
        Result res = new Result();
        if (i % 3 == 0)
            res.is3 = true;
        if (i % 5 == 0)
            res.is5 = true;
        if (i % 7 == 0)
            res.is7 = true;
        if (i % 11 == 0)
            res.is11 = true;
        return res;
    }

    static class Result {
        boolean is3;
        boolean is5;
        boolean is7;
        boolean is11;
    }
}
