package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pageobject.HomePage;
import ru.yandex.praktikum.utils.AppConfig;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(AppConfig.BASE_URL);

        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @After
    public void tearDown() {
            driver.quit();
        }
}