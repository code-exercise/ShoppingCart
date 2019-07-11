package com.exercise.shoppingcart;

public class DiscountOnNextItemOffer implements IOffer {

    private double discountPercentage;

    public DiscountOnNextItemOffer(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void applyOffer(Product product) {
      //implement
    }

}
