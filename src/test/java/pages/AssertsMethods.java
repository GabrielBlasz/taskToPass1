package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssertsMethods extends BasePage {

    public AssertsMethods(WebDriver driver) {
        super(driver);
    }

    // sprawdzenie czy zalogowany poprawnie -działa

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement checkUser;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
    private WebElement SuccesAddedNewAddress;

    ///// sprawdzanie poprawności dodanego adresu

    //name

    @FindBy(css = "div.address-body")
    private WebElement checkAddresConfirmation;

    //address


    public String LoggedIn(){
        return checkUser.getText();

    }
//////////////////////////////////////////////////////////////////////////// paskudna pauza

    public void uglyPause(int time){

        try {
            Thread.sleep(time);
        }
            catch (InterruptedException e){
            e.printStackTrace();
            }

    }
    ///////////////////////////////////////////////////////////////////////////

    public String checkURL(){     // assercja do sprawdzenia adresu WWW
        return driver.getCurrentUrl();
    }

    public String checkConfirmationSaveAddress(){

        return SuccesAddedNewAddress.getText();
   }


   //////////assercje na sprawdzenie czy nowy adres się dobrze dodał

   public String getSubmitConfirmationMessage(){              ///name
        return checkAddresConfirmation.getText();
   }


    }



