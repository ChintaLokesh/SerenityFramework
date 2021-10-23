package com.artium.pagefactory;



import org.joda.time.Seconds;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.time.temporal.ChronoUnit.SECONDS;


import net.serenitybdd.core.pages.PageObject;


public class ArtiumHomePage extends PageObject {
	
	@FindBy(xpath = "//a[text()='Login']" )
	WebElement loginLink;
	
	@FindBy(xpath="//*[text()='Sign up']")
	WebElement signUpLink;
	
	public ArtiumHomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickLoginLink()
	{
	  setImplicitTimeout(10, SECONDS);
	   loginLink.click();
	}

	public void clicksignUpLink()
	{
		setImplicitTimeout(10, SECONDS);
		signUpLink.click();
	}
	
}
