package test.Volatile;

import java.util.Scanner;

public class MainThread { //  это пишущий поток
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()){
            myThread.shutdown();
        }
    }
}

class MyThread extends Thread{ // это читающий поток
    private volatile boolean running = true; // устраняет проблему когерентности кэшей ядер процессора! т.е. теперь
    // переменная не будет кэшироваться в ядрах, а сразу попадет в главную опреативную память и тем самым обеспечит 100%
    // гарантию работоспособности приостановки потока.
    public void run(){
        while (running){
            System.out.println("Hello from the thread");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        this.running=false;
    }
}
