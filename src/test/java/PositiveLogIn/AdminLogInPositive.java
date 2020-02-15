package PositiveLogIn;

import Pages.AdminLogIn;
import Pages.NavigationCatalog;
import Utils.Browser;
import Veryfications.CommonVerification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminLogInPositive {

    @BeforeMethod
    public void setUp(){
        /**
         * Вдигаме браусер
         */
        Browser.open("chrome");
    }

    @AfterMethod
    public void tearDawn(){
        /**
         * сваляме браузер
         */
        Browser.quit();
    }

    @Test
    public void adminLogIn() throws InterruptedException {
        /**
         * method that go on page "pragmaticshop.bg
         */
        AdminLogIn.goTo();
        /**
         * method that log in the admin panel whit username and password
         */
        AdminLogIn.login("Admin", "parola123!");

        /**
         * method that verify the title of the page is like the expected title
         */

        CommonVerification.verifyTiitle("Dashboard","You are not on the corect page!!!");

        NavigationCatalog.products();

        NavigationCatalog.extentionMarketplaceSearch();
        NavigationCatalog.salesOrders();

        AdminLogIn.logout();





    }

}
