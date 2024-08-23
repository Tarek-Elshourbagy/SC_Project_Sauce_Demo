package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.Step_Def.Hooks.driver;

public class P04_Removing_Items {
    public WebElement Username(){
        return driver.findElement(By.id("user-name"));
    }
    public WebElement password(){
        return driver.findElement(By.id("password"));
    }
    public WebElement login_icon(){
        return driver.findElement(By.id("login-button"));
    }
    public List<WebElement> page_items(){
        return driver.findElements(By.className("inventory_item"));
    }
    public WebElement shopping_icon(){
        return driver.findElement(By.className("shopping_cart_link"));
    }
    public WebElement no_of_chosen_items(){
        return driver.findElement(By.className("shopping_cart_badge"));
    }
}
