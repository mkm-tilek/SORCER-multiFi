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
public class InventoryTest {
    private final static Logger logger = LoggerFactory.getLogger(CoffeeMakerTest.class);

    private Inventory inventory;
    private CoffeeMaker coffeeMaker;
    private Recipe latte, mocha, macchiato, cappuccino;

    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();
        inventory = coffeeMaker.checkInventory();

        latte = new Recipe();
        latte.setName("latte");
        latte.setPrice(20);
        latte.setAmtCoffee(4);
        latte.setAmtMilk(0);
        latte.setAmtSugar(1);
        latte.setAmtChocolate(0);

        mocha = new Recipe();
        mocha.setName("mocha");
        mocha.setPrice(120);
        mocha.setAmtCoffee(8);
        mocha.setAmtMilk(13);
        mocha.setAmtSugar(1);
        mocha.setAmtChocolate(12);

        macchiato = new Recipe();
        macchiato.setName("macchiato");
        macchiato.setPrice(55);
        macchiato.setAmtCoffee(1);
        macchiato.setAmtMilk(1);
        macchiato.setAmtSugar(2);
        macchiato.setAmtChocolate(0);

        cappuccino = new Recipe();
        cappuccino.setName("cappuccino");
        cappuccino.setPrice(45);
        cappuccino.setAmtCoffee(2);
        cappuccino.setAmtMilk(1);
        cappuccino.setAmtSugar(2);
        cappuccino.setAmtChocolate(0);
    }

    /**
     * Comparison sign for sugar value should be changed to "<", it should check if value is not negative.
     */
    @Test
    public void testAddInventory(){
        inventory.setCoffee(90);
        inventory.setSugar(80);
        inventory.setMilk(70);
        inventory.setChocolate(100);
        assertEquals(coffeeMaker.checkInventory().getCoffee(), 90);
        assertEquals(coffeeMaker.checkInventory().getMilk(), 70);
        assertEquals(coffeeMaker.checkInventory().getSugar(), 80);
        assertEquals(coffeeMaker.checkInventory().getChocolate(), 100);

        assertFalse(coffeeMaker.addInventory(-25,5,5,5));
        assertTrue(coffeeMaker.addInventory(20,0,0,0));
        assertEquals(coffeeMaker.checkInventory().getCoffee(), 110);

        assertFalse(coffeeMaker.addInventory(0,-20,0,0));
        assertTrue(coffeeMaker.addInventory(0,20,0,0));
        assertEquals(coffeeMaker.checkInventory().getMilk(), 90);

        assertFalse(coffeeMaker.addInventory(0,0,-20,0));
        assertTrue(coffeeMaker.addInventory(0,0,20,0)); // sugar adding gave an error
        assertEquals(coffeeMaker.checkInventory().getSugar(), 100);

        assertFalse(coffeeMaker.addInventory(0,0,0,-40));
        assertTrue(coffeeMaker.addInventory(0,0,0,20));
        assertEquals(coffeeMaker.checkInventory().getChocolate(), 120);
    }

    /**
     * In inventory.setCoffee() method the amount of coffee in inventory should be decreased by the value from Recipe instead of increasing it.
     */
    @Test
    public void testMakeCoffe() {
        inventory.setChocolate(50);
        inventory.setCoffee(50);
        inventory.setSugar(50);
        inventory.setMilk(50);
        assertEquals(coffeeMaker.checkInventory().getChocolate(), 50);
        assertEquals(coffeeMaker.checkInventory().getCoffee(), 50);
        assertEquals(coffeeMaker.checkInventory().getSugar(), 50);
        assertEquals(coffeeMaker.checkInventory().getMilk(), 50);

        coffeeMaker.makeCoffee(mocha, 50);
        assertEquals(coffeeMaker.checkInventory().getChocolate(), 50-mocha.getAmtChocolate());
    }

    /**
     * This looks perfect
     */
    @Test
    public void testPurchase(){
        inventory.setChocolate(0);
        inventory.setCoffee(0);
        inventory.setSugar(0);
        inventory.setMilk(0);

        assertEquals(coffeeMaker.checkInventory().getMilk(), 0);

        assertFalse(coffeeMaker.checkInventory().enoughIngredients(mocha));
        assertEquals(coffeeMaker.makeCoffee(latte, 100), 100);

        inventory.setChocolate(100);
        inventory.setCoffee(100);
        inventory.setSugar(100);
        inventory.setMilk(100);
        assertEquals(coffeeMaker.makeCoffee(mocha, 120), 20);
        assertEquals(coffeeMaker.makeCoffee(mocha, 100), 0);
        assertEquals(coffeeMaker.makeCoffee(mocha, 99), 99);
    }
}
