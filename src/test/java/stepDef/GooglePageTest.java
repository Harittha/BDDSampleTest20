package stepDef;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePageTest {

	WebDriver driver;

		@Given("User is on Google Page")
		public void user_is_on_google_page() {
		    // Write code here that turns the phrase above into concrete actions
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		   // throw new io.cucumber.java.PendingException();
			driver.get("https://www.google.com/");
		}


		//Some other steps were also undefined:

		@When("User search Java Tutorial")
		public void user_search_java_tutorial() {
		    // Write code here that turns the phrase above into concrete actions
		 //   throw new io.cucumber.java.PendingException();
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Java Tutorial");
			searchBox.submit();
		}
		@Then("Should dislay Java Result Page")
		public void should_dislay_java_result_page() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
		Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());
		}

		//Some other steps were also undefined:

		@When("User search Haritha Tutorial")
		public void user_search_Haritha_tutorial() {
		    // Write code here that turns the phrase above into concrete actions
		 //   throw new io.cucumber.java.PendingException();
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Haritha Tutorial");
			searchBox.submit();
		}
		@Then("Should dislay Haritha Result Page")
		public void should_dislay_Haritha_result_page() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
		Assert.assertEquals("Haritha Tutorial - Google Search", driver.getTitle());
		//Assert.assertEquals("Haritha", driver.getTitle());
		}
		
		
		@Then("Close Browser")
		public void close_browser() {
			driver.close();
		}
		
		@After
		public void attachImage(Scenario scenario) throws IOException {
			if(scenario.isFailed()) {
				TakesScreenshot scr = (TakesScreenshot)driver;
				File scrFile = scr.getScreenshotAs(OutputType.FILE);
				byte[] byteImg = FileUtils.readFileToByteArray(scrFile);
				scenario.attach(byteImg, "image/png","image1");
				
			}
		}
		
		

}
		
