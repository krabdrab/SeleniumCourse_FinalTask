package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddNewAddressSteps {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
    }

    @When("^Browser opened Main Page (.*)$")
    public void browserOpenedMainPage(String mainPAge) {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get(mainPAge);

    }

    @When("^User clicked button signIn$")
    public void userClickedButtonSignIn() {

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signInButton.click();
    }

    @And("^User was logged in  after filled correct email and valid password$")
    public void userWasLoggedInAfterFilledCorrectEmailAndValidPassword() {

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("jan.jakowski@silesia.pl");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123!@#Qwe");

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    @And("^User clicked button address$")
    public void userClickedButtonAddress() {

        WebElement addressButton = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]"));
        addressButton.click();
    }

    @And("^User clicked button create new address$")
    public void userClickedButtonCreateNewAddress() {

        WebElement createNewAddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span"));
        createNewAddress.click();
    }


    @And("^User filled out address details : (.*), (.*), (.*),(.*),(.*) and clicked saveButton$")
    public void userFilledOutAddressDetailsAliasAddressPostalCodeCountryPhoneAndClickedSaveButton(String alias, String address, String city, String postalCode, String phone) {

        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.click();
        aliasInput.sendKeys(alias);

        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.click();
        addressInput.sendKeys(address);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.click();
        cityInput.sendKeys(city);

        WebElement postalCodeInput = driver.findElement(By.name("postcode"));
        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.click();
        phoneInput.sendKeys(phone);

        WebElement saveButton = driver.findElement(By.cssSelector("button.btn.btn-primary.float-xs-right"));
        saveButton.click();
    }

//    @Then("^User sees a confirmation message \"([^\"]*)\"$")
//    public void userSeesAConfirmationMessageAdded() {
//
//        WebElement message = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article"));
//        message.getText();
//    }

    @And("^User clicked button delete$")
    public void clickedButtonDelete() {

        WebElement deleteButton = driver.findElement(By.cssSelector("#address-22737 > div.address-footer > a:nth-child(2)"));
        deleteButton.click();

    }

//    @Then("^User sees a confirmation message \"([^\"]*)\"$")
//    public void userSeesAConfirmationMessageDeleted() {
//
//        WebElement message = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article"));
//        message.getText();
//    }
}




