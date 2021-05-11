package hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title, String director, String category, int length, float cost) {
        super(title, category);
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }

    public DigitalVideoDisc() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLength(int len) {
        this.length = len;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String printInfo() {
        return "DVD - " + this.title + " - " + this.category + " - " + this.director +
                " - " + this.length + " - " + this.cost + "$";
    }

    public boolean isTitleContain(String title) {
        String[] tokenList = title.toLowerCase().split(" ");
        for (String s : tokenList) {
            if (!this.title.toLowerCase().contains(s)) {
                return false;
            }
        }
        return true;
    }

    public void play() {
        System.out.println("Playing: " + this.getTitle());
        System.out.println("Length: " + this.getLength());
    }
}
