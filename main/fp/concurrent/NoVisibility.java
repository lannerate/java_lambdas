package fp.concurrent;

/**
 * Created by hzhang3 on 2/27/2017.
 */
public class NoVisibility {
    public static int number;
    public static volatile boolean ready;

    public static class ReaderThread extends Thread{

        @Override
        public void run() {
            while(!ready)
                System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReaderThread readerThread = new ReaderThread();
        readerThread.start();
        Thread.sleep(1000);
        number = 40;
        ready = true;
        Thread.sleep(1000);
    }
}
