import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.rediff.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[2]/div/a")).click();
		WebElement drop_day=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
		List<WebElement> options_day=drop_day.findElements(By.tagName("option"));
		System.out.println(options_day.size());
		
/*		for(int i=0;i<options_day.size();i++) {
			String option_text=options_day.get(i).getAttribute("value");
			System.out.println(i+","+option_text);
			if(option_text.equals("12")) {
				options_day.get(i).click();
			}
		}
	*/	
		for(WebElement e: options_day)
		{
			if(e.getAttribute("value").equals("12"))
				e.click();
		}
		WebElement drop_month = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
		List<WebElement> option_month= drop_month.findElements(By.tagName("option"));
		System.out.println(option_month.size());
		
		for(WebElement e:option_month) {
			//System.out.println(e.getAttribute("value"));
			if(e.getAttribute("value").equals("05"))
				e.click();
		}
		
		WebElement drop_year=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
		List<WebElement> option_year =drop_year.findElements(By.tagName("option"));
		System.out.println(option_year.size());
		
		for(WebElement e:option_year) {
			if(e.getAttribute("value").equals("1996"))
			e.click();
		}
				
		
	}

}
