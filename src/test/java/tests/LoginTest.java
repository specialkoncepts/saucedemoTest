package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class LoginTest extends BaseTest {

    @Test(testName = "US 301 - Verify standard_user can login with right password")
    public void test01() {

        driver.findElement(By.id("sauce-demo")).click();

        BrowserUtils.switchToNewWindow(driver);


    }

    @Test(testName = "US 302 -  When locked out user tries to login with right password I would like to see an error"+
            "message Epic sadface: Sorry, this user has been locked out")
    public void test02()
    {

    }
}



