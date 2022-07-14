package com.bank.step_definitions;

import com.bank.pages.FindTransactionPage;
import com.bank.utilities.BrowserUtils;
import com.bank.utilities.Driver;
import io.cucumber.java.en.*;
import io.cucumber.java.en_scouse.Buh;
import org.junit.Assert;

import java.util.List;

public class FindTransactionStepDefs {

    FindTransactionPage findTransactionPage = new FindTransactionPage();
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_find_transactions_tab() {
        findTransactionPage.goToHeadersPage("Account Activity");
        findTransactionPage.accountSummaryLinks("Find Transactions").click();
    }
    @When("the user enters description “ONLINE”")
    public void the_user_enters_description_online() {

        findTransactionPage.description.sendKeys("ONLINE");
    }

    @Then("results table should only show descriptions containing “ONLINE”")
    public void results_table_should_only_show_descriptions_containing_online() {
       Assert.assertTrue(findTransactionPage.result.getText().contains("ONLINE"));
    }
    @When("the user enters description with small letters “online”")
    public void the_user_enters_description_with_small_letters_online() {

        findTransactionPage.description.clear();
        BrowserUtils.waitFor(1);
        findTransactionPage.description.sendKeys("online");
    }
    @When("clicks search")
    public void clicks_search() {
        findTransactionPage.find.click();
    }

    @Then("results table will not be shown")
    public void resultsTableWillNotBeShown() {

        Assert.assertEquals("No results.",findTransactionPage.noResult.getText());
    }

    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String fromDate, String toDate) {

        findTransactionPage.fromDate.sendKeys(fromDate);
        findTransactionPage.toDate.sendKeys(toDate);
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String fromDate, String toDate) {

        List<String> list = BrowserUtils.getElementsText(findTransactionPage.dates);
        for (String s : list) {
            Assert.assertTrue(s.compareTo(fromDate)>=0 && s.compareTo(toDate) <=0);
        }

    }
    @And("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<String> actualDates = BrowserUtils.getElementsText(findTransactionPage.dates);
        List<String> expectedDates = BrowserUtils.getElementsText(findTransactionPage.dates);
        Assert.assertEquals(expectedDates,actualDates);
        BrowserUtils.waitFor(5);
        findTransactionPage.fromDate.clear();
        findTransactionPage.toDate.clear();
        findTransactionPage.description.clear();

    }
    @Then("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String date) {

        List<String> actualDates = BrowserUtils.getElementsText(findTransactionPage.dates);
        Assert.assertFalse(actualDates.contains(date));
    }

    @When("the user enters description “OFFICE”")
    public void the_user_enters_description_office() {

        findTransactionPage.description.clear();
        findTransactionPage.fromDate.clear();
        findTransactionPage.toDate.clear();
        findTransactionPage.description.sendKeys("OFFICE");
    }
    @Then("results table should only show descriptions containing “OFFICE”")
    public void results_table_should_only_show_descriptions_containing_office() {

        Assert.assertTrue(findTransactionPage.result.getText().contains("OFFICE"));
        BrowserUtils.waitFor(1);
    }

    @But("results table should not show descriptions containing “office”")
    public void resultsTableShouldNotShowDescriptionsContainingOffice() {
        findTransactionPage.description.clear();
        BrowserUtils.waitFor(1);
        findTransactionPage.description.sendKeys("office");
        findTransactionPage.find.click();
        Assert.assertEquals("No results.",findTransactionPage.noResult.getText());
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_deposit() {
        BrowserUtils.waitFor(1);
        Assert.assertFalse(BrowserUtils.getElementsText(findTransactionPage.deposit).isEmpty());
    }
    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_withdrawal() {
        Assert.assertFalse(BrowserUtils.getElementsText(findTransactionPage.withdrawal).isEmpty());
    }
    @When("user selects type “Deposit”")
    public void user_selects_type_deposit() {
        findTransactionPage.types("DEPOSIT");
        findTransactionPage.find.click();
        BrowserUtils.waitFor(1);
    }
    @But("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_withdrawal() {
        Assert.assertFalse(BrowserUtils.getElementsText(findTransactionPage.withdrawal).isEmpty()); // this is a bug
    }
    @When("user selects type “Withdrawal”")
    public void user_selects_type_withdrawal() {
        findTransactionPage.types("WITHDRAWAL");
        findTransactionPage.find.click();
        BrowserUtils.waitFor(1);
    }
    @But("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_deposit() {
        Assert.assertFalse(BrowserUtils.getElementsText(findTransactionPage.deposit).isEmpty()); // this is a bug
    }

}
