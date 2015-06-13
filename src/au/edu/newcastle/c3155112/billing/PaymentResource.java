package au.edu.newcastle.c3155112.billing;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

import java.io.UnsupportedEncodingException;

/**
 * Created by Julius Myszkowski on 12/06/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */

// This class

public interface PaymentResource {
    @Get
    public Payment retrieve() throws UnsupportedEncodingException;

    @Put
    public void store(Payment payment);

    @Delete
    public void remove();
}
