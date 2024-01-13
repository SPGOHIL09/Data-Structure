public class Binary_Search {
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8,9};
		int low = 0 ; 
		int high = a.length - 1;
		int num = 6;
		boolean flag = false;
		while(low <= high)
		{
			int mid = (high + low) / 2;
			if(num < a[mid]) high = mid -1 ; 
			else if (num == a[mid]) {
				flag = false;
				System.out.println("Number is found in index :"+mid);
				return;
			}
			else low = mid + 1;
		}
		System.out.println("Number is not found ");
	}
}