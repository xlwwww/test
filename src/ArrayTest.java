import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {

        public void sortColors(int[] nums) {
            int first = -1;
            int last = nums.length;
            int tmp;
            int i = 0;
            while(i<last){
                if(nums[i] == 2){
                    tmp = nums[last-1];
                    nums[last-1] = nums[i];
                    nums[i] = tmp;
                    last --;
                } else if(nums[i]==0){
                    tmp = nums[i];
                    nums[i] = nums[first+1];
                    nums[first+1] = tmp;
                    first++;
                    i++;
                } else{
                    i++;
                }
            }
        }

        public int binarysearch(int[] nums,int key){
            int start = 0;
            int end = nums.length-1;
            int mid = (start+end)/2;
            while(start<=end){
                if(key>nums[mid]){
                    start = mid+1;
                } else if(key<nums[mid]){
                    end = mid-1;
                } else{
                    return mid;
                }
                mid = (start+end)/2;
            }
            return -1;

        }
        /*
        public int[] merge(int start,int end, int[] nums){
            int s1 = start;
            int s2 = end+1;
            int[] ans = new int[nums.length];
            while(s1<s2&&s2<nums.length){
                if(nums[s1]>nums[s2]){

                }
            }
        }
        public void mergesort(int start,int end,int[] nums){
            if(end==start){
                return;
            }
            int mid = (start+end)/2;
            mergesort(0,mid,nums);
            mergesort(mid+1,end,nums);
            merge(start,end/2,nums);
    }

         */

    public static void main(String[] args) {
        ArrayTest a = new ArrayTest();
        int [] s = new int[]{1,3,5,6,7,9};
        /*
        a.sortColors(s);
       for (int i :s){
           System.out.print(i);
           System.out.print(" ");
       }

         */
        System.out.print(a.binarysearch(s,3));
    }
}
