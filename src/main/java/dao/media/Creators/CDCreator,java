package dao.media;

import entity.db.AIMSDB;
import entity.media.CD;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class CDCreator extends MediaCreator {
    
    @Override
    public static Media create(Media m) throws SQLException {
        if (m.getType() != "CD") {
            return null;
        }
        ResultSet res = CDDAO.getInforById(m.getId())
        if (res.next()) {
             // from Media table
            String title = m.getTitle();
            String type = m.getType();
            int price = m.getPrice();
            String category = m.getCategory();
            int quantity = m.getQuantity();

            // from CD table
            String artist = res.getString("artist");
            String recordLabel = res.getString("recordLabel");
            String musicType = res.getString("musicType");
            Date releasedDate = res.getDate("releasedDate");

            return new CD(id, title, category, price, quantity, type,
                artist, recordLabel, musicType, releasedDate);
        } else {
            throw new SQLException()
        }
    }
}