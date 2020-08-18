package study.stock_system;

import study.stock_system.Buyer;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        if (argumentChecking(args)) {
            int numberOfBuyers = Integer.parseInt(args[0]);
            Stock stock = new Stock();
            CyclicBarrier barrier = new CyclicBarrier(numberOfBuyers);
            for (int i = 0; i < numberOfBuyers; i++) {
                new Thread(new Buyer(stock, barrier, i)).start();
            }

        }
    }


    static boolean argumentChecking(String[] args) {
        if (args.length != 1) {
            System.out.println("Неверное количество аргументов. \nАргумент должен содержать количество покупателей.");
            return false;
        }

        try {
            Integer.parseInt(args[0]);
            return true;
        } catch (Exception e) {
            System.out.println("Аргумент не является числом.");
            return false;
        }
    }
}


