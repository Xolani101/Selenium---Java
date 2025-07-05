import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

    static protected WebDriver driver;

    static{
        WebDriverManager.chromedriver().setup();
        var options = new ChromeOptions();
        //options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
    }

    public static void main(String[] args) {
        driver.get("https://google.com");
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
