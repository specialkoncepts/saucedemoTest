package tests;//<<<<<<< HEAD:src/test/java/LoginTest.java
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//=======
//>>>>>>> main:src/test/java/tests/LoginTest.java
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class LoginTest extends BaseTest {

    @Test(testName = "US 301 - Verify standard_user can login with right password")
    public void test01() {

        driver.get("http://automation.techleadacademy.io/#/");
        driver.findElement(By.id("sauce-demo")).click();
        BrowserUtils.switchToNewWindow(driver);
        driver.findElement(By.id("user-name")).sendKeys();




    }
}
