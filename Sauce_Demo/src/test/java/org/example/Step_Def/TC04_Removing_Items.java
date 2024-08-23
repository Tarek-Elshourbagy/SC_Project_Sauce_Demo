package org.example.Step_Def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_Removing_Items;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.Step_Def.Hooks.driver;

public class TC04_Removing_Items {
    P04_Removing_Items Removing = new P04_Removing_Items();

    @Given("navigate to URL Website")
    public void navigate_to_url_website() {
        driver.navigate().to("https://www.saucedemo.com");
    }
    @When("enter Email and Password {string} {string}")
    public void enter_email_and_password(String username, String password) {
        Removing.Username().sendKeys(username);
        Removing.password().sendKeys(password);
    }
    @When("click on Login icon")
    public void click_on_login_icon() {
        Removing.login_icon().click();
    }
    @Then("Login Successfully to home page")
    public void login_successfully_to_home_page() {
        String newURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(newURL,driver.getCurrentUrl());
    }
    @When("Choose the items by clicking on add to card")
    public void choose_the_items_by_clicking_on_add_to_card() {
        int size = Removing.page_items().size();
        System.out.println(size);
        Assert.assertEquals(size,6);
        for(int i = 0;i<size;i++){
            int num = i+1;
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div["+num+"]/div[2]/div[1]/a/div")).click();
            driver.findElement(By.id("add-to-cart")).click();
            driver.findElement(By.id("back-to-products")).click();
    }
    }
    @Then("Check the items is added to the card")
    public void check_the_items_is_added_to_the_card() {
            String no = Removing.no_of_chosen_items().getText();
            Assert.assertEquals("6",no);
    }
    @Then("We clicking on the shopping icon")
    public void we_clicking_on_the_shopping_icon() {
        Removing.shopping_icon().click();
        String URL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }
    @Then("Removing all items")
    public void removing_items() {
        int size = 8;
        for(int i = 3;i<size;i++){
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div["+i+"]/div[2]/div[2]/button")).click();
        }
    }
}
