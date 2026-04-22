package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    //Локатор верхней кнопки Заказать
    private By orderButtonTop = By.className("Button_Button__ra12g");

    //Локатор нижней кнопки Заказать
    private By orderButtonBottom = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по верхней кнопке Заказать + прокрутка страницы
    public void clickOrderButtonTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        driver.findElement(orderButtonTop).click();
    }

    //Клик по нижней кнопке Заказать + прокрутка к элементу и клик через JavaScript
    public void clickOrderButtonBottom() {
        WebElement button = driver.findElement(orderButtonBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    //Получение текста ответа для выпадающего списка на вопрос по индексу
    public String getAnswerText(int index) {
        String headingId = String.format("accordion__heading-%d", index);
        String panelId = String.format("accordion__panel-%d", index);

        WebElement question = driver.findElement(By.id(headingId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();

        return driver.findElement(By.id(panelId)).getText();
    }
}