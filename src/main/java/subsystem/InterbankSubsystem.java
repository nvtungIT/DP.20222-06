package subsystem;

import entity.payment.CreditCard;
import entity.payment.Card;
import entity.payment.PaymentTransaction;
import subsystem.interbank.InterbankSubsystemController;
import entity.paymentStrategy.PaymentStrategy;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 * 
 * @author hieud
 *
 */
public class InterbankSubsystem implements InterbankInterface {

	/**
	 * Represent the payment strategy
	 */
	private PaymentStrategy paymentStrategy;

	/**
	 * Represent the controller of the subsystem
	 */
	private InterbankSubsystemController ctrl;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	public InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
		this.paymentStrategy = new PaymentStrategy();
	}

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	/**
	 * @see InterbankInterface#payOrder(CreditCard, int,
	 *      String)
	 */
	// Vi phạm OCP: Phương thức payOrder chỉ dành cho Credit Card, sau này có thêm các hình thức thanh toán khác như qua Môm, ZaloPay... nữa thì phải thay đổi trực tiếp mã nguồn
	// Vi phạm DIP: phụ thuộc trực tiếp vào concrete class CreditCard, sau này khi có thêm phương thức thanh toán qua Momo, ZaloPay... thì phải thay đổi
	public PaymentTransaction payOrder(Card card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(card, amount, contents);
		return transaction;
	}

	// strategy
	public PaymentTransaction pay(int amount, String contents) {
		PaymentTransaction transaction = paymentStrategy.pay(amount, contents)
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction refund(Card card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(card, amount, contents);
		return transaction;
	}
}
