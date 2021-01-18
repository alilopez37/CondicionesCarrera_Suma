package main.model;

import java.util.Observable;
import java.util.concurrent.Semaphore;

public class Suma extends Observable implements Runnable {
    public static int valor = 0;
    private static Semaphore mutex = new Semaphore(1);

    @Override
    public void run() {

            for (int i=1;i<=10018;i++) {
                try {
                    mutex.acquire();
                    valor++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    mutex.release();
                }
            }

        this.setChanged();
        this.notifyObservers(String.valueOf(valor));
    }
}
