package com.bank.step_definitions;

import com.bank.pages.LoginPage;
import com.bank.utilities.BrowserUtils;
import com.bank.utilities.ConfigurationReader;
import com.bank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    @Given("user on the home page")
    public void user_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {

        loginPage.loginWithValidInfo();
        BrowserUtils.waitFor(1);
        Driver.getDriver().navigate().back();
        BrowserUtils.waitFor(1);
    }

    @Then("user will be on the Personal Banking page")
    public void user_will_be_on_the_personal_banking_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Personal Banking"));

    }

    @Given("user logs in with invalid credentials")
    public void user_logs_in_with_invalid_credentials() {
        loginPage.loginWithInvalidInfo();


    }
    @Then("user will be seeing error message")
    public void user_will_be_seeing_error_message() {
        Assert.assertEquals("Login and/or password are wrong.",loginPage.messageForInvalidInfo.getText());
    }

    @Given("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginWithBlankInfo();
    }

}
