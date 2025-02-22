package Tests;

import Hooks.ScenarioContext;
import Pages.ElementsPage;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class ElementsStepDef {

    private final HomePage _homePage;
    private ElementsPage _elementPage;
    private final Page _page;
    String regPattern = "^[A-Z]{2}\\d{2}\\s[A-Z]{3}$";

    public ElementsStepDef(ScenarioContext _scenarioContext) throws IOException {
        this._page = (Page) _scenarioContext.getContext("page");
        this._homePage = new HomePage(_page);
        this._elementPage = new ElementsPage(_page);
    }

    @Given("I am on demo site")
    public void i_am_on_demoqa_site() {
        _homePage.VerifyPageUrl();
    }

    @When("I click Elements")
    public void i_click_elements() {
        _homePage.clickElements();
    }

    @Then("I am on Elements page")
    public void i_am_on_elements_page() {
        _elementPage.IsHeaderTextDisplayed();
        _page.waitForTimeout(2000);
    }
}