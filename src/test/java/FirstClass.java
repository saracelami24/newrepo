import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class FirstClass {
   WebDriver driver;
    @BeforeTest
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) throws Exception{

        if(browser.equalsIgnoreCase("firefox")){
           System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/selenium/geckodriver-v0.30.0-win64/geckodriver.exe");
            driver = new FirefoxDriver();
            System.out.println("browser is " +browser);
        }

        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/selenium/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("browser is " +browser);
        }
        else if(browser.equalsIgnoreCase("Edge")){
        System.setProperty("webdriver.edge.driver", "/Users/user/Downloads/selenium/edgedriver_win32/msedgedriver.exe");
        driver = new EdgeDriver();
            System.out.println("browser is " +browser);
        }
        else{
            throw new Exception("Incorrect Browser");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
   public void Test() throws InterruptedException {
        /*System.setProperty("webdriver.edge.driver", "/Users/user/Downloads/selenium/edgedriver_win32/msedgedriver.exe");

        WebDriver driver = new EdgeDriver();*/

        driver.get("https://teflonline.teachaway.com/enroll/");
        driver.manage().window().maximize();
        WebElement accept = driver.findElement(By.id("hs-eu-confirmation-button"));
        accept.click();
        WebElement enroll = driver.findElement(By.xpath("//body/div[@id='global_wrapper']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/p[1]/a[1]"));
        enroll.click();
        Thread.sleep(3000);
        WebElement message = driver.findElement(By.xpath("//body/div[@id='global_wrapper']/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        message.isDisplayed();
        System.out.println(message.isDisplayed());
        driver.quit();
    }

}
