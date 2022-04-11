package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    private static WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //elementy do potwierdzenia zamówienia
    @FindBy(css = "[class=\"h1 card-title\"]")
    private WebElement orderConfirmation;

    //do powrotu do main page
    @FindBy(className = "account")
    private WebElement myAccountButton;

    //metody do potwiedzenia zamówienia

    //tekst z nagłówka powtwierdzenia
    public String getOrderConfirmation(){
        return orderConfirmation.getText();
    }

    //metody do powrotu do strony użytkownika
    public void clickMyAccount(){
        myAccountButton.click();
    }
}