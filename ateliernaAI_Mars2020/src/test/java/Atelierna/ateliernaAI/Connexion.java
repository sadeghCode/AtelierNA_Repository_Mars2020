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
	  driver.findElement(By.xpath(ObjetsRepository.GetObject("EmailConnexion"))).sendKeys(Donnee.GetValue("Compte","Email"));
	  driver.findElement(By.xpath(ObjetsRepository.GetObject("PWDConnexion"))).sendKeys(Donnee.GetValue("Compte","mdp"));
	  driver.findElement(By.xpath(ObjetsRepository.GetObject("ConnexionBoutton"))).click();
	  String Actual=null;	
	  //un temps de synchronisation
	  WebDriverWait waitAcces = new WebDriverWait(driver, 10);
	  WebElement Category_Body = waitAcces.until(ExpectedConditions.visibilityOfElementLocated(By.className("subtitle")));
	  //Récuperation du message de bienvenue affiché sur l'ecran
	  Actual=driver.findElement(By.xpath(ObjetsRepository.GetObject("MessageBienvenue"))).getText();;
	  //Comparaison du message attendu et celui obtennu pour confirmer que la connexion s'est bien etablie
	  Assert.assertTrue(Actual.contains(Donnee.GetValue("Compte","messageBienvenue")));
	  //driver.close();
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
