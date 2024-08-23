package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.Step_Def.Hooks.driver;

public class P06_sorting_items_by_name {
    public WebElement Username() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement password() {
        return driver.findElement(By.id("password"));
    }

    public WebElement login_icon() {
        return driver.findElement(By.id("login-button"));
    }
    public WebElement Sort_Items() {
        return driver.findElement(By.className("product_sort_container"));
    }
}
