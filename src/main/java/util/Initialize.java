package util;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Initialize {
    public Playwright playwright;
    public Browser browser;
    public Page page;
    FileInputStream ip;
    public Properties prop;

    public void StartBrowser(String browserName, String url){
        playwright = Playwright.create();

        switch (browserName){
            case "chromium":
                browser = playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false).setSlowMo(10));
                break;
            case "chrome":
                browser = playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false).setChannel("chrome")
                                .setSlowMo(10));
                break;
            case "msedge":
                browser = playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false).setChannel("msedge")
                                .setSlowMo(10));
                break;
            case "firefox":
                browser = playwright.firefox()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false).setSlowMo(10));
                break;
            case "webkit":
                browser = playwright.webkit()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(false).setSlowMo(10));
                break;
            default:
                break;
        }

        page = browser.newPage(new Browser.NewPageOptions().setViewportSize(1800, 1080));
        page.navigate(url);
    }

    public void closeBrowser() {
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    File file = new File("./src/main/resources/config.properties"); //Path of properties
    FileInputStream fis = new FileInputStream(file); //Using fileinputstream to load the property file

    public Initialize() throws IOException {
        prop = new Properties();
        prop.load(fis);
    }

    public String getUrl() { return prop.getProperty("url"); }
}
