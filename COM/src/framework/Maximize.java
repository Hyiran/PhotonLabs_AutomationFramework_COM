
package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Maximize {

	public void maximize(String viewPort, String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute, WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j, String report, String application, String startTm, String endTm,
			Set<String> windowhandles) throws InterruptedException, IOException, ParseException {
		String Status = null;
		try {
			Thread.sleep(1000);
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(testCaseno + " " + testCaseDescription + " --Failed");
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";
				Results.results(testCaseno, testCaseDescription, Status, viewPort, application, startTm, endTm, driver);
			}
		}
	}

}