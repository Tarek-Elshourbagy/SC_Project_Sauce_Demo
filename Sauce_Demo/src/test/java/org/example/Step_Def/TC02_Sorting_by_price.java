package org.example.Step_Def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P02_Sorting_by_price;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.Step_Def.Hooks.driver;

public class TC02_Sorting_by_price {
    P02_Sorting_by_price Sort = new P02_Sorting_by_price();
    @Given("Navigate To URL website")
    public void navigate_to_url_website() {
        driver.navigate().to("https://www.saucedemo.com");
    }
    @When("enter email and password {string} {string}")
    public void enter_email_and_password(String username, String password) {
        Sort.Username().sendKeys(username);
        Sort.password().sendKeys(password);
    }
    @When("click on login icon")
    public void click_on_login_icon() {
        Sort.login_icon().click();
    }
    @When("Login successfully to home page")
    public void login_successfully_to_home_page() {
        String newURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(newURL,driver.getCurrentUrl());
    }
    @Then("sorting the items from lower price")
    public void sorting_the_items_from_lower_price() {
        Select Drop_down_sort = new Select(Sort.Sort_Items());
        Drop_down_sort.selectByIndex(2);
        String Price = driver.findElement(By.className("inventory_item_price")).getText();
        Assert.assertTrue(Price.contains("$7.99"));
    }
    @And("sorting the items from Highest price")
    public void sorting_the_items_from_Highest_price() {
        Select Drop_down_sort = new Select(Sort.Sort_Items());
        Drop_down_sort.selectByIndex(3);
        String Price = driver.findElement(By.className("inventory_item_price")).getText();
        Assert.assertTrue(Price.contains("$49.99"));
    }

}
