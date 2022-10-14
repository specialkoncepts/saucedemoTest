package tests;

import data.DataProviders;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.SaucedemoPage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    //    driver.quit();
    }

    @Test(testName = "US 301 - Verify standard_user can login with right password")
    public void test01() {


        page.userName.sendKeys("standard_user");

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

    @Test(testName = "US 304 - I need an option to see navigation menu. And confirm all buttons are present")
    public void test04() {


//        driver.get("http://automation.techleadacademy.io/#/");
//
//        driver.findElement(By.id("sauce-demo")).click();
//        BrowserUtils.switchToNewWindow(driver);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        System.out.println(driver.findElement(By.xpath("//a[@id=\"inventory_sidebar_link\"]")).getText());


//        Assert.assertEquals(driver.findElement(By.id("inventory_sidebar_link")).getText(), "All Items");
//        Assert.assertEquals(driver.findElement(By.id("about_sidebar_link")).getText(), "About");
//        Assert.assertEquals(driver.findElement(By.id("logout_sidebar_link")).getText(), "Logout");
//        Assert.assertEquals(driver.findElement(By.id("reset_sidebar_link")).getText(), "Reset App State");

    }

    @Test(testName = "US 305 - Footer of the page should be © 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy")
    public void test05() {

        page.userName.sendKeys("standard_user");

        page.userPassword.sendKeys("secret_sauce");

        page.click(page.loginButton);

        String expected = "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
        String actual = driver.findElement(By.xpath("//div[@class='footer_copy']")).getText();

        Assert.assertEquals(actual, expected);

    }

    @Test(testName = "US 306 - Filter options. When user clicks the filter it should have following options:")
    public void test06() {

        page.userName.sendKeys("standard_user");

        page.userPassword.sendKeys("secret_sauce");

        page.click(page.loginButton);
        String [] btn = new String[] {"az", "za", "lohi", "hilo"};

        for (int i = 0; i < 4 ; i++) {
            String actual = driver.findElement(By.xpath("//select/option["+ (i+1) + "]")).getAttribute("value");
            String expected = btn[i];
            Assert.assertEquals(actual, expected);
        }

    }
}



