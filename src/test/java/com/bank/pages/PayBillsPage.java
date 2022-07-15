package com.bank.pages;

import com.bank.utilities.BrowserUtils;
import com.bank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PayBillsPage extends BasePage{

    public PayBillsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Pay Bills")
    public WebElement payBills;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayee;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInput;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInput;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountInput;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInput;

    @FindBy(id = "add_new_payee")
    public WebElement addBtn;

    @FindBy(id = "alert_content")
    public WebElement message;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrency;

    @FindBy(id = "pc_currency")
    public WebElement dropDown;

    @FindBy(xpath = "//input[@id='pc_amount']")
    public WebElement amount;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculate;

    @FindBy(id ="pc_inDollars_true")
    public WebElement usDollar;


    public void setAddNewPayee(String payeeName, String payeeAddress, String account, String payeeDetails){

        payeeNameInput.sendKeys(payeeName);
        payeeAddressInput.sendKeys(payeeAddress);
        accountInput.sendKeys(account);
        payeeDetailsInput.sendKeys(payeeDetails);
        addBtn.click();
    }

    public void purchaseCurrencyTab(){
        onlineBanking.click();
        goToHeadersPage("Account Summary");
        payBills.click();
        purchaseForeignCurrency.click();
    }
    public void currencies(List<String> list){

//        Select select = new Select(dropDown);
//        for (int i = 1; i < select.getOptions().size(); i++) {
//           list.add(select.getOptions().get(i).getText());
//        }
//        System.out.println(list);
        BrowserUtils.dropdownOptionsAsString(dropDown);
    }

    public void calculateWithoutCurrency(){
        amount.sendKeys("10");
        calculate.click();

    }

    public void calculateWithoutValue(){
        usDollar.click();
        calculate.click();
    }

}
