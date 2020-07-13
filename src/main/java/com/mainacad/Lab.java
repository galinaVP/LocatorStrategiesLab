package com.mainacad;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Lab
{
    public static final By FIRST_NAME = By.id("firstName");
    public static final By LAST_NAME = By.id("lastName");
    public static  final By EMAIL = By.id("userEmail");
    public static  final By FEMALE = By.xpath("//*[text()='Female']");
    public static  final By NUMBER = By.id("userNumber");
    public static  final By DATE_FIELD = By.cssSelector("input#dateOfBirthInput");
    public static  final By SUBJECT = By.id("subjectsContainer");
    public static  final By READING = By.xpath("//*[text()='Reading']");
    public static  final By CHOOSE_FILE = By.cssSelector(".form-control-file");
    public static  final By ADDRESS = By.id("currentAddress");
    public static final By SUBMIT = By.tagName("button");


    public static void main( String[] args )
    {
        //setupChromeDriverAutomatically
        WebDriverManager.chromedriver().setup();

        //Создаём вебдрайвер
        WebDriver driver = new ChromeDriver();

        //Открываем тестовую страницу
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(FIRST_NAME);
        firstName.sendKeys("Halyna");

        WebElement lastName = driver.findElement(LAST_NAME);
        lastName.sendKeys("Prytuliak");

        WebElement email = driver.findElement(EMAIL);
        email.sendKeys("galka.prit@gmail.com");

        WebElement female =  driver.findElement(FEMALE);
        female.click();

        WebElement number = driver.findElement(NUMBER);
        number.sendKeys("0976063327");

        WebElement date = driver.findElement(DATE_FIELD);
        date.click();        
        WebElement month = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
        month.sendKeys("September");
        WebElement year = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
        year.sendKeys("1991");
        year.click();
        WebElement day = driver.findElement(By.cssSelector(".react-datepicker__day--011"));
        day.click();

        WebElement dropDown = driver.findElement(SUBJECT);
        dropDown.sendKeys("C");
        //Select subjects = new Select(dropDown);
        //subjects.selectByIndex(5);

        WebElement hobby =  driver.findElement(READING);
        hobby.click();

        WebElement chooseFileBtn = driver.findElement(By.xpath("/html//input[@id='uploadPicture']"));
        chooseFileBtn.click();

        WebElement address = driver.findElement(ADDRESS);
        address.sendKeys("Vinnitsa, Keletska");

        //WebElement submit =  driver.findElement(SUBMIT);
        //submit.click();

        //driver.close();
    }
}
