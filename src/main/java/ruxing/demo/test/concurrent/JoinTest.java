package ruxing.demo.test.concurrent;

/**
 * Created by ruxing on 06/02/2018.
 */
public class JoinTest {

    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i=0 ; i<10000000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join(); //主线程会等待addThread执行完毕 （1.加了此行i=10000000 2.不加此行i=0）
        System.out.println("i: " + i);
    }

}
