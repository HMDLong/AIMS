package hedspi.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public Track() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public void play() {
        System.out.println("Playing: " + this.title);
    }

    public boolean equals(Object o) {
        if(o instanceof Track)
            return this.title == ((Track)o).getTitle() && this.length == ((Track)o).getLength();
        return false;
    }
}

