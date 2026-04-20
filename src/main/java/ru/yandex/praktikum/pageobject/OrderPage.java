package ru.yandex.praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private final WebDriver driver;

    //Локаторы для первой части формы оформления заказа
    private final By name = By.xpath(".//input[@placeholder='* Имя']"); //имя
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']"); //фамилия
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //адрес
    private final By metroStation = By.className("select-search__input"); //станция метро
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //номер телефона
    private final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); //кнопка далее

    //Локаторы для второй части формы оформления заказа
    private final By date = By.xpath(".//input[contains(@placeholder, 'Когда привезти')]"); //дата доставки
    private final By rentalPeriod = By.className("Dropdown-placeholder"); //срок аренды
    private final By blackColor = By.xpath(".//label[text()='чёрный жемчуг']/input"); //черный цвет самоката
    private final By greyColor = By.xpath(".//label[text()='серая безысходность']/input"); //серый цвет самоката
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']"); //комментарий для курьера
    private final By orderButton = By.xpath(".//button[contains(text(),'Заказать')]"); //кнопка заказать


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для первой части формы оформления заказа
    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(this.surname).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(this.address).sendKeys(address);
    }

    public void setPhone(String phone) {
        driver.findElement(this.phone).sendKeys(phone);
    }

    //Выбор станции метро из выпадающего списка
    public void selectMetroStation(String stationName) {
        driver.findElement(metroStation).click();
        driver.findElement(By.xpath("//div[text()='" + stationName + "']")).click();
    }

    //Клик по кнопке «Далее»
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //Заполнение всей первой части формы оформления заказа
    public void fillFirstPart(String name, String surname, String address, String station, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectMetroStation(station);
        setPhone(phone);
        clickNextButton();
    }

    //Методы для второй части формы оформления заказа
    public void setDate(String dateValue) {
        driver.findElement(date).sendKeys(dateValue);
    }

    //Выбор срока аренды из выпадающего списка
    public void selectRentalPeriod(String period) {
        driver.findElement(By.xpath("//body")).click(); // закрыть календарь, чтобы не перекрывал элементы
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //ожидание, пока календарь закроется
        }
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(".//div[text()='" + period + "']")).click();
    }

    //Выбор цвета самоката
    public void selectColor(String color) {
        if (color.equals("black")) {
            driver.findElement(blackColor).click();
        } else if (color.equals("grey")) {
            driver.findElement(greyColor).click();
        }
    }

    public void setComment(String commentText) {
        driver.findElement(comment).sendKeys(commentText);
    }

    //Клик по кнопке «Заказать»
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
        System.out.println("Кнопка 'Заказать' нажата");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    //Заполнение всей второй части формы оформления заказа
    public void fillSecondPart(String date, String period, String color, String commentText) {
        setDate(date);
        selectRentalPeriod(period);
        selectColor(color);
        setComment(commentText);
        clickOrderButton();
    }
}