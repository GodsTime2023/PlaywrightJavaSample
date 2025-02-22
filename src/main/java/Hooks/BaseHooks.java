package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import util.Initialize;

import java.io.IOException;
import java.util.Random;

public class BaseHooks {
    private final ScenarioContext _scenarioContext;
    private final Initialize _initialize;

    public BaseHooks(Initialize initialize, ScenarioContext scenarioContext) {
        this._initialize = initialize;
        this._scenarioContext = scenarioContext;
    }

    @Before
    public void Start() throws IOException {
        _initialize.StartBrowser("chromium", _initialize.getUrl());
        _scenarioContext.setContext("page", _initialize.page); //Store the page instance
    }

    @After
    public void Shutdown(){
        _initialize.closeBrowser();
    }

    public int AddNumber(){ Random rand = new Random(); return rand.nextInt(999); }
}
