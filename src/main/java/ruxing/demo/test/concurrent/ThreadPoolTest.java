package ruxing.demo.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ruxing on 08/02/2018.
 */
public class ThreadPoolTest {

    public static class MyTask implements Runnable {
        public void run() {
            System.out.println(System.currentTimeMillis() + ": Thread ID: " + Thread.currentThread().getId());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
    }

}
