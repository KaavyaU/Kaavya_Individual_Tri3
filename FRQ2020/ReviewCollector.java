package FRQ2020;

import java.util.ArrayList;

public class ReviewCollector {
    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;

    /** Constructs a ReviewCollector object and initializes the instance variables. */
    public ReviewCollector() {
        reviewList = new ArrayList<ProductReview>();
        productList = new ArrayList<String>();
    }

    public void addReview(ProductReview prodReview){
        reviewList.add(prodReview);
        String prodName = prodReview.getName();
        if (productList.indexOf(prodName) == -1){
            productList.add(prodName);
        }
    }

    public int getNumGoodReviews(String prodName){
        int goodReviews = 0;
        for (int x = 0; x < productList.size(); x++){
            if (productList.get(x).equals(prodName)){
                if (reviewList.get(x).getReview().indexOf("best") != -1){
                    goodReviews++;
                }
            }
        }
        System.out.println(goodReviews + " good reviews for " + prodName);
        return goodReviews;
    }

    public static void main (String [] args){
        ReviewCollector reviews = new ReviewCollector();
        ProductReview prod1 = new ProductReview("Apple", "best fruit ever");
        reviews.addReview(prod1);
        ProductReview prod2 = new ProductReview("Apple", "worst fruit ever");
        reviews.addReview(prod2);
        ProductReview prod3 = new ProductReview("Apple", "abestos");
        reviews.addReview(prod3);
        ProductReview prod4 = new ProductReview("Mango", "mangoes are my favorite");
        reviews.addReview(prod4);
        //should return 2 good reviews
        reviews.getNumGoodReviews("Apple");
    }
}
