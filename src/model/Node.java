package model;

public class Node {
	
	private int value;
	private Player morty;
	private Player rick;
	private boolean sem;
	private Node portal;


	public Node getPortal() {
		return portal;
	}

	public void setPortal(Node portal) {
		this.portal = portal;
	}

	public Player getMorty() {
		return morty;
	}

	public void setMorty(Player morty) {
		this.morty = morty;
	}

	public Player getRick() {
		return rick;
	}

	public void setRick(Player rick) {
		this.rick = rick;
	}

	public boolean isSem() {
		return sem;
	}

	public void setSem(boolean sem) {
		this.sem = sem;
	}


	private Node next;
	private Node previus;


	public Node getPrevius() {
		return previus;
	}

	public void setPrevius(Node previus) {
		this.previus = previus;
	}

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}
	
}
