package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
	
	
	public  void checkbox(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		
		
		String Status = null;
		String Windowid=null;
		try {
			
			
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				 Windowid = driver.getWindowHandle();
					driver.switchTo().window(Windowid);
					
			}
			Thread.sleep(1000);
		
		if(testData.toUpperCase().equals("CHECK"))
		{
			
			if(!webelement.isSelected())
				
				
			{
				webelement.click();
				
			}
		}
		else if(testData.toUpperCase().equals("UNCHECK"))
		{
			
			
			
			if(webelement.isSelected())
			{
				webelement.click();
			}
		}
		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Pass";
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
     	}
		
		}
		catch(Exception e)
		{
			//System.out.println(e.getMessage());
			
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
				
				
			}
		}
		
		
		
		
		
	}

	public  void checkbox(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			MobileElement element, String testData, String action,
			AppiumDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		
		
		String Status = null;
		String Windowid=null;
		try {
			
			
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				 Windowid = driver.getWindowHandle();
					driver.switchTo().window(Windowid);
					
			}
			Thread.sleep(1000);
		
		if(testData.toUpperCase().equals("CHECK"))
		{
			
			if(!element.isSelected())
				
				
			{
				//element.tap(1, 1);
				element.click();
			}
		}
		else if(testData.toUpperCase().equals("UNCHECK"))
		{
			
			
			
			if(element.isSelected())
			{
				//element.tap(1, 1);
				element.click();
			}
		}
		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Pass";
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
     	}
		
		}
		catch(Exception e)
		{
			//System.out.println(e.getMessage());
			
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
				
				
			}
		}
	}	
	
}
