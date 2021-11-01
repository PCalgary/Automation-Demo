package stepDefinitions;

import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.github.bonigarcia.*;

public class LoginStepDefinition {

    private WebDriver driver;
    String APP_URL="https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page";
    String username="Testcodesample786";
    String password="12345678sB@";

    @Given("^Wikipedia application is opened$")
    public void open_application() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(APP_URL);

    }

    @When("^user entered credentials$")
    public void enter_credentials() {
        driver.findElement(By.name("wpName")).sendKeys(username);
        driver.findElement(By.name("wpPassword")).sendKeys(password);
    }


    @Then("^login button is clicked$")
    public void click_login_button() {
        driver.findElement(By.id("wpLoginAttempt")).click();
    }


    @Then("^validation should be done$")
    public void validate_and_close_application() {
        String loggedInUser = driver.findElement(By.xpath("//a[@dir='auto']")).getText();
        System.out.println(loggedInUser);
        Assert.assertEquals(loggedInUser, username);
         driver.quit();
    }

}


