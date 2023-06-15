package opeartions.Menu;

import java.util.Scanner;

import opeartions.service.PartService;

enum EPartMenu{
	EXIT,ALL_PARTS,SEPCIFIC_PART,
	DELETE_PART,UPDATE_PART,ADD_PART,DEFAULT
}

public class PartsMenu {
	public static EPartMenu menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Parts");
		System.out.println("2.Fetch Specific Part");
		System.out.println("3.Delete Part");
		System.out.println("4.Update Part");
		System.out.println("5.Add part");
		System.out.print("Enter your choice = ");
		System.out.println("");
		int choice = new Scanner(System.in).nextInt();
		return (choice<0 ||choice>5 ? EPartMenu.values()[6] :EPartMenu.values()[choice]);
	}
	
public static void ChoosePartMain() {
	System.out.println("Choose Part Operations");
	EPartMenu choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=EPartMenu.EXIT) {
		switch (choice) {
		case ALL_PARTS:
				PartService.getAllParts();
				System.out.println("");
			break;

		case SEPCIFIC_PART:
			PartService.getSpecificPartById();
			System.out.println("");
			break;

		case DELETE_PART:
			PartService.removePart();
			System.out.println("");
			break;

		case UPDATE_PART:
			PartService.updatePart();
			System.out.println("");
			break;

		case ADD_PART:
			PartService.addPart();
			System.out.println("");
			break;

			
		case DEFAULT:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
