package views.screen.payment;

import controller.PaymentController;
import entity.invoice.Invoice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.PopupScreen;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import entity.payment.Card;
import entity.payment.CreditCard;
import entity.payment.DomesticCard;
import entity.paymentStrategy.PaymentStrategy;
import controller.payment.CardCreator;
import controller.payment.CreditCardCreator;

public class PaymentScreenHandler extends BaseScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(PaymentScreenHandler.class.getName());

	@FXML
	private Button btnConfirmPayment;

	@FXML
	private ImageView loadingImage;

	private Invoice invoice;

	@FXML
	private Label pageTitle;

	@FXML
	private TextField cardNumber;

	@FXML
	private TextField holderName;

	@FXML
	private TextField expirationDate;

	@FXML
	private TextField securityCode;

	public PaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath);
		try {
			setupData(invoice);
			setupFunctionality();
		} catch (IOException ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error("Error when loading resources.");
		} catch (Exception ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error(ex.getMessage());
		}
	}

	@Override
	protected void setupData(Object dto) throws Exception {
		this.invoice = (Invoice) dto;
	}
	@Override
	protected void setupFunctionality() throws Exception {
		btnConfirmPayment.setOnMouseClicked(e -> {
			try {
				confirmToPayOrder();
				((PaymentController) getBController()).emptyCart();
			} catch (Exception exp) {
				System.out.println(exp.getStackTrace());
			}
		});
	}

	void confirmToPayOrder() throws IOException{
		String contents = "pay order";
		PaymentController ctrl = (PaymentController) getBController();
		
		// Xử lý để lấy type name của card: Ở đây tạm mặc định type là CreditCard
		CardCreator creditCardCreator = new CreditCardCreator();
		Card creditCard = creditCardCreator.createCard(cardNumber.getText(), holderName.getText(),
				expirationDate.getText(), securityCode.getText());

		Map<String, String> response = ctrl.payOrder(invoice.getAmount(), contents, creditCard);

		BaseScreenHandler resultScreen = new ResultScreenHandler(this.stage, ViewsConfig.RESULT_SCREEN_PATH, response);
		resultScreen.setPreviousScreen(this);
		resultScreen.setHomeScreenHandler(homeScreenHandler);
		resultScreen.setScreenTitle("Result Screen");
		resultScreen.show();
	}

	void confirmToPayOrderUseStrategy() throws IOException{
		String contents = "pay order";
		PaymentController ctrl = (PaymentController) getBController();
		PaymentStrategy paymentStrategy = new PaymentStrategy();
		String choosen = ""
		// Chọn choosen
		
		// Xử lý để lấy type name của card: 
		switch(choosen) {
			case "CreditCard": {
				paymentStrategy = new PaymentByCreditCard();
				card = new CreditCard();
				paymentStrategy.setCard(card)
			}
			case "DomesticCard": {
				paymentStrategy = new PaymentByCreditCard();
				card = new DomesticCard();
				paymentStrategy.setCard(card)
			}
		}
		

		Map<String, String> response = ctrl.pay(invoice.getAmount(), contents, paymentStrategy);

		BaseScreenHandler resultScreen = new ResultScreenHandler(this.stage, ViewsConfig.RESULT_SCREEN_PATH, response);
		resultScreen.setPreviousScreen(this);
		resultScreen.setHomeScreenHandler(homeScreenHandler);
		resultScreen.setScreenTitle("Result Screen");
		resultScreen.show();
	}
}