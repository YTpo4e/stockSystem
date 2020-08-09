package study.stock_system;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Buyer implements Runnable {
    private int purchasedProducts = 0;
    private int numberBuyer;
    private final Stock stock;
    private int transitCount = 0;
    private final CyclicBarrier barrier;

    Buyer(Stock stock, CyclicBarrier barrier, int numberBuyer) {
        this.numberBuyer = numberBuyer;
        this.barrier = barrier;
        this.stock = stock;
    }

    @Override
    public void run() {
        while (stock.getGoods() > 0) {
            transitCount++;
            purchasedProducts += stock.buyGoods((int) (Math.random() * 10) + 1);
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {

            }

        }

        if (stock.getGoods() == 0) {
            barrier.reset();
        }

        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Покупатель номер " + numberBuyer + " купил товаров: " + purchasedProducts + ". Количество покупок: " +
                transitCount;
    }
}
