package com.artium.testscripts;



import org.openqa.selenium.WebDriver;
import com.artium.objectrepository.BusinessLibrary;
import net.thucydides.core.annotations.Managed;

public class BaseClass {

	@Managed
	WebDriver driver;
	

	public static final BusinessLibrary businessLibraryObj=new BusinessLibrary() ;
	
	BaseClass()
	{
		
	}
	
	public static BusinessLibrary getInstance() 
	{
		return businessLibraryObj;
	}
	
}
