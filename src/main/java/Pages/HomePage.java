package Pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    private final Page _page;
    public HomePage(Page page){
        this._page = page;
    }

    private String Elements = "Elements";
    private String TextBox = "Text Box";


    public boolean VerifyPageUrl(){
        return assertThat(_page).equals("https://demoqa.com");
    }

    public void clickElements(){ _page.getByText(Elements).click(); }

    public void clickTextBox(){ _page.locator("//li[@id='item-0'][.='Text Box']").click(); }
}
