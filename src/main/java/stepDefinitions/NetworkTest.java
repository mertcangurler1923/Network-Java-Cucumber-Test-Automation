package stepDefinitions;

import base.NetworkPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import utilities.BaseDriver;

import java.io.FileNotFoundException;
import java.util.List;

public class NetworkTest extends BaseDriver {
    NetworkPage networkPage;

    @Given("“https:\\/\\/www.network.com.tr\\/” access.")
    public void https_www_network_com_tr_access() {
        setUp();
        networkPage=new NetworkPage(driver);
        networkPage.networkHomepage();
    }
    @When("The network url is checked.")
    public void the_network_url_is_checked() {
        List<String> data =networkPage.networkHomepageChecked();
        Assertions.assertEquals("https://www.network.com.tr/",data.get(0));
    }
    @When("Search components “jacket” are printed and searched.")
    public void search_components_jacket_are_printed_and_searched() {
        networkPage.inputJacket();
    }
    @When("Scrolling as much as the show more button on the product listing page.")
    public void scrolling_as_much_as_the_show_more_button_on_the_product_listing_page() {
        networkPage.showMore();
    }
    @When("It is checked that the 2nd page is passed \\(url changes).")
    public void ıt_is_checked_that_the_2nd_page_is_passed_url_changes() {
        List<String> data=networkPage.twoPageCheck();
        Assertions.assertNotEquals(data.get(0),data.get(1));
    }
    @When("You hover over the first discounted product on the product list page, a random size selection is made.")
    public void you_hover_over_the_first_discounted_product_on_the_product_list_page_a_random_size_selection_is_made() {
        networkPage.discountPercentClick();
    }
    @When("Hover the Go to Cart button that opens in the lower right corner.")
    public void hover_the_go_to_cart_button_that_opens_in_the_lower_right_corner() {
        networkPage.goToCard();
    }
    @When("It is checked that the size and price information of the product is correct in the basket.")
    public void ıt_is_checked_that_the_size_and_price_information_of_the_product_is_correct_in_the_basket() {
        networkPage.productPrice();
        List<String> data=networkPage.data();
        Assertions.assertEquals(data.get(2),data.get(4));
        Assertions.assertEquals(data.get(3),"size_"+data.get(5));
    }
    @When("It is checked that the old price of the product added to the cart is greater than the discounted price.")
    public void ıt_is_checked_that_the_old_price_of_the_product_added_to_the_cart_is_greater_than_the_discounted_price() {
        List<String> data=networkPage.data();
        Double boxDiscountMoneyValue=Double.parseDouble(data.get(2).replace(".","").replace(",",".").replace("TL",""));
        Double boxNotDiscountMoneyValue=Double.parseDouble(data.get(6).replace(".","").replace(",",".").replace("TL",""));
        Assertions.assertTrue(boxDiscountMoneyValue<boxNotDiscountMoneyValue);
    }
    @When("Continue button is clicked.")
    public void continue_button_is_clicked() {
        networkPage.goOn();
    }
    @When("Filling in the user information from csv format \\(E-mail - by reading the password from the csv file is necessary.)")
    public void filling_in_the_user_information_from_csv_format_e_mail_by_reading_the_password_from_the_csv_file_is_necessary() throws FileNotFoundException {
        networkPage.idPassword();
    }
    @When("Check that the login button has arrived.")
    public void check_that_the_login_button_has_arrived() {
        List<String> data=networkPage.data();
        Assertions.assertEquals(data.get(7),"true");
    }
    @When("Click the network logo.")
    public void click_the_network_logo() {
        networkPage.networkLogo();
    }
    @When("By clicking on the bag logo on the main page, the right side of the Sepetim building opens.")
    public void by_clicking_on_the_bag_logo_on_the_main_page_the_right_side_of_the_sepetim_building_opens() {
        networkPage.box();
    }
    @Then("It is checked that the basket is empty by removing the product from the basket.")
    public void ı_t_is_checked_that_the_basket_is_empty_by_removing_the_product_from_the_basket() {
        networkPage.boxTrash();
        List<String> data=networkPage.data();
        Assertions.assertEquals(data.get(8),"Sepetiniz Henüz Boş");
        tearDown();
    }

}
