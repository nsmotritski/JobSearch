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
                            return d.findElement(By.cssSelector("a[title='Работа']"));
                        }
                    });
            //Clicking the element, opening and initializing the "jobs.tut.by" page
            element.click();
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
            //explicit wait for the list of the results to be shown on the page
            try {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='search-result']")));
            }
            catch (TimeoutException ex) {
                System.out.println("Expected element was not found");
                throw ex;
            }

            /*WebElement searchResult = (new WebDriverWait(driver, 10))
                    .until(new ExpectedCondition<WebElement>(){
                        @Override
                        public WebElement apply(WebDriver d) {
                            return d.findElement(By.cssSelector("div[class='b-pager__arrows']"));
                        }});*/
            List<WebElement> searchResults =  driver.findElements(By.cssSelector("a[data-qa='vacancy-serp__vacancy-title']"));
            boolean expected = false;
            for (WebElement i :searchResults) {
                System.out.println (i.getText());
                if (i.getText().contains(s)) {
                    expected = true;
                }
            }
            Assert.assertTrue(expected);
        }
        catch(AssertionError ex){
            System.err.println("Assertion did not work");
            throw ex;

        }
        //explicit wait for the element to be shown
       /* WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<WebElement>(){
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.name("text"));
                    }});
        //entering the search query and submitting
        myDynamicElement.sendKeys("Специалист по тестированию");
        myDynamicElement.submit();


        WebElement element = driver.findElement(By.cssSelector("a[title='Работа']") );
        element.click();*/
        //explicit wait until the textbox is loaded

        //explicit wait until div with search results is loaded
            /*WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(presenceOfElementLocated(By.cssSelector(
                    String.valueOf(By.xpath("html/body/div[5]/div[1]/div/div[4]/div/table/tbody/tr/td[2]/div/table")))));
            *//*WebElement searchResult = (new WebDriverWait(driver, 10))
                    .until(new ExpectedCondition<WebElement>(){
                        @Override
                        public WebElement apply(WebDriver d) {
                            return d.findElement(By.xpath("html/body/div[5]/div[1]/div/div[4]/div/table/tbody/tr/td[2]/div/table"));
                        }});*//*
            //gathering the information on the search results into array of String elements
           List<WebElement> searchResults =  driver.findElements(By.cssSelector("a[data-qa='vacancy-serp__vacancy-title']"));
            *//*for (int i=0;i<20;i++){
                searchResults[i] =
            }*//*


            System.out.println("Page URL is: " + driver.getCurrentUrl());
            Assert.assertTrue(driver.getTitle().equals("Работа в Минске, поиск работы в Беларуси. Вакансии и резюме на jobs.tut.by | РАБОТА.TUT.BY"));*/
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
