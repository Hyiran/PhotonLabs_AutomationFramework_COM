package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParagraphCheckpoint {
	
	
	public static void paragraphCheckpoint(String viewPort, String functionality,
			String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver,  String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles) throws IOException, ParseException
	{
		String Status = null;
		try {
			
			System.out.println(testCaseno+" "+testCaseDescription);
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
			    driver.switchTo().window(Windowid);
		
			}

			
			Thread.sleep(500);
		
			
			String actualText=webelement.getText().replace("\\r\\n|\\r|\\n", "");
			String expectedText=testData.replace("\\r\\n|\\r|\\n", "");
			
			System.out.println(actualText);
			System.out.println(expectedText);
			System.out.println(actualText.length());
			System.out.println(actualText.length());
			
			if (actualText.equals(expectedText)) {
				System.out.println(testCaseno+" "+testCaseDescription+"--PASS");

				Status = "Pass";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);

			} else {
				System.out.println(testCaseno+" "+testCaseDescription+"--FAIL");
				Status = "Fail";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}

		} catch (Exception e) {

			Status = "Fail";
			System.out.println(testCaseno+" "+testCaseDescription+"--Not able to compare the text--FAIL");
			Results.results(testCaseno, testCaseDescription, Status,
					viewPort, application, startTm, endTm, driver);

		}
	}

}
