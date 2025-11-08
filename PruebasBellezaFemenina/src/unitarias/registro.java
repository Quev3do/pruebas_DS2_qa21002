package unitarias;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class registro {
	protected WebDriver driver;
	
 	@BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //la direccion cliente de Belleza Femenina
        driver.get("https://belleza-femenina-system-production-f457.up.railway.app/");
    }
 	
 	@Test(priority = 1)
 	public void testBuscarLogin() {
 		driver.findElement(By.cssSelector(".nav-link.navLink.dropdown-toggle.userDropdown")).click();//menu desplegable
 		driver.findElement(By.cssSelector(".dropdown-item.dropdownItem")).click();//ambos (login y registro) usan estas clases
 		
 		boolean login = driver.findElement(By.xpath("//button[text()='Iniciar sesión']")).isDisplayed();
 		
 		Assert.assertTrue(login);
 	}
 	
 	@Test(priority = 2)
 	public void testBuscarRegistro() {
 		boolean registro = driver.findElement(By.id("signUp")).isDisplayed();//boton para ir a registro
 		
 		Assert.assertTrue(registro);
    }
 	
 	@Test(priority = 3)
 	public void testBuscarFormRegistro() {
 		driver.findElement(By.id("signUp")).click();
 		
        boolean crear = driver.findElement(By.xpath("//button[text()='Crear cuenta']")).isDisplayed();
        boolean formR = driver.findElement(By.id("registerForm")).isDisplayed();
        
        Assert.assertTrue(crear && formR);
 	}
 	
}
