package ruxing.demo.test.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ruxing on 06/02/2018.
 */
public class ReentrantLockTest implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();  //加锁 （1.加了此行i=2000000 2.不加此行i是一个<2000000的随机数）
            try {
                i++;
            } finally {
                lock.unlock(); //如果不unlock,且t2.join(),将导致阻塞,lock.lock()换成lock.tryLock()不阻塞
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reenterLockRunnable = new ReentrantLockTest();
        Thread t1 = new Thread(reenterLockRunnable);
        Thread t2 = new Thread(reenterLockRunnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i=" + i);
    }

}
