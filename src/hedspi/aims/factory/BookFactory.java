package hedspi.aims.factory;
import java.util.*;
import hedspi.aims.media.*;

public class BookFactory implements AbstractItemFactory{
    public Media createMediaItemFromConsole() {
        Scanner keybr = new Scanner(System.in);
        Book newBook = new Book();
        System.out.printf("> The number of authors: ");
        int author_num = keybr.nextInt();
        for(int i = 0; i <= author_num; i++)
            newBook.addAuthor(keybr.nextLine());
        keybr.close();
        return newBook;
    }
}

