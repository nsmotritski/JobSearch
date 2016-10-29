import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Николай on 29.10.2016.
 */
public class SeleniumTest {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com");
    }

}
