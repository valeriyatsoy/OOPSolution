package com.seminar2;

public class PhysicalProduct extends Product {

    private double weightKg;
    private boolean fragile;

    public PhysicalProduct(String name, double price, int quantity, boolean inStock, char grade,
                           double weightKg, boolean fragile) {
        super(name, price, quantity, inStock, grade);
        this.weightKg = weightKg;
        this.fragile = fragile;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        if (weightKg <= 0) {
            System.out.println("Weight must be positive - weight was not changed.");
            return;
        }
        this.weightKg = weightKg;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public boolean isHeavy() {
        return weightKg > 20;
    }

    // name, price and quantity are private in Product, so we work with them
    // through the inherited public getters and setters.
    public void reduceStock(int amount) {
        if (amount > getQuantity()) {
            System.out.println("Not enough stock - stock was not changed.");
            return;
        }
        setQuantity(getQuantity() - amount);
        // inStock is a public field in Product, so it is directly accessible here.
        inStock = getQuantity() > 0;
    }

    public String getPackagingNote() {
        return fragile ? "Bubble wrap inside a sturdy box" : "Standard cardboard box";
    }

    @Override
    public void deliver() {
        System.out.println("Shipping " + getName() + " (" + weightKg + " kg) by courier.");
        System.out.println("Packaging: " + getPackagingNote());
        if (isHeavy()) {
            System.out.println("Heavy item - a two-person delivery team is required.");
        }
    }

    @Override
    public double calculateDeliveryCost() {
        double cost = 5.0 + 1.5 * weightKg;
        if (fragile) {
            cost += 4.0;
        }
        return roundToTwoDecimals(cost);
    }
}
