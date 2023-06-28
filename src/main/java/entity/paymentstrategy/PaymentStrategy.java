package entity.paymentstrategy;

import entity.payment.PaymentTransaction;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

public class PaymentStrategy {
    protected Card card;
    protected InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	protected InterbankBoundary interbankBoundary = new InterbankBoundary();

    public abstract PaymentTransaction pay(double amount);

    public void setCard(Card card) {
        this.card = card;
    }

}