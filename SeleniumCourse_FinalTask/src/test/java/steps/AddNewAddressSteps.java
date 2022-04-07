package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNewAddressSteps {

    private WebDriver driver;

    @Given("^Browser opened Main Page (.*)$")
    public void browserOpenedMainPage(String mainPAge) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.driver.manage().window().maximize();
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

        WebElement newAddress = driver.findElements(By.xpath("//i[@class = 'material-icons']")).get(3);
        newAddress.click();

    }

    @And("^User filled out address details (.*), (.*), (.*), (.*), (.*) and clicked saveButton$")
    public void userFilledOutAddressDetails(String alias, String address, String city, String postalCode, String phone) {

        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement postalCodeInput = driver.findElement(By.name("postcode"));
        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement saveButton = driver.findElement(By.cssSelector("button.btn.btn-primary.float-xs-right"));
        saveButton.click();

    }

    @Then("^Added address information should be (.*), (.*), (.*), (.*), (.*) and sees message confirmed$")
    public void addedAddressInformationShouldBe(String alias, String address, String city, String postalCode, String phone) {
        WebElement addressInfo = driver.findElements(By.xpath("//div[@class = 'address-body']")).get(1);
        addressInfo.getText();
        String successInfo = addressInfo.getText();
        assertEquals(alias + "\n" + "Jan Jankowski\n" + address + "\n" + city + "\n" + postalCode + "\n" + "United Kingdom\n" + phone, successInfo);
    }

    @And("^User clicked delete Button and sees message confirmed$")
    public void userClickedDeleteButtonAndSeesMessageConfirmed() {

        WebElement deleteButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]"));
        deleteButton.click();

    }
}
//            WebElement messageConfirm = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
//            messageConfirm.getText();
//            assertEquals(string, messageConfirm.getText());








