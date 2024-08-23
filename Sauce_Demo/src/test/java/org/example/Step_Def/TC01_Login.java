package org.example.Step_Def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_login;
import org.testng.Assert;

import static org.example.Step_Def.Hooks.driver;

public class TC01_Login {
    P01_login login = new P01_login();
    @Given("Navigate to URL website")
    public void navigate_to_url_website() {
        driver.navigate().to("https://www.saucedemo.com");
    }

    @When("Enter email and password {string} {string}")
    public void enter_email_and_password(String username ,String password) {
        login.Username().sendKeys(username);
        login.password().sendKeys(password);
    }

    @And("Click on login icon")
    public void click_on_login_icon() {
        login.login_icon().click();
    }
    @Then("login successfully to home page")
    public void login_successfully_to_home_page() {
        String newURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(newURL,driver.getCurrentUrl());
    }
}
