package controller;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

import common.exception.InvalidCardException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.cart.Cart;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;


/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 * 
 * @author hieud
 *
 */
public class PaymentController extends BaseController {

	/**
	 * Represent the card used for payment
	 */
	private CreditCard card;

	/**
	 * Represent the Interbank subsystem
	 */
	private InterbankInterface interbank;

	/**
	 * Validate the input date which should be in the format "mm/yy", and then
	 * return a {@link String String} representing the date in the
	 * required format "mmyy" .
	 * 
	 * @param date - the {@link String String} represents the input date
	 * @return {@link String String} - date representation of the required
	 *         format
	 * @throws InvalidCardException - if the string does not represent a valid date
	 *                              in the expected format
	 */
	private String getExpirationDate(String date) throws InvalidCardException {
		String[] strs = date.split("/");
		if (strs.length != 2) {
			throw new InvalidCardException();
		}

		String expirationDate = null;
		int month = -1;
		int year = -1;

		try {
			month = Integer.parseInt(strs[0]);
			year = Integer.parseInt(strs[1]);
			if (month < 1 || month > 12 || year < Calendar.getInstance().get(Calendar.YEAR) % 100 || year > 100) {
				throw new InvalidCardException();
			}
			expirationDate = strs[0] + strs[1];

		} catch (Exception ex) {
			throw new InvalidCardException();
		}

		return expirationDate;
	}

	/**
	 * Pay order, and then return the result with a message.
	 * 
	 * @param amount         - the amount to pay
	 * @param contents       - the transaction contents
	 * @param cardNumber     - the card number
	 * @param cardHolderName - the card holder name
	 * @param expirationDate - the expiration date in the format "mm/yy"
	 * @param securityCode   - the cvv/cvc code of the credit card
	 * @return {@link Map Map} represent the payment result with a
	 *         message.
	 */
<<<<<<< HEAD

	// Vi phạm OCP: Phương thức payOrder chỉ dành cho Credit Card, sau này có thêm các hình thức thanh toán khác như qua Môm, ZaloPay... nữa thì phải thay đổi trực tiếp mã nguồn
	// Vi phạm DIP: phụ thuộc trực tiếp vào concrete class CreditCard, sau này khi có thêm phương thức thanh toán qua Momo, ZaloPay... thì phải thay đổi
=======
	// Vi phạm OCP: Phương thức payOrder chỉ dành cho Credit Card, sau này có thêm các hình thức thanh toán khác nữa thì phải thay đổi trực tiếp mã nguồn
>>>>>>> 9fba62a0e431fd716b2792b6ad58e0de456c828d
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