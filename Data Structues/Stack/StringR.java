// . How stack can be used to recognize strings aca, bcb, abcba, abbcbba? Implement a program

import java.util.*;

public class StringR

{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String :");
		String str = sc.nextLine();
		StringRecognize s1 = new StringRecognize(str + " ");
		 
		if(s1.rev())
			System.out.println("Valid String");
		else 
			System.out.println("Invalid String");
	}
}
 class StringRecognize
{
	String str ;
	StringRecognize(String str)
	{
		this.str = str;
	}
	public boolean rev()
	{
		Stack<Character> s = new Stack<>();
		int n = str.length();
		int i = 0;
		char ch = str.charAt(0);
		while(ch != 'c')
		{
			s.push(ch);
			i++;
			ch = str.charAt(i);
			if(ch == ' ')
			{
				return false;
			}
		}

		char x;
		while(!s.isEmpty())
		{
			i++;
			ch = str.charAt(i);
			 x = s.pop();
			if(ch != x)
			{
				return false ;
			}
			
		}
		ch = str.charAt(i+1);
		if(ch == ' ')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}