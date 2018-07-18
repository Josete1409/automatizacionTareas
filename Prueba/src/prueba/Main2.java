package prueba;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main2 {

	private static Properties properties;
	private static String PROP_CATEGORIA = "numero";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		Properties properties = new Properties();
		properties.load(new FileReader("resources//config.properties"));

		String buscarNum = properties.getProperty(PROP_CATEGORIA);


		// the location of chromedriver on your machine
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// This is the location where you have installed Google Chrome on your machine
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.pccomponentes.com/buscar/?query="+args[0]);
		
		WebElement producto = driver.findElement(By.xpath("//body[@id='resultados-busqueda']/div[@id='contenedor-principal']/div[@id='main']/"
				+ "div[@class='container m-t-1 base']/div[@class='row']/div[@class='col-xs-12 col-xl-9']/div[@class='white-card']/div[@id='articleListContent']"
				+ "/div[@class='row page-0']/div[1]/article[1]/div[1]/a[1]"));
		producto.click();
		
//		WebElement numero = driver.findElement(By.xpath("//button[@type='button']//i[contains(@class,'pccom-icon')][contains(text(),'H')]"));
//		int num = Integer.parseInt(buscarNum);
		
		WebElement cantidad = driver.findElement(By.xpath("//input[@id='article-quantity']"));
		cantidad.clear();
		cantidad.sendKeys(buscarNum);
//		for(int i = 0; i<num; i++) {
//			numero.click();
//		}
		WebElement carrito = driver.findElement(By.xpath("//i[@class='pccom-icon arrow']"));
		carrito.click();
		
		

//		WebElement buscador = driver.findElement(By.xpath("//input[@id='query']"));
//		buscador.click();
//
//		buscador.sendKeys(args[0]);

	}

}
