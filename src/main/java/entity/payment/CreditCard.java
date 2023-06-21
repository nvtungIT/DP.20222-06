package entity.payment;

/**
 * @author
 */
public class CreditCard extends Card {

    public CreditCard() {
        super();
    }

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        super(cardCode, owner, dateExpired, cvvCode);
    }
}
