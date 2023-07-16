package subsystem.interbank;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(CreditCard card, int amount, String contents) {
		return null;
	}

    // Vi phạm OCP: Phương thức payOrder chỉ dành cho Credit Card, sau này có thêm các hình thức thanh toán khác như qua Môm, ZaloPay... nữa thì phải thay đổi trực tiếp mã nguồn
	// Vi phạm DIP: phụ thuộc trực tiếp vào concrete class CreditCard, sau này khi có thêm phương thức thanh toán qua Momo, ZaloPay... thì phải thay đổi
	public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
