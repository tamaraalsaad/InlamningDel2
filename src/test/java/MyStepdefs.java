import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I open the register page in {}")
    public void iOpenTheRegisterPageIn(String browser) {

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("file:///C:/Users/tamar/Downloads/Register/Register.html");
    }

    private WebElement waitForVisible(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    @When("I fill in the register page form with{string} {string} {string} {string} {string}{string} {string} {string}")
    public void iFillInTheRegisterPageFormWith(String dateOfBirth,
                                               String firstName,
                                               String lastName, String email,
                                               String confirmEmail,
                                               String password, String confirmPassword,
                                               String acceptTerms) {

        WebElement dobInput = waitForVisible(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div/div/form/div[2]/div/div/input"));
        dobInput.clear();
        dobInput.sendKeys(dateOfBirth);
        dobInput.sendKeys(Keys.TAB);

        driver.findElement(By.id("member_firstname")).sendKeys(firstName);
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);
        if (Boolean.parseBoolean(acceptTerms)) {
            driver.findElement(By.xpath("//label[contains(.,'Terms and Conditions')]")).click();
            driver.findElement(By.xpath("//label[contains(.,'aged over 18')]")).click();
            driver.findElement(By.xpath("//label[contains(.,'Code of Ethics')]")).click();


        }
    }

    @And("I accept the Account Confirmation")
    public void iAcceptTheAccountConfirmation() {
    }

    @And("I red and accept to \\(applies to all Members)")
    public void iRedAndAcceptToAppliesToAllMembers() {
    }

    @And("I submit the registration form")
    public void iSubmitTheRegistrationForm() {

    }
    @And("I confirm and join")
    public void iConfirmAndJoin() {
        driver.findElement(By.cssSelector("input[value='CONFIRM AND JOIN']")).click();
    }


    @Then("I should see a success message {string}")
    public void iShouldSeeASuccessMessage(String A104955 ) {
        driver.get("file:///C:/Users/tamar/Downloads/Register/Success.html");
       WebElement successMessage  = driver.findElement(By.cssSelector("body > div > div.page-content-wrapper > div > div > h2"));

        assertEquals(A104955,successMessage.getText() );
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String arg0) {
    }
}





