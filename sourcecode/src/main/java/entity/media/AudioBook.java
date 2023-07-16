package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import entity.db.AIMSDB;

public class AudioBook extends Media {

    String author;
    String format;
    String language;
    String accent;
    int lengthInMinutes;
    

    public AudioBook() throws SQLException{

    }

    public AudioBook(int id, String title, String category, int price, int quantity, String type, String author,
            String format, String language, String accent,int lengthInMinutes) throws SQLException{
        super(id, title, category, price, quantity, type);
        this.author = author;
        this.format = format;
        this.language = language;
        this.accent = accent;
        this.lengthInMinutes = lengthInMinutes;
    }

    // getter and setter
    public int getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getFormat() {
        return this.format;
    }

    public Book setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getAccent() {
        return this.accent;
    }

    public Book setAccent(String accent) {
        this.accent = accent;
        return this;
    }

    public String getLanguage() {
        return this.language;
    }

    public Book setLanguage(String language) {
        this.language = language;
        return this;
    }


    @Override
    public String toString() {
        String basicInformation = "{" +
                " id='" + id + "'" +
                ", title='" + title + "'" +
                ", category='" + category + "'" +
                ", price='" + price + "'" +
                ", quantity='" + quantity + "'" +
                ", type='" + type + "'" +
                ", imageURL='" + imageURL + "'" +
                "}";
        return "{" +
            basicInformation +
            " author='" + author + "'" +
            ", coverType='" + coverType + "'" +
            ", publisher='" + publisher + "'" +
            ", publishDate='" + publishDate + "'" +
            ", numOfPages='" + numOfPages + "'" +
            ", language='" + language + "'" +
            ", bookCategory='" + bookCategory + "'" +
            "}";
    }
}
