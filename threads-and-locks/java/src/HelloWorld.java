public class HelloWorld{
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(() -> System.out.println("Hello from new thread"));

       myThread.start();
       Thread.yield();
//       Thread.sleep(1);
       System.out.println("Hello from main thread");
       myThread.join();

    }
}
