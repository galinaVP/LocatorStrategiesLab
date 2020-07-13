package com.mainacad;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Lab
{
    public static final By FIRST_NAME = By.id("firstName");
    public static final By LAST_NAME = By.id("lastName");
    public static  final By EMAIL = By.id("userEmail");
    public static  final By FEMALE = By.xpath("//*[text()='Female']");
    public static  final By NUMBER = By.id("userNumber");
    public static  final By DATE_FIELD = By.cssSelector("input#dateOfBirthInput");
    public static final By MONTH = By.cssSelector("button#submit");
    public static final By YEAR = By.cssSelector(".react-datepicker__year-select");
    public static final By DAY = By.cssSelector(".react-datepicker__day--011");
    public static  final By SUBJECT = By.xpath("//div[@id='subjectsContainer']/div/div[1]//input");
    public static  final By READING = By.xpath("//*[text()='Reading']");
    public static  final By CHOOSE_FILE = By.cssSelector(".form-control-file");
    public static  final By ADDRESS = By.id("currentAddress");
    private static final By STATE = By.xpath("//div[@id='state']/div/div[1]/div[.='Select State']");
    public static final By SUBMIT = By.cssSelector("button#submit");
    public static final By CLOSE = By.id("closeLargeModal");


    public static void main( String[] args ) throws InterruptedException {
        //setupChromeDriverAutomatically
        WebDriverManager.chromedriver().setup();

        //Создаём вебдрайвер
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Открываем тестовую страницу
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(FIRST_NAME);
        firstName.sendKeys("Halyna");

        WebElement lastName = driver.findElement(LAST_NAME);
        lastName.sendKeys("Prytuliak");

        WebElement email = driver.findElement(EMAIL);
        email.sendKeys("galka.prit@gmail.com");

        WebElement female = driver.findElement(FEMALE);
        female.click();

        WebElement number = driver.findElement(NUMBER);
        number.sendKeys("0976063327");

        WebElement date = driver.findElement(DATE_FIELD);
        date.click();
        WebElement month = driver.findElement(MONTH);
        month.sendKeys("September");
        WebElement year = driver.findElement(YEAR);
        year.sendKeys("1991");
        year.click();
        WebElement day = driver.findElement(DAY);
        day.click();

        WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(SUBJECT));
        dropDown.click();
        dropDown.sendKeys("English");
        dropDown.sendKeys(Keys.ENTER);

        WebElement hobby =  driver.findElement(READING);
        hobby.click();

        WebElement uploadFile = driver.findElement(By.id("uploadPicture"));
        uploadFile.sendKeys("C:\\Users\\galka\\Downloads\\vik.jpg");

        WebElement address = driver.findElement(ADDRESS);
        address.sendKeys("Vinnitsa, Keletska");


        WebElement state = wait.until(ExpectedConditions.elementToBeClickable(STATE));
        state.click();
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        //Submit button
        WebElement submit =  driver.findElement(SUBMIT);
        js.executeScript("arguments[0].scrollIntoView();", submit);
        submit.click();

        WebElement close = driver.findElement(CLOSE);
        close.click();

        driver.close();
    }
}
