package controller;

import java.sql.SQLException;
import java.util.List;

import dao.media.MediaDAO;

/**
 * This class controls the flow of events in homescreen
 * @author nguyenlm
 */
public class HomeController extends BaseController {


    /**
     * this method gets all Media in DB and return back to home to display
     * @return List[Media]
     * @throws SQLException
     */
    public static List getAllMedia() throws SQLException{
        return new MediaDAO().getAllMedia();
    }


    public static Media getMediaById(int id) throws SQLException {
        Media mediaP = MediaDAO.getMediaById(id);
        try {
            if (mediaP != null) {
                String mediaType = mediaP.getType();
                Class mCreatorClass = Class.forName(mediaType + "Creator");
                Constructor constructor = mCreatorClass.getConstructor();
                MediaCreator mCreator = mCreatorClass.newInstace();
                return mCreator.create(mediaP);
            } else {
                return null;
            }
        } catch (ClassNotFoundException e) {
            // Xử lý nếu không tìm thấy class
            throw new ClassNotFoundException(e);
        } catch (NoSuchMethodException e) {
            // Xử lý nếu không tìm thấy Constructor
            throw new NoSuchMethodException(e);
        } catch (InstantiationException e) {
            // Xử lý nếu không thể tạo instance
            throw new InstantiationException(e);
        } catch (IllegalAccessException e) {
            // Xử lý nếu không có quyền truy cập
            throw new IllegalAccessException(e);
        } catch (InvocationTargetException e) {
            // Xử lý nếu có lỗi trong quá trình tạo instance
        } catch (SQLException) {
            throw new SQLException();
        }

    }
}
