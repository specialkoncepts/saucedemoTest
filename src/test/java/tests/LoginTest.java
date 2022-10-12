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
}



