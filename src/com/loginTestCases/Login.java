package com.loginTestCases;

import java.io.FileInputStream;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {
	WebDriver driver;

	Object[][] data = null;

	@DataProvider(name = "loginData")

	public Object[][] loginDataProvider() throws BiffException, IOException {

		data = getExcellData();
		return data;
	}

	public String[][] getExcellData() throws BiffException, IOException {

		FileInputStream excell = new FileInputStream("F:\\musheik\\DatadrivenExcell\\Book1.xls");

		Workbook workbook = Workbook.getWorkbook(excell);

		Sheet sheet = workbook.getSheet(0); // or give index of sheet its starts feom zero

		int rowCount = sheet.getRows();

		int columnsCount = sheet.getColumns();

		String testData[][] = new String[rowCount - 1][columnsCount];

		for (int row = 1; row < rowCount; row++) { // row starts from one becuase we dont need first row

			for (int column = 0; column < columnsCount; column++) {
				testData[row - 1][column] = sheet.getCell(column, row).getContents(); // starts from(1,0)

			}

		}
		return testData;

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\musheik2\\AutomationArulPrasath\\DataDrivenExcel4video\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

	@Test(dataProvider = "loginData")

	public void loginWithCorrectUserNameAndCorrectPassword(String uname, String pword) throws InterruptedException {
		String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";

		driver.get(url);


		Thread.sleep(3000);

		WebElement username = driver.findElement(By.id("txtUsername"));

		username.sendKeys(uname);
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys(pword);
		Thread.sleep(3000);

		WebElement loginbtn = driver.findElement(By.xpath("//input[@name='Submit']"));
		loginbtn.click();
		Thread.sleep(3000);

	}

	
}
