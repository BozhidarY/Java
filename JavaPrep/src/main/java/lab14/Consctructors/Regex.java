package lab14.Consctructors;

import java.io.Serializable;

public class Regex implements Serializable {
    private int id;
    private String pattern;
    private String description;
    private int rating;

    private static int nextId;

    public Regex(String pattern, String description) {
        this.id = nextId++;
        this.pattern = pattern;
        this.description = description;
        this.rating = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
