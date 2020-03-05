package Atelierna.ateliernaAI;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utilities.ObjetsRepository;
import utilities.Config;

public class PageAccueil {
	
//les autres class ayant besoin de lancement de l'appli vont etre heritée de celle ci
	  WebDriver HomePage() throws IOException   {
	  System.setProperty(Config.GetParam("Webdriver"),Config.GetParam("WebdriverPath"));
	  WebDriver driver = new ChromeDriver();
	  //Ouverture du site
	  driver.get(Config.GetParam("URL"));  
	  driver.manage().window().maximize();
     return driver;
  }

  @BeforeSuite
  public void DebutPageAccueil() {
      System.out.println("Debut de la page d'accueil");
  }
  @AfterSuite
  public void FinPageAccueil(){
      System.out.println("Page accueil affichée");
  }
}
