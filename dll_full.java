package DLL;

import java.util.Scanner;

class linkedlist
{
	int data;
	linkedlist prev;
	linkedlist next;
	
	linkedlist(int value)
	{
		this.data = value;
	}
	
	void display()
	{
		System.out.println(data);
	}
}

class linked
{
	public linkedlist fstnode, lstnode;
	
	linked()
	{
		fstnode = null;
		lstnode = null;
	}
	
	void insert_first(int value)
	{
		linkedlist node = new linkedlist(value);
		node.next = null;
		if(fstnode == null)
		{
			fstnode = lstnode = node;
			System.out.println("Linked list is created succesfully");
		}
		else
		{
			node.prev = null;
			node.next = fstnode;
			fstnode.prev = node;
			fstnode = node;
		}
	}
	
	void insert_at_position(int value)
	{
		int count = 0;
		linkedlist node;
		for(node = fstnode; node!=null; node=node.next)
		{
			count++;
		}
		System.out.println(count + " Nodes are available");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter position");
		int p = Integer.parseInt(sc.nextLine());
		linkedlist node3 = new linkedlist(value);
		node3.next = null;
		if(fstnode == null)
		{
			System.out.println("List is empty;");
		}
		else
		{
			if( p == count + 1 )
				insert_end(value);
			else if (p ==1)
				insert_first(value);
			else
			{
				linkedlist node1, node2;
				node1 = node2 = fstnode;
				for(int i=1; i <= p-1; i++)
				{
					node1 = node1.next;  
				}
				
				node2 = node1.prev;
				node2.next = node1;
				
				node2.next = node3;
				node3.prev = node2;
				node1.prev = node3;
				node3.next = node1;
			}
				
		}
	}
	
	void insert_end(int value)
	{
		linkedlist node = new linkedlist(value);
		node.next = null;
		if(fstnode == null)
		{
			fstnode = lstnode = node;
			System.out.println("Linked list is created succesfully");
		}
		else
		{
			node.prev= lstnode;
			node.next = null;
			lstnode.next = node;
			lstnode = node;
		}
	}
	
	void delete()
	{
		int count = 0 ; 
		linkedlist node, node1, node2;
		Scanner sc = new Scanner(System.in);
		
		for(node = fstnode; node!=null; node=node.next)
		{
			count++;
		}
		
		display();
		
		node = node1 = node2 = fstnode;
		System.out.println(count + " Nodes are available");
		System.out.println("Enter node you want to delete");
		int num = Integer.parseInt(sc.nextLine());
		if(num!=1)
		{
			if(num < count && num > 0)
			{
				for(int i=2; i<=num; i++)
					node = node.next;
		
				for(int i=2; i<=num-1; i++)
					node1 = node1.next;
				
				for(int i=2; i<=num+1; i++)
					node2 = node2.next;
				
				node1.next = node2;
				node2.prev= node1;
				node.next = null;
				node.prev = null;
				node = null;
				
			}
			else if(num==count)
			{
				node = lstnode;
				lstnode = node.prev;
				lstnode.next = null;
				node = null;
			}
			else
			{
				System.out.println("Invalid Number");
			}
		}
		else
		{
			node = fstnode;
			fstnode = node.next;
			fstnode.prev = null;
			node = null;
		}
		
	}
	
	void display()
	{
		linkedlist node = fstnode;
		System.out.println("Ascending order");
		while(node!=null)
		{
			node.display();
			node = node.next;
		}
		
		/*node = lstnode;
		System.out.println("Dscending order");
		{
			node.display();
			node = node.prev;
		}*/
	}
}

public class dll_full {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		linked list = new linked();
		int op = 0;
		while(op!=6)
		{
			System.out.println("\n1.Insert At First\n2.Insert At Last\n3.Insert at position\n4.Delete\n5.Display\n6.Exit");
			System.out.println("Enter your choice");
			op = Integer.parseInt(sc.nextLine());
			switch(op)
			{
			case 1 : 
				list.insert_first(Integer.parseInt(sc.nextLine()));
				break;
				
			case 2 :
				list.insert_end(Integer.parseInt(sc.nextLine()));
				break;
				
			case 3 : 
				list.insert_at_position(Integer.parseInt(sc.nextLine()));
				
			case 4 : 
				list.delete();
				break;
				
			case 5 : 
				list.display();
				break;
				
			case 6 :
				System.exit(0);
				break;
				
				default :
					System.out.println("Invalid choice");
			}
		}
	}

}
