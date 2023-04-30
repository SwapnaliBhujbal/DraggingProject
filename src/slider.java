import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class slider {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   List<WebElement>list=driver.findElements(By.tagName("iframe"));
	   System.out.println(list.size());
	   
	   driver.switchTo().frame(0);
	   
	  WebElement slider= driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
	  Actions action=new Actions(driver);
	  action.moveToElement(slider).dragAndDropBy(slider, 300,0).build().perform();
	  for(int i=1; i<20;i++)
	  action.moveToElement(slider).sendKeys(slider, Keys.ARROW_RIGHT).build().perform();

	}

}
