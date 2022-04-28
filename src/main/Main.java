package main;

import java.util.Scanner;

import model.LinkListTail;
import model.Node;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("BUSCANDO LAS SEMILLAS\n");
		System.out.print("Digita el numero de las columnas del tablero\n");
		int col = sc.nextInt();
		sc.nextLine();
		System.out.print("Ahora el numero de filas\n");
		int fil = sc.nextInt();
		sc.nextLine();
		System.out.print("El numero de semillas en el tablero\n");
		int sem = sc.nextInt();
		sc.nextLine();
		System.out.print("Por ultimo el numero de enlaces\n");
		int link = sc.nextInt();
		sc.nextLine();
		double max = 0.5*(col*fil);
		while(max <link){
			System.out.print("No es un numero valido\n");
			link = sc.nextInt();
			sc.nextLine();
		}
		
		System.out.print("Ahora digita el username del jugador Rick\n");
		String username1 = sc.nextLine();
		System.out.print("Digita el username del jugador de Morty\n");
		String username2 = sc.nextLine();
		
		createLinked(col,fil,sem,link,username1,username2);
	}
	
	public static void createLinked(int col, int fil, int sem, int link, String username1, String username2) {
		LinkListTail list = new LinkListTail(username1, username2);
		int total = col*fil;
		for(int i=1;i<=total;i++)
		 list.addLast(new Node(i));
		
		list.generatePositions();
		list. generateSems(sem);
		list.generatePortals(link);
		list.print(fil);
		
	}

}
