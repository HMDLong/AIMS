package hedspi.aims;

import hedspi.aims.factory.*;
import hedspi.aims.media.*;
import hedspi.aims.order.*;
import java.util.*;

public class AIMS {
    private static List<Media> ListOfProduct = new ArrayList<>();

    private static int currentOrder = 0;
    private static List<Order> orderList = new ArrayList<>();

    private static void changeCurOrder(int order_index) {
        if(order_index > orderList.size()) {
            System.out.printf("Khong ton tai Order #%d\n", order_index);
            return;
        }
        currentOrder = order_index-1;
    }

    private static void whichOrderIsThis() {
        System.out.printf("Day la order #%d (/%d)\n", currentOrder+1, orderList.size());
    }

    private static void makeNewOrder() {
        if(orderList.size() == Order.getOrderLimit()) {
            System.out.printf("Da dat toi da so luong order trong ngay (%d|%d)", Order.getNbOrder(), Order.getOrderLimit());
            return;
        }
        Order newOrder = new Order();
        orderList.add(newOrder);
        System.out.printf("Tao thanh cong order #%d\n", orderList.size());
        changeCurOrder(orderList.size());
    }

    public static void showMenu() {
        System.out.println("Order Management Application");
        System.out.println("----------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.print("----------------------------");

        Scanner keyb = new Scanner(System.in);
        int function;
        do {
            System.out.print("\nChoose a function <0-1-2-3-4>: ");
            function = keyb.nextInt();
            switch(function) {
                case 0: makeNewOrder(); break;
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                default: break;
            }
        } while(function != 0);
        keyb.close();
    }

    public static void showAdminMenu() {
        System.out.println("Order Management Application");
        System.out.println("----------------------------");
        System.out.println("1. Create new item");
        System.out.println("2. Delete item by id");
        System.out.println("3. Display the items list");
        System.out.println("0. Exit");
        System.out.println("----------------------------");

        Scanner keyb = new Scanner(System.in);
        int function;
        do {
            System.out.println("\nChoose a function <0-1-2-3>: ");
            function = keyb.nextInt();
            switch(function) {
                case 1: showCreateMenu(); break;
                case 2: showDeleteMenu(); break;
                case 3: break;
                case 0: break;
                default: System.out.println("Invalid function"); break;
            }
        } while(function != 0);
        keyb.close();
    }

    public static void showCreateMenu() {
        Scanner keyb = new Scanner(System.in);
        System.out.println("""

                1. Book
                2. DVD
                3. CD
                > What do you want to create? :\s""");
        int choice = keyb.nextInt();
        switch (choice) {
            case 1 -> ListOfProduct.add(createMediaFromConsole(new BookFactory()));
            case 2 -> ListOfProduct.add(createMediaFromConsole(new DVDFactory()));
            case 3 -> ListOfProduct.add(createMediaFromConsole(new CDFactory()));
            default -> System.out.println("Invalid item to create");
        }
        keyb.close();
    }

    public static Media createMediaFromConsole(AbstractItemFactory factory) {
        return factory.createMediaItemFromConsole();
    }

    public static void showDeleteMenu() { //experimental
        Scanner keyb = new Scanner(System.in);
        System.out.print("\n> Delete item id: ");
        ListOfProduct.removeIf(e -> (e.getId() == keyb.nextInt()));
        keyb.close();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Who are you <0=customer, 1=admin>");
        int user = keyboard.nextInt();
        switch (user) {
            case 0 -> showMenu();
            case 1 -> showAdminMenu();
            default -> {
                System.out.println("Invalid user!");
                keyboard.close();
            }
        }
    }
}

