package Atelierna.ateliernaAI;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utilities.Donnee;
import utilities.ObjetsRepository;

public class Connexion extends PageAccueil {
	//SADEGH: Test de connexion à l'espace client
  @Test (priority=0)
  public void connexion() throws IOException, InterruptedException {
	  WebDriver driver =HomePage();
	  driver.findElement(By.xpath(ObjetsRepository.GetObject("compte"))).click();
	  //Affichage de la page
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  WebElement Element = driver.findElement(By.className("show"));
	  WebDriverWait wait = new WebDriverWait(driver,5);
	  wait.until(ExpectedConditions.visibilityOf(Element));	
	  js.executeScript("arguments[0].scrollIntoView();", Element);
	  // Saisie de données pour la connexion
	  driver.findElement(By.xpath(ObjetsRepository.GetObject("EmailConnexion"))).sendKeys(Donnee.GetValue("Email"));
	  driver.findElement(By.xpath(ObjetsRepository.GetObject("PWDConnexion"))).sendKeys(Donnee.GetValue("mdp"));
	  driver.findElement(By.xpath(ObjetsRepository.GetObject("ConnexionBoutton"))).click();
	  String Actual=null;	
	  //Récuperation du text, pour confirmer que la connexion s'est bien etablie
	 // Actual=driver.findElement(By.xpath(ObjetsRepository.GetObject("ConnextionConfirmation"))).getText();
	 // System.out.print(Actual);
	  //ssert.assertTrue(Actual.contains("Bonjour Fadel Fadelname"));
	  driver.close();
  }
  @BeforeSuite
  public void DebutConnexcion() {
      System.out.println("Debut de la connexion");
  }
  @AfterSuite
  public void FinConnexcion(){
      System.out.println("La connexion est établie");
  }
  

}
