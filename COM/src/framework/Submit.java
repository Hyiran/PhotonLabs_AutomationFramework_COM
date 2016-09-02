package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Submit {
	
	public void submit(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		String Status=null;
		if (!viewPort.toUpperCase().equals("APPIUM")) {
			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
			//windowhandles.add(Windowid);
		}
		
		webelement.submit();
		try
		{
		
		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Pass";
			System.out.println(testCaseno+ "Submitted the page successfully");
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
		}
	
	} catch (Exception e) {
		if (report.toUpperCase().equals("TESTSTEP")) {
			Status = "Fail";
			System.out.println(testCaseno+" " +
					"Not able to submit the page");
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);
		}
		
		
	}
	}
}


