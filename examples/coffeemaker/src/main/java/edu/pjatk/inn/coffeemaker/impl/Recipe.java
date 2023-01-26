package edu.pjatk.inn.coffeemaker.impl;

import sorcer.core.context.ServiceContext;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * <p>The Recipe class represents as recipe of coffee for {@link CoffeeMaker#CoffeeMaker} class.
 * <p>Recipe class instance can be utilized by {@link Recipe#getContext}.
 * <p>Contains features that are used to create and manage coffee recipe.
 * <p>Implements Serializable interface.
 *
 * <p>Attributes of Recipe represent composition of coffee ingredients:
 * <p><code>name, price, amtCoffee, amtMilk, amtSugar, amtChocolate</code>
 *
 * <p>{@literal Documentation creators (not authors):}
 * <ul>
 *     <li>Tilek Mukambetov
 *     <li>Ulzhan Akmurat
 *     <li>Artem Kholodenko
 * </ul>
 *
 * @author Sarah
 * @author Mike
 *
 * @version 1.0
 * @since 1.0
 */
public class Recipe implements Serializable {

	/** {@link String} <b>name</b> represent name of recipe. */
	private String name;
	/** price represent price of the recipe. */
	private int price;
	/** amtCoffee represent amount of coffee in the recipe. */
	private int amtCoffee;
	/** amtMilk represent amount of milk in the recipe. */
	private int amtMilk;
	/** amtSugar represent amount of sugar in the recipe. */
	private int amtSugar;
	/** amtChocolate represent amount of chocolate in the recipe. */
	private int amtChocolate;

	/**
	 * Constructor of Recipe class.
	 * Initializes with default zero and empty string values.
	 */
	public Recipe() {
		this.name = "";
		this.price = 0;
		this.amtCoffee = 0;
		this.amtMilk = 0;
		this.amtSugar = 0;
		this.amtChocolate = 0;
	}

	/**
	 * {@link Recipe#amtChocolate}
	 * Returns the amount of chocolate in the Recipe.
	 *
	 * @return {@code amtChocolate} - the current value of chocolate.
	 */
	public int getAmtChocolate() {
		return amtChocolate;
	}

	/**
	 * Sets the amount of chocolate for the Recipe.
	 *
	 * @param amtChocolate the value to set chocolate amount, negative value is omitted.
	 */
	public void setAmtChocolate(int amtChocolate) {
		if (amtChocolate >= 0) {
			this.amtChocolate = amtChocolate;
		}
	}

	/**
	 * Returns the amount of coffee in the Recipe.
	 *
	 * @return {@code amtCoffee} - the current value of coffee.
	 */
	public int getAmtCoffee() {
		return amtCoffee;
	}

	/**
	 * Sets the amount of coffee in the Recipe.
	 *
	 * @param amtCoffee the value to set coffee amount, negative value is omitted.
	 */
	public void setAmtCoffee(int amtCoffee) {
		if (amtCoffee >= 0) {
			this.amtCoffee = amtCoffee;
		}
	}

	/**
	 * Returns the amount of milk in the Recipe.
	 *
	 * @return {@code amtMilk} - the current value of milk.
	 */
	public int getAmtMilk() {
		return amtMilk;
	}

	/**
	 * Sets the amount of milk in the Recipe.
	 *
	 * @param amtMilk the value to set milk amount, negative value is omitted.
	 */
	public void setAmtMilk(int amtMilk) {
		if (amtMilk >= 0) {
			this.amtMilk = amtMilk;
		}
	}

	/**
	 *  Returns the amount of sugar in the Recipe.
	 *
	 *  @return {@code amtSugar} - the current value of sugar.
	 */
	public int getAmtSugar() {
		return amtSugar;
	}

	/**
	 * Sets the amount of sugar in the Recipe.
	 *
	 * @param amtSugar the value to set sugar amount, negative value is omitted.
	 */
	public void setAmtSugar(int amtSugar) {
		if (amtSugar >= 0) {
			this.amtSugar = amtSugar;
		}
	}

	/**
	 * Returns the name of the Recipe.
	 *
	 * @return {@code name} - the name of current Recipe instance.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Recipe.
	 *
	 * @param name the string value to define Recipe name, empty string is omitted.
	 */
	public void setName(String name) {
		if(name != null) {
			this.name = name;
		}
	}

	/**
	 * Returns the price of the Recipe.
	 *
	 * @return {@code price} - the current value of price attribute.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of the Recipe.
	 *
	 * @param price the value to set price attribute, negative value is omitted.
	 */
	public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		}
	}

	/**
	 * Compares the current Recipe to the passed Recipe instance.
	 * Returns {@code true} if name attributes are the same, otherwise {@code false}.
	 *
	 * @param recipe the Recipe instance to compare with.
	 * @return {@code Boolean} value result.
	 */
	public boolean equals(Recipe recipe) {
		if((this.name).equals(recipe.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a string representation of the Recipe, issuing name attribute of the Recipe.
	 * @return {@code name} - the name of current Recipe instance.
	 */
	public String toString() {
		return name;
	}

	/**
	 * Creates a new Recipe object, which attributes defined by {@link Context#getValue} elements.
	 *
	 * @param context the Context argument.
	 * @return recipe - the new Recipe object.
	 * @throws ContextException if {@link Context#getValue} method failed or Context element value is not suitable to cast.
	 * @see Context
	 */
	static public Recipe getRecipe(Context context) throws ContextException {
		Recipe recipe = new Recipe();

		try {
			recipe.name = (String)context.getValue("key");
			recipe.price = (int)context.getValue("price");
			recipe.amtCoffee = (int)context.getValue("amtCoffee");
			recipe.amtMilk = (int)context.getValue("amtMilk");
			recipe.amtSugar = (int)context.getValue("amtSugar");
			recipe.amtChocolate = (int)context.getValue("amtChocolate");
		} catch (RemoteException e) {
			throw new ContextException(e);
		}
		return recipe;
	}

	/**
	 * Creates a new Context object, which elements defined by {@link Recipe#Recipe} attributes.
	 *
	 * @param recipe the Recipe argument.
	 * @return context - the new Context instance.
	 * @throws ContextException if {@link Context#putValue} method failed.
	 * @see Context
	 */
	static public Context getContext(Recipe recipe) throws ContextException {
		Context context = new ServiceContext();
		context.putValue("key", recipe.getName());
		context.putValue("price", recipe.getPrice());
		context.putValue("amtCoffee", recipe.getAmtCoffee());
		context.putValue("amtMilk", recipe.getAmtMilk());
		context.putValue("amtSugar", recipe.getAmtSugar());
		context.putValue("amtChocolate", recipe.getAmtChocolate());
		return context;
	}
}
