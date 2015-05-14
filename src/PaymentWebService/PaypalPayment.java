package PaymentWebService;

import java.io.Serializable;

/**
 * Created by Julius Myszkowski on 14/05/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
public class PaypalPayment extends Payment implements Serializable{

    private String payPalId;

    public PaypalPayment(){}

    public String getPayPalId() {
        return payPalId;
    }

    public void setPayPalId(String payPalId) {
        this.payPalId = payPalId;
    }

    public String printReceipt(){
        String receipt = "Payment received: " + "\n"
                + "Method: Paypal - " + payPalId + "\n"
                + "Amount: " + super.getPaymentAmount() + "\n";
        return receipt;
    }

}
