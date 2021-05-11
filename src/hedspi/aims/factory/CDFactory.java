package hedspi.aims.factory;
import java.util.Scanner;
import hedspi.aims.media.*;

public class CDFactory implements AbstractItemFactory{
    public Media createMediaItemFromConsole() {
        CompactDisc disc = new CompactDisc();
        Scanner keybr = new Scanner(System.in);
        System.out.println("Input CD info");
        // ask for artist info
        System.out.print("> Artist: ");
        disc.setArtist(keybr.next());
        // ask for track info
        boolean next = true;
        do {
            Track newTrack = new Track();
            System.out.print("-----\n");
            System.out.print("Track title: ");
            newTrack.setTitle(keybr.next());
            System.out.print("Track length: ");
            newTrack.setLength(keybr.nextInt());
            System.out.print("Add another track? [y=1/n=0]: ");
            if(keybr.nextInt() == 0)
                next = false;
        } while(next);
        return disc;
    }
}

