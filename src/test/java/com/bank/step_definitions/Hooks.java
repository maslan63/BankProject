package com.bank.step_definitions;

import com.bank.pages.LoginPage;
import com.bank.utilities.BrowserUtils;
import com.bank.utilities.ConfigurationReader;
import com.bank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    LoginPage loginPage = new LoginPage();
    @Before
    public void setUp(){
        System.out.println("\tThis is coming from BEFORE");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginWithValidInfo();
        BrowserUtils.waitFor(1);
        Driver.getDriver().navigate().back();
        BrowserUtils.waitFor(1);
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

    //Driver.closeDriver();
    }
}
