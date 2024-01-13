// 46. Implement a program to create a node for singly nexted list. Read the data in a 
//node, print the node.
import java.util.*;
public class  LinkedListImplement
{
	public static void main(String[] args) {
		Scanner cs = new Scanner(System.in);
		SLL ss = new SLL();
		ss.createLL();
		ss.display();
		boolean flag = true;
		while(flag)
		{
			System.out.println("Enter 1 for Insert from Front\n2 for Insert from End\n3 for Insert in Sorted Order\n4 for Delete from First\n5 for Delete from Last\n6 for Delete from Position\n7 for Display\n8 for break :");
			int a = cs.nextInt();
			switch(a)
			{
				case 1 : 
					ss.insertFront();
					break;
				case 2 :
					ss.insertEnd();
					break;
				case 3 :
					ss.insertsord();
					break;
				case 4 : 
					ss.delete_first();
					break;
				case 5 : 
					ss.delete_last();
					break;
				case 6 : 
					ss.delete_pos();
					break; 		
				case 7 :
					ss.display();
					break;	
				case 8 :
					flag = false;
					break;		
			}
		}

	}
}
class MyNode2
{
	int data;
	MyNode2 next;
	MyNode2(int data)
	{
		this.data = data;
	}
}

class SLL
{
	MyNode2 head;
	MyNode2 tail;
	int count = 0;
	Scanner sc  = new Scanner(System.in);
	MyNode2 createLL()
	{
		int x = sc.nextInt();
		while(x != -1)
		{
			
			if(head == null)
			{
				head = new MyNode2(x);
				tail = head;
				count = 1;
				x = sc.nextInt();
				continue;
			}
			
			/*if(x == -1)
			{
				break;
			}*/
			MyNode2 newNode = new MyNode2(x);
			tail.next = newNode;
			tail = tail.next;
			count++;
			x = sc.nextInt();
			
		}
		return head;
	}
	void display()
	{
		MyNode2 temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+"-->");
			temp = temp.next;
			
		}
		System.out.println("null");
	}
	// void insert(int x, int pos)
	// {
	// 	MyNode2 temp2 = head;
	// 	if(pos == 1)
	// 	{
	// 		MyNode2 temp4 = new MyNode2(x);
	// 		temp4.next = head;
	// 		head  = temp4;
	// 		return;
	// 	}
	// 	for(int i = 1 ; i < pos-1 ; i++)
	// 	{
	// 		temp2 = temp2.next;
	// 	}
	// 	MyNode2 temp3 = new MyNode2(x);
	// 	temp3.next  = temp2.next;
	// 	temp2.next = temp3; 

	// }
	public void insertFront()
	{
		Scanner sc = new Scanner(System.in);
		MyNode2 n ;
		System.out.print("Enter the element : ");
		int x = sc.nextInt();
		n = new MyNode2(x);
		n.next = head;
		head = n;
		
	}
	public void insertEnd()
	{
		Scanner sc = new Scanner(System.in);
		MyNode2 n;
		System.out.print("Enter an element : ");
		int x = sc.nextInt();
		n = new MyNode2(x);
		MyNode2 m = head;
		tail.next = n;
		n.next = null;
		tail = n;
		// while(m.next != null)
		// {
		// 	m = m.next;
		// }
		// m.next = n;
		// n.next = null;
		
	}
	// public void LLsort()
	// {
	// 	MyNode2 save,p;
	// 	p = head;
	// 	while(p.next != null)
	// 	{
	// 		save = p.next;
	// 		while(save.next != null)
	// 		{
	// 			if(p.data > save.data)
	// 			{
	// 				int b = p.data;
	// 				p.data = save.data;
	// 				save.data = b;
	// 			}
	// 			save = save.next;
	// 		}
	// 		p = p.next;
			
	// 	}
	// }
	public void insertsord()
	{
		Scanner sc = new Scanner(System.in);

		MyNode2 m,n,save;
		System.out.println("Enter an element : ");
		int x = sc.nextInt();
		m = new MyNode2(x);
		if(head == null)
		{
			m.next = null;
			head = m;
		}
		if(m.data <= head.data)
		{
			m.next = head;
			head = m;
		}
		save = head;
		n = save.next;
		while(n.next != null && m.data >= n.data)
		{
			save = save.next;
			n = save.next;
		}
		m.next = save.next;
		save.next = m;
		
	}
	public void delete_first()
	{
		if(head == null)
		{
			System.out.println("Linked List is Empty!!!");

		}
		else {
			head  = head.next;
		}
	}
	public void delete_last()
	{
		MyNode2 save = head;
		

		if(head == null)
		{
			System.out.println("Linked List is Empty!!!");
		}
		while(save.next != tail )
		{
			save = save.next;
		}
		tail = save;
		save.next = null;
	}
	public void delete_pos()
	{
		System.out.print("Enter position : ");
		int pos = sc.nextInt();
		int count2 = 0;
		MyNode2 save=head;
		MyNode2 pred = null;
		while(count2 != pos-1 && save.next != tail)
		{
			pred = save;
			save=save.next;
			count2++;
			
		}
		if(count2 == pos-1)
		{
			pred.next = save.next;
			save.next  = null;
		}
		else
		{
			System.out.println("Position does not found!!!");
			
		}

	}

}