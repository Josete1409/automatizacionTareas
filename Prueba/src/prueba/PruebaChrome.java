package prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class PruebaChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// the location of chromedriver on your machine
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// This is the location where you have installed Google Chrome on your machine
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/");
		WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
		login.click();
		
		WebElement user = driver.findElement(By.id("login_field"));
		WebElement pass = driver.findElement(By.id("password"));
		
		user.sendKeys("prueba@gmail.com");
		pass.sendKeys("prueba");
		
		WebElement btnLogin = driver.findElement(By.name("commit"));
		btnLogin.submit();		
		
		WebElement btnProfile = driver.findElement(By.xpath("//span[@class='dropdown-caret']"));
		btnProfile.click();
		
		WebElement logout = driver.findElement(By.xpath("//form[@class='logout-form']//button[@class='dropdown-item dropdown-signout'][contains(text(),'Sign out')]"));
		logout.click();
		
	}
}
