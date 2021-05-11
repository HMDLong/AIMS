package hedspi.aims;

import hedspi.aims.factory.*;
import hedspi.aims.media.*;
import hedspi.aims.order.*;
import java.util.*;

public class AIMS {
    private final static List<Media> ListOfProduct = new ArrayList<>();

    private static int id = 0;
    private final static List<Order> orderList = new ArrayList<>();

    private static Scanner keyb; // declare a keyboard inputStream shared for all in AIMS

    private static void makeNewOrder() {
        if(orderList.size() == Order.getOrderLimit()) {
            System.out.printf("Da dat toi da so luong order trong ngay (%d|%d)", Order.getNbOrder(), Order.getOrderLimit());
            return;
        }
        Order newOrder = new Order();
        orderList.add(newOrder);
        System.out.printf("Tao thanh cong order #%d\n", orderList.size());
    }

    public static void addItemToOrder(){
        //TODO
    }

    public static void removeItemFromOrder(){
        //TODO
    }

    public static void showOrder(){
        //TODO
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

        int function;
        do {
            System.out.print("\nChoose a function <0-1-2-3-4>: ");
            function = keyb.nextInt();
            switch(function) {
                case 1: makeNewOrder(); break;
                case 2: addItemToOrder(); break;
                case 3: removeItemFromOrder(); break;
                case 4: showOrder(); break;
                case 0: break;
                default: break;
            }
        } while(function != 0);
    }

    public static void showAdminMenu() {
        System.out.println("Order Management Application");
        System.out.println("----------------------------");
        System.out.println("1. Create new item");
        System.out.println("2. Delete item by id");
        System.out.println("3. Display the items list");
        System.out.println("0. Exit");
        System.out.println("----------------------------");

        int function;
        do {
            System.out.println("\nChoose a function <0-1-2-3>: ");
            function = keyb.nextInt();
            switch(function) {
                case 1: showCreateMenu(); break;
                case 2: showDeleteMenu(); break;
                case 3: showItemList(); break;
                case 0: break;
                default: System.out.println("Invalid function"); break;
            }
        } while(function != 0);
    }

    public static Media createMediaFromConsole(AbstractItemFactory factory) {
        Media newMedia = factory.createMediaItemFromConsole();
        newMedia.setId(id++);
        return newMedia;
    }

    public static void showCreateMenu() {
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
    }

    public static void showDeleteMenu() { //experimental
        System.out.print("\n> Delete item id: ");
        ListOfProduct.removeIf(e -> (e.getId() == keyb.nextInt()));
    }

    public static void showItemList(){
        for(Media item : ListOfProduct){
            item.printInfo();
        }
    }

    public static void main(String[] args) {
        keyb = new Scanner(System.in);
        System.out.println("Who are you <0=customer, 1=admin>");
        int user = keyb.nextInt();
        switch (user) {
            case 0 -> showMenu();
            case 1 -> showAdminMenu();
            default -> System.out.println("Invalid user!");
        }
        keyb.close();
    }
}

