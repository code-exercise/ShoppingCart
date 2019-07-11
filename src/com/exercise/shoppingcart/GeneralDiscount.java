package com.exercise.shoppingcart;

public class GeneralDiscount implements IOffer {

    private double discountPercentage;

    public GeneralDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void applyOffer(Product product) {
        product.setTotalPrice(product.getTotalPrice() - (product.getTotalPrice() * (discountPercentage / 100.0)));
    }

}
