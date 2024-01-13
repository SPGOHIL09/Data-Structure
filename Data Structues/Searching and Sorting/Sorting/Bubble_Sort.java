public class Bubble_Sort
{
	public static void main(String[] args) {
		int a[] = {1,9,3,6,7,10,2,12,8,4,5};
		for(int i = 0 ; i < a.length -1 ; i++)
		{
			for(int j = 0 ; j < a.length-i-1; j++)
			{
				if(a[j] > a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp; 
				}
			}
		}
		for(int n : a)
			System.out.print(n+" ");
	}
}