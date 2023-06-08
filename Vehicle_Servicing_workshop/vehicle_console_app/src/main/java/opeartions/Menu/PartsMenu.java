package opeartions.Menu;

import java.util.Scanner;

import opeartions.service.PartService;

public class PartsMenu {
	public static int menu() {
		System.out.println("0.Exit");
		System.out.println("1.Fetch All Parts");
		System.out.println("2.Fetch Specific Part");
		System.out.println("3.Delete Part");
		System.out.println("4.Update Part");
		System.out.println("5.Add part");
		System.out.print("Enter your choice = ");
		System.out.println("");
		return new Scanner(System.in).nextInt();
	}
	
public static void ChoosePartMain() {
	System.out.println("Choose Part Operations");
	int choice;
	Scanner scan = new Scanner(System.in);
	while((choice = menu())!=0) {
		switch (choice) {
		case 1:
				PartService.getAllParts();
				System.out.println("");
			break;

		case 2:
			PartService.getSpecificPart();
			System.out.println("");
			break;

		case 3:
			PartService.removePart();
			System.out.println("");
			break;

		case 4:
			PartService.updatePart();
			System.out.println("");
			break;

		case 5:
			PartService.addPart();
			System.out.println("");
			break;

			
		default:
			System.out.println("Wrong choice entered..:(");
			break;
		}
	}
}
}
