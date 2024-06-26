package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

	WebDriver driver ;
	public OrderHistoryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="table tbody tr td:nth-child(3)")
	List<WebElement> productNames;
	
	public Boolean verifyOrderDisplay(String productName)
	{
		return productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		
	}

	
	
}
