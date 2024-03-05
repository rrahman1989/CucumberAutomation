Feature: Shopping on Swag Labs
	
	@TestCaseKey=QEP-T26
  Scenario: Purchase a product on Swag Labs
    Given the user navigates to the Swag Labs website
    When the user logs in with the username "standard_user" and password "secret_sauce"
    Then the Products label is displayed on the page

    When the user adds "Sauce Labs Backpack" to the cart
    Then the Add to Cart link changes to "Remove"
    And the checkout icon shows '1' in the image

    When the user clicks on the checkout icon
    Then "Sauce Labs Backpack" with 1 Qty is displayed in the cart

    When the user clicks on the "CheckOut" link
    And then clicks on the "Cancel" link
    Then the "Your Cart" label is displayed

    When the user clicks on the three bars on the left top
    And selects "Logout"
    Then the Saucedemo.com login page is displayed
