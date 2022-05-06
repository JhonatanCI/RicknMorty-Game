package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkListTail {

	public final static String SPLIT=";";	
	
	private List<Player> winners = new ArrayList<Player>();

	private Node head;
	private Node tail;

	private  int semRick = 0;
	private  int semMorty = 0;

	public int getSemRick() {
		return semRick;
	}

	public void setSemRick(int semRick) {
		this.semRick = semRick;

	}	

	public List<Player> getWinners() {
		return winners;
	}

	public void setWinners(List<Player> winners) {
		this.winners = winners;
	}

	public  int getSemMorty() {
		return semMorty;
	}

	public  void setSemMorty(int semMorty) {
		this.semMorty = semMorty;
	}

	public void addFirst(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.setNext(head);
			head.setPrevius(node);
			head = node;
			tail.setNext(head);
		}

	}

	public void addLast(Node node) {
		if (tail == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			node.setPrevius(tail);
			tail = node;
			tail.setNext(head);
		}
	}

	public Node search(int goal) {
		return search(goal, head);
	}

	private Node search(int goal, Node current) {
		if (current == null) {
			return null;
		}
		if (current.getValue() == goal) {
			return current;
		}
		return search(goal, current.getNext());
	}

	public void print(int f) {
		print(head, f, 0);
	}

	private void print(Node current, int f, int num) {

		if (num == f) {
			System.out.print("\n");
			num = 1;
		} else {
			num++;
		}

		if (current.isMorty()) {
			System.out.print("  [M]  ");
		} else

			if (current.isRick()) {
				System.out.print("  [R]  ");
			} else

				if (current.isSem()) {
					System.out.print("  [*]  ");
				} else {

					System.out.print("  [" + current.getValue() + "]  ");
				}

		if (current == tail) {
			return;
		}
		print(current.getNext(), f, num);
	}

	public void printLinks(int f) {
		printLinks(head, f, 0);
	}

	private void printLinks(Node current, int f, int num) {



		if (num == f) {
			System.out.print("\n");
			num = 1;
		} else {
			num++;
		}

		if(current.getLink()!=(char)0){
			System.out.print("  ["+current.getLink()+"]  ");
		}
		else{
			System.out.print("  [ ]  ");
		}
		if (current == tail) {
			return;
		}
		printLinks(current.getNext(), f, num);

	}

	public void delete(int value) {

		if (search(value).getPrevius() != null) {
			search(value).getPrevius().setNext(search(value).getNext());
		} else {
			search(value).getNext().setPrevius(null);
			head = head.getNext();
		}

	}

	public void generatePositions() {
		int m = getRandomNumberUsingNextInt(1, tail.getValue());
		int r = getRandomNumberUsingNextInt(1, tail.getValue());
		while (r == m) {
			r = getRandomNumberUsingNextInt(1, tail.getValue());
		}
		Node rick = search(r);
		Node morty = search(m);
		rick.setRick(true);
		morty.setMorty(true);
	}

	public void generateSems(int quantity) {
		int num = 0;
		int pos = getRandomNumberUsingNextInt(1, tail.getValue());
		while (quantity != num) {
			Node s = search(pos);
			if (!s.isSem() && !s.isMorty() && !s.isRick()) {
				s.setSem(true);
				num++;
			}
			pos = getRandomNumberUsingNextInt(1, tail.getValue());
		}
	}

	public void generateLinks(int link ) {
		int numLinks=0;
		int posNodPor = getRandomNumberUsingNextInt(1, tail.getValue());
		int por = getRandomNumberUsingNextInt(1, tail.getValue());
		int count = 65;
		char chara = (char)count;
		while (link!= numLinks) {

			Node posNod=search(posNodPor);			
			Node portal=search(por);
			if(posNodPor!=por&&posNod.getPortal()==null&&portal.getPortal()==null) {


				portal.setLink(chara);
				posNod.setLink(chara);
				posNod.setPortal(portal);
				portal.setPortal(posNod);
				numLinks++;
				count++;
				chara = (char)count;
			}
			por = getRandomNumberUsingNextInt(1, tail.getValue());
			posNodPor = getRandomNumberUsingNextInt(1, tail.getValue());

		}
	}




	public int getRandomNumberUsingNextInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public int dado() {
		int numDado = getRandomNumberUsingNextInt(1, 6);
		return numDado;
	}

	int turn = 1;

	public int turnos() {

		if (turn == 1) {

			System.out.println("Turno Rick");
			turn = 2;
			return 1;

		} else if (turn == 2) {
			System.out.println("Turno Morty");
			turn = 1;
			return 2;

		}

		return turn;
	}

	public Node findOPlayer(int option) {
		Node out = null;
		switch (option) {
		case 1:
			out = findOPlayer(option, head);
			break;
		case 2:
			out = findOPlayer(option, head);
			break;
		}

		return out;
	}

	private Node findOPlayer(int num, Node current) {
		Node out = null;
		if (current == null) {
			return null;
		}
		if (num == 1) {

			if (current.isRick()) {
				return current;
			}
			return findOPlayer(1, current.getNext());
		} else

			if (num == 2) {

				if (current.isMorty()) {
					return current;
				}
				return findOPlayer(2, current.getNext());
			}

		return out;
	}

	public void movePlayer(int rsp, int numDado, int turn) {
		Node nodo = findOPlayer(turn);
		if (nodo.isRick()) {
			if (rsp == 1) { // hacia adelante
				moveAdelante(nodo, nodo, numDado);
				nodo.setRick(false);
				if (nodo.isSem()) {
					semRick++;
					nodo.setSem(false);
				}


			} else if (rsp == 2) { // hacia atrás
				moveAtras(nodo, nodo, numDado);
				nodo.setRick(false);
				if (nodo.isSem()) {
					++semRick;
					nodo.setSem(false);
				}
			}
		} else if (nodo.isMorty()) {
			if (rsp == 1) { // hacia adelante
				moveAdelante(nodo, nodo, numDado);
				nodo.setMorty(false);
				if (nodo.isSem()) {
					++semMorty;
					nodo.setSem(false);
				}


			} else if (rsp == 2) { // hacia atrás
				moveAtras(nodo, nodo, numDado);
				nodo.setMorty(false);
				if (nodo.isSem()) {
					semMorty++;
					nodo.setSem(false);
				}


			}
		}

	}

	private void moveAdelante(Node current, Node nodo, int numDado) {

		if (nodo.isRick()) {
			// Condicion de parada
			if (numDado == 0) {

				if(current.getPortal()!=null) {

					current.getPortal().setRick(true);

				}else {
					current.setRick(true);
				}
				return;
			}

			// Metodo recursivo
			moveAdelante(current.getNext(), nodo, numDado - 1);

		} else if (nodo.isMorty()) {
			// Condicion de parada
			if (numDado == 0) {
				if(current.getPortal()!=null) {

					current.getPortal().setMorty(true);

				}else {
					current.setMorty(true);
				}
				return;
			}

			// Metodo recursivo
			moveAdelante(current.getNext(), nodo, numDado - 1);
		}

	}

	private void moveAtras(Node current, Node nodo, int numDado) {
		if (nodo.isRick()) {
			// Condicion de parada
			if (numDado == 0) {
				if(current.getPortal()!=null) {

					current.getPortal().setRick(true);

				}else {
					current.setRick(true);
				}
				return;
			}

			// Metodo recursivo
			moveAtras(current.getPrevius(), nodo, numDado - 1);
		} else if (nodo.isMorty()) {
			// Condicion de parada
			if (numDado == 0) {

				if(current.getPortal()!=null) {

					current.getPortal().setMorty(true);

				}else {
					current.setMorty(true);
				}
				return;
			}

			// Metodo recursivo
			moveAtras(current.getPrevius(), nodo, numDado - 1);
		}

	}

	public boolean contin() {
		return countSem(head);
	}

	private boolean countSem(Node current) {
		if (current.isSem()) {
			return true;
		}
		if (current == tail) {
			return false;
		}
		return countSem(current.getNext());

	}

	public String winner(String username1, String username2) {
		contin();
		String msg = "";
		if (semRick > semMorty) {
			msg = username1 + "GANÓ LA PARTIDA/n" + "Semillas recolectadas: " + semRick;

		} else if (semRick < semMorty) {
			msg = username2 + "GANÓ LA PARTIDA/n" + "Semillas recolectadas: " + semMorty;

		}
		
		Player winner = new Player();
		
		updateScore(winner);
		
		exportData();
		
		
		return msg;
	}
	
	private void updateScore(Player winner) {
		boolean stop = false;
		for (int i=0;i<winners.size() && !stop;i++) {
			if (winners.get(i).getUsername.equals(winner.getUSername())) {
				winners.get(i).setPuntaje(winners.get(i).getPuntaje() + winner.getPuntaje);
				stop = true;
			}
		}
		
		if (stop == false) {
			winners.add(winner);
		}
	}


	//Import data
	public void importData() throws IOException {
		File file  = new File("data/TOP.txt");

		if (file!=null) {
			System.out.println("Se importará la información del archivo txt");
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = br.readLine();
				while(line!=null){	
					String[] parts = line.split(SPLIT);
					
	    				Player player = new Player();
	    				winners.add(player);
					  			
					line = br.readLine();    				
				}
				br.close();
				System.out.println("La información se ha importado correctamente");

			}catch (IOException e) {
				System.out.println("Hubo un problema. No se pudo importar la información");    			 			
			}    		
		}

	}




	//Export data
	public void exportData() throws IOException{
		File file = new File ("data/TOP.txt"); 
		PrintWriter pw =  new PrintWriter(file);

		if (file!=null) {    	
			System.out.println("Se exportará la información del archivo txt");
				/*
	    		for (int i=0;i<winners.size();i++) {
	    			pw.println(winners.get(i)+";"+winners.get(i));
	    		}
			 	*/
			pw.close();
			System.out.println("Se ha exportado exitosamente la información del archivo txt"); 		   	
		}     			    
	}

}
