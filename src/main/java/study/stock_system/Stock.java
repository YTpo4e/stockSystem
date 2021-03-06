package study.stock_system;

public class Stock {
    private int goods = 1000;

    synchronized int buyGoods(int purchasedGoods) {
        if (goods >= purchasedGoods) {
            goods -= purchasedGoods;
            return purchasedGoods;
        } else {
            purchasedGoods = goods;
            goods = 0;
            return purchasedGoods;
        }
    }

    public int getGoods() {
        return goods;
    }
}
