import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class TutBy {
    private String url = "http://tut.by";
    public void tutByHomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement menuItem(WebDriver driver,String s) {
        return driver.findElement(By.cssSelector("a[title='"+s+"']") );
    }

    public void Navigate(WebDriver driver) {
        driver.get(this.url);
    }

}
