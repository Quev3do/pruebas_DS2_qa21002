package unitarias;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class empleadosGestion {
	
	protected WebDriver driver;
	
 	@BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //la direccion cliente de Belleza Femenina
        driver.get("https://belleza-femenina-system-admin-production.up.railway.app/");
    }
 	
 	@Test(priority = 1)
 	public void testBuscarLogin() {
 		driver.findElement(By.name("usuario")).sendKeys("rp123");
 		driver.findElement(By.name("contrasenia")).sendKeys("beto123");
 		driver.findElement(By.xpath("//button")).click();
 		
 		//boolean login = driver.findElement(By.id("empleadosDropdown")).isDisplayed();
 		
 		driver.findElement(By.id("empleadosDropdown")).click();
 		
 		//driver.findElement(By.id("empleadosMenu")).click();
 		
 		boolean empleados = driver.findElement(By.id("empleadosMenu")).isDisplayed();
 		
 		Assert.assertTrue(empleados);
 	}
	
 	@Test(priority = 2)
 	public void testBuscarEmpleados() {
 		driver.findElement(By.id("empleadosMenu")).click();
 		
 		boolean empleados = driver.findElement(By.className(".btn.btn-primary.btn-sm.float-right")).isDisplayed();
 		
 		Assert.assertTrue(empleados);
 	}
	//https://belleza-femenina-system-admin-production.up.railway.app/
	//rp123 beto123
	//aside: class -> mainSidebar
	//div: class -> sidebarcontentMain
	//ul: class -> sidebarcontentMain
	//a: class -> sidebarcontentMain
	
	//span: class -> labelMenu (text: Permisos)
	//a: class -> btn btnNuevoPermiso
	
	//span: class -> labelManu (text: Empleados)
	//a: class -> btn btn-primary btn-sm float-right
	
	

}
