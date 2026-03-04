package rvt;

import java.util.ArrayList;

public class Box implements Packable {
    private ArrayList<Packable> packables;
    private double capacity;

    public Box(double capacity) {
        this.capacity = capacity;
        this.packables = new ArrayList<>();
    }

    public void add(Packable packable) {
        if (this.weight() + packable.weight() < capacity) {
            this.packables.add(packable);
        }
    }


    public double weight() {
        double totalWeight = 0;
        for (Packable item : this.packables) {
            totalWeight = totalWeight + item.weight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Box: " + this.packables.size() + " items, " + "total weight " +     
    this.weight() + " kg";
    }


}