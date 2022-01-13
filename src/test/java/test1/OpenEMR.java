package test1;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OpenEMR {
@Test(priority=1)
public void createPatient() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	Actions act=new Actions(driver);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://demo.openemr.io/a/openemr");
	
	driver.findElement(By.id("authUser")).sendKeys("admin");
	driver.findElement(By.id("clearPass")).sendKeys("pass");
	driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[1]/div[1]/div[4]/button/i")).click();
	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div/div[5]/div/div"))).perform();
	driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div/div[5]/div/ul/li[2]/div")).click();
	driver.switchTo().frame(driver.findElement(By.name("pat")));
	Select sal=new Select(driver.findElement(By.id("form_title")));
	sal.selectByValue("Mr.");
	
	//Thread.sleep(3000);
	
	//driver.findElement(By.name("form_title")).sendKeys("MR.");
	driver.findElement(By.id("form_fname")).sendKeys("first");
	driver.findElement(By.name("form_fname")).sendKeys("M");
	driver.findElement(By.name("form_lname")).sendKeys("last");
	//driver.findElement(By.id("form_DOB")).sendKeys(("2022-01-11");
	driver.findElement(By.id("form_DOB")).click();
	//driver.findElement(By.className("xdsoft_today")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/table/tbody/tr[3]/td[3]/div")).click();
Select gender=new Select(driver.findElement(By.id("form_sex")));
   gender.selectByVisibleText("Male");
	driver.findElement(By.id("create")).click();
	driver.switchTo().defaultContent();
    driver.switchTo().frame(driver.findElement(By.id("modalframe")));
    driver.findElement(By.className("btn-primary")).click();
wait.until(ExpectedConditions.alertIsPresent());
System.out.println(driver.switchTo().alert().getText());
driver.switchTo().alert().accept();
//driver.switchTo().frame(By.id("logoutinnerframe"));

}
@Test
public void register() {
	
}
}
