package Atelierna.ateliernaAI;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;
import utilities.Donnee;
import utilities.ObjetsRepository;

public class ModificationProfil extends PageAccueil {
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
		driver.findElement(By.xpath(ObjetsRepository.GetObject("EmailConnexion"))).sendKeys(Donnee.GetValue("ModificationProfil","Email"));
		driver.findElement(By.xpath(ObjetsRepository.GetObject("PWDConnexion"))).sendKeys(Donnee.GetValue("ModificationProfil","mdp"));
		driver.findElement(By.xpath(ObjetsRepository.GetObject("ConnexionBoutton"))).click();
		//Temporisation
		WebDriverWait waitAcces = new WebDriverWait(driver, 10);
		WebElement Category_Body = waitAcces.until(ExpectedConditions.visibilityOfElementLocated(By.className("subtitle")));
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("ProfilLien"))).click();
	    //Saisie de données pour la création du compte
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("NumerDeTelModification"))).clear();
	  	driver.findElement(By.xpath(ObjetsRepository.GetObject("NumerDeTelModification"))).sendKeys(Donnee.GetValue("ModificationProfil","numeroTelephon"));//sendKeys(dataReader.GetValue("numeroTelephon"));
		driver.findElement(By.xpath(ObjetsRepository.GetObject("ModificationDeProfilValidation"))).click();	
		//Récuperation du message de bienvenue affiché sur l'ecran
		String Actual;
		Actual=driver.findElement(By.xpath(ObjetsRepository.GetObject("ModificationDeProfilConfirmation"))).getText();;
		//Comparaison du message attendu et celui obtennu pour confirmer que la connexion s'est bien etablie
		Assert.assertTrue(Actual.contains(Donnee.GetValue("ModificationProfil","ModificationDeProfilConfirmation")));
		//driver.close();

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
