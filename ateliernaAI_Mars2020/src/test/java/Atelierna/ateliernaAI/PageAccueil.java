package Atelierna.ateliernaAI;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.readPropFile;

public class PageAccueil {
	
  @Test
  public   WebDriver HomePage() throws IOException  {
	  	System.setProperty("webdriver.chrome.driver","C:\\Browsers\\chromedriver.exe");
	  	WebDriver driver = new ChromeDriver();
		//Ouverture du site Amazon
		driver.get("https://www.atelierna.com/fr");  
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Création d'un nouveau compte
		//driver.findElement(By.xpath(readPropFile.GetObject("compte"))).click();
		//WebElement Element = driver.findElement(By.className("show"));
		//WebDriverWait wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOf(Element));	
      //js.executeScript("arguments[0].scrollIntoView();", Element);
      return driver;
  }

  
  
}
