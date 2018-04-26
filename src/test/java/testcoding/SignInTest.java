package testcoding;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

	WebDriver driver;
	Basecode base = new Basecode();
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		base.setDriverPath();
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		base.waitFor(2000);

		driver.findElement(By.linkText("Your trips")).click();
		driver.findElement(By.id("SignIn")).click();
		base.waitFor(5000);
		driver.switchTo().frame("modal_window");
		driver.findElement(By.xpath(".//*[@id='ContentFrame']//form//dd[contains(@class,'submit')]/button")).click();
		String errors1 = driver.findElement(By.id("errors1")).getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		driver.quit();
	}

}
