package com.bank.step_definitions;

import com.bank.pages.AccountActivityPage;
import com.bank.pages.LoginPage;
import com.bank.utilities.BrowserUtils;
import com.bank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class AccountActivityPageStepDefs {
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    LoginPage loginPage = new LoginPage();
    @Given("the user is logged in")
    public void the_user_logged_in() {

    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnLinkOnTheAccountSummaryPage(String linkText) {

        loginPage.goToHeadersPage("Account Summary");
        accountActivityPage.accountSummaryLinks(linkText).click();
    }

    @Then("the {string} page should be displayed")
    public void thePageShouldBeDisplayed(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_savings_selected(String string) {

        accountActivityPage.verifyAccountDropdown(string);

    }


}
