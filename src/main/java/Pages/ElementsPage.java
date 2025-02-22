package Pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ElementsPage {
    private Page _page;
    public ElementsPage(Page page){
        this._page = page;
    }

    private String ElementsHeaderText = "Elements";
    private String TextBox = "Text Box";

    public void IsHeaderTextDisplayed(){
        assertThat(_page.getByText(ElementsHeaderText)).isVisible();
    }

    public void ClickTextBox(){
        _page.getByText(TextBox).click();
    }
}
