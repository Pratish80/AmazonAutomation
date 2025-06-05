package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import UtilityFile.ReadfromProperties;

public class SearchTestcase extends BaseClassAmazon {
	
	@Test(priority = 1)
	public void Nonexistingproduct() throws IOException {
		String data = ReadfromProperties.readproperty("nonexistingproduct");
		homepage.Searchdata(data);
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[contains(text(),'No results for')]")));
        assertTrue(result.isDisplayed(),"No results found"+data);

	}

}
