package prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class PruebaFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// the location of geckodriver on your machine
		System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		// This is the location where you have installed Firefox on your machine
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		options.addArguments("--no-remote");
		options.addPreference("dom.ipc.processCount", 8);

		WebDriver driver = new FirefoxDriver();
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
