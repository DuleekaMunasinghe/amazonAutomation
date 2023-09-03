package com.amazon.automation.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;
	 String appurl = "https://www.amazon.com/";
	  
	@BeforeTest
    public void setUp() throws InterruptedException {
  	  System.out.println("Launch Browser");
  	  WebDriverManager.chromedriver().setup();
  	  ChromeOptions options   = new ChromeOptions();
      options.addArguments("--incognito");
  	  options.addArguments("--remote-allow-origins=*");

  	  driver = new ChromeDriver(options); 
  	  driver.manage().deleteAllCookies();
  	  driver.manage().window().maximize();
  	  driver.get(appurl);
  	  Thread.sleep(20000);
        
    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
  	  System.out.println("CloseBrowser");

        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
