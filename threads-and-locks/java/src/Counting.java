public class Counting {
    public static void main(String[] args) throws InterruptedException{
       class Counter {
           private int count = 0;

           // every thread can access, so it cause data race ->
           // public void increment() {++count;}
           // with synchronized the execution is locked by a intrinsic lock aka mutex
           public synchronized void increment() {++count;}

           public int getCount() {return count;}
       }
           final Counter counter = new Counter();
           class CountingThread extends Thread {
               @Override
               public void run() {
                   for (int x = 0; x < 10000; x++) {
                       counter.increment();
                   }
               }
           }
           CountingThread t1 = new CountingThread();
           CountingThread t2 = new CountingThread();
           t1.start(); t2.start();
           t1.join(); t2.join();
           System.out.println(counter.getCount());
    }
}
