package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResendVaPage {
    private static final String URL1 = "https://www.wrike.com/resend-vb/";
    private static final String URL2 = "https://www.wrike.com/resend-va/";

    private static final String firstRadioXPath1 = "//div[@class='radio'][1]/label[@class='switch'][1]/button[@class='switch__button'][1]";
    private static final String secondRadioXPath1 = "//div[@class='radio'][2]/label[@class='switch'][5]/button[@class='switch__button'][1]";
    private static final String thirdRadioXPath1 = "//div[@class='radio'][3]/label[@class='switch'][2]/button[@class='switch__button'][1]";
    private static final String submitXPath1 = "//button[@class='submit wg-btn wg-btn--navy js-survey-submit'][1]";
    private final static String successXPath = "//div[@class='survey-success'][1]";


    private static final String allRadioCss = "label.survey-question-radio";
    private static final String submitCss = "button.submit.survey__submit.wg-btn.wg-btn--navy";
    private static final String successCss = "div.resend-page__cell--success";


    private final static String twitterXPath = "//li[@class='wg-footer__social-item'][1]";
    private final static String twitterLinkXPath = twitterXPath + "/a[1]";
    private final static String twitterImgCss = "div.wg-footer__social-block > div > ul > li:nth-child(1) > a > svg > use";

    private WebDriver driver;

    private WebElement firstRadioButton;
    private WebElement secondRadioButton;
    private WebElement thirdRadioButton;
    private WebElement submitButton;
    private WebElement successItem;

    @FindBy(xpath = twitterXPath)
    private WebElement twitterItem;

    @FindBy(xpath = twitterLinkXPath)
    private WebElement twiterLinkItem;

    @FindBy(css = twitterImgCss)
    private WebElement twitteImageItem;

    public ResendVaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void submit() {
        if (!driver.getCurrentUrl().equals(URL1)) {
            firstRadioButton = driver.findElement(By.xpath(firstRadioXPath1));
            secondRadioButton = driver.findElement(By.xpath(secondRadioXPath1));
            thirdRadioButton = driver.findElement(By.xpath(thirdRadioXPath1));
            submitButton = driver.findElement(By.xpath(submitXPath1));
            successItem = driver.findElement(By.xpath(successXPath));
        } else {
            List<WebElement> list = driver.findElements(By.cssSelector(allRadioCss));
            firstRadioButton = list.get(1);
            secondRadioButton = list.get(3);
            thirdRadioButton = list.get(8);
            submitButton = driver.findElement(By.cssSelector(submitCss));
            successItem = driver.findElement(By.cssSelector(successCss));
        }
    }

    public void setFirstRadioButton() {
        firstRadioButton.click();
    }

    public void setSecondRadioButton() {
        secondRadioButton.click();
    }

    public void setThirdRadioButton() {
        thirdRadioButton.click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public WebElement getSuccessItem() {
        return successItem;
    }

    public WebElement getTwitterItem() {
        return twitterItem;
    }

    public WebElement getTwiterLinkItem() {
        return twiterLinkItem;
    }

    public WebElement getTwitteImageItem() {
        return twitteImageItem;
    }
}
