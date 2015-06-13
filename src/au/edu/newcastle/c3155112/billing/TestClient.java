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
        ClientResource cr = new ClientResource("http://localhost:8081/poll_payment");
//                "http://entass3cms.appspot.com/poll_payment");
        // Workaround for GAE servers to prevent chunk encoding
        cr.setRequestEntityBuffering(true);
        cr.accept(MediaType.APPLICATION_JSON);

        PaymentResource resource = cr.wrap(PaymentResource.class);

        // Get the remote payment
        Payment payment = null;
        try {
            payment = resource.retrieve();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (payment != null) {
            System.out.println("id: " + payment.getId());
            System.out.println("type: " + payment.getType());
            System.out.println("amount: " + payment.getAmount());
        }

        // Update the contact
        payment.setAmount(0.0);
        resource.store(payment);
    }
}
