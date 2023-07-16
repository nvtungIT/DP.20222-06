package dao.media;

import entity.db.AIMSDB;
import entity.media.Book;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class BookCreator extends MediaCreator {
    
    @Override
    public static Media create(Media m) throws SQLException {
        if (m.getType() != "Book") {
            return null;
        }
        ResultSet res = BookDAO.getInforById(m.getId())
        if (res.next()) {
             // from Media table
            String title = m.getTitle();
            String type = m.getType();
            int price = m.getPrice();
            String category = m.getCategory();
            int quantity = m.getQuantity();

            // from Book table
            String author = res.getString("author");
            String coverType = res.getString("coverType");
            String publisher = res.getString("publisher");
            Date publishDate = res.getDate("publishDate");
            int numOfPages = res.getInt("numOfPages");
            String language = res.getString("language");
            String bookCategory = res.getString("bookCategory");

            return new Book(id, title, category, price, quantity, type,
                author, coverType, publisher, publishDate, numOfPages, language, bookCategory);
        } else {
            throw new SQLException()
        }
    }
}