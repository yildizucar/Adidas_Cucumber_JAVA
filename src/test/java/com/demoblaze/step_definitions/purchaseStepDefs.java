package com.demoblaze.step_definitions;

import com.demoblaze.pages.AdidasPage;
import com.demoblaze.utulities.BrowserUtils;
import com.demoblaze.utulities.ConfigurationReader;
import com.demoblaze.utulities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class purchaseStepDefs {

    AdidasPage adidasPage = new AdidasPage();
    int expectedPurhaseAMount = 0;

    String orderID;
    int purchaseAmount;

    @Given("User is on the Home Page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("User adds {string} from {string}")
    public void user_adds_from(String product, String category) {
        expectedPurhaseAMount+=adidasPage.productAdder(category,product);
        System.out.println("expectedPurhaseAMount = " + expectedPurhaseAMount);
    }

    @When("User removes {string} from cart")
    public void user_removes_from_cart(String product) {
        expectedPurhaseAMount-=adidasPage.productRemover(product);
        System.out.println("expectedPurhaseAMount = " + expectedPurhaseAMount);
    }


    @When("User places order and captures and logs purchase ID and Amount")
    public void user_places_order_and_captures_and_logs_purchase_id_and_amount() {
        adidasPage.cart.click();
        adidasPage.placeButton.click();

        adidasPage.fillForm();

        adidasPage.purchaseButton.click();


        String confirmation = adidasPage.confirmation.getText();
        System.out.println("confirmation = " + confirmation);

        String[] confirmationArray = confirmation.split("\n");
        orderID = confirmationArray[0];
        System.out.println("orderID = " + orderID);
        purchaseAmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);



    }
    @Then("User verifies purchase amount equals expected")
    public void user_verifies_purchase_amount_equals_expected() {
        int actualAmount = purchaseAmount;
        System.out.println("actualAmount = " + actualAmount);
        System.out.println("expectedOrderAmmount = " + expectedPurhaseAMount);
        Assert.assertEquals(expectedPurhaseAMount,actualAmount);
        BrowserUtils.sleep(1);
        adidasPage.OK.click();
        BrowserUtils.sleep(1);
        Driver.closeDriver();
    }

}
