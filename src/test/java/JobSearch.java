import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class JobSearch {

    /*@BeforeTest
    public void testBeforeTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://tut.by/");
    }*/

    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\Soft\\Selenium\\Selenium\\geckodriver.exe");
        //opening tut.by in Firefox
        WebDriver driver = new FirefoxDriver();
        driver.get("http://tut.by/");
        //finding the required element and clicking it
        WebElement element = driver.findElement(By.cssSelector("a[title='Работа']") );
        element.click();
        //explicit wait until the textbox is loaded
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<WebElement>(){
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.name("text"));
                    }});
        //entering the search query and submitting
        myDynamicElement.sendKeys("Специалист по тестированию");
        myDynamicElement.submit();
        //explicit wait until div with search results is loaded
        WebElement myDynamicElement2 = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<WebElement>(){
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.cssSelector("div[class='search-result']"));
                    }});
        //gathering the information on the search results into array of String elements
        String[] searchResults = new String[20];
        /*for (int i=0;i<20;i++){
            searchResults[i] =
        }*/

        Thread.sleep(4000);
        System.out.println("Page URL is: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getTitle().equals("Белорусский портал TUT.BY"));

        driver.quit();
    }

    /*
    @AfterTest
    public void testAfterTest() {
        System.out.println("testAfterTest()");
    }
*/
}
