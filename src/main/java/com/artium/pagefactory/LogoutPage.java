package com.artium.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.artium.objectrepository.ReUsableMethods;

import net.serenitybdd.core.pages.PageObject;

public class LogoutPage extends PageObject {

	public ReUsableMethods reUsableMethodsObj;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right dropdownMenuBox show']//*[contains(text(),'Logout')]")
	private WebElement logoutButton;
	
	@FindBy(xpath="//a[@class='txt-decor-none']/span")
	private WebElement userProfileButton;
	
	public LogoutPage()
	{
		PageFactory.initElements(getDriver(), this);
		reUsableMethodsObj=new ReUsableMethods();
	}
	
	public void clickLogoutButton() throws InterruptedException
	{
		getDriver().wait(5000);
		reUsableMethodsObj.clickButtonUsingActionsClass(logoutButton);
	}
	
	public void clickUserProfileButton() throws InterruptedException
	{
		getDriver().wait(5000);
		reUsableMethodsObj.clickButtonUsingActionsClass(userProfileButton);
	}
	
}
