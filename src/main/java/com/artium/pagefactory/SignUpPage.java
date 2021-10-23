package com.artium.pagefactory;

import java.util.List;

import org.jruby.RubyIO.Sysopen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.pages.PageObject;


public class SignUpPage  extends PageObject{
	
	@FindBy(xpath="//div[div[input[@id='RegDemo2NameTxtBox']]]/div[1]/input")
	public WebElement firstNameTextBox;
	
	@FindBy(xpath="//div[div[input[@id='RegDemo2NameTxtBox']]]/div[2]/input")
	public WebElement lastNameTextBox;
	
	@FindBy(xpath="//*[@viewBox='0 0 24 24']")
	public WebElement dob;
	
	@FindBy(xpath="//*[contains(@id,'mat-calendar-button')]")
	public WebElement calenderButton;
	
	@FindBy(xpath="//*[@class='mat-calendar-body']/tr[1]/td")
	public WebElement calenderMonth;
	
	@FindBy(xpath="//tbody[@class='mat-calendar-body']//td/div[1]")
	public List<WebElement> calenderDate;
	
	@FindBy(xpath="//tbody[@class='mat-calendar-body']//td/div[1]")
	public List<WebElement> calenderYearList;
	
	
	@FindBy(xpath="//*[contains(@class,'mat-calendar-arrow')]")
	public WebElement yearArrowIcon;
	
	@FindBy(xpath="//tbody[@class='mat-calendar-body']//tr/td/div[1]")
	public List<WebElement> MonthList;
	
	@FindBy(xpath ="//*[@aria-label='Previous 20 years']")
	public WebElement previousArrowIcon;
	
	@FindBy(xpath="//label")
	public List<WebElement> genderOptions;
	
	@FindBy(xpath="//input[@id='RegDemo2MobileTxtBox']")
	public WebElement phoneTextField;
	
	@FindBy(id="RegDemo2EmailBox")
	public WebElement emailId;
	
	@FindBy(id="UserPasswordTxtBxt")
	public WebElement passwordTextField;
	
	@FindBy(xpath="//button[text()='Sign up and continue']")
	public WebElement signUpAndContinue;
	
	@FindBy(xpath="//select[contains(@class,'drpDownRegDemo2Select')]")
	public WebElement countryCodeSelectDropDown;
	
	@FindBy(xpath="//select[contains(@class,'drpDownRegDemo2Select')]/option")
	public WebElement countryCodeSelectDropDownOptions;
	
	public SignUpPage()
	{
		PageFactory.initElements(getDriver(), this);
	}

	public void setFirstName(String text)
	{
		firstNameTextBox.sendKeys(text);
	}
	
	public void setLastName(String text)
	{
		lastNameTextBox.sendKeys(text);
	}
	
	public void setDOB(String text)
	{
		dob.click();
		String expectedDob[]=text.split("-");
		
		if(!calenderButton.getText().contains(expectedDob[2]))
		{
			yearArrowIcon.click();
			
			do {
			if(Integer.parseInt(calenderYearList.get(0).getText())>Integer.parseInt(expectedDob[2]))
				previousArrowIcon.click();
			}while(!getDriver().findElement(By.xpath("//*[contains(text(),"+expectedDob[2]+")]")).isDisplayed());
		}	

		selectCalenderValue(calenderYearList,expectedDob[2]);
		selectCalenderValue(MonthList,expectedDob[1]);
		selectCalenderValue(calenderDate,expectedDob[0]);
	}
	
	public void selectCalenderValue(List<WebElement> element,String expectedValue)
	{
		for(WebElement wle:element)
		{
			if(wle.getText().equalsIgnoreCase(expectedValue))
			{
				wle.click();
				break;
			}
		}
	}
	
	public void setGender(String expectedValue)
	{
		
		for(WebElement wle:genderOptions)
		{
			if(wle.getText().contains(expectedValue))
			{
				wle.click();
				break;
			}
		}
	}
	
	public void setMobileNumber(String phoneNumber)
	{
		phoneTextField.sendKeys(phoneNumber);
	}
	
	
	public void setEmail(String emailID)
	{
		emailId.sendKeys(emailID);
	}
	
	public void setPassword(String password)
	{
		passwordTextField.sendKeys(password);
	}
	
	public void clickSignUpAndContinue()
	{
		signUpAndContinue.click();
	}
	
	public void selectCountryCode(String code)
	{
		countryCodeSelectDropDown.click();
		Select selObj=new Select(countryCodeSelectDropDown);
		
		List<WebElement> selList=selObj.getOptions();
		selList.size();
		
		for(WebElement wb:selList)
		{
			if(wb.getText().contains(code))
			{
				wb.click();
				break;
			}
		}
		
		
	}
	
}
