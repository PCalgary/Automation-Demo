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


public class SearchStepDefinition {

    private WebDriver driver;
    String APP_URL="https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page";
    String username="Testcodesample786";
    String password="12345678sB@";

    @Given("user is logged in to Wikipedia$")
    public void open_application() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(APP_URL);
          driver.findElement(By.name("wpName")).sendKeys(username);
        driver.findElement(By.name("wpPassword")).sendKeys(password);
         driver.findElement(By.id("wpLoginAttempt")).click();

    }

@When("^search string is entered$")
public void search_string() {
     driver.findElement(By.name("search")).sendKeys("Nalanda");
     driver.findElement(By.id("searchButton")).click();
}


    @Then("^validate search results$")
    public void validate_and_close_application() {
        String searchResultHeading = driver.findElement(By.id("firstHeading")).getText();
        System.out.println(searchResultHeading);
        Assert.assertEquals(searchResultHeading, "Nalanda");
         driver.quit();
    }

}


