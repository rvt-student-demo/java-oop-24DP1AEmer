package rvt;

import java.util.HashMap;
import java.util.Map;   

public class Warehouse {

    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Warehouse() {
        this.prices = new HashMap<>();
        this.stocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stocks.put(product, stock);
    }

    public int price(String product) {
        if (!this.prices.containsKey(product)) {
            return -99;
        }
        return this.prices.get(product);
    }

    public int stock(String product) {
        if (!this.stocks.containsKey(product)) {
            return 0;
        }
        return this.stocks.get(product);
    }

    public boolean take(String product){
        if (!this.stocks.containsKey(product)){
            return false;
        }
        int current = this.stocks.get(product);
        if (current <= 0) {
            return false;
        }

        this.stocks.put(product, current - 1);
        return true;

    }

public static void main(String[] args) {
Warehouse warehouse = new Warehouse();
warehouse.addProduct("coffee", 5, 1);

System.out.println("stock:");
System.out.println("coffee:  " + warehouse.stock("coffee"));
System.out.println("sugar: " + warehouse.stock("sugar"));

System.out.println("taking coffee " + warehouse.take("coffee"));
System.out.println("taking coffee " + warehouse.take("coffee"));
System.out.println("taking sugar " + warehouse.take("sugar"));

System.out.println("stock:");
System.out.println("coffee:  " + warehouse.stock("coffee"));
System.out.println("sugar: " + warehouse.stock("sugar"));
}
}