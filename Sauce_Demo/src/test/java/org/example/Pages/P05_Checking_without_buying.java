package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_Def.Hooks.driver;

public class P05_Checking_without_buying {
    public WebElement Username(){
        return driver.findElement(By.id("user-name"));
    }
    public WebElement password(){
        return driver.findElement(By.id("password"));
    }
    public WebElement login_icon(){
        return driver.findElement(By.id("login-button"));
    }
    public WebElement shopping_icon(){
        return driver.findElement(By.className("shopping_cart_link"));
    }
    public WebElement Checkout(){
        return driver.findElement(By.id("checkout"));
    }
    public WebElement Firstname(){
        return driver.findElement(By.id("first-name"));
    }
    public WebElement Lastname(){
        return driver.findElement(By.id("last-name"));
    }
    public WebElement PostalCode(){
        return driver.findElement(By.id("postal-code"));
    }
    public WebElement Continue(){
        return driver.findElement(By.id("continue"));
    }
    public WebElement Finish(){
        return driver.findElement(By.id("finish"));
    }
}
