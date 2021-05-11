package hedspi.aims.factory;
import java.util.*;
import hedspi.aims.media.*;

public class DVDFactory implements AbstractItemFactory{
    public Media createMediaItemFromConsole() {
        DigitalVideoDisc newDVD = new DigitalVideoDisc();
        Scanner keybr = new Scanner(System.in);
        System.out.println("Nhap title: ");
        newDVD.setTitle(keybr.nextLine());
        System.out.println("Nhap director: ");
        newDVD.setDirector(keybr.nextLine());
        System.out.println("Nhap category: ");
        newDVD.setCategory(keybr.nextLine());
        System.out.println("Nhap length: ");
        newDVD.setLength(keybr.nextInt());
        System.out.println("Nhap cost: ");
        newDVD.setCost(keybr.nextFloat());
        return newDVD;
    }
}
