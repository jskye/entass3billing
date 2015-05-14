package PaymentWebService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;

/**
 * Created by Julius Myszkowski on 14/05/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
@WebService()
public class PaymentWS {

    // service keeps a list of payments
    private ArrayList<Payment> paymentsList = new ArrayList<Payment>();

    // generated
    public static void main(String[] argv) {
        Object implementor = new PaymentWS();
        String address = "http://localhost:8080/PaymentWS";
        Endpoint.publish(address, implementor);
    }

    // client call to make a paypal payment
    @WebMethod
    public String makePPPayment(String paypalId, double amount) {

        PaypalPayment newPPPayment = new PaypalPayment();
        newPPPayment.setPayPalId(paypalId);
        newPPPayment.setPaymentAmount(amount);
        paymentsList.add(newPPPayment);
        String receipt = newPPPayment.printReceipt();
        System.out.println(receipt);
        return receipt;
    }

    // client call to make a credit card payment
    @WebMethod
    public String makeCCPayment(int creditCardNumber, double amount) {
        CreditCardPayment newCCPayment = new CreditCardPayment();
        newCCPayment.setCreditCardNumber(creditCardNumber);
        newCCPayment.setPaymentAmount(amount);
        paymentsList.add(newCCPayment);
        String receipt = newCCPayment.printReceipt();
        System.out.println(receipt);
        return receipt;
    }

    // client call to retrieve the list of payments
    @WebMethod
    public ArrayList<Payment> getPaymentsList(int numPayments) {

        return paymentsList;
    }

}
