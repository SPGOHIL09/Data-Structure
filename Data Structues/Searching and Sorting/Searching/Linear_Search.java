public class Linear_Search {
	public static void main(String[] args) {
		int a[] = {1,9,3,6,7,10,2,12,8};
		int num = 7;
		boolean flag = false;
		int i = 0;
		for(i = 0 ; i < a.length ; i++)
		{
			if(a[i] == num)
			{
				flag = true;
				break;
			}
		}
		if(flag) System.out.println("Number is found in the index :"+(i+1));
		else System.out.println("Number is not found");
	}
}
	
