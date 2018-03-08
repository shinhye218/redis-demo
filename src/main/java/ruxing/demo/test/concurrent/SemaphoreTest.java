package ruxing.demo.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by ruxing on 07/02/2018.
 */
public class SemaphoreTest implements Runnable {

    final Semaphore semaphore = new Semaphore(5);

    public void run() {
        try {
            boolean result = semaphore.tryAcquire(); //缓存acquire()时:5个线程一组单位执行
            Thread.sleep(2000);
            System.out.println("result:" + result);
            System.out.println(Thread.currentThread().getId() + ":done!");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreTest semaphoreTest = new SemaphoreTest();
        for (int i = 0; i < 20; i++) {
            executorService.submit(semaphoreTest);
        }
    }

}
