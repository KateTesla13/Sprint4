package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.pageobject.HomePage;
import ru.yandex.praktikum.pageobject.OrderPage;

public class OrderTest {

    private WebDriver driver;

    //Тест заказа через верхнюю кнопку Заказать
    @Test
    public void orderScooterTopButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Принять куки, чтобы плашка не перекрывала элементы
        driver.findElement(By.xpath(".//button[text()='да все привыкли']")).click();

        HomePage homePage = new HomePage(driver);
        homePage.clickOrderButtonTop();  //нажать верхнюю кнопку Заказать

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFirstPart("Афина", "Дандадан", "ул. Ленина, 5", "Черкизовская", "89991112233");
        orderPage.fillSecondPart("05.07.2026", "двое суток", "grey", "Домофон не работает");

        System.out.println("Тест выполнен, заказ не создан из-за бага в Chrome");
    }

    //Тест заказа через нижнюю кнопку Заказать
    @Test
    public void orderScooter() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Принять куки, чтобы плашка не перекрывала элементы
        driver.findElement(By.xpath(".//button[text()='да все привыкли']")).click();

        HomePage homePage = new HomePage(driver);
        homePage.clickOrderButtonBottom();  //нажать нижнюю кнопку Заказать

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFirstPart("Петр", "Пупкин", "ул. Пушкина, 10", "Сокольники", "89991112233");
        orderPage.fillSecondPart("02.07.2026", "сутки", "black", "Позвонить за час");
        orderPage.clickOrderButton();
        orderPage.confirmOrder();
        System.out.println("Тест выполнен, заказ не создан из-за бага в Chrome");
    }

    //Закрытие браузера после каждого теста
    @After
    public void tearDown() {

        driver.quit();
    }
}