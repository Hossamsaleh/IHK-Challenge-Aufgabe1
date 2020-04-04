package seleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElements {


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
	public void findtelefonnummer()
	{
		//get the PhoneNUM firstly by ID
		WebElement PhoneNum = driver.findElement(By.id("phone"));		
		System.out.println(PhoneNum.getText());
		//2.Prüfe die Telefonnummer auf den Inhalt 0231 9746-0
		Assert.assertTrue(PhoneNum.getText().equals("0231 9746-0"));

		//get the phoneNum2 at the Bottom by Xpath
		WebElement PhoneNum2 = driver.findElement(By.xpath("//*[@id=\"footer_navigation_contact\"]/div"));
		System.out.println(PhoneNum2.getText());
		//2b.Prüfe die Telefonnummer auf den Inhalt 0231 9746-0
		Assert.assertTrue(PhoneNum2.getText().equals("0231 9746-0"));

	}

	@Test
	public void ElementsVorhanden()
	{

		//3.Prüfe ob die Links Datenschutzerklärung und Impressum vorhanden sind
		WebElement Impressum = driver.findElement(By.id("footer_imprint_item0"));
		System.out.println(Impressum.getText());
		WebElement Datenschutzerklärung = driver.findElement(By.id("footer_imprint_item1"));
		System.out.println(Datenschutzerklärung.getText());

	}
	@Test
	public void KennenlernernVorhanden()
	{
		//4.Prüfe ob sich die Navigation „Über uns – lerne uns kennen“ an der dritten Position befindet
		WebElement Kennenlernen = driver.findElement(By.id("gf-panel-item2"));
		System.out.println(Kennenlernen.getLocation());
		driver.navigate().to("https://www.ihk-gfi.de/internet/ueber-uns-4338544");	
	}

	@Test
	public void SuchFeldVorhanden()
	{
		//5.Prüfe ob das Suchfeld vorhanden ist

		WebElement Suchfeld = driver.findElement(By.name("query"));
		System.out.println(Suchfeld.getText());



	}


	@AfterTest
	public void closeDriver()
	{

		driver.quit();
	}




}
