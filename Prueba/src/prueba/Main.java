package prueba;

import java.io.FileReader;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Main {

	private static final String CHROME_BIN = "C:\\Users\\Teknei\\Desktop\\Selenium\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe";
	private static final String PROFILE_CHROME = "C:\\Users\\Teknei\\Desktop\\cosas\\GoogleChromePortable\\Data\\profile";

	// private static final String TEXTO_BUSCAR = "Periféricos";
	private static final String TEXTO_BUSCAR1 = "enlace-secundario";
	// private static final String TEXTO_FIND = "Sillas gaming";

	private static Properties properties;
	private static String PROP_CATEGORIA = "categoria";
	private static String PROP_SUBCATEGORIA = "subcategoria";

	public static void main(String[] args) throws Exception {

		Properties properties = new Properties();
		properties.load(new FileReader("resources//config.properties"));

		String categoria = properties.getProperty(PROP_CATEGORIA);
		String subcategoria = properties.getProperty(PROP_SUBCATEGORIA);

//		//ChromeOptions options = new ChromeOptions();
//		//options.setBinary(CHROME_BIN);
//		//options.addArguments("--user-data-dir="+PROFILE_CHROME);
//		// the location of chromedriver on your machine
//		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		// This is the location where you have installed Google Chrome on your machine
//		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

		// the location of chromedriver on your machine
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// This is the location where you have installed Google Chrome on your machine
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.pccomponentes.com/");
		/*
		 * List<WebElement> elementos = driver.findElements(By.xpath("//input"));
		 * 
		 * for (WebElement e: elementos) { System.out.println(e.getText()); }
		 */

		// WebElement elemento = driver.findElement(By.id("GTM-superfamilia-28"));
		// //Sacar elemento por id
		// WebElement elemento =
		// driver.findElement(By.xpath("//a[@id='GTM-superfamilia-28']")); //Sacar
		// elemento con xpath
		// WebElement elemento =
		// driver.findElement(By.xpath("//a[contains(@id,'superfamilia-28')]")); //Sacar
		// elemento con xpath y las clausula contiene
		// WebElement elemento =
		// driver.findElement(By.xpath("//li[@class='c-main-menu__superitem']/a[@id='GTM-superfamilia-28']"));
		// //Sacar elemento con xpath y usar gerarquia y usando clausula de clases
		// WebElement elemento =
		// driver.findElement(By.xpath("//span[@class='c-main-menu__superitem']/a[@id='GTM-superfamilia-28']"));
		// //DA FALLO NO ENCUENTRA UN SPAN CON DENTRO UN A CON ESOS REQUISITOS

		// WebElement elemento =
		// driver.findElement(By.xpath("//li[@class='c-main-menu__superitem']/a[@title='"+TEXTO_BUSCAR1+"']"));

		WebElement elemento = driver.findElement(By.xpath("//a[@title='" + categoria + "']"));
		elemento.click();

		// Thread.sleep(1000);
		WebElement caja = driver.findElement(By.xpath(
				"//div[@class='listado-todas-categorias listado-categorias-NombreFamilia white-card-movil m-b-3 p-a-2']"));

		WebElement text = caja.findElement(By.xpath(".//strong[@class='h4']"));
		System.out.println(text.getText().toUpperCase());

		List<WebElement> elementos = caja.findElements(By.xpath("//li/a[@class='" + TEXTO_BUSCAR1 + "']"));

		for (int i = 0; i < elementos.size(); i++) {
			caja = driver.findElement(By.xpath(
					"//div[@class='listado-todas-categorias listado-categorias-NombreFamilia white-card-movil m-b-3 p-a-2']"));
			text = caja.findElement(By.xpath(".//strong[@class='h4']"));
			elementos = caja.findElements(By.xpath("//li/a[@class='" + TEXTO_BUSCAR1 + "']"));

			if ((elementos.get(i).getText()).equals(subcategoria)) {
				// elementos.get(i).click();
				((RemoteWebDriver) driver).executeScript("arguments[0].click();", elementos.get(i)); // Sirve para cuando el .click() cuando
																					// da fallo de no clicable o similar
				WebElement div = driver.findElement(By.xpath("//div[@class='select-redondeado__comparsa']/strong"));
				System.out.println(div.getText());
				driver.navigate().back();
			}
		}

		/*
		 * List<WebElement> listaEl =
		 * driver.findElements(By.xpath("//article[@class='tarjeta-familia atrapatodo']"
		 * ));
		 * 
		 * for(WebElement i: listaEl) { WebElement tituloC =
		 * i.findElement(By.xpath(".//header[@class='tarjeta-familia__cabecera']"));
		 * System.out.println(tituloC.getText()); List<WebElement> lista2 =
		 * i.findElements(By.xpath(".//h5//a[@class='enlace-secundario-GTM']"));
		 * for(WebElement x: lista2) { System.out.println(x.getText()); } }
		 * 
		 * //driver.close();
		 */
		System.out.println("Fin correctamente");
	}
}
