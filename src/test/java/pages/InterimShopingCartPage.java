package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InterimShopingCartPage {

    private static WebElement element = null;

    public static WebElement goToShoppingCart(WebDriver driver){

        element = driver.findElement(By.cssSelector("body.a-m-us.a-aui_72554-c.a-aui_accordion_a11y_role_354025-c.a-aui_killswitch_csa_logger_372963-c.a-aui_launch_2021_ally_fixes_392482-c.a-aui_pci_risk_banner_210084-c.a-aui_preload_261698-c.a-aui_rel_noreferrer_noopener_309527-c.a-aui_template_weblab_cache_333406-c.a-aui_tnr_v2_180836-c.a-meter-animate:nth-child(2) div.a-container.a-color-alternate-background:nth-child(30) div.a-row.a-spacing-medium-plus.celwidget.sw-fixed-max-width-horizontal-center:nth-child(1) div.a-column.a-span12.sw-card-container.a-span-last:nth-child(2) div.a-section.a-padding-large.celwidget.sw-atc-conf-actions-wider div.a-section.a-spacing-base.a-padding-mini.celwidget:nth-child(1) span.a-button.a-spacing-top-base.a-button-span12.a-button-base.celwidget span.a-button-inner > a.a-button-text"));
        return element;

    }

}
