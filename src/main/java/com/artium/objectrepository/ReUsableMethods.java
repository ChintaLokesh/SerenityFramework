package com.artium.objectrepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.pages.PageObject;

public class ReUsableMethods extends PageObject {

	String parentWindow;
	String childWindow;
	
	public void switchToChildWindow()
	{
		Set<String> windowHandles=getDriver().getWindowHandles();
		Iterator<String> it=windowHandles.iterator();
		while(it.hasNext())
		{
			parentWindow=it.next();
			childWindow=it.next();
		}
		getDriver().switchTo().window(childWindow);
	}
	
	public void switchToParentWindow()
	{
		Set<String> windowHandles=getDriver().getWindowHandles();
		Iterator<String> it=windowHandles.iterator();
		while(it.hasNext())
		{
			parentWindow=it.next();
			childWindow=it.next();
		}
		getDriver().switchTo().window(parentWindow);
	}
	
	
	public  void clickButtonUsingActionsClass(WebElement wb)
	{
		Actions act = new Actions(getDriver());
		act.moveToElement(wb).click().build().perform();
	}
	
}
