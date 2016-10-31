import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.util.List;

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
        try {
            TutBy tutBy = new TutBy();
            tutBy.Navigate(driver);
            tutBy.tutByHomePage(driver);
            //explicit wait until the menu item is loaded
            WebElement element = (new WebDriverWait(driver, 10))
                    .until(new ExpectedCondition<WebElement>() {
                        @Override
                        public WebElement apply(WebDriver d) {
                            return d.findElement(By.id("mainmenu"));
                        }
                    });
            //Clicking the element, opening and initializing the "jobs.tut.by" page
            element.findElement(By.xpath("//ul/li[6]")).click();
            JobsTutBy jobsPage = new JobsTutBy();
            jobsPage.jobsTutByPage(driver);
            //explicit wait until the menu item is loaded
            WebElement searchElement = (new WebDriverWait(driver, 10))
                    .until(new ExpectedCondition<WebElement>() {
                        @Override
                        public WebElement apply(WebDriver d) {
                            return d.findElement(By.cssSelector("input[name='text']"));
                        }
                    });
            String s = "Специалист по тестированию";
            searchElement.sendKeys(s);
            searchElement.submit();
            /*//explicit wait for the list of the results to be shown on the page - does not work
            try {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='search-result']")));
            }
            catch (TimeoutException ex) {
                System.out.println("Expected element was not found");
                throw ex;
            }*/
            //Getting list of headers of the search result elements
            WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("search-result")));

            List<WebElement> findElements = myDynamicElement.findElements(By.className("search-result-item"));

            for (WebElement webElement : findElements)
            {
                System.out.println (webElement.findElement(By.xpath("div/div[2]/div[1]/a")).getText());
            }
            //Checking the condition
            boolean expected = false;
/*            System.out.println(searchResults.size());
            for (WebElement i :searchResults) {
                System.out.println (i.getText());
                if (i.getText().contains(s)) {
                    expected = true;
                }
            }*/
            Assert.assertTrue(expected);
        }
        catch(AssertionError ex){
            System.err.println("Assertion did not work");
            throw ex;

        }

        finally {
            driver.quit();
        }

    }

    /*
    @AfterTest
    public void testAfterTest() {
        System.out.println("testAfterTest()");
    }
*/
}
