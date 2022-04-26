package q1_Automate_a_Web_Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {

	public static void main(String[] args) {

		String path= "C:\\Users\\TAMASJIT\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		
		///initiate the driver
		WebDriver driver= new ChromeDriver();
		///step:2 base url
		String base_url= "https://learner.demo.edunext.co/register";
		///step:3 launching edunext.co
		driver.get(base_url);
		
		WebElement name= driver.findElement(By.id("register-name"));
		name.getAttribute("placeholder");
		System.out.println(name.getAttribute("placeholder"));
		
		WebElement username= driver.findElement(By.id("register-username"));
		username.getAttribute("placeholder");		
		System.out.println(username.getAttribute("placeholder"));
		
		WebElement email= driver.findElement(By.id("register-email"));
		email.getAttribute("placeholder");
		System.out.println(email.getAttribute("placeholder"));
		
		WebElement password= driver.findElement(By.id("register-password"));
		password.getAttribute("placeholder");
		System.out.println(password.getAttribute("placeholder"));
		driver.findElement(By.id("register-terms_of_service")).click();
		driver.findElement(By.id("register-honor_code")).click();
		
		name.sendKeys("Tamasjit Ghoshal");
		username.sendKeys("tamasjit3");
		email.sendKeys("tamasjit3@gmail.com");
		password.sendKeys("Howrah$22@1999");
		 
		WebElement login= driver.findElement(By.className("action-primary"));
		login.click();
		
		
		//driver.close();
	}
}
