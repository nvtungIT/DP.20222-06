package controller;

// import java.util.Calendar;
// import java.util.Hashtable;
import java.util.Map;

import entity.cart.Cart;


/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 * 
 * @author hieud
 *
 */
public abstract class PaymentController extends BaseController {

	/**
	 * Pay order, and then return the result with a message.
	 * 
	 * @return {@link Map Map} represent the payment result with a
	 *         message.
	 */
	public abstract Map<String, String> payOrder() {

	// Vi phạm OCP: Phương thức payOrder chỉ dành cho Credit Card, sau này có thêm các hình thức thanh toán khác như qua Môm, ZaloPay... nữa thì phải thay đổi trực tiếp mã nguồn
	// Vi phạm DIP: phụ thuộc trực tiếp vào concrete class CreditCard, sau này khi có thêm phương thức thanh toán qua Momo, ZaloPay... thì phải thay đổi
	public Map<String, String> payOrder(int amount, String contents, String cardNumber, String cardHolderName,
			String expirationDate, String securityCode) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {
			this.card = new CreditCard(
					cardNumber,
					cardHolderName,
					getExpirationDate(expirationDate),
					Integer.parseInt(securityCode));

			this.interbank = new InterbankSubsystem();
			PaymentTransaction transaction = interbank.payOrder(card, amount, contents);

			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "You have successfully paid the order!");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
		return result;
	}

	public void emptyCart(){
        SessionInformation.cartInstance.emptyCart();
    }
}