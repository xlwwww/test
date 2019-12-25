import java.util.Stack;

public class My{
    public int[] sort(int arr[]) {
        if (arr == null) {
            return null;
        }
        mergesort(arr, 0, arr.length - 1);
        return arr;
    }
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
            if (arr[s1]>arr[s2]){
                tmp[i++] = arr[s2];
                s2++;
            }
            else{
                tmp[i++] = arr[s1];
                s1++;
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

    //quick sort not recursion
    public void quicksort(int[] arr,int l, int r){
        if (l>r){
            return;
        }
        Stack<Integer> stack  = new Stack();
        stack.push(l);
        stack.push(r);
        while(!stack.empty()){
            r = stack.pop();
            l = stack.pop();
            int[] p=partition(arr,l,r);
            if (l<p[0]-1){
                stack.push(l);
                stack.push(p[0]-1);
            }
            if(r>p[1]+1){
                stack.push(p[1]+1);
                stack.push(r);
            }
        }
    }
    public int[] partition(int[] arr,int l, int r){
        int less = l-1;
        int more = r;
        int cur = l;
        int tmp;
        while(cur < more){
            if (arr[cur]>arr[r]){
                tmp = arr[cur];
                arr[cur] = arr[more-1];
                arr[more-1] = tmp;
                more --;
            }else if(arr[cur]<arr[r]){
                tmp = arr[cur];
                arr[cur] = arr[less+1];
                arr[less+1] = tmp;
                less++;
                cur++;
            }else{
                cur++;
            }
        }
        tmp = arr[r];
        arr[r] = arr[more];
        arr[more] = tmp;
        return new int[]{less+1,more};
    }



    public static void main(String[] args) {
        My t = new My();
        int[] n = new int[]{5,6,3,2,9,0};
        t.quicksort(n,0,n.length-1);
        for (int i =0; i<n.length;i++){
            System.out.print(n[i]+" ");
        }
    }

}

