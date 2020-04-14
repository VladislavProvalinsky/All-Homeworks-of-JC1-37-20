package test.Threads;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("I'm sleeping...");
        Thread.sleep(3000);
        System.out.println("I'm awake!");

        MyThread myThread = new MyThread();
        myThread.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();

        Thread thread = new Thread(new Runner());
        thread.start();
        System.out.println("Hello from the ThreadMain");
    }
}

class Runner implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Hello from the thread - " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Hello from the thread - " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
