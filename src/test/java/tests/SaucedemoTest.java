package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SaucedemoPage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class SaucedemoTest extends BaseTest {

    SaucedemoPage page;

    @BeforeMethod (alwaysRun = true)
    public void setup() {
        driver.findElement(By.id("sauce-demo")).click();
        BrowserUtils.switchToNewWindow(driver);
        page = new SaucedemoPage(driver);
    }
    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "US 301 - Verify standard_user can login with right password")
    public void test01() {

        // driver.findElement(By.id("user-name")).sendKeys("standard_user");
        page.userName.sendKeys("standard_user");
        // driver.findElement(By.id("password")).sendKeys("secret_sauce");
        page.userPassword.sendKeys("secret_sauce");

        // driver.findElement(By.id("login-button")).click();
        page.click(page.loginButton);

        String expected = "PRODUCTS";
        String actual = driver.findElement(By.xpath("//div[@class=\"header_secondary_container\"]/span")).getText();

        Assert.assertEquals(actual, expected);

    }

    @Test(testName = "US 302")
    public void test02() {

        page.userName.sendKeys("locked_out_user");

        page.userPassword.sendKeys("secret_sauce");

        page.click(page.loginButton);

        //System.out.println(driver.findElement(By.xpath("//h3")).getText());

        String expected = "Epic sadface: Sorry, this user has been locked out.";
        String actual = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals(expected, actual);
    }

        @Test(testName = "US 307 - Verify there are 3 social media buttons are present: twitter, facebook and linkedIn")
        public void test07() {


            page.userName.sendKeys("standard_user");
            page.userPassword.sendKeys("secret_sauce");
            page.click(page.loginButton);

            Assert.assertEquals(driver.findElement(By.xpath("//li[@class='social_twitter']")).getText(), "Twitter");
            Assert.assertEquals(driver.findElement(By.xpath("//li[@class='social_facebook']")).getText(), "Facebook");
            Assert.assertEquals(driver.findElement(By.xpath("//li[@class='social_linkedin']")).getText(), "LinkedIn");


        }
    @Test(testName = "US 308 -  Fields displayed where user can input their details")
    public void test08() {


        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='First Name']")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Last Name']")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).getText(), "");
    }
}



