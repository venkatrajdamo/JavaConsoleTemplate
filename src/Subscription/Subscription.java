package Subscription;

import Cost.Plan;
import Products.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Subscription {
    private Plan plan;
    private Product product;
    private Date start;

    public Subscription(Plan plan, Product product, Date start) {
        this.plan = plan;
        this.product = product;
        this.start = start;
    }

    private int getRemainingMonth(){
        if(this.start.getYear() + 1900 == LocalDate.now().getYear()){
            return 12 - this.start.getMonth();
        }
        return 12;

    }

    public List<Double> getMonthlyCostEstimation(){
        List<Double> cost = new ArrayList<>();
        double monthCost = this.plan.getPricing();
        int rem = this.getRemainingMonth();
        for(int i = 0; i< 12-rem;i++){
            cost.add(0.0);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.start);

        int remDay = 31 - calendar.get(Calendar.DAY_OF_MONTH);
        cost.add(remDay * (monthCost /31));

        for(int i = 0; i< rem-1;i++){
            cost.add(monthCost);
        }
        return cost;
    }


    public double getYearlyCostEstimation(){
        double cost = 0;
        for(Double c : getMonthlyCostEstimation()){
            cost += c;
        }
        return cost;
    }

}
