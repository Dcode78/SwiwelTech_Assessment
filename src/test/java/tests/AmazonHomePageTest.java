package tests;

import utility.HandlePropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import pages.*;
import utility.ReadExcel;

public class AmazonHomePageTest {

    private static WebDriver driver = null;
    private static WebElement element = null;

    private static int qtySelected;
    private static int qtyInCart;

    private static float unitPrice;
    private static float cartSubTotal;

    private static String titleInCart;
    private static String titleSelected;

    public static String browserName = null;

    @BeforeTest
    public void setUpTest() throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--headless=new");
        HandlePropertyFile.getproperties();

        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("fireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        String excelPath = "C:\\Users\\User\\IdeaProjects\\SwiwelTech_Assessment\\src\\test\\java\\excel\\data.xlsx";

        String appURL = ReadExcel.readExcel(1, 0, excelPath, "URL_sheet");

        driver.get(appURL);

    }

    @AfterTest
    public void tearDown(){

        driver.close();
        driver.quit();
    }

    @Test
    public static void amazonsearhmethod() throws InterruptedException{

        AmazonHomePage.dropdown_searchDropdownBox(driver);
        System.out.println("== Selected [Books] from drop down ==");

        AmazonHomePage.search_textbox_search_amazon(driver).sendKeys("Automation");
        System.out.println("== Input text [Automation] ==");

        AmazonHomePage.button_submit_search(driver).click();
        System.out.println("== Clicked submit search button ==");
        Thread.sleep(3000);

        IneterimSearchPage.applyStarReviewFilter(driver).click();
        System.out.println("== Filtered 4 Starts & Up reviews ==");
        Thread.sleep(3000);

        IneterimSearchPage.applyEnglishLanguageFilter(driver).click();
        System.out.println("== Filtered English Language ==");
        Thread.sleep(3000);

        IneterimSearchPage.applyBookFormatFilter(driver).click();
        System.out.println("== Filtered for Paperback ==");
        Thread.sleep(5000);

        IneterimSearchPage.getSecondTitle(driver).click();
        System.out.println("== Navigating to PDP ==");
        Thread.sleep(3000);

        ProductDisplayPage.selectBookTypeTogglePDP(driver).click();
        System.out.println("== Clicked Paperback within PDP before getting unit price ==");
        Thread.sleep(2000);

        ProductDisplayPage.setQtyInPDP(driver);

        qtySelected = ProductDisplayPage.getQtyInPDP(driver);
        System.out.println("== Quantiy Selected == "+ qtySelected);

        element = ProductDisplayPage.getUnitPricePDP(driver);
        unitPrice = getUnitPriceInFloat(element);
        System.out.println("== Unit Price == " + unitPrice);

        element = ProductDisplayPage.getTitlePDP(driver);
        titleSelected = element.getText();
        System.out.println("== Selected Title -> " + titleSelected);
        Thread.sleep(2000);

        ProductDisplayPage.addToCartPDP(driver).click();
        InterimShopingCartPage.goToShoppingCart(driver).click();
        Thread.sleep(2000);

        element = AmazonShoppingCartPage.getTitleInCart(driver);
        titleInCart = element.getText();
        System.out.println("== Title in Cart -> " + titleInCart);

        element = AmazonShoppingCartPage.getCartQuantiy(driver);
        qtyInCart = parseInt(element.getText());
        System.out.println("== Quantiy in Cart == " + qtyInCart);

        element = AmazonShoppingCartPage.getCartTotal(driver);
        cartSubTotal = (parseFloat(element.getText().substring(2)));
        System.out.println("== Cart Subtotal == " + cartSubTotal);

        System.out.println("== Calculated Cart Subtotal == " + calcCartTotal());

        AmazonShoppingCartPage.clickBtnDelete(driver).click();
        Thread.sleep(3000);

        element = AmazonShoppingCartPage.getClearedSubTotal(driver);
        String clearedSubTotal = element.getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(titleSelected,titleInCart, "Title in Cart is NOT Equal");
        softAssert.assertEquals(cartSubTotal, calcCartTotal(), "Cart Total NOT Equal" );
        softAssert.assertEquals(qtySelected,  qtyInCart, "Quantity in cart is NOT Equal to Selected quantity" );
        softAssert.assertEquals( clearedSubTotal, "$0.00", "Cart is NOT cleared, value is not $0.00" );

        softAssert.assertAll();

    }

    public static float calcCartTotal(){

        return  (qtyInCart * unitPrice);
    }

    public static float getUnitPriceInFloat (WebElement e){

        return (parseFloat(e.getText().substring(1)));

    }

}

