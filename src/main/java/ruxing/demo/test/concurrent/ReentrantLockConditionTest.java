package ruxing.demo.test.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ruxing on 06/02/2018.
 */
public class ReentrantLockConditionTest implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    public static Condition condition = lock.newCondition();

    public void run() {
        try {
            System.out.println("Thread is running");
            lock.lock();
            condition.await();  //await()会释放所持有的lock
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockConditionTest conditionRunnable = new ReentrantLockConditionTest();
        Thread t1 = new Thread(conditionRunnable);
        t1.start();
        Thread.sleep(3000);

        lock.lock();
        condition.signal(); //通知t1继续执行
        lock.unlock();  //省略了此行,t1将无法获取lock,造成阻塞
    }

}
