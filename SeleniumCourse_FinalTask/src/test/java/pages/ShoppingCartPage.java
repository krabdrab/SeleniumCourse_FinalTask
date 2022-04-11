package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private static WebDriver driver;
    public ShoppingCartPage(WebDriver driver) {
        ShoppingCartPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //elementy do potwierdzenia zakupu
    @FindBy(css = "[href=\"https://mystore-testlab.coderslab.pl/index.php?controller=order\"]")
    private WebElement proceededToCheckoutButton;

    //metody do potwierdzenia zakupu
    public void clickProceededToCheckout() {
        proceededToCheckoutButton.click();
    }

}
