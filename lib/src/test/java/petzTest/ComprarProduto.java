package petzTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.Home;
import pages.Lista;
import pages.Produto;

public class ComprarProduto {
	
	String url;			//endereço do site
	WebDriver driver;	//objeto do Selenium WebDriver
	
	Home home;
	Lista lista;
	Produto produto;
	
	@Before
	public void iniciar() {
		url = "https://www.petz.com.br";
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		
		home = new Home(driver);
		lista = new Lista(driver);
		produto = new Produto(driver);
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Dado("^que o usuário acessa o site Petz$")
	public void que_o_usuário_acessa_o_site_Petz() {
		driver.get(url);
	}

	@Quando("^busca por \"([^\"]*)\" e pressiona Enter$")
	public void busca_por_e_pressiona_Enter(String produto) {
	    home.buscarProdutoComEnter(produto);
	}

	@Então("^exibe uma lista de produtos relacionados a \"([^\"]*)\"$")
	public void exibe_uma_lista_de_produtos_relacionados_a(String produto) {
		assertEquals("RESULTADOS PARA \"" + produto.toUpperCase() + "\"", lista.lerCabecalhoResultado());
	    
	}

	@Quando("^escolhe \"([^\"]*)\"$")
	public void escolhe(String produto) {
		lista.clicarNoProduto(produto);
	    
	}

	@Então("^exibe o preço de \"([^\"]*)\"$")
	public void exibe_o_preco(String preco) {
		assertEquals(preco, produto.verPreco());
	}

}
