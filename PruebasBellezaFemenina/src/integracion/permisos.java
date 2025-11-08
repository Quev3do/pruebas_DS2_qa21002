package integracion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class permisos {
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
 		
 		boolean permisos = driver.findElement(By.id("empleadosDropdown")).isDisplayed();
 		
 		Assert.assertTrue(permisos);
 	}

 	@Test(priority = 2)
 	public void testBuscarEmpleados() {
 		driver.findElement(By.id("empleadosDropdown")).click();
 		
 		driver.findElement(By.xpath("a[contains(@class,'linkDropdown') and span[@class='labelMenu' and normalize-space()='Permisos']]")).click();
 		
 		boolean per = driver.findElement(By.cssSelector(".btn.btnNuevoPermiso")).isDisplayed();
 		
 		Assert.assertTrue(per);
 	}
 	
 	@Test(priority = 3)
 	public void testNuevoPermiso() {  
 		driver.findElement(By.id("nombre_permiso")).sendKeys("Junior");
 		driver.findElement(By.id("registroVentas")).click();
 		driver.findElement(By.xpath("//button[text()='Guardar']")).click();
 		
 		boolean permisosT = driver.findElement(By.cssSelector("tablaPermisoCompleta")).isDisplayed();
 		
 		Assert.assertTrue(permisosT);
 	}
 	
 		
 		
}
