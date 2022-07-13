package com.bank.step_definitions;

import com.bank.pages.LoginPage;
import com.bank.pages.PayBillsPage;
import com.bank.utilities.BrowserUtils;
import com.bank.utilities.ConfigurationReader;
import com.bank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("Add New Payee tab")
    public void add_new_payee_tab() {

        new LoginPage().loginWithValidInfo();
        BrowserUtils.waitFor(1);
        Driver.getDriver().navigate().back();
        BrowserUtils.waitFor(1);
        payBillsPage.onlineBanking.click();
        payBillsPage.payBills.click();
        payBillsPage.addNewPayee.click();
        BrowserUtils.waitFor(1);
    }
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        payBillsPage.setAddNewPayee(dataTable.get("Payee Name"), dataTable.get("Payee Address"), dataTable.get("Account"), dataTable.get("Payee Details") );
        BrowserUtils.waitFor(1);

    }
    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_the_new_payee_the_law_offices_of_hyde_price_scharks_was_successfully_created_should_be_displayed() {

        String alert = "The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        Assert.assertEquals("The new payee The Law Offices of Hyde, Price & Scharks was successfully created.",payBillsPage.message.getText());
    }

}
