package driverfactory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements BrowserManager {

    @Override
    public WebDriver getDriver() {
        return new ChromeDriver();
    }

    @Override
    public Capabilities setCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Ensure new headless mode is used
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        options.setCapability("browserName", "Chrome");
        return options;
    }

}
