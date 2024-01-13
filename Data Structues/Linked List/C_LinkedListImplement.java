import java.util.*;
public class C_LinkedListImplement
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularLinkedList cc = new CircularLinkedList();
		boolean flag = true;
		while(flag)
		{
			System.out.println("Enter 1 for Insert from Front\nEnter 2 for Insert from End\nEnter 3 for Delete at a position\nEnter 4 for Display\nEnter 5 for Break :");
			int a = sc.nextInt();
			switch(a)
			{
				case 1 : 
					cc.insert_front();
					break;
				case 2 :
					cc.insert_end();
					break;
				
				case 3 : 
					cc.delete_pos();
					break; 		
				case 4 :
					cc.display();
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
	MyNode next;
	MyNode(int info)
	{
		this.info = info;
	}
}
class CircularLinkedList
{
	Scanner sc = new Scanner(System.in);
	MyNode head,tail;
 
	public void insert_front()
	{
		System.out.print("Enter the element : ");
		int x = sc.nextInt();
		MyNode n ;
		if(head == null)
		{
			n = new MyNode(x);
			head = n;
			tail = n;
			tail.next = head;
		}
		else 
		{
			n = new MyNode(x);
			n.next = head;
			head = n;
			tail.next = head;
		}
	}
	public void insert_end()
	{
		System.out.print("Enter the element : ");
		int x = sc.nextInt();
		MyNode n ;
		if(head == null)
		{
			n = new MyNode(x);
			head  = n;
			tail = n;
			tail.next = head;
		}
		else
		{
			n = new MyNode(x);
			n.next  = head;
			tail.next = n;
			tail = n;
		}
	}
	public void display()
	{
		MyNode p = head;
		while(p != tail)
		{
			System.out.print(p.info+"-->");
			p = p.next;
		}
		if(p != null)
			System.out.print(p.info+"-->");
		System.out.println("null");
	}
	public void delete_pos()
	{
		int count = 0;
		System.out.print("Enter pos : ");
		int pos = sc.nextInt();
		MyNode save = head;
		MyNode pred = null;
		while(count < pos-1 && save != tail)
		{
			pred = save;
			save = save.next;
			count++;

		}

		if(count != pos-1)
		{
			System.out.println("Node at specifiy position!!!");
			
		}
		else {
		if(save == null&& pred == null)
		{
			System.out.println("Circular Linked List is Empty!!!");
			return;
		}
		if(head == tail)
		{
			head = null;
			tail = null;
			return;
		}
		if(save == head)
		{
			count++;
			head = head.next;
			tail.next = head;

		}
		else if(save == tail)
		{
			count++;
			tail = pred;
			tail.next = head;
		}
		else
		{
			pred.next = save.next;

		}
		}
	}
}