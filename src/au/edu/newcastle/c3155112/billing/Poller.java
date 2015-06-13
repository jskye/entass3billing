package au.edu.newcastle.c3155112.billing;

import org.restlet.resource.ClientResource;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
* Created by Julius Myszkowski on 13/06/2015.
* Subject: ${subjectCode} - ${subjectTitle}
* University of Newcastle
* Student Number: c3155112
* email: c3155112@uon.edu.au, julius.skye@gmail.com
*/

public class Poller implements Runnable {

    // a scheduler so we can schedule when the poller will start.
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    // get client resource from server
    private ClientResource clientRes = new ClientResource("http://localhost:8081/poll_payment");

    public void start() {
        run();
    }

    // method to run REST call to get the resource
    @Override
    public void run() {
        //poll
        Payment payment = clientRes.get(Payment.class);
        //check if null
        if(payment != null)
        {
            System.out.println(payment);
        }
        //schedule
        scheduler.schedule(this, 1, TimeUnit.SECONDS);
    }
}