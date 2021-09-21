package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Before;

public class CoffeeMakerCucumberTest {

    private CoffeeMaker coffeeMaker;

    private int menuID;
    private int paidMoney;

    private Recipe newRecipe(String name, int coffee, int milk, int sugar, int chocolate, int price) throws  RecipeException {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setAmtCoffee(Integer.toString(coffee));
        recipe.setAmtMilk(Integer.toString(milk));
        recipe.setAmtSugar(Integer.toString(sugar));
        recipe.setAmtChocolate(Integer.toString(chocolate));
        recipe.setPrice(Integer.toString(price));
        return recipe;
    }

    @Given("Coffee maker wait for a user input.")
    public void coffeeMakerWaitForAUserInput() throws RecipeException {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.addRecipe(newRecipe("Coffee", 3, 1, 1, 0, 50));
        coffeeMaker.addRecipe(newRecipe("Latte", 4, 20, 1, 0, 100));
        coffeeMaker.addRecipe(newRecipe("Americano", 5, 0, 1, 0, 70));
    }

    @When("I want to purchase a {word}")
    public void iWantToPurchaseA(String beverage) {
        switch(beverage) {
            case "Coffee":
                menuID = 0;
                break;
            case "Latte":
                menuID = 1;
                break;
            case "Americano":
                menuID = 2;
                break;
            default:
                menuID = 3;
        }
    }

    @When("I give coffee maker {int}")
    public void iGiveCoffeeMaker(int money) {
        paidMoney = money;
    }

    @Then("I get money {int} back")
    public void iGetMoneyBack(int change) {
        assertEquals(change, coffeeMaker.makeCoffee(menuID, paidMoney));
    }
}
