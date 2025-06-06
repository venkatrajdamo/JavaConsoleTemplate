import Popular.Social;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Social popularityTracker = new Social();
        System.out.println(popularityTracker.mostPopular());
        popularityTracker.increasePopularity(7);
       popularityTracker.increasePopularity(7);
       popularityTracker.increasePopularity(8);
       System.out.println(popularityTracker.mostPopular());        // returns 7
       popularityTracker.increasePopularity(8);
       popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 8
       popularityTracker.decreasePopularity(8);
       popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 7
       popularityTracker.decreasePopularity(7);
       popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);

        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());
    }
}