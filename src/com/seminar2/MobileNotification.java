package com.seminar2;

import java.time.LocalTime;

// Sends the notification as a push message to the customer's phone.
public class MobileNotification extends Notification {

    // Quiet hours: push messages must not wake the customer up at night.
    private static final LocalTime QUIET_START = LocalTime.of(22, 0);
    private static final LocalTime QUIET_END = LocalTime.of(8, 0);

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

    // Overriding: same signature as in Notification, different behaviour.
    @Override
    public boolean canSendAt(LocalTime time) {
        // Quiet hours cross midnight, so it is "from 22:00 OR before 08:00".
        // With && no time could ever be both after 22:00 and before 08:00.
        boolean quietHours = !time.isBefore(QUIET_START) || time.isBefore(QUIET_END);
        return !quietHours;
    }
}
