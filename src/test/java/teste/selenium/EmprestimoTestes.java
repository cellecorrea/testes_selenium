package teste.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

public class EmprestimoTestes {
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
	public void REQ06CT01emprestimocomsucesso() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		espera();
		driver.get("https://ts-scel.herokuapp.com/");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.linkText("Empréstimo")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1994");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("4444");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	}

	@Test
	public void REQ06CT02emprestimoisbninvalido() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		espera();
		driver.get("https://ts-scel.herokuapp.com/");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.linkText("Empréstimo")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("7894");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("4444");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	}


	@Test
	public void rEQ07CT01develocucaoempretimo() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		espera();
		driver.get("https://ts-scel.herokuapp.com/");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.linkText("Empréstimo")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1994");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("4444");
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();	
		driver.switchTo().window(vars.get("win515").toString());
		driver.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();
	}



	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
