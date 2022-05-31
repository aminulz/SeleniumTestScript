

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

    public class Rupantor {
        private WebDriver driver;
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
        public void testFirstTestCase() throws Exception {
            driver.get("http://172.168.21.95:8084/Rupantor/userManagement/login.jsp");
            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Admin");
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("p");
            driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[6]/div/button")).click();
            driver.findElement(By.linkText("//*[@id=\"loginform\"]/div[2]/div/button")).click();
            driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div/button")).click();
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
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
