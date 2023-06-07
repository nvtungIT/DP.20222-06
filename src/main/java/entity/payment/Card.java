package entity.payment;

/**
 * @author
 */
public abstract class Card {

    protected String cardCode;
    protected String owner;
    protected String dateExpired;
    protected int cvvCode;

    public Card(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}
