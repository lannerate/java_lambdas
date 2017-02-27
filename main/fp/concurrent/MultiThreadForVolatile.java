package fp.concurrent;

/**
 * Created by hzhang3 on 2/27/2017.
 */
public class MultiThreadForVolatile {

    public static volatile int k = 0;
    public static class plusTask implements Runnable{
        @Override
        public void run() {
            for (int m = 0; m < 1000; m++){
                k++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i =0; i< threads.length; i++){
            threads[i] = new Thread(new plusTask());
            threads[i].start();
        }
        for (Thread thread: threads){
            thread.join();
        }
        // multi-threads volatile is not sure to keep atomic
        System.out.print(k);
    }

}
