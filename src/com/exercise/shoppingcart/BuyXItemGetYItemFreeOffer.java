package com.exercise.shoppingcart;

public class BuyXItemGetYItemFreeOffer implements IOffer {

    private int XItem;
    private int YItem;

    public BuyXItemGetYItemFreeOffer(int xItem, int yItem) {
        XItem = xItem;
        YItem = yItem;
    }

    @Override
    public void applyOffer(Product product) {
        
    }

}
