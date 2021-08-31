/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 * 
 * 
 * Modifications 
 * 20171114 - Ian De Silva - Updated to comply with JUnit 4 and to adhere to 
 * 							 coding standards.  Added test documentation.
 */
package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Pittayut Benjamasutin
 */
public class CoffeeMakerTest {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;

	/**
	 * Initializes some recipes to test with and the {@link CoffeeMaker} 
	 * object we wish to test.
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
	}

	/**
	 * Given two well-formed recipes
	 * When we added two recipes to program
	 * Then we should get True from program return.
	 */
	@Test
	public void testAddRecipe() {
		Assert.assertTrue(this.coffeeMaker.addRecipe(this.recipe2));
		Assert.assertTrue(this.coffeeMaker.addRecipe(this.recipe3));
	}

	/**
	 * Given four well-formed recipes
	 * When we added four recipes into program
	 * Then program should add only 3 recipes and
	 * the fourth recipe will return false
	 */
	@Test
	public void testAddMoreThanThreeRecipes() {
		this.coffeeMaker.addRecipe(this.recipe1);
		this.coffeeMaker.addRecipe(this.recipe2);
		this.coffeeMaker.addRecipe(this.recipe3);
		Assert.assertFalse(this.coffeeMaker.addRecipe(this.recipe4));
	}

	/**
	 * Given one well-formed recipe
	 * When we added a duplicated recipe into recipes book
	 * Then we should get return false.
	 */
	@Test
	public void testAddRecipeWithDuplicateName() {
		Assert.assertTrue(this.coffeeMaker.addRecipe(this.recipe1));
		Assert.assertFalse(this.coffeeMaker.addRecipe(this.recipe1));
	}

	/**
	 * Given program added well-formed recipe
	 * When we try to delete a recipe
	 * Then we should get return name of deleted recipe name and
	 * can't find the deleted recipe in the recipes list.
	 */
	@Test
	public void testDeleteRecipe() {
		this.coffeeMaker.addRecipe(this.recipe3);
		Assert.assertEquals(this.recipe3.getName(), this.coffeeMaker.deleteRecipe(0));
		Assert.assertNotEquals(this.recipe3, this.coffeeMaker.getRecipes()[0]);
	}

	/**
	 * Given program hasn't any recipes
	 * When we try to delete a recipe
	 * Then we should get return Null.
	 */
	@Test
	public void testDeleteRecipeNotExist() {
		Assert.assertNull(this.coffeeMaker.deleteRecipe(0));
	}

	/**
	 * Given program added a well-formed recipe
	 * When we try to edit a recipe
	 * Then we should get name of the edited recipe.
	 */
	@Test
	public void testEditValidRecipe() {
		this.coffeeMaker.addRecipe(this.recipe1);
		Assert.assertEquals(this.recipe1.getName(), this.coffeeMaker.editRecipe(0, this.recipe3));
	}

	/**
	 * Given the program hasn't any recipes
	 * When we try to edit a recipe
	 * Then we should get return Null.
	 */
	@Test
	public void testEditNotExistRecipe() {
		Assert.assertNull(this.coffeeMaker.editRecipe(0, this.recipe3));
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test
	public void testAddInventoryWithValid() throws InventoryException {
		this.coffeeMaker.addInventory("4", "7", "1", "9");
		this.coffeeMaker.addInventory("2", "3", "4", "5");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryException() throws InventoryException {
		this.coffeeMaker.addInventory("4", "-1", "asdf", "3");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed coffee quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryInvalidCoffee() throws InventoryException {
		this.coffeeMaker.addInventory("abc", "2", "4", "6");
		this.coffeeMaker.addInventory("-2", "2", "4", "6");
		this.coffeeMaker.addInventory("0", "2", "4", "6");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed milk quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryInvalidMilk() throws InventoryException {
		this.coffeeMaker.addInventory("1", "abc", "4", "6");
		this.coffeeMaker.addInventory("1", "-2", "4", "6");
		this.coffeeMaker.addInventory("1", "0", "4", "6");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed sugar quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryInvalidSugar() throws InventoryException {
		this.coffeeMaker.addInventory("1", "2", "abc", "6");
		this.coffeeMaker.addInventory("1", "2", "-1", "6");
		this.coffeeMaker.addInventory("1", "2", "0", "6");
	}

	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed chocolate quantities (i.e., a negative
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 *
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryInvalidChocolate() throws InventoryException {
		this.coffeeMaker.addInventory("1", "2", "4", "abc");
		this.coffeeMaker.addInventory("1", "2", "4", "-1");
		this.coffeeMaker.addInventory("1", "2", "4", "0");
	}

	/**
	 * Given there are 15 items per each ingredient in inventory
	 * When we try to check inventory and update items in inventory
	 * then we should get the same value as checked.
	 *
	 * @throws InventoryException if there was an error parsing the quanity
	 *  	to a positive integer.
	 */
	@Test
	public void testCheckInventory() throws InventoryException {
		Assert.assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", this.coffeeMaker.checkInventory());
		this.coffeeMaker.addInventory("20", "20", "20", "20");
		Assert.assertEquals("Coffee: 35\nMilk: 35\nSugar: 35\nChocolate: 35\n", this.coffeeMaker.checkInventory());
	}

	/**
	 * Given a coffee maker with two valid recipes
	 * When we make coffee, selecting the valid recipe and paying more than
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffeeWithValidInput() {
		this.coffeeMaker.addRecipe(this.recipe1);
		this.coffeeMaker.addRecipe(this.recipe3);
		Assert.assertEquals(100L, (long)this.coffeeMaker.makeCoffee(0, 150));
		Assert.assertEquals(0L, (long)this.coffeeMaker.makeCoffee(1, 100));
	}

	/**
	 * Given a coffee maker with hasn't any recipes
	 * When we try to make coffee with any recipes
	 * Then we got change back.
	 */
	@Test
	public void testMakeCoffeeWithNoRecipe() {
		Assert.assertEquals(50L, (long)this.coffeeMaker.makeCoffee(1, 50));
	}

	/**
	 * Given a coffee maker with has a valid recipe
	 * When we try to make coffee with not enough ingredients in inventory
	 * Then we got change back.
	 */
	@Test
	public void testMakeCoffeeWithNotEnoughInventory() {
		this.coffeeMaker.addRecipe(this.recipe2);
		Assert.assertEquals(150L, (long)this.coffeeMaker.makeCoffee(0, 150));
	}

	/**
	 * Given a coffee maker with has a valid recipe
	 * When we try to make coffee with not enough money
	 * Then we got change back.
	 */
	@Test
	public void testMakeCoffeeWithNotEnoughMoney() {
		this.coffeeMaker.addRecipe(this.recipe4);
		Assert.assertEquals(0L, (long)this.coffeeMaker.makeCoffee(0, 0));
	}

	/**
	 * Given a coffee maker with has a valid recipe
	 * When we try to make coffee to update inventory
	 * Then we should get update in inventory.
	 */
	@Test
	public void testCheckInventoryAfterPurchase() {
		this.coffeeMaker.addRecipe(this.recipe1);
		this.coffeeMaker.makeCoffee(0, 100);
		Assert.assertEquals("Coffee: 12\nMilk: 14\nSugar: 14\nChocolate: 15\n", this.coffeeMaker.checkInventory());
	}
}
