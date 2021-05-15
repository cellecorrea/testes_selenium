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

public class LoginTestes {
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
	public void rEQ08CT01rejeitaracesso() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(699, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("joao");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("33333");
		driver.findElement(By.cssSelector("button")).click();
	}

	@Test
	public void rEQ09CT01usuariojose() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(699, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
		driver.findElement(By.linkText("Alunos")).click();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("7856");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Amora");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("amora@email.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("03309000");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.linkText("Voltar")).click();
		driver.findElement(By.linkText("Empréstimo")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
		espera();
		driver.switchTo().window(vars.get("win6241").toString());
		driver.findElement(By.linkText("Voltar")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.linkText("Lista de Livros")).click();
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("pogramacao vol 3");
		driver.findElement(By.cssSelector(".btn")).click();
	}

@Test
public void rEQ10CT01usuariomaria() {
  driver.get("https://ts-scel.herokuapp.com/");
  driver.manage().window().setSize(new Dimension(699, 728));
  driver.findElement(By.linkText("Logout")).click();
  driver.findElement(By.name("username")).click();
  driver.findElement(By.name("username")).sendKeys("maria");
  driver.findElement(By.name("password")).click();
  driver.findElement(By.name("password")).sendKeys("456");
  driver.findElement(By.cssSelector("button")).click();
  espera();
  driver.findElement(By.linkText("Alunos")).click();
  driver.findElement(By.id("ra")).click();
  driver.findElement(By.id("ra")).sendKeys("5555");
  driver.findElement(By.id("nome")).click();
  driver.findElement(By.id("nome")).sendKeys("Olivia");
  driver.findElement(By.id("email")).click();
  driver.findElement(By.id("email")).sendKeys("olivia@email.com");
  driver.findElement(By.id("cep")).click();
  driver.findElement(By.id("cep")).sendKeys("79620-050");
  driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
  driver.findElement(By.id("cep")).click();
  driver.findElement(By.id("cep")).sendKeys("79620050");
  driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
  espera();
  driver.findElement(By.linkText("Voltar")).click();
  driver.findElement(By.linkText("Livros")).click();
  driver.findElement(By.linkText("Lista de Livros")).click();
  driver.findElement(By.cssSelector("body")).click();
  driver.findElement(By.linkText("Voltar")).click();
  driver.findElement(By.linkText("Empréstimo")).click();
  vars.put("window_handles", driver.getWindowHandles());
  driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
  espera();
  driver.switchTo().window(vars.get("win3445").toString());
  driver.findElement(By.linkText("Voltar")).click();
}
	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
