package AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	public AmazonHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchbar;
	@FindBy(id="nav-search-submit-button")
	public WebElement Searchbtn;
	
	public void Searchdata(String Inputdata) {
		if (Inputdata == null || Inputdata.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Search input data is null or empty!");
        }
		searchbar.clear();
		searchbar.sendKeys(Inputdata);
		Searchbtn.click();
	}
	
		
}
