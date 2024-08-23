package org.example.Step_Def;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P06_sorting_items_by_name;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.example.Step_Def.Hooks.driver;

public class TC06_sorting_items_by_name {
    P06_sorting_items_by_name Sort_name = new P06_sorting_items_by_name();
    @Given("Navigate To URL")
    public void navigate_to_url() {
        driver.navigate().to("https://www.saucedemo.com");
    }
    @When("enter email , password {string} {string}")
    public void enter_email_password(String username, String password) {
        Sort_name.Username().sendKeys(username);
        Sort_name.password().sendKeys(password);
    }
    @When("click login icon")
    public void click_login_icon() {
        Sort_name.login_icon().click();
    }
    @When("Login successfully to homepage")
    public void login_successfully_to_homepage() {
        String newURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(newURL,driver.getCurrentUrl());
    }
    @Then("sorting the items from A-Z price")
    public void sorting_the_items_from_a_z_price() {
        Select Drop_down_sort = new Select(Sort_name.Sort_Items());
        Drop_down_sort.selectByIndex(0);
        String Price = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertTrue(Price.contains("Sauce Labs Backpack"));
    }
    @Then("sorting the items from Z-A price")
    public void sorting_the_items_from_z_a_price() {
        Select Drop_down_sort = new Select(Sort_name.Sort_Items());
        Drop_down_sort.selectByIndex(1);
        String Price = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertTrue(Price.contains("Test.allTheThings() T-Shirt (Red)"));
    }
}
