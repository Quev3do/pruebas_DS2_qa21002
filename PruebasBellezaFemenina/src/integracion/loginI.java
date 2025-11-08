package integracion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginI {
protected WebDriver driver;
	
 	@BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://belleza-femenina-system-production-f457.up.railway.app/");
    }
 	
 	@Test(priority = 1)
 	public void testBuscarLogin() {
 		driver.findElement(By.cssSelector(".nav-link.navLink.dropdown-toggle.userDropdown")).click();
 		driver.findElement(By.cssSelector(".dropdown-item.dropdownItem")).click();
 		
 		//driver.findElement(By.id("signUp")).click();
        
        boolean buscar = driver.findElement(By.xpath("//button[text()='Iniciar sesión']")).isDisplayed();
 		
 		Assert.assertTrue(buscar);
    }
 	
 	@Test(priority = 2)
	public void testLogin() {
		driver.findElement(By.name("email")).sendKeys("qa21002@ues.edu.sv");
	    driver.findElement(By.name("password")).sendKeys("Adan1234#");
	    
	    driver.findElement(By.xpath("//button[text()='Iniciar sesión']")).click();
	    
	    boolean inicio = driver.findElement(By.cssSelector(".nav-link.navLink.dropdown-toggle.userDropdown")).isDisplayed();
	    
	    Assert.assertTrue(inicio);
	}
}
