package SampleTest;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.Actions;

public class TestSuiteOne {

	public static void main(String[] args)throws Exception {
		
		System.out.println("**** Initiating Test Run ****");
		
		//WebDriver driver = new FirefoxDriver();

		File pathToBinary = new File("C:\\Users\\kierson.vigilla\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amaysim.com.au/help/manage-account");		
		Assert.assertEquals("Manage your account | amaysim",driver.getTitle());
		System.out.println("correct page loaded!");
		
		
		driver.findElement(By.id("manage-your-plan-amp-service")).click();
		System.out.println("accordion jquery for managing amp service seen!");
		
		driver.findElement(By.id("account-settings")).click();
		System.out.println("accordion jquery for account settings seen!");
		
		driver.findElement(By.id("manage-your-data-usage")).click();
		System.out.println("accordion jquery for managing data usage seen!");
		
		Actions action1 = new Actions(driver);
		WebElement we1 = driver.findElement(By.linkText("plans"));
		action1.moveToElement(we1).build().perform();

		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("C:\\Users\\Public\\ScreenshotHoverPlans.png"));
        System.out.println("screenshot for hovered plans navigation saved at C:\\Users\\Public\\");
        
        Actions action2 = new Actions(driver);
		WebElement we2 = driver.findElement(By.linkText("about"));
		action2.moveToElement(we2).build().perform();

		File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile2, new File("C:\\Users\\Public\\ScreenshotHoverAbout.png"));
        System.out.println("screenshot for hovered about navigation saved at C:\\Users\\Public\\");
                	
		
		System.out.println("**** Test Run Completed ****");
	}

}
