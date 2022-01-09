package atos.syntel;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.event.KeyEvent;
public class YouTubeAutomation {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\N.rajesh\\\\\\\\.eclipse\\\\\\\\SeleniumPro\\\\\\\\chrome\\\\\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("youtube");
		List<WebElement> opt = driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li/descendant::div[@class='eIPGRd']"));
		System.out.println(opt.size());
		for(int i=0;i<=opt.size();i++)
		{
			String tr = opt.get(i).getText();
			System.out.println(tr);
			if(tr.contains("YouTube"))
			{
				opt.get(i).click();
				break;
			}
		
		}
	WebElement link = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
    Actions a=new Actions(driver);
    a.contextClick(link).build().perform();
    Robot r=new Robot();
    r.keyPress(KeyEvent.VK_DOWN);
    r.keyRelease(KeyEvent.VK_DOWN);
    r.keyPress(KeyEvent.VK_ENTER);
    r.keyRelease(KeyEvent.VK_ENTER);
    String re = driver.getWindowHandle();
 Set<String> wh = driver.getWindowHandles();
  for (String th : wh) {
	if(th.equalsIgnoreCase(re))
	{
		driver.switchTo().window(th);
	}
}
driver.switchTo().window(re);
	}

}
