package org.example.Step_Def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P05_Checking_without_buying;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.Step_Def.Hooks.driver;

public class TC05_checking_without_buying {
    P05_Checking_without_buying Checking_buying = new P05_Checking_without_buying();
    @Given("navigate To URL Website")
    public void navigate_to_url_website() {
        driver.navigate().to("https://www.saucedemo.com");
    }
    @When("enter Email And Password {string} {string}")
    public void enter_email_and_password(String username, String password) {
        Checking_buying.Username().sendKeys(username);
        Checking_buying.password().sendKeys(password);
    }
    @When("click on Login Icon")
    public void click_on_login_icon() {
        Checking_buying.login_icon().click();
    }
    @Then("Login Successfully to home Page")
    public void login_successfully_to_home_page() {
        String newURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(newURL,driver.getCurrentUrl());
    }
    @Then("We clicking on the shopping Icon")
    public void we_clicking_on_the_shopping_icon() {
        Checking_buying.shopping_icon().click();
        String URL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(URL, driver.getCurrentUrl());

    }
    @Then("Cleck on checkout without buying")
    public void cleck_on_checkout_without_buying() {
        Checking_buying.Checkout().click();
        Checking_buying.Firstname().sendKeys("tttt");
        Checking_buying.Lastname().sendKeys("Sllhtvtrgl");
        Checking_buying.PostalCode().sendKeys("ggbgr");
        Checking_buying.Continue().click();
    }
    @Then("validate that no expenses")
    public void validate_that_no_expenses() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html",driver.getCurrentUrl());
        String Expences =driver.findElement(By.className("summary_total_label")).getText();
        System.out.println(Expences);
        Assert.assertEquals(Expences,"Total: $0.00");
        Checking_buying.Finish().click();
    }

}
