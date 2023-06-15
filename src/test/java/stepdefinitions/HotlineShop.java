package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HotlineShop {
	
	private WebDriver driver;
	
	@Before("@ShopFormEmpty")
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
	}

	@Given("^I visit hotline.ua main page$")
    public void i_visit_httpshotlineua_main_page() {
		driver.get("https://hotline.ua/");
    }
	
	@When("^I navigate to hotline.ua form page$")
	public void i_navigate_to_httpshotlineuaform_page() {
		driver.findElement(By.xpath("//a[contains(text(),'Підключити магазин')]")).click();
		if (!(driver.getCurrentUrl()).equalsIgnoreCase("https://hotline.ua/form/")) {
			Assert.fail();
		}	
	}
	
	@And("^I click on form initiation button$")
	public void i_click_on_form_initiation_button() {
		driver.findElement(By.xpath("//a[@class='btn-graphite btn-cell']")).click();
		}
	
	@Then("^I should be taken to step 1 of the form$")
	public void i_should_be_taken_to_step_1_of_the_form() {
		if ((driver.getCurrentUrl()).equalsIgnoreCase("https://hotline.ua/form/?step=1")) {
			System.out.println("Ok, i'm on page https://hotline.ua/form/?step=1");
//			Assert.assertNotNull(driver.findElement(By.xpath("//a[@class='btn-graphite btn-cell'][@data-submit-form]")));
		} else 
			Assert.fail();
	}
	
	@And("^form fields should be blank except for radio buttons$")
	public void form_fields_should_be_blank_except_for_radio_buttons() {
//		throw new PendingException();
	}
	
	@And("^submit button should be enabled$")
	public void submit_button_should_be_enabled() {
//		throw new PendingException();
	}
	
    @Given("^I step 1 form page loaded$")
    public void i_step_1_form_page_loaded() {
//        throw new PendingException();
    }
    @When("^I do not fill all empty fields$")
    public void i_do_not_fill_all_empty_fields() {
//        throw new PendingException();
    }
    
    @And("^I click on form submit button$")
    public void i_click_on_form_submit_button() {
//    	throw new PendingException();
    }

    @Then("^I should stay on the form$")
    public void i_should_stay_on_the_form() {
//        throw new PendingException();
    }

    @And("^Validation errors should be displayed for invalidly filled fields$")
    public void validation_errors_should_be_displayed_for_invalidly_filled_fields() {
//        throw new PendingException();
    }
	
	@After("@ShopFormEmpty")
	public void tearDown() {
		driver.quit();		
	}
}
