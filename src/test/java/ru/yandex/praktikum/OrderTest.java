package ru.yandex.praktikum;

import org.junit.Test;
import ru.yandex.praktikum.pageobject.OrderPage;

import static org.junit.Assert.assertTrue;

public class OrderTest extends BaseTest {

    //Тест заказа через верхнюю кнопку Заказать
    @Test
    public void orderScooterTopButton() {
        homePage.clickOrderButtonTop(); //нажать верхнюю кнопку Заказать

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFirstPart("Афина", "Дандадан", "ул. Ленина, 5", "Черкизовская", "89991112233");
        orderPage.fillSecondPart("05.07.2026", "двое суток", "grey", "Домофон не работает");
        boolean isOrderCreated = orderPage.isOrderCreated();
        assertTrue("Заказ должен быть создан, но из-за бага в Chrome этого не произошло", isOrderCreated);
    }

    //Тест заказа через нижнюю кнопку Заказать
    @Test
    public void orderScooter() {
            homePage.clickOrderButtonBottom();  //нажать нижнюю кнопку Заказать

            OrderPage orderPage = new OrderPage(driver);
            orderPage.fillFirstPart("Петр", "Пупкин", "ул. Пушкина, 10", "Сокольники", "89991112233");
            orderPage.fillSecondPart("02.07.2026", "сутки", "black", "Позвонить за час");
            boolean isOrderCreated = orderPage.isOrderCreated();
            assertTrue("Заказ должен быть создан, но из-за бага в Chrome этого не произошло", isOrderCreated);
        }
}