package test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
		SearchBox.sendKeys("samsung mobile");
		WebElement searchbutton = driver.findElement(By.id("nav-search-submit-button"));
		
		searchbutton.click();
        List<WebElement> mobilename = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		
		List<WebElement> mobileprice = driver.findElements(By.xpath("//div[@class='a-section']//a//span[@class='a-price-whole']"));
		
		List<WebElement> correncysymbol = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		
		for(int i=0;i<mobileprice.size();i++)
		{
				System.out.println("mobile : " + mobilename.get(i).getText());
				System.out.println("Price : "+correncysymbol.get(i).getText() + " " +mobileprice.get(i).getText());
		}
		TakesScreenshot ssobj = (TakesScreenshot) driver;
		File fileObj = ssobj.getScreenshotAs(OutputType.FILE);
		File screenshotObject = new File("amazonss.png");
		
		FileUtils.copyFile(fileObj,screenshotObject);
		driver.close();
		
		
	}

}
