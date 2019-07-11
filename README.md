# ShoppingCart
CREATE A SIMPLE SHOPPING CART:

# Task Description

Implement following diagram to create a simple shopping cart. You can download the partially implemented code given 
and complete the required method classes.

![alt text](https://github.com/code-exercise/ShoppingCart/blob/master/shopping-cart.jpg)




	 Requirement: We should be able to add different products to shopping cart.
	    When:
		    – Add 1 unit of ‘Gatsby hair cream’, unit price 30 Rupees.
			– Add 1 unit of ‘Bvlgiri Soap’, unit price 100 Rupees.
		Then:
			– The product count of the cart should be 2.
			– The total value of cart should be 130 rupees.

 - THERE IS AN OFFER ON GATSBY HAIR CREAM 
	– BUY X ITEM GET Y ITEM FREE– IF YOU BUY 2 GATSBY HAIR CREAM YOU WILL GET 1 FREE.
	– THERE IS NO OFFER ON ‘BVLGIRI SOAP’.
```
	 Requirement: Add Products and apply offer to shopping cart
		When: 
			- Add 5 unit of ‘Gatsby hair cream’, unit price 30 Rupees.
		Then:
			– The product count of cart should be 1.
			– The total value of cart should be 120 rupees.

	 Requirement: Add different Products and apply offer to shopping cart
		When:
			– Add 3 unit of ‘Gatsby hair cream’, unit price 30 Rupees.
			– Add 2 unit of ‘Bvlgiri Soap’, unit price 100 Rupees.
		Then:
			– The product count of the cart should be 2.
			– The total value of cart should be 260.0 rupees.		
```
THERE IS A DISCOUNT ON THE GATSBY HAIR CREAM
	– BUY 1 ITEM GET 50% DISCOUNT ON NEXT ITEM.
	– THERE IS NO OFFER ON ‘BVLGIRI SOAP’.
```
    Requirement: Apply discount on shopping cart
        When: Add 2 unit of ‘Gatsby hair cream’, unit price 30 Rupees.
        Then:
            – The product count of cart should be 1.
            – The total price of product should be 45.
            – The total value of cart should be 45.0 rupees.	
```
THERE IS A GENERAL DISCOUNT
   - IF TOTAL CART VALUE IS > 500 THEN 20% DISCOUNT ON EACH PRODUCT
```
   	Requirement: Apply discount on shopping cart
		When: 
		    - Add 4 unit of ‘Bvlgiri Perfume’, unit price 100 Rupees.
		    - Add 5 unit of 'Axe Deo', unit price 30 Rupees.

	Then:
		– The product count of cart should be 2.
		– The total price of Bvlgiri Perfumes should be 320.0.
		– The total price of Axe Deo should be 120.0.
		– The total value of cart should be 440.0 rupees.	
```		
