//33. Implement a program to convert in-fix notation to post-fix notation using stack.
// and print arthimetic solutions in postfix
import java.util.*;
public class Infix_to_Postfix
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an Infix Expression :");
		String infix = sc.nextLine();
		String postfix = revpol(infix+")");
		System.out.println(postfix);
		// if(postfix != null)
		// {
		// 	evalpost(postfix);
		// }
		// else 
		// 	System.out.println("Incorrect Infix Input");
		
		

	}
	public static int inputprec(char next)
	{
		if(next == '+' || next == '-')
		 {
		 	return 1 ;
		 }
		else if(next == '*'|| next == '/') 
		{
			return 3 ;
		}
		else if(next == '^'|| next == '$') 
		{
				return 6 ;
		}
		else if((next >= 65 && next <= 90) || (next >= 97 && next <= 122) || (next >= 48 && next <= 57))
		 {
		 	return 7 ;
		 }
		else if(next == '(')
		 {
		 	return 9 ;
		 }
		else if(next == ')')
		 {
		 	return 0 ;
		 }

		return -1;
	}

	public static int stackprec(char next)
	{
		if(next == '+' || next == '-')
		 {
		 	return 2 ;
		 }
		else if(next == '*'|| next == '/')
		 {
		 	return 4 ;
		 }
		else if(next == '^'|| next == '$')
		 {
		 	return 5 ;
		 }
		else if((next >= 65 && next <= 90) || (next >= 97 && next <= 122) || (next >= 48 && next <= 57))
		 {
		 	return 8 ;
		 }
		else if(next == '(')
		 {
		 	return 0 ;
		 }

		return -1;
	
	}
	public static int checkrank(char next)
	{
		if(next == '+' || next == '-')
		{
			return -1 ;
		} 
		else if(next == '*'|| next == '/')
		 {
		 	return -1 ;
		 }
		else if(next == '^'|| next == '$')
		 {
		 	return -1 ;
		 }
		else if((next >= 65 && next <= 90) || (next >= 97 && next <= 122) || (next >= 48 && next <= 57))
		 {
		 	return 1 ;
		 }
		else
		return 0;
		
	}
	public static String revpol(String infix)
	{
		Stack<Character> s = new Stack<>();
		String polish = "";
		int rank = 0;
		s.push('(');
		for(int i = 0 ; i < infix.length() ; i++)
		{
			char next  = infix.charAt(i);
				
			if(s.size() < 1)
			{
				System.out.println("Invalid String1");
				return null;
			}

			
			while(stackprec(s.peek()) > inputprec(next))
			{
				char temp = s.pop();
				polish = polish + temp;
				rank = rank + checkrank(temp);
				if(rank < 1)
				{
					
					System.out.println("Invalid String2");
					return null;
				}

			}
			if(stackprec(s.peek()) != inputprec(next))
			{
				s.push(next);
			}
			else
			{
				s.pop();
			}

			
		}
		if(rank != 1)
		{
			System.out.println("Invalid String3");
			return null;
		}
		else
		{
			return polish;
		}
	}
	public static void evalpost(String postfix)
	{
		Stack<Integer> s2 = new Stack<>();
		int value = 0 ;
		int n = postfix.length();
		for(int i = 0 ; i < n ; i++)
		{
			char temp = postfix.charAt(i);
			if(Character.isDigit(temp))
			{
				int temp2 = Character.getNumericValue(temp);
				s2.push((temp2));
			}
			else
			{
				double op2 = s2.pop();
				double op1 = s2.pop();
				double ans = operations(op1,op2,temp);
				s2.push((int)ans);

			}
		}
		if(s2.size() == 1)
		{
			System.out.println(s2);
		}
		else
			System.out.println("Invalid Operation");
	}
	public static double operations(double op1, double op2, char temp)
	{
		switch(temp)
		{
		case '+' :
			return (op1 + op2);
		case '-' :
			return (op1 - op2);
		case '*' :
			return (op1 * op2);
		case '/' :
			return (op1) / (float)op2;
		case '^' :
			return (Math.pow(op1,op2));
		default : return 0;			
		}
	}
}
