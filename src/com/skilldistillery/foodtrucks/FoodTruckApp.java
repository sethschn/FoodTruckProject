package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {
	// 1. Users will input and rate a list of food trucks
	// 2. then view the average rating and the highest rated truck
	// F I E L D S
	static boolean quitting;
	
	//C O N S T R U C T O R S
	public FoodTruckApp() {
	}

	public static void main(String[] args) {
		FoodTruckApp main = new FoodTruckApp();	
		FoodTruck[] ftArray = new FoodTruck[5];
		Scanner kb = new Scanner(System.in);

		System.out.println("Please enter up to five food trucks.");
		// loop through 5 times and ask for food truck name, food type and rating.
		for (int i = 0; i < 5; i++) {
			ftArray[i] = new FoodTruck();
			ftArray[i].inputFoodTruckName(kb);
			if (quitting) {
				ftArray[i] = null;
				break;
			}
			ftArray[i].inputFoodTruckType(kb);
			ftArray[i].inputFoodTruckRating(kb);
		}
		System.out.println();

		main.foodTruckMenu(kb, ftArray);

		kb.close();
	}// end main

	public void foodTruckMenu(Scanner kb,FoodTruck[] ftArray) {
		System.out.println("1. List all existing food trucks");
		System.out.println("2. See the average rating of food trucks");
		System.out.println("3. Display the highest rated food truck");
		System.out.println("4. Quit the program");
		System.out.print("Choice(1-4): ");
		int choice = kb.nextInt();
		System.out.println();
		switch (choice) {
		case 1:
			listAllFoodTrucks(kb, ftArray);
			break;
		case 2:
			foodTruckAvgRating(kb, ftArray);
			break;
		case 3:
			showHighestRated(kb, ftArray);
			break;
		case 4:
			// quitTheProgram();
			System.out.println("\tQuitting");
			break;
		default:
			System.out.println("ERROR DEFAULT CASE!");
			break;
		}
		

	}// end foodTruckMenu

	public void listAllFoodTrucks(Scanner kb, FoodTruck[] ftArray) {
		for (FoodTruck ftObj : ftArray) {
			if (ftObj != null) {
				System.out.println(ftObj.toString());
			}
		}
		System.out.println("");
		this.foodTruckMenu(kb,ftArray);
	}//end list all food trucks
	
	public void foodTruckAvgRating(Scanner kb, FoodTruck[] ftArray) {
		double total = 0.0;
		double averageRating = 0.0;
		int counter = 0;
		for (FoodTruck ftObj : ftArray) {
			if (ftObj != null) {
				total = total + ftObj.getRating();
				counter++;
			}
		}
		averageRating = (total / counter)*100;
		averageRating = averageRating / 100;
		System.out.println("\tAverage rating "+averageRating+"\n");
		this.foodTruckMenu(kb, ftArray);
	}// end food truck average
	
	public void showHighestRated(Scanner kb, FoodTruck[] ftArray) {
		double highest = Integer.MIN_VALUE;
		FoodTruck ftHighest = null;
		for (FoodTruck ftObj : ftArray) {
			if (ftObj != null) {
				double rating = ftObj.getRating();
				if (rating > highest) {
					highest = rating;
					ftHighest = ftObj;
				}
				
			}
		}
		System.out.println("\t\tHighest rated food truck");
		System.out.println("\t"+ftHighest);
		System.out.println();
		this.foodTruckMenu(kb, ftArray);

	}

}// end class
