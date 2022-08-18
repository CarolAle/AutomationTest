package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lista extends PageObject {	
	WebElement prod;

	WebDriverWait wait = new WebDriverWait(driver,30);	
	
	public Lista(WebDriver driver) {
		super(driver);
	}
	
	public void buscaVestido() {
		Actions a = new Actions(driver);
		//driver.findElement(By.linkText("Dresses")).click();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		a.moveToElement(element).perform();
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")).click();

		a.contextClick(element);
	}
	
	public void clicarNoProduto() {
		Actions a = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Printed Dress"));
		a.moveToElement(element).perform();
		driver.findElement(By.xpath("(//a[@title='View'])[1]//span")).click();

		a.contextClick(element);
	}
	
	public void clicaBotaoAddCart() {
		//prod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='our_price_display']")));
		WebElement prod2 = driver.findElement(By.xpath("//p[@id='add_to_cart']"));
		prod2.click();
	}
	
	public void clicaBotaoProCheckout() {
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]")).click();
	}
	
	public void clicaBotaoProCheckout2() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
	}
	
	public void signIn(String email, String senha) {
		WebElement mail = driver.findElement(By.id("email"));
		mail.sendKeys(email);
		WebElement passwd = driver.findElement(By.id("passwd"));
		passwd.sendKeys(senha);
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	public void clicaContinuar() {
		driver.findElement(By.name("processAddress")).click();
	}
	
	public void aceitaTermos() {
		WebElement check = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
		check.click();
		driver.findElement(By.name("processCarrier")).click();
	}
	
	public void payBank() {
		driver.findElement(By.className("payment_module")).click();
	}
	public void confirmOrder() {
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
		driver.findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]"));
		driver.findElement(By.xpath("//strong[contains(text(),'$29.12')]"));  //confere o valor total
	}
	

}
