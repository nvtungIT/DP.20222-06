package views.screen;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author
 */
// Vi phạm SRP: thực hiện nhiều hơn 2 trách nhiệm (>=2 lý do để thay đổi: 1 là config các màn hình, 2 là việc thay đổi đơn vị tiền tệ
// giải pháp: tách getCurrencyFormat() qua một lớp khác
public class ViewsConfig {

    // static resource
    public static final String IMAGE_PATH = "src/main/resources/assets/images";
    public static final String INVOICE_SCREEN_PATH = "/views/fxml/invoice.fxml";
    public static final String INVOICE_MEDIA_SCREEN_PATH = "/views/fxml/media_invoice.fxml";
    public static final String PAYMENT_SCREEN_PATH = "/views/fxml/payment.fxml";
    public static final String RESULT_SCREEN_PATH = "/views/fxml/result.fxml";
    public static final String LOGIN_SCREEN_PATH = "/views/fxml/login.fxml";
    public static final String INTRO_SCREEN_PATH = "/views/fxml/intro.fxml";
    public static final String CART_SCREEN_PATH = "/views/fxml/cart.fxml";
    public static final String SHIPPING_SCREEN_PATH = "/views/fxml/shipping.fxml";
    public static final String CART_MEDIA_PATH = "/views/fxml/media_cart.fxml";
    public static final String HOME_PATH  = "/views/fxml/home.fxml";
    public static final String HOME_MEDIA_PATH = "/views/fxml/media_home.fxml";
    public static final String POPUP_PATH = "/views/fxml/popup.fxml";

    public static float PERCENT_VAT = 10;

    public static Font REGULAR_FONT = Font.font("Segoe UI", FontWeight.NORMAL, FontPosture.REGULAR, 24);

    public static String getCurrencyFormat(int num) {
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(vietnam);
        return defaultFormat.format(num);
    }
}
