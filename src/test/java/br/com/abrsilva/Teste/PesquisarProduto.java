package br.com.abrsilva.Teste;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PesquisarProduto {

	protected static WebDriver driver;

	public MetodosGerais metodo = new MetodosGerais(driver);

	@BeforeAll
	public static void setup() throws InterruptedException {
		driver = Browser.iniciar();
	}

	@Test
	@Order(1)
	public void buscarProduto() throws InterruptedException {
		metodo.escreverTexto("geladeira");
		// Ícone de busca (Lupa)
		metodo.clickBotao("#h_search-btn");
		metodo.aguardarElemento(5);
		metodo.validarURL("https://www.submarino.com.br/busca/geladeira");
	}

	@Test
	@Order(2)
	public void selecionarProduto() {
		metodo.validarProdutoSelecionado(
				"#content-middle > div:nth-child(6) > div > div > div > div.row.product-grid.no-gutters.main-grid > div:nth-child(1) > div "
						+ "> div.RippleContainer-sc-1rpenp9-0.dMCfqq > a > section > div.Info-bwhjk3-5.gWiKbT.ViewUI-sc-1ijittn-6.iXIDWU "
						+ "> div.TitleWrapper-sc-1wh9e1x-7.cOZQdh.ViewUI-sc-1ijittn-6.iXIDWU > h2",
				"Geladeira / Refrigerador Duplex Brastemp BRM44HB 375L Branco Frost Free");
		metodo.clickImagem(
				"a[href='/produto/133257344?pfm_carac=geladeira&pfm_page=search&pfm_pos=grid&pfm_type=search_page']");
	}

	@Test
	@Order(3)
	public void comprarProduto() throws InterruptedException {
		metodo.aguardarElemento(3);
		metodo.scrollVertical();
		// Comando [Comprar]
		metodo.aguardarElemento(3);
		metodo.clickBotao("#btn-buy");
	}

	@Test
	@Order(4)
	public void confirmarVoltagemProduto() throws InterruptedException {
		// Mensagem - O produto escolhido é 110V
		metodo.mensagemAlerta(
				"//div[@class='ColUI-gjy0oc-0 jzdysX ViewUI-sc-1ijittn-6 iXIDWU']/span[@class='TextUI-sc-12tokcy-0 kFQuRf']");

		// Mensagem - Tem certeza que é o produto desejado?
		metodo.aguardarElemento(3);
		metodo.mensagemAlerta(
				"//div[@class='ColUI-gjy0oc-0 imjgvb ViewUI-sc-1ijittn-6 iXIDWU']/span[@class='TextUI-sc-12tokcy-0 kgCTfT']");

		// Sim, continuar
		metodo.clickBotao("a[value='Sim, continuar']");
	}

	@Test
	@Order(5)
	public void adicionarProdutoAoCarrinho() throws InterruptedException {
		metodo.aguardarElemento(3);
		metodo.clickBotao("#btn-continue");
	}
	
	@Test
	@Order(6)
	public void validarCarrinho() {
		metodo.validarLinkProduto("//div[@class='basket-productTitle__wrapper']/h2[@class='basket-productTitle']/a");
		metodo.validarProdutoSelecionado("a[title='Geladeira / Refrigerador Duplex Brastemp BRM44HB 375L Branco 110V Frost Free']", "Geladeira / Refrigerador Duplex Brastemp BRM44HB 375L Branco 110V Frost Free");
	}

	@AfterAll
	public static void tearDown() throws InterruptedException {
		Browser.finalizar();
	}
}
