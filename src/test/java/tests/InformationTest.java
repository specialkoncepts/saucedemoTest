package tests;


import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;
import utils.BrowserUtils;


public class InformationTest {
    @Test(testName = "US 308 -  Fields displayed where user can input their details")
    public void test01() {

        System.setProperty("webdriver.chrome.driver", "D:\\!Users\\Mike\\Desktop\\Selenium\\libsSel\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/");

        driver.findElement(By.id("sauce-demo")).click();
        BrowserUtils.switchToNewWindow(driver);


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        //Assert.assertEquals(driver.findElement(By.xpath("//li[@class='social_twitter']")).getText(), "Twitter");
        //Assert.assertEquals(driver.findElement(By.xpath("//li[@class='social_facebook']")).getText(), "Facebook");
        //Assert.assertEquals(driver.findElement(By.xpath("//li[@class='social_linkedin']")).getText(), "LinkedIn");

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='First Name']")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Last Name']")).getText(), "");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).getText(), "");





    }

}