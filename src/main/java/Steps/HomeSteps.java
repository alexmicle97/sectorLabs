package Steps;

import Base.BaseSteps;
import Pages.HomePage;
import Pages.SearchResults;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.jodah.failsafe.internal.util.Assert;

public class HomeSteps extends BaseSteps {
    public HomePage homePage;
    public SearchResults searchResults;


    public HomeSteps() {
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

    @Then("the search page is visible")
    public void theSearchPageIsVisible() {

    }

    @And("the list of articles is retrieved and check if all contains {string}")
    public void theListOfArticlesIsRetrievedAndCheckIfAllContains(String expectedText) {
        boolean result = searchResults.checkIfSearchMatchesExpectedResult(expectedText);
        Assert.isTrue(result, "The expected text is not matching desired search.");
    }
}
