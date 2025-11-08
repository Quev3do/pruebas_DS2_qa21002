package integracion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class empleados {
	protected WebDriver driver;
	
 	@BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://belleza-femenina-system-admin-production.up.railway.app/");
    }
 	
 	@Test(priority = 1)
 	public void testBuscarLogin() {
 		driver.findElement(By.name("usuario")).sendKeys("rp123");
 		driver.findElement(By.name("contrasenia")).sendKeys("beto123");
 		driver.findElement(By.xpath("//button")).click();
 		
 		
 		//driver.findElement(By.id("empleadosDropdown")).click();
 		
 		boolean empleados = driver.findElement(By.id("empleadosDropdown")).isDisplayed();
 		
 		Assert.assertTrue(empleados);
 	}
	
 	@Test(priority = 2)
 	public void testBuscarEmpleados() {
 		driver.findElement(By.id("empleadosDropdown")).click();
 		
 		driver.findElement(By.xpath("a[contains(@class,'linkDropdown') and span[@class='labelMenu' and normalize-space()='Empleados']]")).click();
 		
 		boolean empleados = driver.findElement(By.id("card_title")).isDisplayed();
 		
 		Assert.assertTrue(empleados);
 	}
 	
 	@Test(priority = 3)
 	public void testIngresarDatos() {
 		driver.findElement(By.xpath("//a[text()='Crear Nuevo']")).click();
 		
 		driver.findElement(By.id("nombre")).sendKeys("quevedo");
 		driver.findElement(By.id("apellido")).sendKeys("adan");
 		driver.findElement(By.id("telefono")).sendKeys("10918001");
 		driver.findElement(By.id("usuario")).sendKeys("queb2");
 		driver.findElement(By.id("contrasenia")).sendKeys("vz55#");
 		driver.findElement(By.id("idPermiso")).sendKeys("Gerente");
 		
 		driver.findElement(By.xpath("//button[text()='Enviar']")).click();
 		
 		boolean empleados = driver.findElement(By.id("card_title")).isDisplayed();
 		
 		Assert.assertTrue(empleados);
 	}
}
