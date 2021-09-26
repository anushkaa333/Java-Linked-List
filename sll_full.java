package SLL;


import java.io.*;
import java.util.Scanner;

class linkedlist {
	int data;
	linkedlist next;

	linkedlist(int value) {
		this.data = value;
	}

	void display() {
		System.out.println(data);
	}
}

class linked {
	public linkedlist fstnode, lastnode;
	private int value;

	linked() {
		fstnode = null;
		lastnode = null;
	}
	
	/* Insert node or create linked list */
	void insertnode(int value) {
		linkedlist node = new linkedlist(value);
		node.next = null;
		if(fstnode == null) {
			fstnode = lastnode = node;
			System.out.println("Linked list created successfully!");
		}
		else {
			lastnode.next = node;
			lastnode = node;
			System.out.println("Node inserted successfully!");
		}
	}
	
	void insertNth(Scanner input)
	{
		int count=0;
		
		linkedlist node;
		for(node = fstnode; node != null; node = node.next)
			count++;
		
		System.out.println(count+" nodes available here!");
		
		System.out.println("Enter value :");
		int value = input.nextInt();
		System.out.println("Enter position : ");
		int position = input.nextInt();
		
		linkedlist node1 = new linkedlist(value);
		node1.next = null;
		
		if(position == count+1)
			insertnode(value);
		else if(position == 1)
		{
			node1.next = fstnode;
			fstnode = node1;
		}
		else
		{
			linkedlist current = fstnode;
			linkedlist prev = null;
			int i = 0;
			while(i < position)
			{
				prev = current;
				current = current.next;
				i++;
			}
			
			node1.next = current;
			prev.next = node1;
		}
			
	}

	/* Delete node from linked list */
	void delete() {
		int count = 0, number, i;
		linkedlist node, node1;
		Scanner input = new Scanner(System.in);
		
		for(node = fstnode; node != null; node = node.next)
			count++;
		display();
		node = node1 = fstnode;
		System.out.println(count+" nodes available here!");
		System.out.println("Enter the node number which you want to delete:");
		number = Integer.parseInt(input.nextLine());
		if(number != 1) {
			if(number <= count) {
				for(i = 2; i <= number; i++)
					node = node.next;

				for(i = 2; i <= number-1; i++)
					node1 = node1.next;

				node1.next = node.next;
				node.next = null;
				node = null;
			}
			else
				System.out.println("Invalid node number!\n");
		}
		else {
			fstnode = node.next;
			node = null;
		}

		System.out.println("Node has been deleted successfully!\n");
	}

	/* Display linked list */
	void display() {
		linkedlist node = fstnode;
		System.out.println("List of node:");
		while(node != null) {
			node.display();
			node = node.next;
		}
	}
}


public class sll_full {
	public static void main(String args[ ]) {
		linked list = new linked();
		Scanner input = new Scanner(System.in);
		int op = 0;
		while(op != 5) {
			System.out.println("1. Insert  2. Insert at any position  3. Delete 4. Display 5. Exit");
			System.out.println("Enter your choice:");
			op = Integer.parseInt(input.nextLine());
			switch(op) {
				case 1:
					System.out.println("Enter the value for Linked list:");
					list.insertnode(Integer.parseInt(input.nextLine()));
					break;
					
				case 2 : 
					list.insertNth(input);
					break;

				case 3:
					list.delete();
					break;

				case 4:
					list.display();
					break;

				case 5:
					System.out.println("Bye Bye!");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice!");

			}
		}
	}
}
