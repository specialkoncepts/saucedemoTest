package utils;

public class BrowserUtils {

    public static void switchToNewWindow(){
        for(String each: driver.getWindowHandles()){
            if(!each.equals(driver.getWindowHandle()))
                driver.switchTo().window(each);
        }
    }
}
