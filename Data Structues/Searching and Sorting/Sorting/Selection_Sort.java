public class Selection_Sort
{
	public static void main(String[] args) {
		int a[] = {1,9,3,6,7,10,2,12,8,4,5};
		for(int i = 0 ; i < a.length - 1 ; i++)
		{
			int small = i;
			for(int j = i + 1; j < a.length ; j++)
			{
				if(a[small] > a[j])
					small = j;
			}
			int temp = a[small];
			a[small] = a[i];
			a[i] = temp;
		}
		for(int n : a)
			System.out.print(n+" ");
	}
}