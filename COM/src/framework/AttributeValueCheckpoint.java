package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AttributeValueCheckpoint {
	
	public void attributeValueCheckpoint(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application,String startTm,String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		
		String Status=null;
		
		
		
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			
			String[] values=testData.split(",");
            String toolTip=webelement.getAttribute(values[0]);
			
            if(toolTip.equals(values[1]))
			{
				System.out.println(testCaseno+" "+testCaseDescription+" --Pass");
				Status = "Pass";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
			else
			{
				Status = "Fail";
                System.out.println(testCaseno+" "+testCaseDescription+" --Fail");
                Results.results(testCaseno, testCaseDescription, Status,
    					viewPort, application, startTm, endTm, driver);
			}

		} catch (Exception e) {
            System.out.println(testCaseno+" "+testCaseDescription+" --ERROR");
			Status = "Fail";
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);

		}
		
		
	}

}
