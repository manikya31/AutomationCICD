package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.ProductCheckoutPage;
import rahulshettyacademy.pageobjects.OrderHistoryPage;

public class AbstractComponent {


	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartBtn;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orderLink;
	
	public void waitMethodForVisibility(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));			
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitMethodForVisibility(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));			
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitMethodForInVisibility(WebElement element) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));			
		wait.until(ExpectedConditions.invisibilityOf(element));
		//Thread.sleep(1000);
	}
	public void scrollBy(WebElement element) 
	{
		Point point = element.getLocation();
		int xCord = point.getX();
		int yCord = point.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("window.scroll(" + xCord + ", " + yCord + ");");
	}
	
	public  ProductCheckoutPage goToCartPage()
	{
		cartBtn.click();
		ProductCheckoutPage pCheckoutPage =  new ProductCheckoutPage(driver);
		return pCheckoutPage;
	}
	public  OrderHistoryPage goToOrdersPage()
	{
		orderLink.click();
		return new OrderHistoryPage(driver);
		
	}
	
}
