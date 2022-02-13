package org.unibl.etf.tks.selenium;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class DeleteLengthTest {
	
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
	public void testDelete() throws InterruptedException {
		driver.get("http://localhost:4200/");
		Thread.sleep(1000);
		vars.put("x", driver.findElements(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr")).size());
		driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr[1]/td[4]/button[1]")).click();
		vars.put("y", driver.findElements(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr")).size());
		vars.put("x", js.executeScript("return arguments[0]-1", vars.get("x")));
		assertEquals(vars.get("y").toString(), vars.get("x").toString());
		driver.quit();
	}
}
