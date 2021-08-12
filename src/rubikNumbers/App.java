package rubikNumbers;

import java.util.Scanner;

public class App {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		menu();

	}

	public static void menu(){
		boolean continueM = false;

		try {
			while(!continueM){
				System.out.println("======Rubik Numbers======");
				System.out.println("Elige en que modo quieres jugar:" +
						"\n1.Rubik Numbers Basico"+
						"\n2.Rubik Numbers Avanzado"+
						"\n3.Rubik Numbers Experto"+
						"\n4.Salir del programa"+
						"\n-->");

				String option = sc.nextLine();

				switch (option) {
					case "1" -> {
						RunMode.basicMode();
						continueM = true;
					}
					case "2" -> {
						RunMode.advancedMode();
						continueM = true;
					}
					case "3" -> {
						RunMode.expertMode();
						continueM = true;
					}
					case "4" -> {
						System.out.println("Saliendo del programa...");
						continueM = true;
					}

					default -> System.err.println("[!] Introduce una opcion valida del menu!");
				}
			}
		}catch (Exception e){
			System.err.println("[!] Error en el menu");
			e.printStackTrace();
		}
	}
}
