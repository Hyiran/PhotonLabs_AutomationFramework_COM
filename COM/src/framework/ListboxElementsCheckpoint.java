package framework;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ListboxElementsCheckpoint {
	public void listboxElementsCheckpoint(String viewPort,
			String functionality, String driverExecute, String testCaseno,
			String testCaseDescription, String testCaseExecute,
			WebElement webelement, String testData, String action,
			WebDriver driver, String oldValue, int j,
			String report, String application, String startTm, String endTm,Set<String> windowhandles)
			throws IOException, ParseException {

		String Status = null;
		try {
			if (!viewPort.toUpperCase().equals("APPIUM")) {
				String Windowid = driver.getWindowHandle();
				driver.switchTo().window(Windowid);
				//windowhandles.add(Windowid);
			}
			Thread.sleep(2000);

			// WebElement ListElement=driver.findElement(By.tagName("select"));

			String[] Parts = testData.split(",");

			Select Select = new Select(webelement);
			List<WebElement> List = Select.getOptions();
            //int element=0;
			int counter = 0;
			for(int k=0;k<=Parts.length;k++)
			{
				
				for (int i = 0; i < List.size(); i++) {
					if (List.get(i).getText().equals(Parts[k])) {
						System.out.println("list Item " + i + " "
								+ List.get(i).getText() +" found");
						counter=counter+1;
					}
					else if(i==List.size())
					{
						System.out.println("List item "+List.get(i).getText()+ " not found in the list box");
						
					}
				}
				
			}
			
			

			if (counter == List.size()) {
				System.out
						.println("All the list items are displaying correctly");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Pass";

					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver);
				}

			} else {
				System.out
						.println("All the list items are not displaying correctly");
				if (report.toUpperCase().equals("TESTSTEP")) {
					Status = "Fail";

					Results.results(testCaseno, testCaseDescription, Status,
							viewPort, application, startTm, endTm, driver);
				}
			}
		} catch (Exception e) {
			if (report.toUpperCase().equals("TESTSTEP")) {
				Status = "Fail";

				Results.results(testCaseno, testCaseDescription, Status,
						viewPort, application, startTm, endTm, driver);
			}
		}
	}
}
