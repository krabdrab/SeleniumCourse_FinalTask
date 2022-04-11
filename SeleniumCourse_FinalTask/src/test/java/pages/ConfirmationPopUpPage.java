package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPopUpPage {
    private static WebDriver driver;
    @FindBy(css = "[class=\"btn btn-primary\"]")
    private WebElement toCheckoutButton;

    public ConfirmationPopUpPage(WebDriver driver) {
        ConfirmationPopUpPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToCheckout() {

        toCheckoutButton.click();
    }
}
