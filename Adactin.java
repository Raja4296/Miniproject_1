package adactinproject;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Adactin {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajadurai\\Desktop\\SELENIUM\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://adactinhotelapp.com/index.php");
	    String currentUrl = driver.getCurrentUrl();
	    System.out.println(currentUrl);
	    String title = driver.getTitle();
	    System.out.println(title);
	    driver.findElement(By.id("username")).sendKeys("Rajapandi4296");
	    driver.findElement(By.id("password")).sendKeys("Rutumsd7");
	    driver.findElement(By.id("login")).click();
	    List<WebElement> alldd = driver.findElements(By.tagName("select"));
	    for (int i=0; i<alldd.size(); i++) {
	    	WebElement a = alldd.get(i);
		    Select  s = new Select(a);
		    if(i==0) {
		    s.selectByValue("Adelaide");
		    }
		    else if(i==1) {
			    s.selectByValue("Hotel Hervey");}
		    else if(i==2) {
			    s.selectByValue("Double");}
		    else if(i==3) {
			    s.selectByValue("1");}
		    else if(i==4) {
			    s.selectByValue("2"); }
		    else{
			    s.selectByValue("0"); }}
	    WebElement dat = driver.findElement(By.cssSelector("#datepick_in"));
	    dat.clear();
	    dat.sendKeys("28/11/2021");
	    WebElement date = driver.findElement(By.cssSelector("#datepick_out"));
	    date.clear();
	    date.sendKeys("29/11/2021");
	    driver.findElement(By.xpath("//input[@id='Submit']")).click();
	    driver.findElement(By.cssSelector("#radiobutton_0")).click();
	    driver.findElement(By.xpath("//input[@id='continue']")).click();
	    driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Rajapandi");
	    driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Ramamoorthy");
	    driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys
	    ("P.no-1, Vignesh nagar, Mariammankovil, Thanjavur.");
	    driver.findElement(By.xpath("//input[@id='cc_num']")).sendKeys("4332456788993321");
	    List<WebElement> allcc = driver.findElements(By.tagName("select"));
	    for (int i=0; i<allcc.size(); i++) {
	    	WebElement b = allcc.get(i);
		    Select  s = new Select(b);
		    if(i==0) {
		    s.selectByValue("VISA");
		    }
		    else if(i==1) {
			    s.selectByValue("2");}
		    else if(i==2) {
			    s.selectByValue("2022");}
		   }
	    driver.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys("456");
	    driver.findElement(By.cssSelector("#book_now")).click();
	    driver.findElement(By.xpath("//input[@id='my_itinerary']")).click();
	    
	    Thread.sleep(4000);
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File g = ts.getScreenshotAs(OutputType.FILE);
	    File h = new File("./Screenshot/adactin.png");
	    FileHandler.copy(g, h);
	}
}