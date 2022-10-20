package PracticeTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class zeusAllTest {
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
        // Go to main page
        driver.get("https://demo.zeuz.ai/web/level/one/actions");
        driver.manage().window().maximize();
        // First test
        driver.findElement(By.xpath("//*[@id=\"portfolio\"]/div/div/div[1]/div/div[1]/center/a")).click();
        driver.findElement(By.id("hint-toggle")).click();
        driver.findElement(By.id("username_id")).sendKeys("zeuzTest");
        driver.findElement(By.id("password_id")).sendKeys("zeuzPass");
        driver.findElement(By.id("signin_id")).click();
        String login = driver.findElement( By.xpath("//*[@id=\"text_showing\"]")).getText();
        System.out.println(login);
        driver.navigate().back();
        //Second test
        driver.findElement(By.xpath("//*[@id=\"portfolio\"]/div/div/div[2]/div/div[1]/center/a")).click();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("element_id")));
        firstResult.click();
        System.out.println("Wait for element test passed!");
        driver.navigate().back();
        //Third test
        driver.findElement(By.xpath("//*[@id=\"portfolio\"]/div/div/div[3]/div/div[1]/center/a")).click();
        String copyText = driver.findElement(By.id("randomText")).getText();
        driver.findElement(By.id("enter_text")).sendKeys(copyText);
        driver.findElement(By.id("verify_id")).click();
        String result = driver.findElement(By.id("text_showing")).getText();
        System.out.println(result);
        driver.navigate().back();
        driver.get("C:\\Users\\Aminul\\Pictures\\Saved Pictures\\task-complete.jpg");
        System.out.println("All tests completed!!");
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
