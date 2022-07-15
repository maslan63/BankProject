package com.bank.step_definitions;

import com.bank.pages.PayBillsPage;
import com.bank.utilities.BrowserUtils;
import com.bank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_purchase_foreign_currency_cash_tab() {

        payBillsPage.purchaseCurrencyTab();
        BrowserUtils.waitFor(1);
    }
    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {

        payBillsPage.currencies(dataTable);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        payBillsPage.calculateWithoutCurrency();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        Driver.getDriver().switchTo().alert().accept();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

        payBillsPage.calculateWithoutValue();
    }


}
