package teste.selenium;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MantemLivroTestes {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browser_driver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void REQ01CT01cadastrolivrocomsucesso() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("7894");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("Daniel Kenji");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("O Santos Caiu");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		driver.findElement(By.linkText("Excluir")).click();
	}
	
		  @Test
		  public void REQ02CT01testeentradainvalidamin() {
		    driver.get("https://ts-scel.herokuapp.com/");
		    driver.manage().window().setSize(new Dimension(1382, 744));
			driver.findElement(By.name("username")).click();
			driver.findElement(By.name("username")).sendKeys("jose");
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.cssSelector("button")).click();
			espera();
		    driver.findElement(By.linkText("Livros")).click();
		    driver.findElement(By.id("isbn")).click();
		    driver.findElement(By.id("isbn")).sendKeys("4");
		    driver.findElement(By.id("autor")).click();
		    driver.findElement(By.id("autor")).sendKeys("Gabriel Alex");
		    driver.findElement(By.id("titulo")).click();
		    driver.findElement(By.id("titulo")).sendKeys("Olá amigos");
		    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		  }
		  
		  @Test
		  public void REQ02CT02testeentradainvalidamax() {
		    driver.get("https://ts-scel.herokuapp.com/");
		    driver.manage().window().setSize(new Dimension(1382, 744));
		    driver.get("https://ts-scel.herokuapp.com/");
		    driver.manage().window().setSize(new Dimension(1382, 744));
			driver.findElement(By.name("username")).click();
			driver.findElement(By.name("username")).sendKeys("jose");
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).sendKeys("123");
			driver.findElement(By.cssSelector("button")).click();
			espera();
		    driver.findElement(By.linkText("Livros")).click();
		    driver.findElement(By.id("isbn")).click();
		    driver.findElement(By.id("isbn")).sendKeys("458697");
		    driver.findElement(By.id("autor")).click();
		    driver.findElement(By.id("autor")).sendKeys("Marcelle");
		    driver.findElement(By.id("titulo")).click();
		    driver.findElement(By.id("titulo")).sendKeys("Hoje não");
		    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		  }
		  

	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
