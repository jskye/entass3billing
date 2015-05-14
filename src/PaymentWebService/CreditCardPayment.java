package PaymentWebService;

import java.io.Serializable;

/**
 * Created by Julius Myszkowski on 14/05/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
public class CreditCardPayment extends Payment implements Serializable{

    private int creditCardNumber;

    public CreditCardPayment(){}

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String printReceipt(){
        String receipt = "Payment received: " + "\n"
                + "Method: Paypal - " + creditCardNumber + "\n"
                + "Amount: " + super.getPaymentAmount() + "\n";
        return receipt;
    }

}
