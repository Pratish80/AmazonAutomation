package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import UtilityFile.ReadfromProperties;

public class Removecartproduct extends BaseClassAmazon {
	@Test
	public void removeprodut() throws IOException {
		String Inputdata = ReadfromProperties.readproperty("existing_product");
		homepage.Searchdata(Inputdata);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement fourth_Product = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@data-component-type='s-search-result'])[4]//h2")));
		fourth_Product.click();

		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		WebElement addtoCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
		addtoCartBtn.click();
		String cartUrl = ReadfromProperties.readproperty("carturl");
		driver.get(cartUrl);
		WebElement deleteButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-icon a-icon-small-trash']")));
		deleteButton.click();
		WebElement emptyMsg = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your Amazon Cart is empty')]")));
		if (emptyMsg.isDisplayed()) {
			System.out.println("Product removed successfully. Cart is now empty.");
		} else {
			System.out.println("Cart is not empty after deletion.");
		}
	}
}
