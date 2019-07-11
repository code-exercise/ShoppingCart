package com.test.shoppingcart;

import org.junit.Assert;
import org.junit.Test;

import com.exercise.shoppingcart.BuyXItemGetYItemFreeOffer;
import com.exercise.shoppingcart.DiscountOnNextItemOffer;
import com.exercise.shoppingcart.GeneralDiscount;
import com.exercise.shoppingcart.IOffer;
import com.exercise.shoppingcart.NoOffer;
import com.exercise.shoppingcart.Product;
import com.exercise.shoppingcart.ShoppingCart;

public class ShoppingCartTest {

    @Test
    public void testCreateEmptyShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        Assert.assertEquals(0, cart.getProductCount());
    }

    @Test
    public void testAddSingleProductToShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Gatsby hair cream", 1, 30.0);
        cart.addProduct(product);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(30.0, cart.getTotalCartValue(), 0.0);
    }

    /**
     *  Requirement: We should be able to add different products to shopping cart.
     * 	    When:
     * 		    – Add 1 unit of ‘Gatsby hair cream’, unit price 30 Rupees.
     * 			– Add 1 unit of ‘Bvlgiri Soap’, unit price 100 Rupees.
     * 		Then:
     * 			– The product count of the cart should be 2.
     * 			– The total value of cart should be 130 rupees.
     */
    @Test
    public void addDifferentProductsToTheCart() {
        ShoppingCart cart = new ShoppingCart();
        Product gatsByCream = new Product("Gatsby hair cream", 1, 30.0);
        Product bvlgiriSoap = new Product("Bvlgiri Soap", 1, 100.0);
        cart.addProduct(gatsByCream);
        cart.addProduct(bvlgiriSoap);
        Assert.assertEquals(2, cart.getProductCount());
        Assert.assertEquals(130.0, cart.getTotalCartValue(), 0.0);
    }

    /**
     * Requirement: Add Products and apply offer to shopping cart
     * 			When:
     * 				- Add 5 unit of ‘Gatsby hair cream’, unit price 30 Rupees.
     * 			Then:
     * 				– The product count of cart should be 1.
     * 				– The total value of cart should be 120 rupees.
     */
    @Test
    public void testAddMultipleQuantityOfAProductAndApplyOfferToCart() {
        IOffer offer = new BuyXItemGetYItemFreeOffer(2, 1);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product product = new Product("Gatsby hair cream", 5, 150.0);
        cart.addProduct(product);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(120.0, cart.getTotalCartValue(), 0.0);
    }

    /**
     * Requirement: Add different Products and apply offer to shopping cart
     * 			When:
     * 				– Add 3 unit of ‘Gatsby hair cream’, unit price 30 Rupees.
     * 				– Add 2 unit of ‘Bvlgiri Soap’, unit price 100 Rupees.
     * 			Then:
     * 				– The product count of the cart should be 2.
     * 				– The total value of cart should be 260.0 rupees.
     */
    @Test
    public void addDifferentProductsAndAppyOfferToTheCart() {
        IOffer offer = new BuyXItemGetYItemFreeOffer(2, 1);
        ShoppingCart cart = new ShoppingCart();
        Product gatsByCream = new Product("Gatsby hair cream", 3, 90.0);
        Product bvlgiriSoap = new Product("Bvlgiri Soap", 2, 200.0);
        cart.setOffer(offer);
        cart.addProduct(gatsByCream);
        cart.setOffer(new NoOffer());// No offer for the Soap
        cart.addProduct(bvlgiriSoap);
        Assert.assertEquals(2, cart.getProductCount());
        Assert.assertEquals(260.0, cart.getTotalCartValue(), 0.0);
    }

    /**
     * Requirement: Apply discount on shopping cart
     * 		When: Add 2 unit of ‘Gatsby hair cream’, unit price 30 Rupees.
     * 	Then:
     * 		– The product count of cart should be 1.
     * 		– The total price of product should be 45.
     * 		– The total value of cart should be 45.0 rupees.
     */
    @Test
    public void testApplyBuyOneGetFiftyPercentDiscountOnNextOfferToTheCart() {
        IOffer offer = new DiscountOnNextItemOffer(50.0);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product gatsByCream = new Product("Gatsby hair cream", 2, 60.0);
        cart.addProduct(gatsByCream);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(45.0, cart.getProductByName("Gatsby hair cream").getTotalPrice(), 0.0);
        Assert.assertEquals(45.0, cart.getTotalCartValue(), 0.0);
    }


    /**
     * Requirement: Apply discount on shopping cart
     * 		When:
     * 		- Add 4 unit of ‘Bvlgiri Perfume’, unit price 100 Rupees.
     * 		- Add 5 unit of 'Axe Deo', unit price 30 Rupees.
     *
     * 	Then:
     * 		– The product count of cart should be 2.
     * 		– The total price of Bvlgiri Perfumes should be 320.0.
     * 		– The total price of Axe Deo should be 120.0.
     * 		– The total value of cart should be 440.0 rupees.
     */
    @Test
    public void testApplyGeneralDiscountOnCart() {
        ShoppingCart cart = new ShoppingCart();
        Product doveSoap = new Product("Dove Soap", 5, 150.0);
        Product axeDeo = new Product("Axe Deo", 4, 400.0);
        double totalPrice = doveSoap.getTotalPrice() + axeDeo.getTotalPrice();
        if (totalPrice > 500) {
            IOffer offer = new GeneralDiscount(20.0);
            cart.setOffer(offer);
        }
        cart.addProduct(doveSoap);
        cart.addProduct(axeDeo);
        Assert.assertEquals(2, cart.getProductCount());
        Assert.assertEquals(120.0, cart.getProductByName("Dove Soap").getTotalPrice(), 0.0);
        Assert.assertEquals(320.0, cart.getProductByName("Axe Deo").getTotalPrice(), 0.0);
        Assert.assertEquals(440.0, cart.getTotalCartValue(), 0.0);
    }
}
