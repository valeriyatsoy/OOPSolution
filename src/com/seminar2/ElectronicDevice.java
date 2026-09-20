package com.seminar2;

public class ElectronicDevice extends PhysicalProduct {

    private String brand;
    private int warrantyMonths;

    public ElectronicDevice(String name, double price, int quantity, char grade,
                            double weightKg, String brand, int warrantyMonths) {
        // electronics are always fragile, and inStock can be worked out from the quantity
        super(name, price, quantity, quantity > 0, grade, weightKg, true);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    // overrides PhysicalProduct.getPackagingNote()
    @Override
    public String getPackagingNote() {
        return "Anti-static bag inside a padded box - keep dry";
    }

    // overrides Product.calculateDeliveryCost() (as already overridden in PhysicalProduct)
    @Override
    public double calculateDeliveryCost() {
        // keep the PhysicalProduct formula and add a flat insurance fee
        return roundToTwoDecimals(super.calculateDeliveryCost() + 2.5);
    }

    // overrides Product.deliver()
    @Override
    public void deliver() {
        System.out.println("Insured courier shipment: " + brand + " " + getName()
                + " (" + warrantyMonths + " months warranty included)");
        System.out.println("Packaging: " + getPackagingNote());
    }
}
