package com.seminar2;

public class DigitalProduct extends Product {

    private double fileSizeMb;
    private String downloadUrl;

    public DigitalProduct(String name, double price, char grade, double fileSizeMb, String downloadUrl) {
        // Digital goods never sell out, so quantity is not tracked: we pass 0 and true to Product.
        super(name, price, 0, true, grade);
        this.fileSizeMb = fileSizeMb;
        this.downloadUrl = downloadUrl;
    }

    public double getFileSizeMb() {
        return fileSizeMb;
    }

    public void setFileSizeMb(double fileSizeMb) {
        if (fileSizeMb <= 0) {
            System.out.println("File size must be positive - file size was not changed.");
            return;
        }
        this.fileSizeMb = fileSizeMb;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public void download() {
        System.out.println("Downloading " + getName() + " (" + fileSizeMb + " MB) from " + downloadUrl);
    }

    public double estimateDownloadSeconds(double speedMbps) {
        if (speedMbps <= 0) {
            System.out.println("Speed must be positive.");
            return 0;
        }
        return fileSizeMb * 8 / speedMbps;
    }

    @Override
    public void deliver() {
        System.out.println("Sending the download link for " + getName() + " by e-mail: " + downloadUrl);
    }

    @Override
    public double calculateDeliveryCost() {
        return 0.0; // nothing to ship
    }
}
