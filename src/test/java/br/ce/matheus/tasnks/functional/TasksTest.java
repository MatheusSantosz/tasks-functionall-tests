package br.ce.matheus.tasnks.functional;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TasksTest {
	public WebDriver AcessarAplicacao (){
		System.setProperty("webdriver.chrome.driver", "D:\\dev\\java\\seleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = AcessarAplicacao();
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		//escrever descricao
		driver.findElement(By.id("task")).sendKeys("teste via selenium");
		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("14/03/2022");
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		//validar mensagem de sucesso
		String menssage = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", menssage);
		} finally {
		//fechar o browser
		driver.quit();
		
		}
	}
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = AcessarAplicacao();
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		//validar mensagem de sucesso
		String menssage = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", menssage);
		} finally {
		//fechar o browser
		driver.quit();
		
		}
		
	}
	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = AcessarAplicacao();
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		//escrever descricao
		driver.findElement(By.id("task")).sendKeys("teste via selenium");
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		//validar mensagem de sucesso
		String menssage = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", menssage);
		} finally {
		//fechar o browser
		driver.quit();
		
		}
	}
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		WebDriver driver = AcessarAplicacao();
		try {
		//clicar em Add todo
		driver.findElement(By.id("addTodo")).click();
		//escrever descricao
		driver.findElement(By.id("task")).sendKeys("teste via selenium");
		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("14/03/2010");
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		//validar mensagem de sucesso
		String menssage = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", menssage);
		} finally {
		//fechar o browser
			//
		driver.quit();		
		
		}
	}
	
	
	
}
