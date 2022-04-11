package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

public class NewOrderSteps {
    private WebDriver driver;

    @Given("^User opened(.*) page$")
    public void openMyStore(String url) {
        // Skonfiguruj sterownik przeglądarki.
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki.
        driver.manage().window().maximize();
        //Ustaw czas oczekiwania na ładowanie elementów.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        // Przejdź do strony.
        driver.get(url);

    }

    @And("^User clicks on SingIn button$")
    public void clickSingIn() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSingInButton();
    }

    @And("^User enters email (.*) and password (.*) and click SignIn button$")
    public void enterLoginAndPassword(String email, String password) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.logIn(email, password);

        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickMyStoreButton();
    }

    @When("^User finds Hummingbird Printed Sweater$")
    public void userFindsProduct() {
        //przejście do strony głównej po logowaniu
        MainPage mainPage = new MainPage(driver);
        //znalezienie produktu
        mainPage.addSweater();
    }


    @And("^User choose (.*), (.*), add product to the basket and goes to checkout$")
    public void addProduct(String size, String quantity) {
        //strona produktu
        HummingBirdSweaterProductPage productPage = new HummingBirdSweaterProductPage(driver);

        //wybór rozmiaru i ilości z parametru (L i 2 szt)
        productPage.addProductWithParameters("L", "2");
        productPage.clickAddToCart();
        ConfirmationPopUpPage confirmationPopUpPage = new ConfirmationPopUpPage(driver);

        //czekam na pojawienie się popUpa z potwierdzeniem.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalLabel")));

        //potwierdzenie w popUpie.

        confirmationPopUpPage.goToCheckout();

        //potwierdzenie w koszyku
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickProceededToCheckout();

    }

    @And("^User confirms address alias (.*)$")
    public void addressConfirmation(String alias) {
        OrderPage orderPage = new OrderPage(driver);

        Assert.assertEquals(alias, orderPage.getAddressAlias());

    }

    @And("^User choose delivery method Pick up in store, choose pay by Check and confirms order$")
    public void paymentAndDeliveryMethods() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickContinueButton();

        OrderPage orderPageDelivery = new OrderPage(driver);
        orderPageDelivery.clickDelivery();

        OrderPage orderPagePayment = new OrderPage(driver);
        orderPagePayment.paymentConfirmation();
    }

    @Then("^User sees order confirmation$")
    public void orderConfirmation() {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        Assert.assertEquals("\uE876YOUR ORDER IS CONFIRMED", orderConfirmationPage.getOrderConfirmation());
    }

    @And("^Screenshot is taken$")
    public void takeScreenShoot() throws Exception {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        //screenshot test.png
        OrderConfirmationPage.takeSnapShot(driver, "C://screenshot//test.png");

    }

    @And("^User goes back to account page and goes to order history$")
    public void toOrderHistory() {
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.clickMyAccount();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.toOrderHistory();
    }

    @And("^Browser is closed$")
    public void browserClosing() {
        driver.quit();
    }

}