package Payments;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by Julius Myszkowski on 14/05/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
@WebService()
public class PaymentWS {

    public static void main(String[] argv) {
        Object implementor = new PaymentWS();
        String address = "http://localhost:8081/PaymentWS";
        Endpoint.publish(address, implementor);
    }

    @WebMethod
    public String makePPPayment(String paypalId, double amount) {

        PaypalPayment newPPPayment = new PaypalPayment();
        newPPPayment.setPayPalId(paypalId);
        newPPPayment.setPaymentAmount(amount);
        String receipt = newPPPayment.printReceipt();
        System.out.println(receipt);
        return receipt;
    }

    @WebMethod
    public String makeCCPayment(int creditCardNumber, double amount) {
        CreditCardPayment newCCPayment = new CreditCardPayment();
        newCCPayment.setCreditCardNumber(creditCardNumber);
        newCCPayment.setPaymentAmount(amount);
        String receipt = newCCPayment.printReceipt();
        System.out.println(receipt);
        return receipt;
    }

}
