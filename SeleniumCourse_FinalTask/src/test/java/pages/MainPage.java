package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private static WebDriver driver;
    //konstruktor dla obiektu strony głównej
    @FindBy(css = "[title=\"Log in to your customer account\"]")
    private WebElement singInButton;
    //wyszukiwanie elementów potrzebnych do zalogowanania
    @FindBy(css = "[alt=\"Brown bear printed sweater\"]")
    private WebElement sweaterIcon;

    //wyszukiwanie produktu

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //metody potrzebne do zalogowania

    public void clickSingInButton() {
        singInButton.click();
    }

    //metody do dodanie produktu do koszyka
    public void addSweater() {
        sweaterIcon.click();
    }
}