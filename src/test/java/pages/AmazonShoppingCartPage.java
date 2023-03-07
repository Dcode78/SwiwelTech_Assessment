package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonShoppingCartPage {

    private static WebElement element = null;

    public static WebElement getCartTotal(WebDriver driver){

        element = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']")); //subtotal
        return element;

    }

    public static WebElement getCartQuantiy (WebDriver driver){

        element = driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
        //element = driver.findElement(By.xpath("//span[@class ='a-truncate-cut']"));
        return element;

    }

    public static WebElement getTitleInCart (WebDriver driver){

        //element = driver.findElement(By.xpath("//span[@class ='a-truncate-full a-offscreen']"));
        element = driver.findElement(By.xpath("//span[@class ='a-truncate-cut']"));
        return element;

    }

    public static WebElement clickBtnDelete (WebDriver driver) {

        element = driver.findElement(By.xpath("//span[@class='a-declarative']//input[@value='Delete']"));
        return element;

    }

    public static WebElement getClearedSubTotal (WebDriver driver){

        element = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']//span[contains(text(), '$0.00')]"));
        return element;
    }

}
