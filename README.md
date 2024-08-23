# Selenium Test Automation Project
## Overview
This repository contains Selenium test automation scripts written in Java for application:

Sauce Demo
#### Link :
[Sauce Demo](https://www.saucedemo.com)
The project uses Selenium WebDriver for automation and includes both automated test cases and a traditional test plan.
## Project Structure
```
/selenium-test-automation
├── /src
│   ├── /main
│   │   ├── /java
│   │   ├── /resouces
│   │   │   ├── /Features
│   │   │   │   ├── f01_Login.feature
│   │   │   │   ├── f02_sorting_items_By_price.feature
│   │   │   │   ├── f03_Buying_all_iteams.feature
│   │   │   │   ├── f04_Removing_items.feature
│   │   │   │   ├── f05_Checkout_without_buying.feature
│   │   │   │   ├── f06_sorting_items_by_name.feature
│   │   │   ├── /WebDrivers
│   ├── /test
│   │   ├── /java
│   │   │   ├── /example
│   │   │   │   ├── /Pages
│   │   │   │   │   ├── P01_login.java
│   │   │   │   │   ├── P02_Sorting_by_price.java
│   │   │   │   │   ├── P03_Buying_all_items.java
│   │   │   │   │   ├── P04_Removing_Items.java
│   │   │   │   │   ├── P05_Checking_without_buying.java
│   │   │   │   │   └── P06_Sorting_items_by_name.java
│   │   │   │   ├── /Step_Def
│   │   │   │   │   ├── Hooks.java
│   │   │   │   │   ├── TC01_Login
│   │   │   │   │   ├── TC02_Sorting_by_price
│   │   │   │   │   ├── TC03_Buying_all_iteams
│   │   │   │   │   ├── TC04_Removing_Items
│   │   │   │   │   ├── TC05_checking_without_buying
│   │   │   │   │   ├── TC06_sorting_items_by_name
│   │   │   │   ├── /testRunner
│   │   │   │   │   ├── runner
├── pom.xml

```
## Configuration
### WebDriver Configuration HOOKS FILE
Edit the WebDriverConfig.java file to set the path to your WebDriver executable if it’s not in your system’s PATH:

```
public class Hooks {
    public static ChromeDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","D:\\TESTING\\projects\\CIB Tarek El Shourbagy\\CIB Assessment\\Automation Test\\Tarek_El_Shourbagy\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void quit() {
        driver.quit();
    }
}
```
## Test Cases
### Sauce Demo using Cucamber to explain the test cases steps
  f01_Login.feature
  
  f02_sorting_items_By_price.feature
  
  f03_Buying_all_iteams.feature
  
  f04_Removing_items.feature
  
  f05_Checkout_without_buying.feature
  
  f06_sorting_items_by_name.feature
```
@smoke
Feature: Login with all user website provided
  Scenario Outline: Login with all user website provided
    Given Navigate to URL website
    When Enter email and password "<username>" "<password>"
    And Click on login icon
    Then login successfully to home page

    Examples:
      |username|                        | password  |
      | standard_user              |    | secret_sauce  |
      | problem_user               |    | secret_sauce  |
      | performance_glitch_user    |    | secret_sauce  |
      | error_user                 |    | secret_sauce  |
      | visual_user                |    | secret_sauce  |
```
## Page Object Model (POM)
### i used POM creating all locators in one class for each flow
```
package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_Def.Hooks.driver;

public class P01_login {
    public WebElement Username() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement password() {
        return driver.findElement(By.id("password"));
    }

    public WebElement login_icon() {
        return driver.findElement(By.id("login-button"));
    }
}
```
### i linked each POM class with main class where we can provide an action with this locators
```
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
```
## Runner
### used to genarate all test cases to run in sequancy
```
package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = {"src/main/resources/features"},
                glue = {"Step_def"},
                tags = "@smoke",
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cukes.xml",
                        "rerun:target/rerun.txt"
                }
        )


public class runner extends AbstractTestNGCucumberTests {

}
```
