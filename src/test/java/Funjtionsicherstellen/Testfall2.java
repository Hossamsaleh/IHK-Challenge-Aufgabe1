package Funjtionsicherstellen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testfall2 {



	ChromeDriver driver ;

	@BeforeTest
	public void openUrL()
	{

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"\\resources\\chromedriver.exe");

		//1.Aufruf der Hauptseite https://www.ihk-gfi.de
		driver = new ChromeDriver();
		driver.navigate().to("https://www.ihk-gfi.de");

	}

	@Test
	public void DualStudium()
	{
		//2.Suche nach „Duales Studium“

		WebElement txtSearch = driver.findElement(By.id("search-field"));

		txtSearch.sendKeys("Duales Studium");
		txtSearch.submit();


	}
	@Test
	public void TrefferVorhanden()
	{

		//3.Prüfe, ob 2 Treffer erscheinen

		WebElement TrefferVorhanden = driver.findElement(By.id("search_hits"));
		System.out.println(TrefferVorhanden.getText());

	}

	@Test
	public void TreffermitID() 
	{
		//4.Prüfe ob der Treffer mit der ID 4370252 vorhanden ist
		WebElement TreffermitId = driver.findElement(By.id("4370252"));
		System.out.println(TreffermitId.getLocation());




	}


	@AfterTest
	public void closebrowser() {

		driver.quit();

	}













}    	   
