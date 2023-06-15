package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class Search {

	@Given("^I visit website as unregistered user$")
	public void i_visit_website_as_unregistered_user() {
		System.out.println("Outputted from test: I_visit_website_as_unregistered_user");
	}

	@When("^I select the Books option from the categories dropdown$")
	public void i_select_the_books_option_from_the_categories_dropdown() {
		System.out.println("Outputted from test: i_select_the_books_option_from_the_categories_dropdown");
	}

	@When("^I select the Baby option from the categories dropdown$")
	public void i_select_the_baby_option_from_the_categories_dropdown() {
		System.out.println("Outputted from test: i_select_the_baby_option_from_the_categories_dropdown");
	}

	@Then("^I should see the books main page having heading as Best sellers$")
	public void i_should_see_the_books_main_page_having_heading_as_best_sellers() {
		System.out.println("Outputted from test: i_should_see_the_books_main_page_having_heading_as_best_sellers");
	}

	@Then("^I should see the baby products main page having heading as The Baby Store$")
	public void i_should_see_the_baby_products_main_page_having_heading_as_the_baby_store() {
		System.out.println("Outputted from test: i_should_see_the_baby_products_main_page_having_heading_as_the_baby_store");
	}

	@And("^I clik on search icon option$")
	public void i_clik_on_search_icon_option() {
		System.out.println("Outputted from test: i_clik_on_search_icon_option");
	}

	@But("^I should not see other categories products$")
	public void i_should_not_see_other_categories_products() {
		System.out.println("Outputted from test: i_should_not_see_other_categories_products");
	}

}
