package com.artium.testscripts;

import com.artium.objectrepository.BusinessLibrary;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest extends BaseClass {

	public BusinessLibrary businessLibraryObj;
	
	@Before
	public void configure()
	{
		businessLibraryObj=BaseClass.getInstance();
	}
	
	@When("User clicks on Login Using Password Link")
	public void user_clicks_on_login_using_password_link() {
	 
		businessLibraryObj.clickLoginUsingPassword();
		
	}
	
	@Then("user login to Application using email {string} and password {string}")
	public void user_login_to_application_using_email_and_password(String username, String password) {
		
		businessLibraryObj.loginToApp(username, password);
	}
	
}
