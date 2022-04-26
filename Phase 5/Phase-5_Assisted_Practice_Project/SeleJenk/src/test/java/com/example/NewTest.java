package com.example;        

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class NewTest {      
        private WebDriver driver;   
        SoftAssert soft=new SoftAssert();
        @Test               
        public void testEasy() {    
            System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\tamas\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.get("https://www.facebook.com");  
            String title = driver.getTitle();                
            AssertJUnit.assertEquals("FB Login",title);        
        }   
       /* @BeforeTest
        public void beforeTest() {  
            driver = new FirefoxDriver();  
        }       
        @AfterTest
        public void afterTest() {
            driver.quit();          
        }  
        */     
}
