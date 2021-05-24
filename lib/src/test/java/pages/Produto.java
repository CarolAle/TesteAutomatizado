package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Produto extends PageObject {
	
	@FindBy(xpath = "/html[1]/body[1]/div[9]/main[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	WebElement preco;

	public Produto(WebDriver driver) {
		super(driver);
	}
	
	public String verPreco() {
		return preco.getText();
	}
	
}
