package entity.paymentstrategy;

import entity.payment.PaymentTransaction;
import entity.card.CreditCard;



public abstract class PaymentByCreditCard extends PaymentStrategy {
    
    public PaymentByCreditCard() {
        this.card = new CreditCard();
    }

    public PaymentTransaction pay(double amount, String contents) {
        String requestPayload = interbankPayloadConverter.convertToRequestPayload(this.card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
    }
}