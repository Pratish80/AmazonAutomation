package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExistingproductTestcase extends BaseClassAmazon{
	@Test(dataProvider = "existingproduct",priority = 2)
	public void ExistingProduct(String productName) throws IOException {
		homepage.Searchdata(productName);
		WebElement res=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
		String text =res.getText();
		assertTrue(text.toLowerCase().contains(productName.toLowerCase()),"Actual product not found"+text);
	}
	@DataProvider(name="existingproduct")
	public Object[][]provider(){
		return new Object[][] {
			{"Laptop"},{"Headphones"},{"Speaker"}
		};
		
	}
}
