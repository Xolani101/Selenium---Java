import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

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
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");
        System.out.println("Page title is: " + driver.getTitle());

        WebElement emailTextbox = driver.findElement(By.id("working"));
        System.out.println("Email Textbox: " + emailTextbox.getAttribute("type"));

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        System.out.println(radioButtons.size() + " radio buttons found.");

        WebElement bottomButton = driver.findElement(
            RelativeLocator.with(By.name("submit")).below(By.id("submit"))
        );
        System.out.println("Bottom Button Text: " + bottomButton.getAttribute("value"));

        WebElement image = driver.findElement(By.id("imageButton"));
        System.out.println("Image Button Alt Text: " + image.getAttribute("alt"));

        WebElement buttonClick = driver.findElement(By.cssSelector("input[value='Click!']"));
        System.out.println("Button Click Text: " + buttonClick.getAttribute("value"));

        driver.quit();
    }
}
