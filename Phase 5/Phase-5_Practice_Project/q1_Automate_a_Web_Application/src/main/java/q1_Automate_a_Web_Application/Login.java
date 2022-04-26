package q1_Automate_a_Web_Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {

		String path= "C:\\Users\\TAMASJIT\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		
		///initiate the driver
		WebDriver driver= new ChromeDriver();
		///step:2 base url
		String base_url= "https://learner.demo.edunext.co/login";
		///step:3 launching edunext.co
		driver.get(base_url);
		
		WebElement email= driver.findElement(By.id("login-email"));
		email.getAttribute("placeholder");
		System.out.println(email.getAttribute("placeholder"));
		
		WebElement password= driver.findElement(By.id("login-password"));
		password.getAttribute("placeholder");		
		System.out.println(password.getAttribute("placeholder"));
		
		email.sendKeys("tamasjit3@gmail.com");
		password.sendKeys("Howrah$22@1999");
		
		 
		WebElement login= driver.findElement(By.className("action-primary"));
		login.click();
		
		
		//driver.close();
	}
}
