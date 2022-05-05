package main;

import java.util.Scanner;

import model.LinkListTail;
import model.Node;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static LinkListTail list = new LinkListTail();

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
		
		createLinked(col,fil,sem,link);
		System.out.println("  ");
		System.out.println("EMPIEZA EL JUEGO\n");
		int optionMenu;
		while(list.contin()) {
		 System.out.println("\n    MENU ");
	        System.out.println("1. Tirar Dado");
	        System.out.println("2. Ver tablero");
	        System.out.println("3. Ver enlaces");
	        System.out.println("4. Marcador");
	    
	         
	        System.out.println("¿qué desea hacer?");
	        optionMenu = sc.nextInt();
	        jugando(fil,optionMenu,username1,username2);
        }
		
		
		
	
		
	
	}
	
	public static void createLinked(int col, int fil, int sem, int link) {
		
		int total = col*fil;
		for(int i=1;i<=total;i++)
		list.addLast(new Node(i));
		
		list.generatePositions();
		list. generateSems(sem);
		list.generateLinks(link);
		list.print(fil);
		
	}
	
	public static void jugando(int fil,int optionMenu, String username1,String username2) {
		
	    	  
	            
	           switch(optionMenu){
	               case 1:
	                   System.out.println("TIRA DADOS");
	                   TirarDados(list.turnos(), fil);
	                   
	                   break;
	               case 2:
	                   System.out.println("TABLERO");
	                   VerTablero(fil);
	                   break;
	                case 3:
	                   System.out.println("PORTALES: ");
	                   MostrarLinks(fil);
	                   
	                   break;
	                case 4:
		               System.out.println("MARCADOR");
		               MostrarMarcador();
		                   
		                   break;
	                
	                default:
	                   System.out.println("Solo números entre 1 y 4");
	           }
	            
	       
		showWinner(username1,username2);
		
	}
	
	
	
	private static void MostrarMarcador() {
		// TODO Auto-generated method stub
		
	}

	private static void MostrarLinks(int fil) {
		list.printLinks(fil);
		
	}

	private static void VerTablero(int fil) {
		list.print(fil);
		
	}

	private static void TirarDados(int turn, int fil) {
		if (turn==1) {
			int numDado = list.dado();
			System.out.println("Sacaste: "+numDado);
			System.out.println("Hacia dónde va Rick?\n");
			System.out.println("Direccion: 1: Avanza | 2: Retrocede");
			int rsp = sc.nextInt();
			sc.nextLine();
			
			list.movePlayer(rsp, numDado,turn);
			list.print(fil);
		
			
		}else if(turn==2) {
			int numDado = list.dado();
			System.out.println("Sacaste: "+numDado);
			System.out.println("Hacia dónde va Morty?\n");
			System.out.println("Direccion: 1: Avanza | 2: Retrocede");
			int rsp = sc.nextInt();
			sc.nextLine();
			list.movePlayer(rsp, numDado,turn);
			list.print(fil);
		}	
		
	}

	public static void showWinner(String username1,String username2) {
		list.winner(username1, username2);
		
	}
}
