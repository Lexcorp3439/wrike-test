import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.MainPage;
import pages.ResendVaPage;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class ScenarioTest {
    private final static String propertyKey = "webdriver.chrome.driver";
    private final static String propertyValue = "D:\\Projects\\IdeaProjects\\wrike-test\\drivers\\chromedriver.exe";

    private final static String URL = "https://www.wrike.com/";

    private final static String URLMatch = "resend";
    private final static String TwitterLink = "https://twitter.com/wrike";
    private final static String TwitterImagePath = "/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter";

    private WebDriver webDriver;
    private MainPage mainPage;
    private ResendVaPage resendVaPage;

    @Test
    @Description(value = "Test case scenario")
    public void scenarioTest() {
        System.setProperty(propertyKey, propertyValue);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        stepOne();
        stepTwo();
        stepThree();
        stepFour();
        stepFive();
        stepSix();

        webDriver.close();
    }

    @Step("Open url: https://www.wrike.com/")
    private void stepOne() {
        webDriver.get(URL);
    }

    @Step("Click \"Get started for free\" button near \"Login\" button;")
    private void stepTwo() {
        mainPage = new MainPage(webDriver);
        mainPage.clickToFreeStartAboutLogin();
    }

    @Step("Fill in the email field with random generated value of email with mask " +
            "“<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);")
    private void stepThree() {
        mainPage.enterBuisenessEmail(generateRandomWord().concat("+wpt@wriketask.qaa"));
    }

    @Step("Click on \"Create my Wrike account\" button + check with assertion that you are moved to the next page;")
    private void stepFour() {
        resendVaPage = mainPage.clickCreateWrikeAccount();
        boolean isRedirect = (new WebDriverWait(webDriver, 6))
                .until(ExpectedConditions.urlContains("resend"));
        assertTrue("Illegal page", isRedirect);
        resendVaPage.submit();
    }

    @Step("Fill in the Q&A section at the left part of page (like random generated answers) " +
            "+ check with assertion that your answers are submitted;")
    private void stepFive() {
        resendVaPage.setFirstRadioButton();
        resendVaPage.setSecondRadioButton();
        resendVaPage.setThirdRadioButton();
        resendVaPage.clickOnSubmitButton();

        WebElement success = (new WebDriverWait(webDriver, 5))
                .until(ExpectedConditions.visibilityOf(resendVaPage.getSuccessItem()));
        assertNotNull("Answers are not submitted",success);
    }

    @Step("Check that section \"Follow us\" at the site footer contains the \"Twitter\" button " +
            "that leads to the correct url and has the correct icon;")
    private void stepSix() {
        assertTrue("Twitter button is not displayed",resendVaPage.getTwitterItem().isDisplayed());
        assertEquals("Incorrect link",TwitterLink, resendVaPage.getTwiterLinkItem().getAttribute("href"));
        assertEquals("Incorrect image",TwitterImagePath, resendVaPage.getTwitteImageItem().getAttribute("xlink:href"));
    }

    private String generateRandomWord() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(6);
        for(int i = 0; i < 6; i++) {
            char tmp = (char) ('a' + r.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        return sb.toString();
    }
}
