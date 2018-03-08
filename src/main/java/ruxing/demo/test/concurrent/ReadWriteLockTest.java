package ruxing.demo.test.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ruxing on 08/02/2018.
 */
public class ReadWriteLockTest {

    private static Lock lock = new ReentrantLock();

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = readWriteLock.readLock();

    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000); //读操作的耗时越多,读写锁的优势就越明显
            System.out.println("read...");
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
            System.out.println("write...");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockTest test = new ReadWriteLockTest();

        Runnable readRunable = new Runnable() {
            public void run() {
                try {
                    test.handleRead(readLock);  //读写锁只要2秒多,下一行的普通重入锁要20多秒
//                    test.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunable = new Runnable() {
            public void run() {
                try {
                    test.handleWrite(readLock, new Random().nextInt());
//                    test.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i <18; i++) {
            new Thread(readRunable).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(writeRunable).start();
        }

    }

}
