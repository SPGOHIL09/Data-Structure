public class QuickSort{

    public static int partition(int a[] , int low , int high){
        int curr = a[low];
        int j = high;
        for(int i = j ; i >= low ; i--){
            if(curr < a[i]){
                int temp = a[j];
                a[j] =a[i];
                a[i] =temp;
                j--;
            }
        }
        int temp = a[j];
        a[j] = curr;
        a[low] = temp;
        return j;
    }

    // pivot is first element
    public static void quickSort(int a[] , int low , int high){
        if(low < high){
            int pidx = partition(a, low, high);
            quickSort(a, low, pidx-1);
            quickSort(a, pidx+1, high);
        }  
    }
    public static void main(String[] args) {
        int a[] = {1,9,3,6,2,99,25,4,6,33,6,7,3,34};
        quickSort(a , 0 , a.length-1);
        for(int n : a){
            System.out.print(n + " ");
        }
    }
}