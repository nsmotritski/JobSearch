import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JobsTutBy {
    public void jobsTutByPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement searchString(WebDriver driver, String s) {
        return driver.findElement(By.cssSelector("a[name='"+s+"']") );
    }
}
