import java.util.*;

public class Solution {
    /*
    Set<Integer> lookup = new HashSet<>();
    String str;
    List<String> list;
    public boolean wordBreak(String s, List<String> wordDict) {
        str = s;
        list = wordDict;
        return dfs(0);
    }
    public boolean dfs(int i){
        if(i==str.length()){
            return true;
        }
        if(lookup.contains(i)) return false;
        for(String word:list){
            //找到了str中存在某个dict中的某word
            if(str.startsWith(word,i)){
                if(dfs(i+word.length())) return true;
                else{
                    lookup.add(i);
                }
            }
        }
        return false;
    }
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length()+1;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i =1;i<n;i++){
            for(int j=0;j<i;j++){
                if (dp[j]==1 && wordDict.contains(s.substring(j,i))){
                        dp[i] = 1;
                        break;
                    }
                }
        }
        return dp[s.length()] == 1;
    }
    char[][] g;
    public int numIslands(char[][] grid) {
        g = grid;
        int ans= 0;

        return ans;
    }
/*
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        if(s.length()==1)
        {return false;}
        Stack ss = new Stack();
        int i = 1;
        ss.push(s.charAt(0));
        while(i<s.length()){
            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                ss.push(s.charAt(i));
            }else{
                if (ss.empty()) {return fas
                char tmp = (char)ss.pop();
                if (!help(tmp,s.charAt(i))) {
                    return false;
                }
            }
            i++;
        }
        if(!ss.empty()) {return false;}
        return true;
    }


 */
    private boolean help(char a, char b){
        if(a=='('){
            if(b==')'){return true;}
        } else if(a == '{'){
            if(b=='}') {return true;}
        } else{
            if (b==']') {return true;}
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ss = new ArrayList<>();
        ss.add("go");
        ss.add("goal");
        ss.add("goals");
        ss.add("special");
        //System.out.println(s.isValid("()"));

    }
}
