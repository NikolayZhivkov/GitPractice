package NegativeTest;

import Pages.AdminLogIn;
import Utils.Browser;
import Veryfications.CommonVerification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminLogInNegative {

    @BeforeMethod
    public void setUp(){
        Browser.open("firefox");
    }
    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }

    @Test
    public void adminLogInNegative(){


        AdminLogIn.goTo();
        AdminLogIn.login("Admin","parola12345!");
        CommonVerification.verifyErrorValidationMessage("No match for Username and/or Password.", "The expected validation error message is INCORRECT!");


    }
}
