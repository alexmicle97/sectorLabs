package Steps;

import Base.BaseSteps;
import Pages.HomePage;
import Pages.SearchResults;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.jodah.failsafe.internal.util.Assert;

/**
 * Author: Amicle
 */
public class Steps extends BaseSteps {
    public HomePage homePage;
    public SearchResults searchResults;


    public Steps() {
        super();
    }

    public void initialize() throws InterruptedException {
        initializeDriver();
        homePage = new HomePage();
    }


    @Given("The browser is opened")
    public void theBrowserIsOpened() throws InterruptedException {
        initialize();
    }

    @When("The {string} is typed as location")
    public void theIsTypedAsLocation(String location) throws InterruptedException {
        homePage.typeLocation(location);
    }

    @Then("the {string} option is selected")
    public void theOptionIsSelected(String option) {
        homePage.selectPurpose(option);
    }

    @When("the search button is pressed")
    public void theSearchButtonIsPressed() {
        searchResults = homePage.search();
    }

    @And("the list of articles is retrieved and check if all contains {string}")
    public void theListOfArticlesIsRetrievedAndCheckIfAllContains(String expectedText) {
        boolean result = searchResults.checkIfSearchMatchesExpectedResult(expectedText);
        Assert.isTrue(result, "The expected text is not matching desired search.");
    }

    @Then("the browser is closed")
    public void theBrowserIsClosed() {
        driver.quit();
    }

    @When("The user scrolls down to popular searches")
    public void theUserScrollsDownToPopularSearches() throws InterruptedException {
        homePage.scrollDownToPopularSearches();
    }

    @Then("the popular searches are visible to the user")
    public void theHyperlinksAreVisibleToTheUser() {
        homePage.waitUntilPopularSearchesIsVisible();
    }


    @When("the user clicks on the {string} search link")
    public void theUserClicksOnTheSearchLink(String linkName) {
        searchResults = homePage.retrievePopularSearchesLinksAndClickOnUserInputLink(linkName);
    }

    @When("the user clicks on rent button")
    public void theUserClicksOnRentButton() throws InterruptedException {
        homePage.clickOnRentButton();
    }

    @And("the popular searches are expanded")
    public void thePopularSearchesAreExpanded() {
        homePage.setExpandDubaiPopularSearches();
    }
}
