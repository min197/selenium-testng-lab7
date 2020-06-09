package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class E3 {
	
	private ChromeDriver webdriver;
    private static final String ERROR_MESSAGE = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
    
    @BeforeClass
    public void initBrowser() {
    	System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webdriver = new ChromeDriver(options);
    	
    }
    
    @Test
    public void openUrlTest() {
        webdriver.get("http://automationpractice.com/");
    }
    
    @Test
    public void verifyPageTitleTest() {
        webdriver.get("http://automationpractice.com/");
        String pageTitle = webdriver.getTitle();
        System.out.println("Title site : " + pageTitle);
        Assert.assertEquals(pageTitle, "My Store");
    }
    
	@Test
    public void createExistingUserNegativeTest() {
        webdriver.get("http://automationpractice.com/");

        WebDriverWait wait = new WebDriverWait( webdriver, 60 );

        webdriver.findElement(By.cssSelector(".login")).click();

        wait.until(new PageLoaded());

        webdriver.findElement(By.id("email_create")).sendKeys("john.doe@yahoo.com");
        
        webdriver.findElement(By.id("SubmitCreate")).click();
        
        WebElement errorAlert = webdriver.findElement(By.id("create_account_error"));

        wait.until(ExpectedConditions.visibilityOfAllElements(errorAlert));
        String errorMessage = errorAlert.getText();

        Assert.assertEquals(errorMessage, ERROR_MESSAGE);
    }
	
	@Test
	public void createNewUserWithTrueFormTest() throws InterruptedException {
		
		 webdriver.get("http://automationpractice.com/");

		 WebDriverWait wait = new WebDriverWait(webdriver, 60 );

	     webdriver.findElement(By.cssSelector(".login")).click();	

	     wait.until(new PageLoaded());

	     webdriver.findElement(By.id("email_create")).sendKeys("newemail00162313@gmail.com");
	        
	     webdriver.findElement(By.id("SubmitCreate")).click();
	        
	     Thread.sleep(4000);
	     
	     webdriver.findElement(By.id("customer_firstname")).sendKeys("Minh");
	
	        
	     webdriver.findElement(By.id("customer_lastname")).sendKeys("Minh");
	                
	     webdriver.findElement(By.id("passwd")).sendKeys("!@#1231331231");
	        
	     webdriver.findElement(By.id("address1")).sendKeys("630 Sullivan Rd");
	        
	     webdriver.findElement(By.id("city")).sendKeys("New York");
	        
	     Select slState = new Select( webdriver.findElement(By.id("id_state")));
	     slState.selectByVisibleText("New York");
	     slState.selectByIndex(32);
	      
	     webdriver.findElement(By.id("postcode")).sendKeys("07201");
	        
	     Select slCountry = new Select( webdriver.findElement(By.id("id_country")));
	     slCountry.selectByVisibleText("United States");
	     slCountry.selectByIndex(1);
	        
	     webdriver.findElement(By.id("phone_mobile")).sendKeys("+18004724643");
	        
	     webdriver.findElement(By.id("submitAccount")).click();
	        
	}
	
	@Test
	public void createNewUserWithFalseFormTest() throws InterruptedException {

		 webdriver.get("http://automationpractice.com/");

		 WebDriverWait wait = new WebDriverWait(webdriver, 60 );

	     webdriver.findElement(By.cssSelector(".login")).click();	

	     wait.until(new PageLoaded());

	     webdriver.findElement(By.id("email_create")).sendKeys("newemail834233@gmail.com");
	        
	     webdriver.findElement(By.id("SubmitCreate")).click();
	        
	     Thread.sleep(4000);
	     
	     webdriver.findElement(By.id("customer_firstname")).sendKeys("");
	     
	        
	     webdriver.findElement(By.id("customer_lastname")).sendKeys("Minh");
	        
	        //webdriver.findElement(By.id("email")).sendKeys("newemail123013@gmail.com");
	        
	     webdriver.findElement(By.id("passwd")).sendKeys("weqwe3123123");
	        
	     webdriver.findElement(By.id("address1")).sendKeys("");
	        
	     webdriver.findElement(By.id("city")).sendKeys("");
	        
	     Select slState = new Select( webdriver.findElement(By.id("id_state")));
	     slState.selectByVisibleText("New York");
	     slState.selectByIndex(32);
	      
	     webdriver.findElement(By.id("postcode")).sendKeys("07201");
	        
	     Select slCountry = new Select( webdriver.findElement(By.id("id_country")));
	     slCountry.selectByVisibleText("United States");
	     slCountry.selectByIndex(1);
	        
	     webdriver.findElement(By.id("phone_mobile")).sendKeys("+18004724643");
	        
	     webdriver.findElement(By.id("submitAccount")).click();
	     
	     
	        
	}
	
	
	@AfterClass
	public void closeBrowser(){
	        webdriver.quit();
	}
}
