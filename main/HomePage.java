package com.BookFlight.pom;
 import org.openqa.selenium.By;
 import org.openqa.selenium.JavascriptExecutor;
 import org.openqa.selenium.WebDriver;


public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    By close = By.xpath("//span[@data-cy='closeModal']");
    By roundTripButton = By.xpath("//li[@data-cy='roundTrip']");
    By sourceCity = By.id("fromCity");
    By sourceSearchBox = By.xpath("//input[@aria-controls='react-autowhatever-1']");
    By destinationCity = By.id("toCity");
    By destinationSearchBox =By.xpath("//input[@aria-controls='react-autowhatever-1']");
    By SearchButton = By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");


//     Action Methods:

//    public void closePopUp() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(close).click();
//        Thread.sleep(2000);
//    }

    public void closePopUp() {
        try {
            Thread.sleep(2000);
            driver.findElement(By.tagName("body")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
            System.out.println("Popup Closed");
        }
        catch (Exception e) {

            System.out.println("Popup not displayed");
        }
    }

    public void clickRoundTripButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(roundTripButton).click();
        Thread.sleep(2000);


    }

    public void enterSourceCity(String fromCity) throws InterruptedException {
        driver.findElement(sourceCity).click();
        Thread.sleep(2000);
        driver.findElement(sourceSearchBox).sendKeys(fromCity);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='"+fromCity+"']")).click();

    }

    public void enterDestinationCity(String toCity) throws InterruptedException {
        driver.findElement(destinationCity).click();
        Thread.sleep(2000);
        driver.findElement(destinationSearchBox).sendKeys(toCity);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='"+toCity+"']")).click();
        Thread.sleep(2000);

    }
    public void selectDepartureDate() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(450,510)","");
        driver.findElement(By.xpath("//div[@aria-label='Mon May 25 2026']")).click();
        Thread.sleep(2000);
    }

    public void selectReturnDate() throws InterruptedException {
        driver.findElement(By.xpath("//div[@aria-label='Wed May 27 2026']")).click();
        Thread.sleep(2000);
    }

    public void clickSearchButton(){
        driver.findElement(SearchButton).click();
    }
}
