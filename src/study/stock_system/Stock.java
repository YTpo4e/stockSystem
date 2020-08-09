package study.stock_system;

public class Stock {
    private int goods = 1000;

    synchronized int buyGoods(int goods) {
        if (this.goods >= goods) {
            this.goods -= goods;
            return goods;
        } else {
            goods = this.goods;
            goods = 0;
            return goods;
        }
    }

    public int getGoods() {
        return goods;
    }
}
