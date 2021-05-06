package hedspi.aims.media;
import java.util.*;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track>Tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category) {
        super(title, category);
    }

    public CompactDisc() {
        super();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String printInfo() {
        String info = "";
        for(int i = 0; i < this.Tracks.size(); i++) {
            info += i+1;
            info += ". ";
            info += this.Tracks.get(i);
            info += "\n";
        }
        return "<" + this.artist + ">\n" + info;
    }

    public boolean addTrack(Track track) {
        if(this.Tracks.contains(track)) return false;
        this.Tracks.add(track);
        return true;
    }

    public boolean removeTrack(Track track) {
        if(!this.Tracks.contains(track)) return false;
        this.Tracks.remove(track);
        return true;
    }

    public int getDiscLength() {
        int totalLen = 0;
        for(int i = 0; i < this.Tracks.size(); i++)
            totalLen += this.Tracks.get(i).getLength();
        return totalLen;
    }

    public void play() {
        System.out.println(printInfo());
        for(int i = 0; i < this.Tracks.size(); i++)
            this.Tracks.get(i).play();
    }
}

