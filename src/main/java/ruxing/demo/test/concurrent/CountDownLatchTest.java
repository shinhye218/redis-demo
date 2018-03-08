package ruxing.demo.test.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ruxing on 07/02/2018.
 */
public class CountDownLatchTest implements Runnable {

    static final CountDownLatch end = new CountDownLatch(10);

    static final CountDownLatchTest test = new CountDownLatchTest();

    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("check complete");
            end.countDown(); //计数减1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(test);
        }

        //等待
        end.await();

        System.out.println("Fire!");
        executorService.shutdown();
    }

}
