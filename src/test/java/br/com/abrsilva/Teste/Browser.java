package br.com.abrsilva.Teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Browser {
	
	protected static WebDriver driver;

	public static WebDriver iniciar() throws InterruptedException {
		driver = AcessoWeb.navegaBrowser();
		return driver;
	}

	public static void finalizar() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		driver.quit();
	}

}
