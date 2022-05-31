import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class SmtestUsers {
    WebDriver driver = null;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://WebDrivers//chromedriver//chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testSmtestUsers() throws Exception {
        driver.get("http://smtest.suffixit.com:8576/");
//        driver.get("http://172.168.10.165:3000/");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("DIST@321!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a")).click(); //Report
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")).click(); //DSS
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/ul/li[1]/a/span")).click(); //DSS ALL

        driver.findElement(By.xpath("(//*[@id=\"Zone\"])[1]")).click(); //Select Wing
        driver.findElement(By.xpath("//*[text()='Dhaka']")).click();
//        driver.findElement(By.xpath("(//*[@id=\"Zone\"])[1]")).click(); //Select second wing
//        driver.findElement(By.xpath("//*[text()='Potential']")).click();

        driver.findElement(By.xpath("(//*[@id=\"Zone\"])[2]")).click(); //Select Division
        WebElement division = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Narayanganj']")));
        division.click();


//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id=\"Zone\"]/div[1])[3]"))).click(); //Select Teritory
//        driver.findElement(By.xpath("//*[text()='Narayanganj']")).click();

        driver.findElement(By.xpath("//*[@id=\"ProductCategory\"]/div/div[1]")).click(); //Click Category
        driver.findElement(By.xpath("//*[text()='Cigrettee']")).click(); //Select Cigrette
        driver.findElement(By.xpath("//*[@id=\"marketWiseTargetAdd\"]/div[7]/div/div[1]/div/div/div/input")).click(); //Click Month
        driver.findElement(By.xpath("//*[@id=\"marketWiseTargetAdd\"]/div[7]/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]")).click(); //Select Month
        new Select(driver.findElement(By.id("inlineFormCustomSelect"))).selectByVisibleText("XLS"); //Select file format
        driver.findElement(By.xpath("//button[@type='submit']")).click(); //Press Submit
    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
