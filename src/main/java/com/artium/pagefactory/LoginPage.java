package com.artium.pagefactory;

import static java.time.temporal.ChronoUnit.SECONDS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject {
	
	
	@FindBy(xpath="//*[text()='Sign up']")
	private WebElement signUpLink;
	
	@FindBy(xpath="//a[text()='Login Using Password']")
	private WebElement loginusingPasswordLink;
	
	@FindBy(id="UserEmailTxt")
	private WebElement userEmailText;
	
	@FindBy(id="UserPasswordTxtBxt")
	private WebElement userPasswordText;
	
	@FindBy(xpath="//*[@type='submit' and contains(text(),'Login')]")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[@type='submit']")
	public WebElement signUpAndContinueButton;
	
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clicksignUpLink()
	{
		setImplicitTimeout(10, SECONDS);
		signUpLink.click();
	}
	
	public void clickSignUpAndContinueButton()
	{
		setImplicitTimeout(10, SECONDS);
		signUpAndContinueButton.submit();
	}
	
	public void clickLoginUsingPasswordLink()
	{
		setImplicitTimeout(10, SECONDS);
		loginusingPasswordLink.click();
	}
	
	
	public void inputUserEmail(String text)
	{
		userEmailText.sendKeys(text);
	}
	
	public void inputPassword(String text)
	{
		userPasswordText.sendKeys(text);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
}
