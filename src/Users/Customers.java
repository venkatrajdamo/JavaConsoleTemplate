package Users;

import Cost.Plan;
import Products.Product;
import Subscription.Subscription;

import java.util.Date;

public class Customers {
    private String Id;
    private String OrgName;
    private Subscription subscription;

    public Customers(String id, String orgName) {
        Id = id;
        OrgName = orgName;
    }

    public void subscribe(Plan plan, Product product, Date start){
        this.subscription = new Subscription(plan, product, start);
    }

    public void getCost(){
        System.out.println(this.subscription.getMonthlyCostEstimation());
        System.out.println(this.subscription.getYearlyCostEstimation());
    }
}
