package com.seminar2;

import com.seminar2.command.AddItemCommand;
import com.seminar2.command.OrderMenu;
import com.seminar2.command.RemoveItemCommand;
import com.seminar2.customer.Customer;
import com.seminar2.customer.ShippingAddress;
import com.seminar2.exception.InsufficientBalanceException;
import com.seminar2.order.Order;
import com.seminar2.order.OrderNumberGenerator;
import com.seminar2.product.Clothing;
import com.seminar2.product.PhysicalProduct;

import java.util.Scanner;

import static java.lang.System.out;

// A third class with a main method: the customer edits an order by typing in the console.
// Command: this is the CLIENT - it creates the commands and gives them to the menu (the invoker).
public class OrderConsole {
    public static void main(String[] args) {
        ShippingAddress home = new ShippingAddress("12 Amir Temur St", "Tashkent", "100000");
        Customer customer = new Customer("Aziz Karimov", 120, 2500, home);
        PhysicalProduct laptop = new PhysicalProduct("Laptop", 899.99, 10, true, 'A', 2.1, true);
        Clothing jacket = new Clothing("Winter Jacket", 79.5, 40, 'B', 1.2, "M", "Polyester");
        Order order = new Order(OrderNumberGenerator.getInstance().nextOrderId(), customer);

        // Every menu key holds a command. A new option is one more line here.
        OrderMenu menu = new OrderMenu();
        menu.addOption("1", new AddItemCommand(order, laptop, 1));
        menu.addOption("2", new AddItemCommand(order, jacket, 1));
        menu.addOption("3", new RemoveItemCommand(order, laptop));
        menu.addOption("4", new RemoveItemCommand(order, jacket));

        Scanner scanner = new Scanner(System.in);
        boolean editing = true;
        while (editing) {
            out.println();
            out.println("1 - add laptop      2 - add jacket");
            out.println("3 - remove laptop   4 - remove jacket");
            out.println("0 - place the order");
            out.print("Your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                editing = false;
            } else {
                menu.select(choice);           // no if / else for every action
                out.println("Order total: " + order.getTotal());
            }
        }
        scanner.close();

        order.printSummary();
        try {
            order.place();
        } catch (InsufficientBalanceException e) {
            out.println("Order was not placed: " + e.getMessage());
        }
    }
}
