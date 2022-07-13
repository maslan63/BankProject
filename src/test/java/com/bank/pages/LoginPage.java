package com.bank.pages;

import com.bank.utilities.BrowserUtils;
import com.bank.utilities.ConfigurationReader;
import com.bank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="signin_button")
    public WebElement signinButton;

    @FindBy(id="user_login")
    public WebElement usernameInput;

     @FindBy(id="user_password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement messageForInvalidInfo;

    public void loginWithValidInfo(){
        signinButton.click();
        BrowserUtils.waitFor(1);
        String username= ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

    public void loginWithInvalidInfo(){
        signinButton.click();
        BrowserUtils.waitFor(1);
        usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.sendKeys("somepassword");
        loginBtn.click();

    }

    public void loginWithBlankInfo(){
        signinButton.click();
        BrowserUtils.waitFor(1);
        loginBtn.click();
    }

}