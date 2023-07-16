package dao.media;

import entity.db.AIMSDB;
import entity.media.DVD;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DVDCreator extends MediaCreator {
    
    @Override
    public static Media create(Media m) throws SQLException {
        if (m.getType() != "DVD") {
            return null;
        }
        ResultSet res = DVDDAO.getInforById(m.getId())
        if (res.next()) {
             // from Media table
            String title = m.getTitle();
            String type = m.getType();
            int price = m.getPrice();
            String category = m.getCategory();
            int quantity = m.getQuantity();

            // from DVD table
            String discType = res.getString("discType");
            String director = res.getString("director");
            int runtime = res.getInt("runtime");
            String studio = res.getString("studio");
            String subtitles = res.getString("subtitle");
            Date releasedDate = res.getDate("releasedDate");
            String filmType = res.getString("filmType");

            return new DVD(id, title, category, price, quantity, type, discType, director,
                runtime, studio, subtitles, releasedDate, filmType);
        } else {
            throw new SQLException()
        }
    }
}