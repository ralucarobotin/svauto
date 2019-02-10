package helpers;

import org.openqa.selenium.WebElement;

public class WebElementHelper {

    public static void setFieldValue(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            if (element != null && element.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}