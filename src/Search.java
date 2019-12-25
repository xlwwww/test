import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Search {
    Set<State> dict = new HashSet<>();
    public void dfs(State state,ArrayList<State> ans){
        if (state.isGoal()){
            for(State i : ans){
                System.out.println(i);
            }
            System.out.println("================================");
            return;
        }
        /*if(dict.contains(state)){
            return;
        }
         */
        for(State i : state.successors()){
            if(ans.contains(i)){
                continue;
            }
            ans.add(i);
            dfs(i,ans);
            ans.remove(ans.size()-1);
        }
        //dict.add(state);
        return;
    }

    public static void main(String[] args) {
        Search s = new Search();
        State init = new State(3,3,1);
        ArrayList<State> ans = new ArrayList<>();
        ans.add(init);
        s.dfs(init,ans);
    }
}
