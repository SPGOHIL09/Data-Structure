// 40. Write algorithms to perform following operations on a circular queue:
import java.util.*;
public class CircularQueueImplement
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number index : ");
		int n = sc.nextInt();
		MyCircularQueue q = new MyCircularQueue(n);
		boolean flag = true;
		while(flag)
		{
			System.out.print("Enter 1 for \'Queue\' \nEnter 2 for \'Dequeue\' \nEnter 3 for \'Display\' \n Enter 4 for \'Break\' :");
			int x = sc.nextInt();
			switch(x)
			{
				case 1 :
					q.fn_cqInsert();
					break;
				case 2 : 
					q.fn_cqDelete();
					break;
				case 3 :
					q.fn_display();
					break;
				case 4 :
					flag = false;
					break;
							
			}
			
		}
	}
}

class MyCircularQueue
{
	Scanner cs = new Scanner(System.in);
	int n;
	int f = -1 , r = -1;
	int arr[];
	MyCircularQueue(int n)
	{
		this.n = n;
		arr = new int[n];

	}
	public void fn_cqInsert()
	{
		System.out.print("Enter number to be added : ");
		int x = cs.nextInt();
		
		if(r == n - 1)
			r = 0;
		else 
			r++;
		if(f == r)
			System.out.println("Queue is OverFLow!!!");
		else
		{
			arr[r] = x;
			System.out.println("A number is inserted!!!");

			if(f == -1)
			f = 0;
		}
		

		
	}

	public void fn_cqDelete()
	{

		if(f == -1)
			System.out.println("Queue is UnderFlow");
		else
		{
			arr[f] = 0;
			
		}
		if(f == r)
		{
			f = -1;
			r = -1;
		}
		if(f == n - 1)
		{
			f = 0;

		}
		else 
		{
			f++;
		}
	}
	public void fn_display()
	{
		for(int temp : arr)
		{
			System.out.print(temp+" ");

		}
		System.out.println();
	}
}