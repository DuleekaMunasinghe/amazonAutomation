package com.amazon.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getNumberOfSearchResults() {
        return driver.findElements(By.cssSelector(".s-result-item")).size();
    }
}
