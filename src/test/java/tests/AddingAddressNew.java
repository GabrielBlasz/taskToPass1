package tests;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddinAddressPage;
import pages.AssertsMethods;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AddingAddressNew {

    private WebDriver driver;

    @Given("the user is on the page with adding a new address")
    public void SetUpBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        LoginPage loginUser = new LoginPage(driver);
        loginUser.loginAs();

    }

    @When("presses the create address button")
    public void goToTheAdressTab() {

        AssertsMethods checkWww = new AssertsMethods(driver);
        assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=address", checkWww.checkURL());
    }

    @Then("^fill in the form with data \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void AddFormAddress(String alias, String address, String postalCode, String city, String country, String phone) {
        AddinAddressPage newAddresPage = new AddinAddressPage(driver);
        newAddresPage.submmittingAddres(alias, address, postalCode, city, country, phone);

        AssertsMethods checkSuccesCreateNewAddress = new AssertsMethods(driver);
        assertEquals("Address successfully added!", checkSuccesCreateNewAddress.checkConfirmationSaveAddress());



    }



    @And("check if the given data is correct")
    public void checkNewCreateAddres() {

        AssertsMethods nameAdded = new AssertsMethods(driver);
        Assert.assertEquals("Adam Adam", nameAdded.checkNameAdded());




    }
}












