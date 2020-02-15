package Veryfications;

import Utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class CommonVerification {
    private static final By LOC_ERROR_VALIDATION_MESSAGE = By.cssSelector(".alert.alert-danger.alert-dismissible");

    public static void verifyTiitle(String exectedTitle, String errorMessage) {
        /**
         * this method take the page title
         */

        String actualTitle = Browser.driver.getTitle();

        /**
         * this method make veryfication if the 2 title are the same
         */
        Assert.assertEquals(actualTitle,exectedTitle,errorMessage);



    }


    public static void verifyErrorValidationMessage(String expectedMessage, String messageInCaseOfIncorrectValidationMessage) {
        String actualErrorValidationMessage = Browser.driver.findElement(LOC_ERROR_VALIDATION_MESSAGE).getText();

        Assert.assertEquals(actualErrorValidationMessage,expectedMessage, messageInCaseOfIncorrectValidationMessage);
    }
}
