package com.artium.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.artium.objectrepository.ReUsableMethods;

import net.serenitybdd.core.pages.PageObject;

public class BookUrSlotPage extends PageObject {
	
	public ReUsableMethods reUsableMethodsObj;
	public BookUrSlotPage()
	{
		PageFactory.initElements(getDriver(), this);
		reUsableMethodsObj=new ReUsableMethods();
	}
	
	@FindBy(xpath="//div[contains(@class,'RegDemo5HeaderText')]")
	private WebElement bookUrSlotLabel;
	
	@FindBy(xpath="//*[contains(@class,'img-responsive leftArrow')]")
	private WebElement leftArrowLink;
	
	
	public String getBookurSlotLabel()
	{
		
		return(bookUrSlotLabel.getText());
	}

	public void clickLeftArrowLink()
	{
		reUsableMethodsObj.clickButtonUsingActionsClass(leftArrowLink);
	}
	
}
