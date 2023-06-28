package entity.payment;

/**
 * @author
 */
public class DomesticCard extends Card {

    private String type;
    private String issuingBank;
    private String validateFromDate;
    // private int cardNumber;
    // private String cardHolderName; 
    public DomesticCard() {
        super();
    }

    public DomesticCard(String cardCode, String owner, String dateExpired, int cvvCode, String type, String issuingBank, String validateFromDate) {
        super(cardCode, owner, dateExpired, cvvCode);
        this.type = type;
        this.issuingBank = issuingBank;
        this.validateFromDate = validateFromDate;
    }
}
