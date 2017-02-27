package fp.concurrent;

/**
 * Created by hzhang3 on 2/27/2017.
 */
public class ThreadGroupName implements Runnable{

    @Override
    public void run() {
        String tgn = Thread.currentThread().getThreadGroup().getName() + " - " + Thread.currentThread().getName();
        while(true){
            System.out.println("Current thread: " + tgn);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ThreadGroup tg = new ThreadGroup("printGroup");
        Thread t1 = new Thread(tg, new ThreadGroupName(),"t1");
        Thread t2 = new Thread(tg, new ThreadGroupName(),"t2");
        t1.start();t2.start();
        System.out.println(tg.activeCount());
        tg.list();
    }
}
