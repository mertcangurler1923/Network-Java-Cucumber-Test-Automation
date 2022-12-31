package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseDriver {
    public static WebDriver driver;
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.network.com.tr/");
        driver.manage().window().maximize();
    }
    public static void tearDown(){
        driver.quit();
    }

}
