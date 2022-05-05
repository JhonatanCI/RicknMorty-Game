package model;

public class Node {
	
	private int value;
	
	private boolean morty;
	private boolean rick;
	private boolean sem;
	
	private Node next;
	private Node previus;
	
	

	int passed;
	private Node portal;

	private char link=0;
	
	public char getLink() {
		return link;
	}

	public void setLink(char link) {
		this.link = link;
	}

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



	public int getPassed() {
		return passed;
	}

	public void setPassed(int passed) {
		this.passed = passed;
	}

	public Node getPrevius() {
		return previus;
	}

	public void setPrevius(Node previus) {
		this.previus = previus;
	}

	public Node(int value) {
		this.value = value;
		passed=0;
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

	public void setPortal(Node posNod) {
		portal=posNod;
		
	}
	
	public Node getPortal() {
		return portal;
	}
}
