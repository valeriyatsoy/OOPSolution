package com.seminar2;

public class Clothing extends PhysicalProduct {

    private String size;
    private String material;

    public Clothing(String name, double price, int quantity, char grade,
                    double weightKg, String size, String material) {
        // clothes are not fragile, and inStock can be worked out from the quantity
        super(name, price, quantity, quantity > 0, grade, weightKg, false);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    // overrides PhysicalProduct.getPackagingNote()
    @Override
    public String getPackagingNote() {
        return "Folded in a plastic bag";
    }

    // overrides Product.calculateDeliveryCost(): a flat rate that replaces
    // (instead of extending) the PhysicalProduct formula
    @Override
    public double calculateDeliveryCost() {
        return 3.0;
    }

    // overrides Product.deliver()
    @Override
    public void deliver() {
        System.out.println("Posting " + getName() + " (size " + size + ", " + material + ")");
        System.out.println("Packaging: " + getPackagingNote());
    }
}
