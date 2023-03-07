package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IneterimSearchPage {

    private static WebElement element = null;

    public static WebElement applyStarReviewFilter (WebDriver driver){

        element = driver.findElement(By.xpath("//li[@id='p_72/1250221011']//span[@class='a-size-small a-color-base']"));
        return element;

    }

    public static WebElement applyEnglishLanguageFilter (WebDriver driver){

        element = driver.findElement(By.xpath("//li[@id ='p_n_feature_nine_browse-bin/3291437011']//i[@class ='a-icon a-icon-checkbox']"));
        return element;

    }

    public static WebElement applyBookFormatFilter (WebDriver driver){

        element = driver.findElement(By.xpath("//li[@id = 'p_n_feature_browse-bin/2656022011']//span[@class ='a-size-base a-color-base']"));
        return element;

    }

    public static WebElement getSecondTitle (WebDriver driver){

        element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]"));
        System.out.println("== 2nd Title in results, to be selected -> "+ element.getText());
        return element;

    }

}
