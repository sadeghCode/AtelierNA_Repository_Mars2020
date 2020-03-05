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
import utilities.Donnee;
import utilities.ObjetsRepository;

public class ModificationAdresse extends PageAccueil{ 
	  @Test
	public void CreationAdress() throws IOException, InterruptedException {
		  WebDriver driver =HomePage();
		  driver.findElement(By.xpath(ObjetsRepository.GetObject("compte"))).click();
		  //Affichage de la page
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  WebElement Element = driver.findElement(By.className("show"));
		  WebDriverWait wait = new WebDriverWait(driver,5);
		  wait.until(ExpectedConditions.visibilityOf(Element));	
		  js.executeScript("arguments[0].scrollIntoView();", Element);
		  // Saisie de données pour la connexion 
		  driver.findElement(By.xpath(ObjetsRepository.GetObject("EmailConnexion"))).sendKeys(Donnee.GetValue("ModificationAdresse","Email_NA"));
		  driver.findElement(By.xpath(ObjetsRepository.GetObject("PWDConnexion"))).sendKeys(Donnee.GetValue("ModificationAdresse","mdp_NA"));
		  driver.findElement(By.xpath(ObjetsRepository.GetObject("ConnexionBoutton"))).click();
		  String Actual=null;	
		  //un temps de synchronisation
		  WebDriverWait waitAcces = new WebDriverWait(driver, 10);
		  WebElement Category_Body = waitAcces.until(ExpectedConditions.visibilityOfElementLocated(By.className("subtitle")));
		  //Récuperation du message de bienvenue affiché sur l'ecran
		  Actual=driver.findElement(By.xpath(ObjetsRepository.GetObject("MessageBienvenue"))).getText();
		  Assert.assertTrue(Actual.contains(Donnee.GetValue("ModificationAdresse","messageBienvenueConnexion")));
		  driver.findElement(By.xpath(ObjetsRepository.GetObject("CreationAdress"))).click();
		  //Comparaison du message attendu et celui obtennu pour confirmer que la connexion s'est bien etablie
	      driver.findElement(By.xpath(ObjetsRepository.GetObject("ModificationAdressExistantButton"))).click();
	      WebDriverWait waitAcces2 = new WebDriverWait(driver, 10);
		  WebElement Category_Body2 = waitAcces2.until(ExpectedConditions.visibilityOfElementLocated(By.className("lastname")));
	      driver.findElement(By.xpath(ObjetsRepository.GetObject("IndicTelephoneAdress_NA"))).clear();
	      driver.findElement(By.xpath(ObjetsRepository.GetObject("IndicTelephoneAdress_NA"))).sendKeys(Donnee.GetValue("ModificationAdresse","IndicTelephoneAdress_NA"));
	      driver.findElement(By.xpath(ObjetsRepository.GetObject("Adress_NA"))).clear();
	      driver.findElement(By.xpath(ObjetsRepository.GetObject("Adress_NA"))).sendKeys(Donnee.GetValue("NouvelleAdresse","Adress_NA"));
	      driver.findElement(By.xpath(ObjetsRepository.GetObject("ValidationAdress_NA"))).click();
	      String msg=driver.findElement(By.xpath(ObjetsRepository.GetObject("COnfirmationDemodificationAdresse"))).getText();
		  Assert.assertTrue(msg.contains(Donnee.GetValue("ModificationAdresse","COnfirmationDemodificationAdresse")));
	     }
}
