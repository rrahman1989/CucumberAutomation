package com.cucumber.cucumber.zephyr.project.saucelab.steps;

import javax.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SauceSteps {
	
	private WebDriver driver;
    private WebDriverWait wait;

    @Inject
    public SauceSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }
	
	

	@Given("^the user navigates to the Swag Labs website$")
    public void the_user_navigates_to_the_Swag_Labs_website() throws Throwable {
        // Navigate to the Swag Labs website
        driver.get("https://www.saucedemo.com");

        // Additional validation if needed
    }

    @When("^the user adds \"([^\"]*)\" to the cart$")
    public void the_user_adds_to_the_cart(String product) throws Throwable {
        // Find and click on the "Add to Cart" button for the specified product
    	//"//*[@id=\"add-to-cart-sauce-labs-backpack\"]"
    	System.out.println("Products: " + "//*[@id='add-to-cart-" + product.toLowerCase() + "']");
    	//WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce labs backpack"));
        //WebElement addToCartButton = driver.findElement(By.xpath("//*[@id='add-to-cart-" + product.toLowerCase() + "']"));
    	WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
    	addToCartButton.click();
    }

    @Then("^the Add to Cart link changes to \"([^\"]*)\"$")
    public void the_Add_to_Cart_link_changes_to(String buttonText) throws Throwable {
        // Find and validate the text of the "Add to Cart" button
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")));
        String actualButtonText = addToCartButton.getText();
        if (!actualButtonText.equals(buttonText)) {
            throw new AssertionError("Expected button text: " + buttonText + ", Actual button text: " + actualButtonText);
        }
    }

    @Then("^the checkout icon shows '(\\d+)' in the image$")
    public void the_checkout_icon_shows_in_the_image(int expectedCount) throws Throwable {
        // Find and validate the count in the checkout icon
        WebElement checkoutIcon = driver.findElement(By.className("shopping_cart_badge"));
        String actualCountText = checkoutIcon.getText();
        int actualCount = Integer.parseInt(actualCountText);
        if (actualCount != expectedCount) {
            throw new AssertionError("Expected checkout icon count: " + expectedCount + ", Actual count: " + actualCount);
        }
    }

    @When("^the user clicks on the checkout icon$")
    public void the_user_clicks_on_the_checkout_icon() throws Throwable {
        // Find and click on the checkout icon
        WebElement checkoutIcon = driver.findElement(By.className("shopping_cart_badge"));
        checkoutIcon.click();
    }

    @Then("^\"([^\"]*)\" with (\\d+) Qty is displayed in the cart$")
    public void with_Qty_is_displayed_in_the_cart(String product, int expectedQty) throws Throwable {
        // Find and validate the product and quantity in the cart
        WebElement productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']"));
        WebElement qtyInCart = productInCart.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]"));
        int actualQty = Integer.parseInt(qtyInCart.getText());
        if (actualQty != expectedQty) {
            throw new AssertionError("Expected quantity for " + product + ": " + expectedQty + ", Actual quantity: " + actualQty);
        }
    }
    
    
    @When("^the user clicks on the \"([^\"]*)\" link$")
    public void the_user_clicks_on_the_link(String arg1) throws Throwable {
        // Implement the code to click on the specified link
    	driver.findElement(By.id(arg1.toLowerCase())).click();
    }

    @When("^then clicks on the \"([^\"]*)\" link$")
    public void then_clicks_on_the_link(String arg1) throws Throwable {
        // Implement the code to click on the specified link
    	driver.findElement(By.id(arg1.toLowerCase())).click();
    }
	

	@When("^the user logs in with the username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void the_user_logs_in_with_the_username_and_password(String username, String password) throws Throwable {
        
		
    
		// Login with username and password
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("^the Products label is displayed on the page$")
    public void the_Products_label_is_displayed_on_the_page() throws Throwable {
        // Validate the "Products" label is displayed
        WebElement productsLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[2]/span")));
        if (productsLabel.isDisplayed()) {
            System.out.println("Products label is displayed.");
        } else {
            System.out.println("Products label validation failed!");
        }
    }

    // Continue with the remaining step definitions in a similar manner
    // ...

    @Then("^the \"([^\"]*)\" label is displayed$")
    public void the_label_is_displayed(String label) throws Throwable {
        // Validate the specified label is displayed
        WebElement displayedLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + label + "']")));
        if (displayedLabel.isDisplayed()) {
            System.out.println(label + " label is displayed.");
        } else {
            System.out.println(label + " label validation failed!");
        }
    }
    
    @When("^the user clicks on the three bars on the left top$")
    public void the_user_clicks_on_the_three_bars_on_the_left_top() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @When("^selects \"([^\"]*)\"$")
    public void selects(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("^the Saucedemo\\.com login page is displayed$")
    public void the_Saucedemo_com_login_page_is_displayed() throws Throwable {
        // Verify saucedemo.com login page is displayed
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Saucedemo.com login page is displayed.");
        } else {
            System.out.println("Logout validation failed!");
        }

        // Close the browser
        driver.quit();
    }

	
}
