package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends PageObject {
	//atributos
	@FindBy(id = "search")
	private WebElement busca;

	public Home(WebDriver driver) {
		super(driver);
	}
	
	public void buscarProdutoComEnter(String produto) {
		busca.clear();
		busca.sendKeys(produto + Keys.ENTER);
	}
}
