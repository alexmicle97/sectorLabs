package Pages;

import Base.BaseSteps;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * author: Amicle
 */
public class HomePage extends BaseSteps {

    @FindBy(xpath ="/html/body/div[2]/header/div[4]/div/div[2]/div/div[1]/div[2]/div/div/ul/input")

    WebElement location;

    @FindBy(xpath = "(//*[name()='path'][@class='cls-1'])[1]")
    WebElement purpose;

    @FindBy(xpath = "/html/body/div[2]/header/div[4]/div/div[2]/div/div[2]/a")
    WebElement searchButton;


    /**
     * HomePage constructor for initializing the page web elements.
     */
    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    /**
     *
     * @param location used for storing the location name.
     * method used to inserting the location text passed by the user into the location web element.
     */
    public void typeLocation(String location) throws InterruptedException {
        waitUntilElementIsVisible(this.location);
        this.location.sendKeys(location);
        Thread.sleep(5000);
        this.location.sendKeys(Keys.RETURN);
    }

    /**
     *
     * @param purpose used to determine if the property is for rent or buy.
     * method used for selecting from the listbox the property passed by the user.
     */
    public void selectPurpose(String purpose) {
        waitUntilElementIsClickable(this.purpose);
        WebElement buy = driver.findElement(By.xpath("/html/body/div[3]/header/div[4]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div[1]/div/span[1]/button"));
        WebElement rent = driver.findElement(By.xpath("/html/body/div[3]/header/div[4]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div[1]/div/span[2]/button"));
        if (purpose.equals("rent")) rent.click();
        else buy.click();
    }

    /**
     * method used to wait until an element is visible on the page.
     * @param webElement the web element passed in order to wait for its visibility.
     */

    public void waitUntilElementIsVisible(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * @param element used to wait until the element passed is clickable.
     */
    public void waitUntilElementIsClickable(WebElement element){
        Actions builder = new Actions(driver);
        builder.click(element).build().perform();
    }

    /**
     *
     * @param xpath string passed as xpath.
     * method used to wait until the passed xpath element is clickable.
     */
    public void waitUntilElementIsClickableAndClick(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    /**
     * method used for clicking the find button from the home page.
     * @return the SearchResults page.
     */
    public SearchResults search(){
        waitUntilElementIsClickableAndClick("/html/body/div[4]/header/div[4]/div/div[2]/div/div[2]/a");
        return new SearchResults();
    }
}