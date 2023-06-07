package controller;

// import java.util.Calendar;
// import java.util.Hashtable;
import java.util.Map;

import entity.cart.Cart;


/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 * 
 * @author hieud
 *
 */
public abstract class PaymentController extends BaseController {

	/**
	 * Pay order, and then return the result with a message.
	 * 
	 * @return {@link Map Map} represent the payment result with a
	 *         message.
	 */
	public abstract Map<String, String> payOrder() {
	}

	public void emptyCart(){
        SessionInformation.cartInstance.emptyCart();
    }
}