public class Solve {
    int[] result = new int[100];
    int cnt =0;
    public void mergesort(int arr[],int l, int r){
        if (l == r){
            return;
        }
        int mid = (l+r)/2;
        mergesort(arr,l,mid);
        mergesort(arr,mid+1,r);
        merge(arr,l,r,mid);
    }
    public void merge(int[] arr,int l ,int r,int mid){
        int s1= l;
        int s2 = mid+1;
        int[] tmp = new int[r-l+1];
        int i=0;
        int k =0;
        while(s1<=mid && s2<=r){
            if (arr[s1]<arr[s2]){
                tmp[i++]=arr[s1];
                s1++;
            }
            else{
                tmp[i++] = arr[s2];
                for (int j = s1;j<=mid;j++) {
                    System.out.print(arr[j] + " ");
                    System.out.print(arr[s2]);
                    System.out.println();
                }
                s2++;
            }
        }
        while (s1<=mid){
            tmp[i++] = arr[s1++];
        }
        while (s2<=r){
            tmp[i++] = arr[s2++];
        }
        for (i = l; i <=r;i++){
            arr[i] = tmp[k++];
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5,0};
        Solve t = new Solve();
        t.mergesort(arr, 0, arr.length - 1);
    }
}
