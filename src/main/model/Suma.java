package main.model;

import java.util.Observable;

public class Suma extends Observable implements Runnable {
    public static int valor = 0;

    @Override
    public void run() {
        for (int i=1;i<=10018;i++)
            valor++;
        this.setChanged();
        this.notifyObservers(String.valueOf(valor));
    }
}
