package hedspi.aims.factory;
import java.util.Scanner;
import hedspi.aims.media.*;

public class CDFactory implements AbstractItemFactory{
    public Media createMediaItemFromConsole() {
        CompactDisc disc = new CompactDisc();
        Scanner keybr = new Scanner(System.in);
        System.out.println("Input CD info");
        // ask for artist info
        System.out.printf("> Artist: ");
        disc.setArtist(keybr.next());
        // ask for track info
        boolean next = true;
        do {
            Track newTrack = new Track();
            System.out.printf("-----\n");
            System.out.printf("Track title: ");
            newTrack.setTitle(keybr.next());
            System.out.printf("Track length: ");
            newTrack.setLength(keybr.nextInt());
            System.out.printf("Add another track? [y=1/n=0]: ");
            if(keybr.nextInt() == 0)
                next = false;
        } while(next);
        keybr.close();
        return disc;
    }
}

