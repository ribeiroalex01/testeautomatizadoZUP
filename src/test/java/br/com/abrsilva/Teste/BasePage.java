package br.com.abrsilva.Teste;

import org.openqa.selenium.WebDriver;

public class BasePage {
	protected static WebDriver driver;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
	}

}
