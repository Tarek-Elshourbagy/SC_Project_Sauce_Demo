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