package au.edu.newcastle.c3155112.billing;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Julius Myszkowski on 13/06/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
@WebListener
public class StartPoller implements ServletContextListener{

        //constructor
        public StartPoller(){}

         // thread that will poll the GAE frontend app for restful payment details
        private Thread pollerThread = null;

        public void contextInitialized(ServletContextEvent sce) {
            System.out.println("Payment Poller Thread started");
            if((pollerThread == null ) || (!pollerThread.isAlive())) {
                pollerThread = new Thread(new Poller());
                pollerThread.start();
            }
        }

        // if the context is destroyed then stop the thread.
        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            try {
                pollerThread.interrupt();
            }
            catch (Exception e) {
            }
            System.out.println("stopped poller thread");
        }
    }
