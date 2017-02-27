package fp.concurrent;

/**
 * Created by hzhang3 on 2/27/2017.
 */
public class JoinThread {
    public volatile static int i = 0;
    public static class AddThread extends Thread {

        @Override
        public void run() {
            for( i = 0; i< 10000; i++);
//            yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
//        addThread.join();
//        addThread.join(1);
//        addThread.wait(0);
        System.out.println(i);
    }

}
