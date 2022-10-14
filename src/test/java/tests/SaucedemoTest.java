package tests;

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

    @Test(testName = "US 309 - Add to cart, and item should be displayed in cart view ")
    public void test09()
    {
        //driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        page.addToCart.click();
        //driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
        page.shoppingCartDisplay.isDisplayed();
    }

    @Test(testName = "US 310 - Remove from cart, user should be able to remove items from cart")
    public void test10()
    {
        //driver.findElement(By.xpath("//div/button[text()='Remove']")).click();
        page.removeItem.click();
    }
}



