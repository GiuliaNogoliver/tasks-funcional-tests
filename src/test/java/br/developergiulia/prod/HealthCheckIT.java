package br.developergiulia.prod;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HealthCheckIT {

    @Test
    public void healthCheck() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/dev/java/129.0.6668.59/chrome-win32/chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        try {
            // Botar o IP seria melhor - boa pratica
            driver.navigate().to("http://localhost:8001/tasks/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String version = driver.findElement(By.className("lead")).getText();
            Assertions.assertEquals("A very simple task management tool", version);
        } finally {
            driver.quit();
        }
    }
}