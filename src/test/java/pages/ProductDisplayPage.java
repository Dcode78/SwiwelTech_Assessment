package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Integer.parseInt;

public class ProductDisplayPage {

    private static WebElement element = null;
    private static int qtyInCart;

    public static WebElement selectBookTypeTogglePDP(WebDriver driver){

        element = driver.findElement(By.xpath("//ul[@class='a-unordered-list a-nostyle a-button-list a-horizontal']//*[text()='Paperback']"));
        return element;

    }

    public static WebElement getUnitPricePDP(WebDriver driver){

        element = driver.findElement(By.xpath("//span[@id = 'price']"));
        return element;

    }

    public static WebElement getTitlePDP(WebDriver driver){

        element = driver.findElement(By.xpath("//span[@id='productTitle']"));
        return element;

    }

    public static void setQtyInPDP(WebDriver driver){

        element = driver.findElement(By.id("quantity"));
        Select se = new Select(element);
        se.selectByValue("2");

    }

    public static int getQtyInPDP(WebDriver driver){

        element = driver.findElement(By.id("quantity"));
        Select se = new Select(element);
        qtyInCart = parseInt(se.getFirstSelectedOption().getText());
        return qtyInCart;

    }

    public static WebElement addToCartPDP(WebDriver driver){

        element = driver.findElement(By.cssSelector("#add-to-cart-button"));
        return element;

    }
}
