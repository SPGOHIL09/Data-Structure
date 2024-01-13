// Implement Queue using LinkedList
import java.util.*;
class MyNode
{
	int info;
	MyNode next;
	MyNode(int info)
	{
		this.info = info;
	}
}


public class QueueLinkedList
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QueueLink q = new QueueLink();
		boolean flag = true;
		while(flag)
		{
			System.out.println("Enter 1 for Enqueue\nEnter 2 for Dequeue\nEnter 3 for Display\nEnter 4 for Break : ");
			int x = sc.nextInt();
			switch(x)
			{
				case 1 :
                        q.insert_end();
                        break;
                case 2 :
                		q.delete_front();
                		break;
                case 3 : 
                		q.display();
                		break;
                case 4 :
                		flag = false;
                		break;				        
			}
		}
	}
}


class QueueLink
{
	Scanner sc = new Scanner(System.in);
	MyNode head,tail;
	int count_node = 0;

	public void insert_end()
	{
		System.out.print("Enter element : ");
        int x = sc.nextInt();
        if(head == null)  // if the first node is null
        {
            MyNode m = new MyNode(x);
            head = m;
            tail = head;
            count_node = 1;
            System.out.println("A Node is Inserted!!!");
            System.out.println();
        }
        else
        {
            MyNode n = new MyNode(x);
            tail.next = n;
            tail = n;
            n.next = null;
            System.out.println("A Node is Inserted!!!");
            System.out.println();
            count_node++;
        }
	}

	public void display()
    {                              //Printig all the node
        MyNode p = head;
        while(p != null)
        {
            System.out.print(p.info+"-->");
            p = p.next;
        }
        System.out.println("null");
        System.out.println("Total number of nodes : "+count_node);
    }
    public void delete_front()
    {
    	if(head == null)
    	{
    		System.out.println("Queue Linked List is Underflow!!!");
    		return;
    	}
    	if(head == tail)
    	{
    		head = null;
    		count_node = 0;
    		System.out.println("Element of Deleted Node : "+head.info);
    		System.out.println("Queue Linked List is Empty!!!");
    		System.out.println();
    	}
    	else
    	{
    		System.out.println("Element of Deleted Node : "+head.info);
    		System.out.println();
    		head = head.next;
    		count_node--;
    	}
    }
}