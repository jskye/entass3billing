package au.edu.newcastle.c3155112.billing;

/**
 * Created by Julius Myszkowski on 14/05/2015.
 * Subject: ${subjectCode} - ${subjectTitle}
 * University of Newcastle
 * Student Number: c3155112
 * email: c3155112@uon.edu.au, julius.skye@gmail.com
 */
public class Payment {


    private String id;
    private String type;
    private Double amount;

    // constr
    public Payment() {
    }


    // getters/setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString()
    {
        return "type="+type+"&id="+id+"&amount="+String.valueOf(amount);
    }
}