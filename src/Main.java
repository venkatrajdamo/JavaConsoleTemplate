/*
* Customer
* Id
* Org
*
* Pricing based on tiers
*
*
*
* Specific Product
*
* */

import Cost.BasicPlan;
import Cost.Plan;
import Cost.PremiunPlan;
import Products.JiraProduct;
import Users.Customers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "31-Dec-2025";
        Date date = formatter.parse(dateInString);

        Customers c1 = new Customers("t1", "test1");
        c1.subscribe(new BasicPlan(), new JiraProduct(), new Date());
        c1.getCost();
        Customers c2 = new Customers("t2", "test2");
        c2.subscribe(new BasicPlan(), new JiraProduct(), date);
        c2.getCost();
    }
}