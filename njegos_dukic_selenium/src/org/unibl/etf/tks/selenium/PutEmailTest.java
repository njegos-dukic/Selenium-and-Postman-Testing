package org.unibl.etf.tks.selenium;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class PutEmailTest {
	
	private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    
    @Before
    public void setUp() {
    	System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
    	driver = new FirefoxDriver();
    	js = (JavascriptExecutor) driver;
    	vars = new HashMap<String, Object>();
    }
    
    @Test
    public void testName() throws InterruptedException {
	    driver.get("http://localhost:4200/");
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("Add Student")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".form-group:nth-child(1) > .form-control")).click();
	    driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[1]/input")).sendKeys("Njegos Dukic");
	    driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[2]/input")).sendKeys("njegos.dukic@mail.com");
	    {
	      WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[3]/select"));
	      dropdown.findElement(By.xpath("//option[. = 'B-Tech']")).click();
	    }
	    driver.findElement(By.cssSelector(".btn-success")).click();
	    driver.findElement(By.linkText("View Student")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".btn-info")).click();
        Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
	    driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[1]/input")).clear();
	    driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[1]/input")).sendKeys("Njegos Dukic Updated");
	    driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[2]/input")).clear();
	    driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[2]/input")).sendKeys("njegos.dukic.998@gmail.com");
	    driver.findElement(By.cssSelector(".ng-untouched:nth-child(2)")).click();
	    {
	      WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[3]/select"));
	      dropdown.findElement(By.xpath("//option[. = 'M-Tech']")).click();
	    }
	    driver.findElement(By.cssSelector(".btn-success")).click();
	    driver.findElement(By.cssSelector(".btn-danger")).click();
	    assertThat(driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr/td[2]")).getText(), is("njegos.dukic.998@gmail.com"));
	    driver.quit();
    }
}
