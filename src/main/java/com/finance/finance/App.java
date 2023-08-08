package com.finance.finance;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import java.io.File;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
	@SuppressWarnings({ "deprecation" })
	public static void main(final String[] args) throws InterruptedException, IOException {
		//System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		System.setProperty("webdriver.chrome.driver", "F:\\\\chromedriver_win32\\\\chromedriver.exe");
		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		//chromeOptions.addArguments(new String[] { "--headless" });
		//chromeOptions.addArguments(new String[] { "--no-sandbox" });
		chromeOptions.addArguments(new String[] { "--disable-dev-shm-usage" });
		final WebDriver driver = (WebDriver) new ChromeDriver(chromeOptions);
		driver.get("http://43.204.145.218:8084/contact.html");
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.findElement(By.name("Name")).sendKeys(new CharSequence[] { "Vikul" });
		driver.findElement(By.name("Phone Number")).sendKeys(new CharSequence[] { "9999999999" });
		driver.findElement(By.name("Email")).sendKeys(new CharSequence[] { "vikul@gmail.com" });
		driver.findElement(By.name("Message")).sendKeys(new CharSequence[] { "Welcome to the DevOps session" });
		driver.findElement(By.className("send_bt")).click();
		final String message = driver.findElement(By.id("message")).getText();
		if (message.equals("Email Sent")) {
			System.out.println("Script executed Successfully");
		} else {
			System.out.println("Script failed");
		}
		Thread.sleep(3000L);
		//driver.quit();
		}

}
