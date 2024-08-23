package org.example.Step_Def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_Buying_all_iteams;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.Step_Def.Hooks.driver;

public class TC03_Buying_all_iteams {
    P03_Buying_all_iteams buying = new P03_Buying_all_iteams();
    @Given("Navigate to URL Website")
    public void navigate_to_url_website() {
        driver.navigate().to("https://www.saucedemo.com");
    }

    @When("Enter Email and Password {string} {string}")
    public void enter_email_and_password(String username ,String password) {
        buying.Username().sendKeys(username);
        buying.password().sendKeys(password);
    }

    @And("Click on Login icon")
    public void click_on_login_icon() {
        buying.login_icon().click();
    }
    @Then("login Successfully to home page")
    public void login_successfully_to_home_page() {
        String newURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(newURL,driver.getCurrentUrl());
    }
    @When("choose the items by clicking on add to card")
    public void choose_the_items_by_clicking_on_add_to_card() {
        int size = buying.page_items().size();
        System.out.println(size);
        for(int i = 0;i<size;i++){
            int num = i+1;
                driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div["+num+"]/div[2]/div[1]/a/div")).click();
                driver.findElement(By.id("add-to-cart")).click();
                driver.findElement(By.id("back-to-products")).click();
            }
        }
    @Then("check the items is added to the card")
    public void the_icon_changed_to_be_remove() {
        String no = buying.no_of_chosen_items().getText();
        Assert.assertEquals("6",no);
    }

    @And("we clicking on the shopping icon")
    public void we_clicking_on_the_shopping_icon() {
        buying.shopping_icon().click();
        String URL = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }

    @Then("clicking on checkout to move to anther page and enter the valid data")
    public void clicking_on_checkout_to_move_to_anther_page_and_enter_the_valid_data() {
        buying.Checkout().click();
        buying.Firstname().sendKeys("llll");
        buying.Lastname().sendKeys("Slll");
        buying.PostalCode().sendKeys("llll");
        buying.Continue().click();
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html",driver.getCurrentUrl());
        buying.Finish().click();
    }

    @Then("after clicking finished a success message appeared")
    public void after_clicking_finished_a_success_message_appeared() {
        String Msg_succ = "Thank you for your order!";
        Assert.assertTrue(buying.succ_Msg().getText().contains(Msg_succ));
    }

}
