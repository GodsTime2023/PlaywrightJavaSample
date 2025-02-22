package Pages;

import com.microsoft.playwright.Page;
import dto.proto.WebForm;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ElementsPage {
    private Page _page;
    public ElementsPage(Page page){
        this._page = page;
    }

    private final String elementsHeaderText = "Elements";
    private final String textBoxHeaderText = "Text Box";
    private final String textBox = "Text Box";

    public void IsHeaderTextDisplayed(){
        assertThat(_page.getByText(elementsHeaderText)).isVisible();
    }

    public void ClickTextBox(){
        _page.locator(textBox).click();
    }

    public void IsHeaderTextOnTextBoxPageDisplayed(){
        assertThat(_page.locator("//h1")).isVisible();
    }

    public void CompleteForm(WebForm webForm){
        _page.locator("//*[@placeholder='Full Name']").fill(webForm.getFullName());
        _page.locator("//*[@placeholder='name@example.com']").fill(webForm.getEmail());
        _page.locator("//*[@placeholder='Current Address']").fill(webForm.getCurrentAddress());
        _page.locator("//*[@id='permanentAddress']").fill(webForm.getPermanentAddress());
    }
}
