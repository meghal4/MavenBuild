package test1;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Laaveo {
	@Test
	public void openLaveo() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		Actions act=new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://platform.laaveo.com/application/dashboard");
		
		driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("dhimen.laaveo@yopmail.com");
		driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys("dhimen.laaveo@yopmail.com");
		driver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/form/div/div[2]/button")).click();
		
	}

}
