package com.amazon.Swiggy;
import static org.testng.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderFoodSteps extends Driver {

	@Given("a user is on the landing page of Swiggy")
	public void userIsOnLandingPage() {
		assertTrue(driver.getTitle().equals("Order food online from India's best food delivery service. Order from restaurants near you")); 

	}

	@When("he must able to type a delivery location as ‘Hyderabad’ and select the first option from the auto-complete box.")
	public void he_must_able_to_type_a_delivery_location_as_hyderabad_and_select_the_first_option_from_the_auto_complete_box() {
		// Write code here that turns the phrase above into concrete actions
		locationpage.searchItem("Hyderabad");
	}

	@When("he must able to click on the first restaurant shown under ‘Top restaurant chains in Hyderabad’.")
	public void he_must_able_to_click_on_the_first_restaurant_shown_under_top_restaurant_chains_in_hyderabad() {
		// Write code here that turns the phrase above into concrete actions
		addcart.FirstRestaurant();
	}

	@When("he must able to click on ‘Add’ button corresponding to first listed dish.")
	public void he_must_able_to_click_on_add_button_corresponding_to_first_listed_dish() {
		// Write code here that turns the phrase above into concrete actions
		addcart.AddFood();
	}

	@When("he must able to hover over ‘Cart’ in the top right corner.")
	public void he_must_able_to_hover_over_cart_in_the_top_right_corner() {
		// Write code here that turns the phrase above into concrete actions
		addcart.Cart();
	}

	@When("he must able to click on ‘Check Out’ in the sub-menu.")
	public void he_must_able_to_click_on_check_out_in_the_sub_menu() {
		// Write code here that turns the phrase above into concrete actions
		addcart.CheckOut();
	}

	@Then("he must able to verify the text is visible on the next page - {string}")
	public void he_must_able_to_verify_the_text_is_visible_on_the_next_page(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(signinpage.Signin().equals("To place your order now, log in to your existing account or sign up."));
	}
}
