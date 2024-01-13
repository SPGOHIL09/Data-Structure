public class Insertion_Sort {
    public static void main(String[] args) {
        int a[] = {1,9,3,6,2,99,25,4,6,33,6,7,3,34};

        for(int i = 1 ; i < a.length ; i++){
            int curr = a[i];
            int j = i-1;
            while(j >= 0 && curr < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = curr;
        }
        for(int n : a){
            System.out.print(n + " ");
        }
    }
}
