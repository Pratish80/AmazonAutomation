package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import UtilityFile.ReadfromProperties;

public class AddToCartTest extends BaseClassAmazon {
@Test
public void addProductfourth() throws IOException {
	String Inputdata=ReadfromProperties.readproperty("existing_product");
	homepage.Searchdata(Inputdata);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement fourth_Product = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("(//div[@data-component-type='s-search-result'])[4]//h2")));
    fourth_Product.click();
    
//    WebElement addtoCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
//            By.id("add-to-cart-button")));
//        addtoCartBtn.click();
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Now click Add to Cart
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@name='submit.add-to-cart']")));
        addToCartBtn.click();
        String cartUrl = ReadfromProperties.readproperty("carturl");
        driver.get(cartUrl);
        
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("quantity")));
            Select quantitySelect = new Select(quantity);
            quantitySelect.selectByVisibleText("2");
            String selectedQuantity = quantitySelect.getFirstSelectedOption().getText().trim();
            assertEquals(selectedQuantity, "2", "Expected quantity in cart to be 2");
            
            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(@class,'sc-price')]")));
                String price = priceElement.getText().trim();
				assertTrue(!price.isEmpty(), "Price not found for product in cart");
				 System.out.println("Product added to cart");
			        System.out.println("   - Quantity: " + selectedQuantity);
			        System.out.println("   - Price: " + price);

}

}
