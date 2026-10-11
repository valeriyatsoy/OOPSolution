package com.seminar2;

// Shows the notification in the customer's web browser.
public class WebNotification extends Notification {

    private String browser;

    public WebNotification(Customer customer, String message, String browser) {
        super(customer, message);
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

    @Override
    public void send() {
        System.out.println("Browser notification in " + browser + " for "
                + getCustomer().getName() + ": " + getMessage());
    }
}
