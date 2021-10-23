package com.artium.objectrepository;




import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import com.artium.pagefactory.ArtiumHomePage;
import com.artium.pagefactory.BookUrSlotPage;
import com.artium.pagefactory.LoginPage;
import com.artium.pagefactory.LogoutPage;
import com.artium.pagefactory.SignUpPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class BusinessLibrary extends PageObject {

	public SignUpPage signUppageObj;
	public org.apache.log4j.Logger logger;
	public ArtiumHomePage artiumHomePageObj;
	public LoginPage loginPageObj;
	public ReUsableMethods reUsableMethodsObj;
	public LogoutPage logoutPageObj;
	public BookUrSlotPage bookUrSlotPageObj;
	public FileReader fr;
	public Properties propObj;
	
	public BusinessLibrary()
	{
		signUppageObj=new SignUpPage();
		artiumHomePageObj= new ArtiumHomePage();
		reUsableMethodsObj = new ReUsableMethods(); 
		loginPageObj=new LoginPage();
		logoutPageObj=new LogoutPage();
		bookUrSlotPageObj=new BookUrSlotPage();
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/log4j.properties");
		logger=Logger.getLogger("logs");
	}
	
	 /**
	   * This method is used to open web application.
	   * @author  Lokesh Chinta
	   * @version 1.0
	   * @since   2021-10-23
	   */
	
	public void openWebApp() throws IOException
	{
		fr=new FileReader(System.getProperty("user.dir")+"/config.properties");
		propObj=new Properties();
		propObj.load(fr);
		Serenity.takeScreenshot();
		logger.debug("Web Application is opened");
		getDriver().get(propObj.getProperty("URL"));
		Serenity.takeScreenshot();

	}
	
	/**
	   * This method is used to Navigate to Login Page.
	   * @author  Lokesh Chinta
	   * @version 1.0
	   * @since   2021-10-23
	   */
	
	public void navigateToLoginpage()
	{
		Serenity.takeScreenshot();
		artiumHomePageObj.clickLoginLink();
		logger.debug(" clicked on Login Button");
		reUsableMethodsObj.switchToChildWindow();
		logger.debug("Navigated to Child Window");
		Serenity.takeScreenshot();
	}
	
	/**
	   * This method is used to click sign up button.
	   * @author  Lokesh Chinta
	   * @version 1.0
	   * @since   2021-10-23
	   */
	
	public void clickSignUpButton()
	{
		Serenity.takeScreenshot();
		loginPageObj.clicksignUpLink();
		logger.debug("clicks on sign up link");
		Serenity.takeScreenshot();
	}
	
	/**
	   * This method is used to click Sign up and Continue Button.
	   * @author  Lokesh Chinta
	   * @version 1.0
	   * @since   2021-10-23
	   */
	
	public void clickSignUpAndContinueButton()
	{
		Serenity.takeScreenshot();
		reUsableMethodsObj.clickButtonUsingActionsClass(getDriver().findElement(By.xpath("//*[@type='submit']")));
		logger.debug("clicks on sign up link");
		Serenity.takeScreenshot();
	}
	
	/**
	   * This method is used to fill the fields in Sign Up Page.
	   * @author  Lokesh Chinta
	   * @version 1.0
	   * @since   2021-10-23
	   * @param firstName This is the first paramter to provide first name
	   * @param lastName  This is the second parameter to provide last name
	   * @param dob This is the third paramter to provide Date of Birth
	   * @param gender  This is the fourth parameter to provide gender
	   * @param mobileNumber This is the fifth paramter to provide mobileNumber
	   * @param email  This is the sixth parameter to provide email
	   * @param countryCode This is the seventh paramter to provide countryCode
	   * @param password  This is the eighth parameter to provide password
	   */
	
	public  void addsingUpFields(String firstName,String
			lastName,String dob,String gender,String mobileNumber,String email,String countryCode,String password)
	{
		Serenity.takeScreenshot();
		signUppageObj.selectCountryCode(countryCode);
		logger.debug(" user provided country code as "+countryCode);
		signUppageObj.setFirstName(firstName);
		logger.debug("user provided First Name as "+firstName);
		signUppageObj.setLastName(lastName);
		logger.debug("user provided Last Name as "+lastName);
		signUppageObj.setDOB(dob);
		logger.debug("user provided Date of Birth as "+dob);
		signUppageObj.setGender(gender);
		logger.debug("user provided Gender  as "+gender);
		signUppageObj.setMobileNumber(mobileNumber);
		logger.debug("user provided Mobile Number as "+mobileNumber);
		signUppageObj.setEmail(email);
		logger.debug("user provided Email as "+email);
		signUppageObj.setPassword(password);
		logger.debug("user provided Password as "+password);
		Serenity.takeScreenshot();
	}
	
	/**
	   * This method is used to click Login Using password.
	   * @author  Lokesh Chinta
	   * @version 1.0
	   * @since   2021-10-23
	   */
	public void clickLoginUsingPassword()
	{
		Serenity.takeScreenshot();
		loginPageObj.clickLoginUsingPasswordLink();
		logger.debug("user clicked on Login Using Password Link");
		Serenity.takeScreenshot();
	}
	
	/**
	   * This method is used to login to Application.
	   * @author  Lokesh Chinta
	   * @version 1.0
	   * @since   2021-10-23
	   */
	
	public void loginToApp(String username,String password)
	{
		Serenity.takeScreenshot();
		loginPageObj.inputUserEmail(username);
		logger.debug("user gives user email as "+username);
		loginPageObj.inputPassword(password);
		logger.debug("user gives password  as "+password);
		loginPageObj.clickLoginButton();
		Serenity.takeScreenshot();
		logger.debug("user clicked on Login Button");
	}
	
	/**
	   * This method is used to verify Book Ur Slot label .
	   * @author  Lokesh Chinta
	   * @version 1.0
	   * @since   2021-10-23
	   */
	
	public void verifyBookUrSlotLabel(String name)
	{
		Serenity.takeScreenshot();
		System.out.println(bookUrSlotPageObj.getBookurSlotLabel());
		System.out.println(name);
		assertEquals(bookUrSlotPageObj.getBookurSlotLabel(), name);
	}
	
	/**
	   * This method is used to logout to Application.
	   * @author  Lokesh Chinta
	   * @version 1.0
	   * @since   2021-10-23
	   */
	
	public void logout() throws InterruptedException
	{
		Serenity.takeScreenshot();
		bookUrSlotPageObj.clickLeftArrowLink();
		Serenity.takeScreenshot();
	}
	
}
