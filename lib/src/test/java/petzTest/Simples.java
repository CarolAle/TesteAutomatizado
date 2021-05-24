package petzTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Simples {
	
	String url;			//endereço do site
	WebDriver driver;	//objeto do Selenium WebDriver
	
	@Before
	public void iniciar() {
		url = "https://www.petz.com.br";
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void abrirPagina() {
		driver.get(url);
		assertEquals("Pet Shop: Petz o maior pet shop do Brasil.", driver.getTitle());
	}
	
	
}
