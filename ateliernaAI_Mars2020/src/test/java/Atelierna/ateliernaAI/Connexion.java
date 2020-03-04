package Atelierna.ateliernaAI;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utilities.readPropFile;

public class Connexion extends PageAccueil {
  @Test
  public WebDriver connexion() throws IOException, InterruptedException {
	  WebDriver driver =HomePage();
	  driver.findElement(By.xpath(readPropFile.GetObject("compte"))).click();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  WebElement Element = driver.findElement(By.className("show"));
	  WebDriverWait wait = new WebDriverWait(driver,5);
	  wait.until(ExpectedConditions.visibilityOf(Element));	
	  js.executeScript("arguments[0].scrollIntoView();", Element);
	  driver.findElement(By.xpath(readPropFile.GetObject("EmailConnexion"))).sendKeys("test1@gyezg.fr");
	  driver.findElement(By.xpath(readPropFile.GetObject("PWDConnexion"))).sendKeys("test1@ef");
	  driver.findElement(By.xpath(readPropFile.GetObject("ConnexionBoutton"))).click();
	  String Actual=null;
	  //WebElement Element2 = driver.findElement(By.xpath(readPropFile.GetObject("CreationCompteConfirmation")));
	 // WebElement Element2 = driver.findElement(By.xpath(readPropFile.GetObject("CreationCompteConfirmation")));
	  //WebDriverWait wait2 = new WebDriverWait(driver,5);
	  //wait2.until(ExpectedConditions.visibilityOf(Element2));	
	  //js.executeScript("arguments[0].scrollIntoView();", Element2);
	  //driver.manage().window().maximize();
	   //driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[3]/div[4]/div/div/div[1]/div[1]/div/div/p")).click();
		//System.out.print("yesssssssssssssssssssssssss"+Actual);
		//Assert.assertTrue(Actual.contains("Test1 Test1"));
	 //driver.findElement(By.xpath(readPropFile.GetObject("compte"))).click();		
	  return driver;
  }
}
