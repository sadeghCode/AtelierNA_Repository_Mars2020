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
import utilities.Donnee;
import utilities.ObjetsRepository;
import utilities.Donnee;

public class CreationDeCompte extends PageAccueil {
  @Test
  public void CreationCompte() throws IOException, InterruptedException {
	    // Lancement de l'appli et acces à la page d'accueil
	    WebDriver driver =HomePage();
		driver.findElement(By.xpath(ObjetsRepository.GetObject("compte"))).click();
		//Affichage de la page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.className("show"));
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(Element));	
		js.executeScript("arguments[0].scrollIntoView();", Element);
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("creationCompte"))).click();
	    //Saisie de données pour la création du compte
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("creationPrenom"))).sendKeys(Donnee.GetValue("creationPrenom"));//dataReader.GetValue("creationPrenom"));
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("creationNom"))).sendKeys(Donnee.GetValue("creationNom"));//sendKeys(dataReader.GetValue("creationNome"));
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("creationEmail"))).sendKeys(Donnee.GetValue("Email"));//sendKeys(dataReader.GetValue("creationEmail"));
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("indicatifTelephon"))).clear();
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("indicatifTelephon"))).sendKeys(Donnee.GetValue("indicatifTelephon"));//sendKeys(dataReader.GetValue("indicatifTelephon"));
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("numeroTelephon"))).sendKeys(Donnee.GetValue("numeroTelephon"));//sendKeys(dataReader.GetValue("numeroTelephon"));
		Select JourList= new Select(driver.findElement(By.id("block-login-register-language")));
		driver.findElement(By.xpath(ObjetsRepository.GetObject("mdp"))).sendKeys(Donnee.GetValue("mdp"));//sendKeys(dataReader.GetValue("mdp"));
		driver.findElement(By.xpath(ObjetsRepository.GetObject("mdpConfirm"))).sendKeys(Donnee.GetValue("mdpConfirm"));//sendKeys(dataReader.GetValue("mdpConfirm"));
		driver.findElement(By.xpath(ObjetsRepository.GetObject("validationbButton"))).click();	
		//Assert.assertTrue(Actual.contains("Bonjour Fadel Fadelname"));

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.print("Debut de création du compte");
  		}

  @AfterTest
  public void afterTest() {
	  System.out.print("Fin de création du compte");
  }
  
}
