import java.util.*;
public class QueueImplement
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number index : ");
		int n = sc.nextInt();
		MyQueue q = new MyQueue(n);
		boolean flag  = true;
		while(flag)
		{
			System.out.print("Enter 1 for \'Queue\' \nEnter 2 for \'Dequeue\' \nEnter 3 for \'Display\' \n Enter 4 for \'Break\' :");
			int x = sc.nextInt();
			switch(x)
			{
				case 1 :
					q.fn_enqueue();
					break;
				case 2 : 
					q.fn_dequeue();
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
class MyQueue
{
	Scanner cs = new Scanner(System.in);
	int n;
	int f = -1 , r = -1;
	int arr[];

	MyQueue(int n)
	{
		this.n = n;
		arr = new int[n];
	}

	public void fn_enqueue()
	{
		System.out.print("Enter number to be added : ");
		int x = cs.nextInt();
		r++;
		if(r < n)
		{
			System.out.println("A number is enqueued!!!");
			arr[r] = x;
		}
		else
		{
			System.out.println("A Queue is OverFlow!!!");
		}
		if(r != -1)
		{
			f = 0;
		}
		
	}

	public void fn_dequeue()
	{
		if(f == -1)
		{
			System.out.println("Queue is Empty!!!");
		}
		else
		{
			
			if(f > r)
			{
				f = -1;
				r = -1;
				System.out.println("Queue is Empty!!!");
			}
			else
			{
				arr[f] = 0;
				System.out.println("A number is dequeued!!!");
				f++;
			}

		}

	}
	public void fn_display()
	{
		for(int temp : arr)
		{
			System.out.print(temp+" ");
		}
	}
}