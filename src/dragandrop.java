import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class dragandrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> list=driver.findElements(By.tagName("iframe"));
		System.out.println(list.size());
		driver.switchTo().frame(0);
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		System.out.println(element.getText());
		
		WebElement drop=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		System.out.println(drop.getText());
		
		Actions action=new Actions(driver);
		action.moveToElement(element).dragAndDrop(element, drop).build().perform();

	}

}
