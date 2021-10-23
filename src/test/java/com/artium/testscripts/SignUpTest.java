package com.artium.testscripts;



import java.io.IOException;

import com.artium.objectrepository.BusinessLibrary;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class SignUpTest extends BaseClass {


	public BusinessLibrary businessLibraryObj;
	@Before
	public void configure()
	{
		businessLibraryObj=BaseClass.getInstance();
	}
	
	@Given("User opens the Web Application")
	public void user_opens_the_web_application() throws IOException {
		
		businessLibraryObj.openWebApp();
	}

	@When("User navigates to Login Page")
	public void user_navigates_to_login_page() {
		
		businessLibraryObj.navigateToLoginpage();
	}

	@When("User clicks on Sign up button")
	public void user_clicks_on_sign_up_button() {
		
		businessLibraryObj.clickSignUpButton();
	}

	@When("User provides first name {string} last name {string} Birth Date {string} gender {string} mobile number {string} email {string} country code {string} password {string}")
	public void user_provides_first_name_last_name_birth_date_gender_mobile_number_email_password(String firstName,String
			lastName,String dob,String gender,String mobileNumber,String email,String countryCode,String password) throws InterruptedException {
		
		businessLibraryObj.addsingUpFields(firstName, lastName, dob, gender, mobileNumber, email,countryCode, password);
	}
	
	@When("clicks on Sign up and continue button")
	public void clicks_on_sign_up_and_continue_button() {
	  
		businessLibraryObj.clickSignUpAndContinueButton();
	}
	
	@Then("user lands to Book your slot web page {string}")
	public void user_lands_to_Book_your_slot_web_page(String name) throws InterruptedException {
		businessLibraryObj.verifyBookUrSlotLabel(name);
		
	}

	@Then("user logout to web Application")
	public void user_logout_to_web_Application() throws InterruptedException
	{
		businessLibraryObj.logout();
	}
	
}
