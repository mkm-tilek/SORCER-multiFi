package edu.pjatk.inn.coffeemaker;


import org.sorcer.test.SorcerTestRunner;
import edu.pjatk.inn.coffeemaker.impl.CoffeeMaker;
import edu.pjatk.inn.coffeemaker.impl.Inventory;
import edu.pjatk.inn.coffeemaker.impl.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sorcer.service.ContextException;
import org.junit.runner.RunWith;
import org.sorcer.test.ProjectContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")
public class RecipeTest {

    private final static Logger logger = LoggerFactory.getLogger(CoffeeMakerTest.class);

    private Inventory inventory;
    private CoffeeMaker coffeeMaker;
    private Recipe espresso, cappuccino, latte, americano;

    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();
        inventory = coffeeMaker.checkInventory();

        espresso = new Recipe();
        espresso.setName("espresso");
        espresso.setPrice(63);
        espresso.setAmtCoffee(4);
        espresso.setAmtMilk(2);
        espresso.setAmtSugar(1);
        espresso.setAmtChocolate(0);

        cappuccino = new Recipe();
        cappuccino.setName("cappuccino");
        cappuccino.setPrice(120);
        cappuccino.setAmtCoffee(4);
        cappuccino.setAmtMilk(1);
        cappuccino.setAmtSugar(7);
        cappuccino.setAmtChocolate(4);

        latte = new Recipe();
        latte.setName("latte");
        latte.setPrice(80);
        latte.setAmtCoffee(7);
        latte.setAmtMilk(1);
        latte.setAmtSugar(5);
        latte.setAmtChocolate(0);

        americano = new Recipe();
        americano.setName("americano");
        americano.setPrice(95);
        americano.setAmtCoffee(8);
        americano.setAmtMilk(0);
        americano.setAmtSugar(2);
        americano.setAmtChocolate(0);
    }

    /**
     * By user story the maximum number of recipes is defined as 3, so NUM_RECIPES should be changed to 3.
     * True value is already assigned to variable. This code is ambiguous and should removed.
     */
    @Test
    public void testAddRecipe() {
        assertTrue(coffeeMaker.addRecipe(espresso));
        assertTrue(coffeeMaker.addRecipe(latte));
        assertTrue(coffeeMaker.addRecipe(americano));
        assertFalse(coffeeMaker.addRecipe(cappuccino)); //Adds 4-th recipe
    }

    /**
     * Element in recipeArray is assigned to same Recipe object instead of deleting it (setting default Recipe).
     * Element in recipeFull should be assigned to false value.
     */
    @Test
    public void testDeleteRecipe() {
        assertFalse(coffeeMaker.deleteRecipe(latte));
        assertTrue(coffeeMaker.addRecipe(latte));
        assertTrue(coffeeMaker.deleteRecipe(latte));
        assertEquals(coffeeMaker.getRecipeForName("latery"), null);
        assertFalse(coffeeMaker.deleteRecipe(latte));
    }

    /**
     * oldRecipe.getName() should be compared with newRecipe.getName() instead of comparing with null.
     * So it should not contain 2 identical recipes.
     * Element of recipeArray should be compared with oldRecipe instead of newRecipe.
     */
    @Test
    public void testEditRecipe() {

        Recipe cappuccino2 = new Recipe();
        cappuccino2.setName("cappuccino");
        cappuccino2.setPrice(20);
        cappuccino2.setAmtCoffee(3);
        cappuccino2.setAmtMilk(1);
        cappuccino2.setAmtSugar(0);
        cappuccino2.setAmtChocolate(0);

        assertTrue(coffeeMaker.addRecipe(espresso));
        assertTrue(coffeeMaker.addRecipe(cappuccino));
        assertFalse(coffeeMaker.editRecipe(espresso, cappuccino2));
    }

}
