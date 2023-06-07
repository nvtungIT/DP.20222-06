package dao.user;

import entity.db.AIMSDB;
import entity.media.Book;
import entity.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author
 */
public class UserDAO {

    public User authenticate(String email, String encryptedPassword) throws SQLException {
        String sql = "SELECT * FROM User " +
                "where email = '" + email + "' and encrypted_password = '" + encryptedPassword + "'";
        ResultSet res =  AIMSDB.getConnection().createStatement().executeQuery(sql);
        if(res.next()) {
            // return new User(
            //         res.getInt("id"),
            //         res.getString("name"),
            //         res.getString("email"),
            //         res.getString("address"),
            //         res.getString("phone")
            // );
            User user = User.getInstance();
            user.setId(res.getInt("id"));
            user.setName(res.getString("name"));
            user.setAddress(res.getString("address"));
            user.setEmail(res.getString("email"));
            user.setPhone(res.getString("phone"));
            return user;
        } else {
            throw new SQLException();
        }
    }
}
