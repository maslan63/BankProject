package com.bank.pages;

import com.bank.utilities.BrowserUtils;
import com.bank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {


    @FindBy(xpath = "//strong[.='Online Banking']")
    public WebElement onlineBanking;

    @FindBy(xpath = "//span[@class='headers']")
    public List<WebElement> headersLink;

    public WebElement accountSummaryLinks(String linkText) {

        return Driver.getDriver().findElement(By.linkText(linkText));
    }

    public void goToHeadersPage(String headers){
        onlineBanking.click();
        BrowserUtils.waitFor(2);
        for (WebElement webElement : headersLink) {
            if (webElement.getText().equals(headers)) {
                webElement.click();
            }
        }
    }
}
