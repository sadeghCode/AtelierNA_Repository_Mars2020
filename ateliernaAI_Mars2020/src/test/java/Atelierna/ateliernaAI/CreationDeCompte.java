package Atelierna.ateliernaAI;
import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utilities.dataReader;
import utilities.readPropFile;


public class CreationDeCompte extends PageAccueil {
  @Test
  public void CreationCompte() throws IOException, InterruptedException {
	    // Creation d'instance webdriver
	    WebDriver driver =HomePage();
		//saisie de donnée
		driver.findElement(By.xpath(readPropFile.GetObject("compte"))).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.className("show"));
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(Element));	
		js.executeScript("arguments[0].scrollIntoView();", Element);
	  	driver.findElement(By.xpath(readPropFile.GetObject("creationCompte"))).click();
	  	driver.findElement(By.xpath(readPropFile.GetObject("creationPrenom"))).sendKeys("test1");//dataReader.GetValue("creationPrenom"));
	  	driver.findElement(By.xpath(readPropFile.GetObject("creationNome"))).sendKeys("test1");//sendKeys(dataReader.GetValue("creationNome"));
	  	driver.findElement(By.xpath(readPropFile.GetObject("creationEmail"))).sendKeys("test1@gyezg.fr");//sendKeys(dataReader.GetValue("creationEmail"));
		//driver.findElement(By.xpath(readPropFile.GetObject("creationEmail"))).sendKeys("test1@gyezg.fr");//sendKeys(dataReader.GetValue("creationEmail"));
	  	driver.findElement(By.xpath(readPropFile.GetObject("indicatifTelephon"))).clear();
	  	driver.findElement(By.xpath(readPropFile.GetObject("indicatifTelephon"))).sendKeys("33");//sendKeys(dataReader.GetValue("indicatifTelephon"));
	  	driver.findElement(By.xpath(readPropFile.GetObject("numeroTelephon"))).sendKeys("667909245");//sendKeys(dataReader.GetValue("numeroTelephon"));
		Select JourList= new Select(driver.findElement(By.id("block-login-register-language")));
		//JourList.selectByValue(String.valueOf(dataReader.GetValue("Allemand")));
		driver.findElement(By.xpath(readPropFile.GetObject("mdp"))).sendKeys("test1@ef");//sendKeys(dataReader.GetValue("mdp"));
		driver.findElement(By.xpath(readPropFile.GetObject("mdpConfirm"))).sendKeys("test1@ef");//sendKeys(dataReader.GetValue("mdpConfirm"));
		//driver.findElement(By.xpath(readPropFile.GetObject("validationbButton"))).click();	
		String Actual="driver.findElement(By.xpath(readPropFile.GetObject(\"CreationCompteConfirmation\")))";
		Assert.assertTrue(Actual.contains("Bonjour Fadel Fadelname"));
		
		
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }
  
}
