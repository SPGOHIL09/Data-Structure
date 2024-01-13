// Write a program to implelement Doubly Linked List
import java.util.*;
public class D_LinkedListImplement
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		DoublyLinkedList dd = new DoublyLinkedList();
		boolean flag = true;
		while(flag)
		{
			System.out.println("Enter 1 for Insert from Front\nEnter 2 for Insert from End\nEnter 3 for Delete at a position\nEnter 4 for Display\nEnter 5 for Break :");
			int a = sc.nextInt();
			switch(a)
			{
				case 1 : 
					dd.insert_front();
					break;
				case 2 :
					dd.insert_end();
					break;
				
				case 3 : 
					dd.delete_pos();
					break; 		
				case 4 :
					dd.display();
					break;	
				case 5 :
					flag = false;
					break;		
			}
		}
	}
}
class MyNode
{
	int info;
	MyNode lptr = null;
	MyNode rptr = null;
	MyNode(int info)
	{
		this.info = info;
	}
}
class DoublyLinkedList
{
	Scanner sc = new Scanner(System.in);
	MyNode head,tail;

	public void insert_end()
	{
		MyNode n;
		System.out.print("Enter an element : ");
		int x = sc.nextInt();
		if(head == null)
		{
			n = new MyNode(x);
			head = n;
			tail = n;
		}
		else
		{
			n = new MyNode(x);
			tail.rptr = n;
			n.lptr = tail;
			tail = n;
		}
	}

	public void insert_front()
	{
		MyNode n;
		System.out.print("Enter an element : ");
		int x = sc.nextInt();
		if(head == null)
		{
			n = new MyNode(x);
			head = n;
			tail = n;
		}
		else 
		{
			n = new MyNode(x);
			head.lptr = n;
			n.rptr = head;
			head = n;
		}
	}

	public void display()
	{
		MyNode temp = head;
		MyNode temp2 = tail;
		System.out.println("Display from Left Side : ");
		while(temp != null)
		{
			System.out.print(temp.info+"-->");
			temp = temp.rptr;
		}
		System.out.println("null");
		System.out.println("Display from Right Side : ");
		while(temp2  != null)
		{
			System.out.print(temp2.info+"-->");
			temp2 = temp2.lptr;
		}
		System.out.println("null");
	}
	public void delete_pos()
	{
		int count = 0;
		System.out.print("Enter pos : ");
		int pos = sc.nextInt();
		MyNode old = head;
		MyNode pred = null;

		while(count < pos -1 &&  old != tail)
		{
			pred = old;
			old = old.rptr;
			count++;
		}

		if(pos-1 != count)
		{
			System.out.println("Node does not found!!");
		}
		if(head == null && tail == null)
		{
			System.out.println("Doubly Linked List is Empty!!!");
			return;
		}
		else 
		{
			if(head == tail)
			{
				head = null;
				tail = null;
				return;
			}

			if(old == head)
			{
				head = head.rptr;
				head.lptr = null;
				old.rptr = null;

			}
			else if(old == tail)
			{
				tail = tail.lptr;
				tail.rptr = null;
			}
			else
			{
				pred.rptr = old.rptr;
				old.rptr.lptr = old.lptr;
				old.rptr = null;
				old.lptr = null;
			}

		}


	}
}