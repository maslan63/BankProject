package com.bank.pages;

import com.bank.utilities.BrowserUtils;
import com.bank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account_activity_link")
    public WebElement accountActivity;

    @FindBy(xpath = "//span[.='Account Summary']")
    public WebElement accountSummary;

    @FindBy(linkText = "Savings")
    public WebElement savings;

    @FindBy(linkText ="Brokerage")
    public WebElement brokerage;

    @FindBy(linkText ="Checking")
    public WebElement checking;

    @FindBy(linkText ="Credit Card")
    public WebElement creditCard ;

    @FindBy(linkText ="Loan")
    public WebElement loan;

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;




    public void verifyAccountDropdown(String option){

        Select select=new Select(accountDropdown);
        String firstSelectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option+ " is not displayed", option,firstSelectedOption);
    }

}
