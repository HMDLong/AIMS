package hedspi.aims.media;

public abstract class Disc extends Media{
    protected float length;
    protected String director;

    public Disc(String title, String category) {
        super(title, category);
    }

    public Disc() {
        super();
    }

    public float getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}