package controller;
import entity.payment.Card;

public interface CardCreator {
    public Card createCard(String cardCode, String owner, String dateExpired, int cvvCode);
}