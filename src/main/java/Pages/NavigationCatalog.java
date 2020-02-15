package Pages;

import Utils.Browser;
import Veryfications.CommonVerification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NavigationCatalog {
    private static final By LOC_PRODUCTS=By.xpath("//ul[@id=\"collapse1\"]//..//li[2]");
    public static void products() throws InterruptedException {
        /**
         * method that go on products menu and will make a search for a product
         */
        Browser.driver.findElement(By.id("menu-catalog")).click();
        Browser.driver.findElement(LOC_PRODUCTS).click();
        CommonVerification.verifyTiitle("Products", "Opps something is wrong!!!!");

        WebElement checkbox = Browser.driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
        checkbox.click();
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        Browser.driver.findElement(By.id("input-name")).sendKeys("Apple cinema 30");
        WebElement statusSelect = Browser.driver.findElement(By.id("input-status"));

        Select status = new Select(statusSelect);

        status.selectByVisibleText("Enabled");

        Browser.driver.findElement(By.id("button-filter")).click();
        Thread.sleep(5000);
        Browser.driver.findElement(By.xpath("//td[@class=\"text-center\"]//..//img[@alt=\"Apple Cinema 30\"]")).isDisplayed();



    }


    public static void extentionMarketplaceSearch() {
        /**
         * method that open the extention menu a search for a specific product
         */
        Browser.driver.findElement(By.id("menu-extension")).click();
        Browser.driver.findElement(By.xpath("//ul[@id=\"collapse14\"]//..//li[1]")).click();
        CommonVerification.verifyTiitle("Extension Marketplace","Opps wrong page!!!");
        Browser.driver.findElement(By.xpath("//div[@id=\"extension-filter\"]//..//input[@class=\"form-control\"]")).sendKeys("Social Like FREE ");
        Browser.driver.findElement(By.xpath("//button[@id=\"button-filter\"]//..//i[@class=\"fa fa-filter\"]")).click();
        Browser.driver.findElement(By.xpath("//div[@class=\"extension-description\"]//..//img[@alt=\"Social Like FREE (Google+, LinkedIn)\"]")).isDisplayed();
    }

    public static void salesOrders() {
        /**
         * method that click ot menu sales then click on orders and check the dropdown menu
         */

        Browser.driver.findElement(By.id("menu-sale")).click();
        Browser.driver.findElement(By.xpath("//ul[@id=\"collapse26\"]//..//li[1]")).click();
        CommonVerification.verifyTiitle("Orders","Opps we are sorry!");

        WebElement selectMenu = Browser.driver.findElement(By.id("input-order-status"));

        Select selectDrop = new Select(selectMenu);
        List<String> exp_options = Arrays.asList(new String[]{"","Missing Orders", "Canceled", "Canceled Reversal", "Chargeback", "Complete", "Denied", "Expired", "Failed", "Pending", "Processed", "Processing", "Refunded", "Reversed", "Shipped", "Voided"});
        List<String> act_options = new ArrayList<>();
        List<WebElement>all_options = selectDrop.getOptions();

        for (WebElement option: all_options) {
            act_options.add(option.getText());

        }
        Assert.assertEquals(act_options.toArray(),exp_options.toArray());
    }
}
