package entity.paymentstrategy;

import entity.payment.PaymentTransaction;
import entity.card.DomesticCard;



public abstract class PaymentByDomesticCard extends PaymentStrategy {
    
    public PaymentByDomesticCard() {
        this.card = new CreditCard();
    }

    public PaymentTransaction pay(double amount, String contents) {
        // ...
        String requestPayload = interbankPayloadConverter.convertToRequestPayload(this.card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
    }
}