package com.seminar2;

public class SoftwareLicense extends DigitalProduct {

    private String licenseKey;
    private int durationMonths;
    private int maxDevices;

    public SoftwareLicense(String name, double price, char grade, double fileSizeMb, String downloadUrl,
                           String licenseKey, int durationMonths, int maxDevices) {
        super(name, price, grade, fileSizeMb, downloadUrl);
        this.licenseKey = licenseKey;
        this.durationMonths = durationMonths;
        this.maxDevices = maxDevices;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public int getMaxDevices() {
        return maxDevices;
    }

    public void setMaxDevices(int maxDevices) {
        this.maxDevices = maxDevices;
    }

    @Override
    public void download() {
        System.out.println("Downloading the installer for " + getName() + " (" + getFileSizeMb() + " MB)");
        System.out.println("License key: " + licenseKey + " - valid for " + durationMonths
                + " months on up to " + maxDevices + " device(s)");
    }
}
