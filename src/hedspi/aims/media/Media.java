package hedspi.aims.media;

public abstract class Media implements Comparable<Media>{
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public Media(String title) {
        this.title = title;
    }

    public Media() {
        super();
    }

    public abstract String printInfo();

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public boolean equals(Object o) {
        if(o instanceof Media)
            return this.id == ((Media)o).getId();
        return false;
    }

    public int compareTo(Media o) {
        return this.title.compareTo(o.getTitle());
    }
}

