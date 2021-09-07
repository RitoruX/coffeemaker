package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Inventory class.
 *
 * @author Pittayut Benjamasutin
 */
public class InventoryTest {

    /**
     * The object under test.
     */
    private Inventory inventory;

    // Sample recipes to use in testing.
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;

    /**
     * Initializes Inventory object.
     */
    @Before
    public void setUp() throws RecipeException {
        inventory = new Inventory();

        //Set up for huge amount of coffee
        recipe1 = new Recipe();
        recipe1.setName("Coffee");
        recipe1.setAmtCoffee("100");

        //Set up for huge amount of milk
        recipe2 = new Recipe();
        recipe2.setName("Milk");
        recipe2.setAmtMilk("100");

        //Set up for huge amount of sugar
        recipe3 = new Recipe();
        recipe3.setName("Sugar");
        recipe3.setAmtSugar("100");

        //Set up for huge amount of chocolate
        recipe4 = new Recipe();
        recipe4.setName("Chocolate");
        recipe4.setAmtChocolate("100");
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Chocolate into the inventory
     * Then inventory item should be updated.
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test
    public void testValidAddChocolate() throws InventoryException {
        inventory.addChocolate("3");
        Assert.assertEquals(inventory.getChocolate(), 18);
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Chocolate in negative value into the inventory
     * Then exception should be thrown because of phasing
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testNegativeAddChocolate() throws InventoryException {
        inventory.addChocolate("-1");
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Chocolate in String format into the inventory
     * Then exception should be thrown because of phasing
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testInvalidFormatAddChocolate() throws InventoryException {
        inventory.addChocolate("abcdef");
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to set amount of chocolate in inventory.
     * Then amount of item in inventory should be updated.
     */
    @Test
    public void testSetChocolate() {
        inventory.setChocolate(10);
        Assert.assertEquals(inventory.getChocolate(), 10);
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to set amount of chocolate with negative value.
     * Then amount of item in inventory should not be updated.
     */
    @Test
    public void testNegativeSetChocolate() {
        inventory.setChocolate(-10);
        Assert.assertEquals(inventory.getChocolate(), 15);
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Coffee into the inventory
     * Then inventory item should be updated.
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test
    public void testValidAddCoffee() throws InventoryException {
        inventory.addCoffee("3");
        Assert.assertEquals(inventory.getCoffee(), 18);
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Coffee in negative value into the inventory
     * Then exception should be thrown because of phasing
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testNegativeAddCoffee() throws InventoryException {
        inventory.addCoffee("-1");
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Coffee in String format into the inventory
     * Then exception should be thrown because of phasing
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testInvalidFormatAddCoffee() throws InventoryException {
        inventory.addCoffee("abcdef");
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to set amount of Coffee in inventory.
     * Then amount of item in inventory should be updated.
     */
    @Test
    public void testSetCoffee() {
        inventory.setCoffee(10);
        Assert.assertEquals(inventory.getCoffee(), 10);
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to set amount of Coffee with negative value.
     * Then amount of item in inventory should not be updated.
     */
    @Test
    public void testNegativeSetCoffee() {
        inventory.setCoffee(-10);
        Assert.assertEquals(inventory.getCoffee(), 15);
    }



    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Milk into the inventory
     * Then inventory item should be updated.
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test
    public void testValidAddMilk() throws InventoryException {
        inventory.addMilk("3");
        Assert.assertEquals(inventory.getMilk(), 18);
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Milk in negative value into the inventory
     * Then exception should be thrown because of phasing
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testNegativeAddMilk() throws InventoryException {
        inventory.addMilk("-1");
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Milk in String format into the inventory
     * Then exception should be thrown because of phasing
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testInvalidFormatAddMilk() throws InventoryException {
        inventory.addMilk("abcdef");
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to set amount of Milk in inventory.
     * Then amount of item in inventory should be updated.
     */
    @Test
    public void testSetMilk() {
        inventory.setMilk(10);
        Assert.assertEquals(inventory.getMilk(), 10);
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to set amount of Milk with negative value.
     * Then amount of item in inventory should not be updated.
     */
    @Test
    public void testNegativeSetMilk() {
        inventory.setMilk(-10);
        Assert.assertEquals(inventory.getMilk(), 15);
    }




    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Sugar into the inventory
     * Then inventory item should be updated.
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test
    public void testValidAddSugar() throws InventoryException {
        inventory.addSugar("3");
        Assert.assertEquals(inventory.getSugar(), 18);
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Sugar in negative value into the inventory
     * Then exception should be thrown because of phasing
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testNegativeAddSugar() throws InventoryException {
        inventory.addSugar("-1");
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to add Sugar in String format into the inventory
     * Then exception should be thrown because of phasing
     *
     * @throws InventoryException if there was an error parsing the quanity
     *          to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testInvalidFormatAddSugar() throws InventoryException {
        inventory.addSugar("abcdef");
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to set amount of Sugar in inventory.
     * Then amount of item in inventory should be updated.
     */
    @Test
    public void testSetSugar() {
        inventory.setSugar(10);
        Assert.assertEquals(inventory.getSugar(), 10);
    }

    /**
     * Given there's Inventory that there are 15 items per each ingredient.
     * When we try to set amount of Sugar with negative value.
     * Then amount of item in inventory should not be updated.
     */
    @Test
    public void testNegativeSetSugar() {
        inventory.setSugar(-10);
        Assert.assertEquals(inventory.getSugar(), 15);
    }

    /**
     * Given there's inventory that there are 15 items per each ingredient.
     * When we try to check that inventory has ingredient enough for that recipe, or not.
     * Then they should return False because of that recipe need huge amount of Coffee
     */
    @Test
    public void testNotEnoughCoffee() {
        Assert.assertFalse(inventory.enoughIngredients(recipe1));
    }

    /**
     * Given there's inventory that there are 15 items per each ingredient.
     * When we try to check that inventory has ingredient enough for that recipe, or not.
     * Then they should return False because of that recipe need huge amount of Milk
     */
    @Test
    public void testNotEnoughMilk() {
        Assert.assertFalse(inventory.enoughIngredients(recipe2));
    }

    /**
     * Given there's inventory that there are 15 items per each ingredient.
     * When we try to check that inventory has ingredient enough for that recipe, or not.
     * Then they should return False because of that recipe need huge amount of Sugar
     */
    @Test
    public void testNotEnoughSugar() {
        Assert.assertFalse(inventory.enoughIngredients(recipe3));
    }

    /**
     * Given there's inventory that there are 15 items per each ingredient.
     * When we try to check that inventory has ingredient enough for that recipe, or not.
     * Then they should return False because of that recipe need huge amount of Chocolate
     */
    @Test
    public void testNotEnoughChocolate() {
        Assert.assertFalse(inventory.enoughIngredients(recipe4));
    }
}
