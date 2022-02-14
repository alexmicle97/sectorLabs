package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * Author: Amicle
 */

public class BaseSteps {

public static WebDriver driver;
public static Properties properties;

    /**
     * Base step class constructor for reading the configuration files for the driver
     */
    public BaseSteps() {
        try{
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream("C:\\Users\\Alex\\IdeaProjects\\sectorLabs\\src\\main\\java\\configuration\\config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize method for initialize setting, properties and opening the wanted browser.
     */
    public void initializeDriver() throws InterruptedException {
        String browserName = properties.getProperty("browser");

        if(browserName.equals(properties.getProperty("browser"))){
            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get(properties.getProperty("url"));
    }
}
