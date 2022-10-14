package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoPage extends BasePage{

   WebDriver driver;


   public SaucedemoPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="user-name")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement userPassword;

    @FindBy(id="login-button")
    public WebElement loginButton;

}
