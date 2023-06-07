package controller;
import entity.payment.CreditCard;

public class CreditCardCreator implements CardCreator {
    @Override
    public Card createCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        return new CreditCard(cardCode, owner, dateExpired, cvvCode, bank);
    }
}