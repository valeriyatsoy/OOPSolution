package com.seminar2;

// Sends the notification as a push message to the customer's phone.
public class MobileNotification extends Notification {

    private String deviceName;

    public MobileNotification(Customer customer, String message, String deviceName) {
        super(customer, message);
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    @Override
    public void send() {
        System.out.println("Push notification to " + getCustomer().getName()
                + "'s " + deviceName + ": " + getMessage());
    }
}
