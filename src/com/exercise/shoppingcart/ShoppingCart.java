package com.exercise.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> productList = new ArrayList<>();
    private IOffer offer;
    private double totalCartValue;

    public int getProductCount() {
        return productList.size();
    }

    public void addProduct(Product product) {
        //implement
    }

    public double getTotalCartValue() {
        //implement
        return totalCartValue;
    }

    public Product getProductByName(String name) {
        if (productList.size() > 0) {
            productList.stream().filter(product -> product.getName().equals(name)).findFirst().get();
        }
        return null;
    }

    public void setOffer(IOffer offer) {
        this.offer = offer;
    }

}
