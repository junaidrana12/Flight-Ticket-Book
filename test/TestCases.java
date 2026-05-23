package testCases;

import com.BookFlight.pom.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class TestCases {
        WebDriver driver;
        @BeforeTest
      public void launchChromeBrowser () {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.get("https://www.makemytrip.com/");
            driver.manage().window().maximize();
        }

        @Test
        public void searchFlightTickets () throws InterruptedException {
            HomePage homePage = new HomePage(driver);
            homePage.closePopUp();
            homePage.clickRoundTripButton();
            homePage.enterSourceCity("Pune");
            homePage.enterDestinationCity("Delhi");
            homePage.selectDepartureDate();
            homePage.clickSearchButton();
        }

        @AfterTest
        public void closeBrowser () {
            driver.close();
        }
    }
