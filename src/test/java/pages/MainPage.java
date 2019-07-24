package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final static String URL = "https://www.wrike.com/";
    private final static String starterButtonXPath = "//div[@class='r'][1]/*/button[@class='wg-header__free-trial-button wg-btn wg-btn--green']";
    private final static String enterInputXPath = "//input[@class='wg-input modal-form-trial__input'][1]";
    private final static String createButtonXPath = "//button[@class='wg-btn wg-btn--blue modal-form-trial__submit'][1]";


    private WebDriver driver;

    @FindBy(xpath = starterButtonXPath)
    private WebElement getStartedForFreeButton;

    @FindBy(xpath = enterInputXPath)
    private WebElement enterBusinessEmailInput;

    @FindBy(xpath = createButtonXPath)
    private WebElement createWrikeAccountButton;



    public MainPage(WebDriver driver) {
        if (!driver.getCurrentUrl().equals(URL)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void clickToFreeStartAboutLogin() {
        getStartedForFreeButton.click();
    }

    public void enterBuisenessEmail(String email) {
        enterBusinessEmailInput.sendKeys(email);
    }

    public ResendVaPage clickCreateWrikeAccount() {
        createWrikeAccountButton.click();
        return new ResendVaPage(driver);
    }
}
