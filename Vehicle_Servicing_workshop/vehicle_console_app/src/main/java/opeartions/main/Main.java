package opeartions.main;

import java.sql.SQLException;

import opeartions.Menu.MainMenu;

public class Main {

	private static MainMenu mainmenu;
	public static void main(String[] args) throws SQLException {
		System.out.println("Main Function Started!");
		Main m= new Main();
		m.mainmenu.TheMainMenu();
		System.out.println("Main Function Ended!");
		
	}

}
