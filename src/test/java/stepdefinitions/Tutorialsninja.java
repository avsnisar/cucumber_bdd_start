package stepdefinitions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tutorialsninja {

	private WebDriver driver;
	private Logger log;

	@Before
	public void setup() {

		log = LogManager.getLogger(Tutorialsninja.class.getName());

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.debug("Browser has been launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Given("^I visit tutorialsninja.com register page from scratch$")
	public void i_visit_tutorialsninjacom_register_page_from_scratch() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		log.debug("Navigated in browser to the registration form page");
	}

	@When("^I fill following fields below with following data in table$")
	public void i_fill_following_fields_below_with_following_data_in_table(DataTable data) {
		Map<String, String> dataMap = data.asMap(String.class, String.class);

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataMap.get("name"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataMap.get("surname"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(dataMap.get("email"));
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataMap.get("phone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataMap.get("pass"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(dataMap.get("passconfirm"));

		log.debug("Filled all text input fields on the registration form page");
	}

	@And("^I tick privacy policy checkbox$")
	public void i_tick_privacy_policy_checkbox() {
		driver.findElement(By.name("agree")).click();
		log.debug("Ticket the checkbox input field on the registration form page");
	}

	@And("^I click continue button$")
	public void i_click_continue_button() {
		driver.findElement(By.cssSelector("input[value='Continue']")).click();
		log.debug("Submitted the registration form");
	}

	@Then("^I get registered account on website$")
	public void i_get_registered_account_on_website() {
		Boolean result = new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementWithText(By.tagName("a"), "DDDDDD"));
		Assert.assertTrue(result);
		log.info("Successfully registered!");
//		Thread.sleep(5000);
//		Assert.assertNotNull(driver.findElement(By.linkText("Success")));
	}

	@After
	public void tearDown() {
		driver.quit();
		log.debug("Broswer has been automatically terminated");
	}
}
