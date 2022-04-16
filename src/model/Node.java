package model;

public class Node {
	
	private int value;
	private boolean morty;
	private boolean rick;
	private boolean sem;


	public boolean isMorty() {
		return morty;
	}

	public void setMorty(boolean morty) {
		this.morty = morty;
	}

	public boolean isRick() {
		return rick;
	}

	public void setRick(boolean rick) {
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
