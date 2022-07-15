package com.bank.pages;

import com.bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactionPage extends BasePage {

    public FindTransactionPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id='aa_description']")
    public WebElement description;

    @FindBy(xpath = "//button[.='Find']")
    public WebElement find;

    @FindBy(xpath = "(//table[@class= 'table table-condensed table-hover'])[2]/tbody/tr/td[2]")
    public WebElement result;

    @FindBy(xpath = "//*[@id=\"filtered_transactions_for_account\"]/div")
    public WebElement noResult;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;
    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[1]")
    public List<WebElement> dates;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[3]")
    public List<WebElement> deposit;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td[4]")
    public List<WebElement> withdrawal;

    @FindBy(id = "aa_type")
    public WebElement type;

    @FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[2]/a")
    public WebElement findTransaction;

    public void types(String text){
        Select types = new Select(type);

        types.selectByValue(text);

    }


    //


}
