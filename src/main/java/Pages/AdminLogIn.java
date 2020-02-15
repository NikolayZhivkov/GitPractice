package Pages;

import Utils.Browser;
import org.openqa.selenium.By;

public class AdminLogIn {
    /**
     * Positive log in
     */

    private static final By LOC_USERNAME = By.id("input-username");
    private static final By LOC_PASSWORD = By.id("input-password");
    private static final By LOC_LOGIN_BUTTON = By.cssSelector(".btn-primary");

    public static void goTo() {
        Browser.driver.get("http://shop.pragmatic.bg/admin/");
    }

    public static void login(String username, String password) {

        Browser.driver.findElement(LOC_USERNAME).sendKeys(username);
        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);
        Browser.driver.findElement(LOC_LOGIN_BUTTON).click();

    }

    public static void logout() {
        Browser.driver.findElement(By.id("button-filter")).click();
    }
}
