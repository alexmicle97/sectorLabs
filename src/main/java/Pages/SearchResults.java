package Pages;

import Base.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchResults extends BaseSteps {

    /**
     * Logger of the class.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(SearchResults.class);

    @FindBy(xpath = "//ul[@class='_357a9937']")
    WebElement articleUl;

    /**
     * SearchResults class constructor for initializing the page elements.
     */
    public SearchResults() {
        PageFactory.initElements(driver, this);
    }


    /**
     *
     * @returns a list of web elements.
     */
    public List<WebElement> getAllArticlesFromCurrentPage() {
        return articleUl.findElements(By.xpath("//li[@aria-label='Listing']//div[@aria-label='Location']"));
    }

    /**
     *
     * @param expectedResult used to compare the text from the web element with the text passed by the user.
     * @return true or false depending if the text matches with what user inputs.
     */
    public boolean checkIfSearchMatchesExpectedResult(String expectedResult) {
        boolean ok = true;
        List<WebElement> elementList = getAllArticlesFromCurrentPage();
        for (WebElement element : elementList) {
            ok = element.getText().contains(expectedResult);
            if (!ok) {
                LOGGER.debug("The following web element: " + element + " is not containing the word " + expectedResult);
                break;
            }
        }
        return ok;
    }
}
