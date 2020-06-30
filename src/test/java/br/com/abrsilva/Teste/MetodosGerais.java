package br.com.abrsilva.Teste;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class MetodosGerais extends BasePage {

	private String link;

	public MetodosGerais(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param tempo - Informar número para tempo de espera em segundos
	 * @throws InterruptedException
	 */
	public void aguardarElemento(int tempo) throws InterruptedException {
		TimeUnit.SECONDS.sleep(tempo);
		return;
	}

	public String validarURL(String texto) {
		String URL = driver.getCurrentUrl();
		Assertions.assertEquals(URL, texto);
		return texto;
	}

	public String escreverTexto(String texto) {
		driver.findElement(By.cssSelector("#h_search-input")).sendKeys(texto);
		return texto;
	}

	public void clickBotao(String elementoCSS) {
		driver.findElement(By.cssSelector(elementoCSS)).click();
	}

	public String validarProdutoSelecionado(String elementoCSS, Object descricaoProduto) {
		String elementoTexto = driver.findElement(By.cssSelector(elementoCSS)).getText();
		Assertions.assertEquals(descricaoProduto, elementoTexto);
		System.out.println(elementoTexto);
		return elementoTexto;
	}

	public void clickImagem(String elementoCSS) {
		driver.findElement(By.cssSelector(elementoCSS)).click();
		// driver.findElement(By.cssSelector("a[href='images/shim.gif']")).click();
	}

	public void scrollVertical() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy (0,150)");
	}

	public String mensagemAlerta(String elementoXPath) {
		String textoMensagem = driver.findElement(By.xpath(elementoXPath)).getText();
		System.out.println(textoMensagem);
		return textoMensagem;
	}

	public String validarLinkProduto(String elementoXPath) {
		link = driver.findElement(By.xpath(elementoXPath)).getAttribute("href");
		System.out.println(link);
		return elementoXPath;
	}

}
