package model;

import java.util.Random;

public class LinkListTail {
	
	private Node head;
	private Node tail;
	private String rickName;
	private String mortyName;
	
	public LinkListTail(String username1, String username2) {
		this.rickName=username1;
		this.mortyName=username2;
	}

	public void addFirst(Node node) {
		if(head == null) {
			head = node;
			tail = node;
		}else {
			node.setNext(head);
			head.setPrevius(node);
			head = node;
		}
		
	}
	
	public void addLast(Node node) {
		if(tail==null) {
			head = node;
			tail = node;
		}else {
			tail.setNext(node);
			node.setPrevius(tail);
			tail = node;	
		}
	}
	
	public Node search(int goal) {
		return search(goal,head);
	}
	
	private Node search(int goal, Node current) {
		
		if(current == null) {
			return null;
		}
		
		if(current.getValue()==goal) {
			return current;
		}
		
		return search(goal,current.getNext());
	}
	
	public void print(int f) {
		print(head,f,0);
	}
	private void print(Node current,int f,int num) {
		if(current==null) {
			return;
		}
		
		if(num==f) {
			System.out.print("\n");
			num=1;
		}else {
			num++;
		}
		
		
		if(current.getMorty()!=null) {
			System.out.print("  [M]  ");
		}else
		
		if(current.getRick()!=null) {
			System.out.print("  [R]  ");
		}else
		
		if(current.isSem()) {
			System.out.print("  [*]  ");
		}else {

		
		System.out.print("  ["+current.getValue()+"]  ");}
		print(current.getNext(),f,num);
	}

	public void delete(int value) {
		
		if(search(value).getPrevius()!=null) {
			search(value).getPrevius().setNext(search(value).getNext());
		}else {
			search(value).getNext().setPrevius(null);
			head = head.getNext();
		}
	
	}
	
	public void generatePositions() {
		int m = getRandomNumberUsingNextInt( 1,  tail.getValue());
		int r = getRandomNumberUsingNextInt( 1,  tail.getValue());
		while(r==m) {
		 r = getRandomNumberUsingNextInt( 1,  tail.getValue());
		}
		Node rick = search(r);
		Node morty = search(m);
		rick.setRick(new Player(rickName));
		morty.setMorty(new Player(mortyName));
	}
	
	public void generateSems(int quantity) {
		int num=0;
		int pos=getRandomNumberUsingNextInt( 1,  tail.getValue());
		while(quantity!=num) {
			Node s = search(pos);
			if(!s.isSem()&&s.getMorty()==null&&s.getRick()==null) {
				s.setSem(true);
				num++;
			}
			pos=getRandomNumberUsingNextInt( 1,  tail.getValue());
		}
	}
	
	public int getRandomNumberUsingNextInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}

	public void generatePortals(int link) {
		
		int num=0;
		int pos=getRandomNumberUsingNextInt( 1,  tail.getValue());
		int por= getRandomNumberUsingNextInt( 1,  tail.getValue());
		if(por==pos) {
			generatePortals( link);
		}
		while(link!=num) {
			Node s = search(pos);
			Node portal = search(por);
			if(s.getMorty()==null&&s.getRick()==null) {
				s.setPortal(portal);
				num++;
			}
			pos=getRandomNumberUsingNextInt( 1,  tail.getValue());
		}
		
	}
}
