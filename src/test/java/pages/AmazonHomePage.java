package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomePage {

    private static WebElement element = null;

    public static WebElement dropdown_searchDropdownBox (WebDriver driver){

        element = driver.findElement(By.id("searchDropdownBox"));
        Select se = new Select(element);
        se.selectByValue("search-alias=stripbooks-intl-ship");
        return element;

    }
    public static WebElement search_textbox_search_amazon(WebDriver driver){

        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        return element;

    }

    public static WebElement button_submit_search (WebDriver driver){

        WebElement element = driver.findElement(By.id("nav-search-submit-button"));
        return element;

    }
}