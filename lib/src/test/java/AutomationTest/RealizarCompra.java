package AutomationTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import pages.Lista;

public class RealizarCompra {
	String url;			//endereço do site
	WebDriver driver;	//objeto do Selenium WebDriver
	
	Lista lista;
	
	@Before
	public void iniciar() {
		url = "http://automationpractice.com/index.php";
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		lista = new Lista(driver);
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Dado("^que acesso o site \"([^\"]*)\"$")
	public void que_acesso_o_site(String arg1) {
		driver.get(url);
	}

	@Dado("^entro na categoria vestido casual$")
	public void entro_na_categoria_vestido_casual() {
		lista.buscaVestido();
	}
	
	  
	@Quando("^clico no produto \"([^\"]*)\"$")
	public void que_clico_no_produto(String produto) {
		lista.clicarNoProduto();
	   
	}

	@Dado("^clico no botão \"([^\"]*)\"$")
	public void clica_no_botão(String arg1) throws InterruptedException {
		lista.clicaBotaoAddCart();
		Thread.sleep(3000);
	 
	}

	@Dado("^clico em \"([^\"]*)\"$")
	public void clicar_na_botão(String arg1) throws InterruptedException {
		lista.clicaBotaoProCheckout();
	}
	
	@Dado("^clico em \"([^\"]*)\" na tela de resumo$")
	public void clica_no_botão_Proceed_to_checkout(String arg1) throws InterruptedException {
		Thread.sleep(3000);
		lista.clicaBotaoProCheckout2();
		}

	@Dado("^Preencho os campos email e senha com \"([^\"]*)\" e \"([^\"]*)\" com uma conta válida$")
	public void preenche_campo_e_com_uma_conta_válida(String arg1, String arg2) {
		lista.signIn(arg1, arg2);
}
	@Dado("^clico em \"([^\"]*)\" no passo (\\d+)$")
	public void clicar_em(String arg1, String arg2) throws InterruptedException {
		Thread.sleep(3000);
		lista.clicaContinuar();
	}

	@Dado("^Clico em aceitar os termos e \"([^\"]*)\" no passo (\\d+)$")
	public void clica_em_aceitar_os_termos(String arg1, String arg2) {
		lista.aceitaTermos();
	}

	@Dado("^Clico na opção Pay by bank wire\"$")
	public void clica_na_opção_Pay_by_bank_wire() {
		lista.payBank();
	}

	@Dado("^Clico na opção \"([^\"]*)\"$")
	public void clica_na_opção(String arg1) {
		lista.confirmOrder();
	}

}
