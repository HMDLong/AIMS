package hedspi.aims.media;
import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private String content;
    private List<String> contentTokens = new ArrayList<>();
    private Map<String, Integer> wordFrequency = new TreeMap<>();

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, ArrayList<String> authors) {
        super(title, category);
        this.authors = authors;
    }

    public Book() {
        super();
    }

    public String printInfo() {
        String str = "";
        for(int i = 0; i < authors.size(); i++) {
            str += authors.get(i);
            str += " ";
        }
        return "Book - " + this.title + " - " + this.category + " - <" + str.strip() + "> - " + this.cost + "$";
    }

    public boolean removeAuthor(String author) {
        if(!authors.contains(author))
            return false;
        authors.remove(author);
        return true;
    }

    public boolean addAuthor(String author) {
        if(authors.contains(author))
            return false;
        authors.add(author);
        return true;
    }

    public void setAuthor(List<String> authors) {
        this.authors = authors;
    }

    public void setContent(String newContent) {
        this.content = newContent;
        processContent();
    }

    private void processContent() {
        //split contents to tokens
        String[] tokens = this.content.split(" ");
        //add to contentTokens and sort
        Collections.addAll(contentTokens, tokens);
        Collections.sort(contentTokens);
        //count frequency
        for(String token : contentTokens)
            if(wordFrequency.containsKey(token)) {
                //get the current frequency
                int freq = wordFrequency.get(token);
                //update new frequency
                wordFrequency.put(token, freq+1);
            }
            else
                wordFrequency.put(token, 1);
    }

    public String toString() {
        String bk = "Title: "+this.title;
        bk += "\nCategory: "+this.category;
        bk += "\nAuthor(s): ";
        for(int i=0;i<authors.size();i++){
            bk += authors.get(i);
            if(i != authors.size() - 1) {bk +=" & ";}
        }
        bk += "\nContent Length: "+this.contentTokens.size();
        bk += "\nContent Frequency: \n";
        for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()) {
            bk += entry.getKey() + " - "+ entry.getValue() + "\n";
        }
        return bk;
    }
}

