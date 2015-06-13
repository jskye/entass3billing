package au.edu.newcastle.c3155112.billing;

/**
 * Created by Julius Myszkowski on 13/06/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */

import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;

import java.io.UnsupportedEncodingException;

public class TestClient implements Runnable{

    @Override
    public void run() {
        // Initialize the resource proxy.
        ClientResource clientRes = new ClientResource("http://localhost:8081/poll_payment");
//                "http://entass3cms.appspot.com/poll_payment");
        // Workaround for GAE servers to prevent chunk encoding
//        cr.setRequestEntityBuffering(true);
        clientRes.accept(MediaType.APPLICATION_JSON);

        // Get the remote payment
//        JacksonRepresentation<Payment> payment = clientRes.get(Payment.class);
        Payment payment = clientRes.get(Payment.class);
        PaymentResource resource = clientRes.wrap(PaymentResource.class);

        try {
            payment = resource.retrieve();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (payment != null) {
            System.out.println(payment.toString());
            System.out.println("id: " + payment.getId());
            System.out.println("type: " + payment.getType());
            System.out.println("amount: " + payment.getAmount());
            // Update the payment
            payment.setAmount(0.0);
            resource.store(payment);
        }
        System.out.println("Payment null");

    }
}
