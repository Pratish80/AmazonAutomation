package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AmazonPages.AmazonHomePage;
import UtilityFile.ReadfromProperties;

public class BaseClassAmazon {

	public static WebDriver driver;
	public AmazonHomePage homepage;

	@BeforeClass
	public void Precondition() throws InterruptedException, IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		homepage = new AmazonHomePage(driver);

	}

	@BeforeMethod
	public void searchfield() throws IOException {
		String data = ReadfromProperties.readproperty("nonexistingproduct");
		homepage.Searchdata(data);
	

	}


	@AfterClass
	public void Postcondition() {
		driver.quit();
	}
}
