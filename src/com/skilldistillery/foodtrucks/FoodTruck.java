package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruck {
	// F I E L D S
	private int numericId = 1;
	private static int counter = 1;
	private String name;
	private String foodType;
	private double rating;
	
	public String toString() {
		return "FoodTruck [name=" + name + ", foodType=" + foodType + ", rating=" + rating
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	// C O N S T R U C T O R S
	public FoodTruck () {
		this.numericId = counter;
		counter++;
		
	}
	
	
	// M E T H O D S
	public void inputFoodTruckName(Scanner kb) {
		System.out.print("Please enter the food truck name: ");
		String foodTruckName = kb.next();
		if (foodTruckName.equalsIgnoreCase("quit")) {
			FoodTruckApp.quitting = true;
		}
		this.setName(foodTruckName);
		
	}
	
	
	public void inputFoodTruckType(Scanner kb) {
		System.out.print("Please enter the food truck type: ");
		String foodTruckType = kb.next();
		this.setFoodType(foodTruckType);
		
	}
	
	public void inputFoodTruckRating(Scanner kb) {
		System.out.print("Please enter the food truck rating: ");
		double foodTruckRating = kb.nextDouble();
		this.setRating(foodTruckRating);
		
	}
	
}
