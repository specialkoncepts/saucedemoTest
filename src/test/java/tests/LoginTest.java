package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

public class LoginTest extends BaseTest {

    @BeforeMethod (alwaysRun = true)
    public void setup() {
        driver.findElement(By.id("sauce-demo")).click();
        BrowserUtils.switchToNewWindow(driver);
    }
    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "US 301 - Verify standard_user can login with right password")
    public void test01() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
        String expected = "PRODUCTS";
        String actual = driver.findElement(By.xpath("//div[@class=\"header_secondary_container\"]/span")).getText();

        Assert.assertEquals(actual, expected);

    }

//    @Test(testName = "US 302")
//    public void test02() {
//
//
//    }

    @Test(testName = "US 302 -  When locked out user tries to login with right password I would like to see an error"+
            "message Epic sadface: Sorry, this user has been locked out")
    public void test02()
    {

    }
}



