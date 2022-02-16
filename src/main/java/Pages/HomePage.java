package Pages;

import Base.BaseSteps;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

/**
 * author: Amicle
 */
public class HomePage extends BaseSteps {

    private static Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "/html/body/div[2]/header/div[4]/div/div[2]/div/div[1]/div[2]/div/div/ul/input")

    WebElement location;

    @FindBy(xpath = "(//*[name()='path'][@class='cls-1'])[1]")
    WebElement purpose;

    @FindBy(xpath = "/html/body/div[2]/main/div[5]/div/div[2]/div[2]/div/div/div[2]")
    WebElement rentButton;

    @FindBy(css = "#body-wrapper > main:nth-child(3) > div:nth-child(5)")
    WebElement main;

    @FindBy(css = "body > div:nth-child(3) > main:nth-child(3) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3)")
    WebElement expandSearches;

    /**
     * HomePage constructor for initializing the page web elements.
     */
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * @param location used for storing the location name.
     *                 method used to inserting the location text passed by the user into the location web element.
     */
    public void typeLocation(String location) throws InterruptedException {
        waitUntilElementIsVisible(this.location);
        this.location.sendKeys(location);
        Thread.sleep(5000);
        this.location.sendKeys(Keys.RETURN);
    }

    /**
     * @param purpose used to determine if the property is for rent or buy.
     *                method used for selecting from the listbox the property passed by the user.
     */
    public void selectPurpose(String purpose) {
        clickOnWebElementUsingAction(this.purpose);
        WebElement buy = driver.findElement(By.xpath("/html/body/div[3]/header/div[4]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div[1]/div/span[1]/button"));
        WebElement rent = driver.findElement(By.xpath("/html/body/div[3]/header/div[4]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div[1]/div/span[2]/button"));
        if (purpose.equals("rent")) rent.click();
        else buy.click();
    }

    /**
     * method used to wait until an element is visible on the page.
     *
     * @param webElement the web element passed in order to wait for its visibility.
     */

    private void waitUntilElementIsVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * @param element used to click the passed element.
     */
    private void clickOnWebElementUsingAction(WebElement element) {
        Actions builder = new Actions(driver);
        builder.click(element).build().perform();
    }


    /**
     * @param xpath string passed as xpath.
     * method used to wait until the passed xpath element is clickable.
     */
    private void waitUntilElementIsClickableAndClickByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    /**
     * method used to expand the popular searches(click on view all).
     */
    public void setExpandDubaiPopularSearches() {
        waitUntilElementIsClickableAndClickByXpath("/html/body/div[2]/main/div[5]/div/div[2]/div[1]/div[2]/div/div[1]/div[2]");
    }

    /**
     * @param xpath path of the web element for identifying it's position.
     */
    private void waitUntilElementIsVisibleByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    /**
     * method used for clicking the find button from the home page.
     *
     * @return the SearchResults page.
     */
    public SearchResults search() {
        waitUntilElementIsClickableAndClickByXpath("/html/body/div[4]/header/div[4]/div/div[2]/div/div[2]/a");
        return new SearchResults();
    }

    /**
     * Method used to scroll down until main tag is visible.
     */
    public void scrollDownToPopularSearches() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", main);
        waitUntilElementIsVisible(main);
    }

    /**
     * Method used to wait until the popular searches section is visible
     */
    public void waitUntilPopularSearchesIsVisible() {
        waitUntilElementIsVisibleByXpath("/html/body/div[2]/main/div[5]/div/div[2]/div[1]/div[1]/div");
    }

    /**
     * @param link name of the link to be clicked
     * @return after click a new searchResult page, as the page is changed by click.
     */
    public SearchResults retrievePopularSearchesLinksAndClickOnUserInputLink(String link) {
        List<WebElement> popularSearches = driver.findElements(By.xpath("/html/body/div[2]/main/div[5]/div/div[2]/div[1]/div[2]/div/div//li/a"));
        for (WebElement element : popularSearches) {
            if (element.getText().equals(link)) {
                element.click();
                break;
            }
        }
        return new SearchResults();
    }

    /**
     * Method used to click on rent button.
     */
    public void clickOnRentButton() {
        rentButton.click();

    }
}