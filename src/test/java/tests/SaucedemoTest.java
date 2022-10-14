package tests;

import org.openqa.selenium.WebElement;
import pages.SaucedemoPage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

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

    @Test(testName = "US 303 - When problem_user logs in all items on homepage should display same images")
    public void test03() {

        page.userName.sendKeys("problem_user");
        page.userPassword.sendKeys("secret_sauce");
        page.click(page.loginButton);



        List<WebElement> list = driver.findElements(By.xpath("//img[@src=\"/static/media/sl-404.168b1cce.jpg\"]"));
        list.forEach(each -> Assert.assertTrue(each.getAttribute("src").equals(each.getAttribute("src"))));
    }

    @Test(testName = "US 304 - I need an option to see navigation menu. And confirm all buttons are present")
    public void test04() {

        page.userName.sendKeys("standard_user");
        page.userPassword.sendKeys("secret_sauce");
        page.click(page.loginButton);

        driver.findElement(By.id("react-burger-menu-btn")).click();

        Assert.assertEquals(driver.findElement(By.id("inventory_sidebar_link")).getText(), "All Items");
        Assert.assertEquals(driver.findElement(By.id("about_sidebar_link")).getText(), "About");
        Assert.assertEquals(driver.findElement(By.id("logout_sidebar_link")).getText(), "Logout");
        Assert.assertEquals(driver.findElement(By.id("reset_sidebar_link")).getText(), "Reset App State");

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

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();

        Assert.assertEquals(driver.findElement(By.id("inventory_sidebar_link")).getText(), "All Items");
        Assert.assertEquals(driver.findElement(By.id("about_sidebar_link")).getText(), "About");
        Assert.assertEquals(driver.findElement(By.id("logout_sidebar_link")).getText(), "Logout");
        Assert.assertEquals(driver.findElement(By.id("reset_sidebar_link")).getText(), "Reset App State");


        for (int i = 0; i < 4 ; i++) {
            String actual = driver.findElement(By.xpath("//select/option["+ (i+1) + "]")).getAttribute("value");
            String expected = btn[i];
            Assert.assertEquals(actual, expected);
        }

        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='First Name']")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Last Name']")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).getText(), "");
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
    @Test(testName = "US 309 - Add to cart, and item should be displayed in cart view ")
    public void test09()
    {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //page.addToCart.click();
        driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
        //page.shoppingCartDisplay.isDisplayed();
    }

    @Test(testName = "US 310 - Remove from cart, user should be able to remove items from cart")
    public void test10()
    {
        driver.findElement(By.xpath("//div/button[text()='Remove']")).click();
        //page.removeItem.click();
    }
}




