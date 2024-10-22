package br.developergiulia.funcional;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:/dev/java/129.0.6668.59/chrome-win32/chrome.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to("http://localhost:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		
		// Clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();
		
		// Escrever a descrição
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
				
		// Escrever a data 
		driver.findElement(By.id("dueDate")).sendKeys("01/01/2030");
		
		// Clicar em Salvar
		driver.findElement(By.id("saveButton")).click();
		
		// Validar Mensagem de Sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assertions.assertEquals("Success!", message);
		
		driver.quit();
	}
}
