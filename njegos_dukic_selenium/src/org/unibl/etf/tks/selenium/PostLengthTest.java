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

public class PostLengthTest {
	
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
    public void testLength() throws InterruptedException {
	    driver.get("http://localhost:4200/");
	    vars.put("x", driver.findElements(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr")).size());
	    try {
	      Thread.sleep(1000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.linkText("Add Student")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".form-group:nth-child(1) > .form-control")).click();
	    driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[1]/input")).sendKeys("Njegos Dukic");
	    driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[2]/input")).sendKeys("njegos.dukic@gmail.com");
	    driver.findElement(By.cssSelector(".ng-untouched")).click();
	    {
	      WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[3]/select"));
	      dropdown.findElement(By.xpath("//option[. = 'B-Tech']")).click();
	    }
	    driver.findElement(By.cssSelector("option:nth-child(2)")).click();
	    driver.findElement(By.cssSelector(".btn-success")).click();
	    driver.findElement(By.linkText("View Student")).click();
	    Thread.sleep(1000);
	    vars.put("y", driver.findElements(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr")).size());
	    vars.put("x", js.executeScript("return arguments[0]+1", vars.get("x")));
	    assertEquals(vars.get("y").toString(), vars.get("x").toString());
	    driver.quit();
    }
}
