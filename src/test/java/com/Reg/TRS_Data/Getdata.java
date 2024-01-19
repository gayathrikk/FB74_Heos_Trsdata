package com.Reg.TRS_Data;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Getdata {
	
	private RemoteWebDriver driver;
	
	@BeforeTest
	
	public void setup() throws MalformedURLException 
	{
		
		  DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.20.23.7:5555/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	
	       
	}
	
	@Test(priority=1)
	public void login()throws InterruptedException
	{
		
		driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
		driver.manage().window().maximize();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);
		WebDriverWait wait = new WebDriverWait(driver, 10);
    	driver.switchTo().defaultContent(); // Switch back to default content
    	WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
    	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
    	    viewerElement.click();
    	    System.out.println("Viewer icon is clicked");
    	} else {
    	    System.out.println("Viewer icon is not clickable");
    	}
    	

        String parentWindow = driver.getWindowHandle();
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
        if (loginButton != null) {
            loginButton.click();
            System.out.println("Login button clicked successfully.");
        } else {
            System.out.println("Login button is not clicked.");
        }
        
	  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	  Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        if (emailInput != null && emailInput.isDisplayed()) {
            emailInput.sendKeys("teamsoftware457@gmail.com");
            System.out.println("Email was entered successfully.");
        } else {
           System.out.println("Email was not entered.");
        }
       

        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        if (nextButton1 != null) {
            nextButton1.click();
            System.out.println("Next button 1 is clicked.");
        } else {
            System.out.println("Next button 1 is not clicked.");
        }
        
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
        passwordInput.sendKeys("Health#123");
        if (passwordInput.getAttribute("value").equals("Health#123")) {
            System.out.println("Password was entered successfully.");
        } else {
            System.out.println("Password was not entered.");
        }
       
        
        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        if (nextButton2 != null) {
            nextButton2.click();
            System.out.println("Next button 2 is clicked.");
        } else {
            System.out.println("Next button 2 is not clicked.");
        }
        

        driver.switchTo().window(parentWindow);
        System.out.println("Login successfully");
        System.out.println("************************Login validation done***********************");
	        
	}
	
	@Test(priority=2)
	public void series_set() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		driver.switchTo().defaultContent();

		
    	 try {
    		    WebElement Mouse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[6]")));
    		    Mouse.click();
    		    System.out.println("Human Fetus clicked successfully.");
    		    Thread.sleep(2000);
    		} catch (Exception e) {
    		    System.out.println("Human Fetus not clicked: " + e.getMessage());
    		}
    	 
    	 
    	 try {
    		    WebElement Brain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[7]//td[2]")));
    		    Brain.click();
    		    System.out.println(" Brain clicked successfully.");
    		    Thread.sleep(2000);
    		} catch (Exception e) {
    		    System.out.println("Brain not clicked: " + e.getMessage());
    		}
    	
    	 
    	 try {
 		    WebElement MTB_10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[25]//td[3]")));
 		    MTB_10.click();
 		    System.out.println("FTB-40 clicked successfully.");
 		    Thread.sleep(2000);
 		} catch (Exception e) {
 		    System.out.println(" FTB-40 not clicked: " + e.getMessage());
 		}
    	 
    	 By arrowLeftLocator = By.xpath("(//i[@class='fa fa-arrow-circle-left ngx-gallery-icon-content'])[2]");

    	 for (int i = 0; i < 5; i++) {
    	     driver.findElement(arrowLeftLocator).click();
    	 }

    	 try {
  		    WebElement section = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='4'])[1]")));
  		    section.click();
  		    System.out.println("section clicked successfully.");
  		    Thread.sleep(2000);
  		} catch (Exception e) {
  		    System.out.println("section not clicked: " + e.getMessage());
  		}
    	 
    	 
    	 System.out.println("************************************Series set validation done********************************");

    	 
	}
	
	@Test(priority = 3)
	public void registration() throws InterruptedException {
	    clickElementByXPath("//a[@title='Manual Registration']", "Manual Registration");
	    System.out.println("************************Manual Registration opened successfully***********************");
	    Thread.sleep(6000);
	}

	@Test(priority = 4)
	public void getTrs() throws InterruptedException {
	    for (int i = 1; i <= 400; i++) {
	        WebElement section = driver.findElement(By.xpath("(//div[@class='paragraph'])[2]"));
	        String sectionText = section.getText();
	        System.out.println(sectionText);

	        trsRot();
	        nextSection();
	        Thread.sleep(8000);
	        System.out.println("");
	    }
	}

	private void trsRot() {
	    printCaptionText("(//div[@class='caption'])[3]", "Translate");
	    printCaptionText("(//div[@class='caption'])[4]", "Rotation");
	}

	private void nextSection() {
	    clickElementByXPath("//i[@class='fas fa-arrow-right']", "Next Section");
	}

	private void clickElementByXPath(String xpath, String elementName) {
	    WebDriverWait wait = new WebDriverWait(driver, 50);
	    driver.switchTo().defaultContent();

	    try {
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	        element.click();
	        System.out.println(elementName + " clicked");
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println(elementName + " is not clicked: " + e.getMessage());
	    }
	}

	private void printCaptionText(String xpath, String captionName) {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    String text = element.getText();
	    System.out.println(captionName + ": " + text);
	}

	
	@AfterTest
	public void close()
	{
		driver.quit();
	}

}
