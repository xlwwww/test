import java.util.*;

public class ADT {
    public static List<String> getWords(String inputFileName){
        List<String> s = new ArrayList<>();
        In in = new In();
        while (in.isEmpty()){
            s.add(in.readString());
        }
        return s;
    }
    public static int countUniqueWords(List<String> list){
        Set<String> s = new HashSet<>();
        for(String a:list){
            s.add(a);
        }
        return s.size();
    }
    public static Map collectWordCount(List<String> targets, List<String> words){
        Map<String,Integer> m = new HashMap<>();
        for (String word: words){
            if (targets.contains(word)){
                if (m.containsKey(word)){
                     m.put(word,m.get(word)+1);
                } else {
                    m.put(word, 1);
                }
            }
        }
        return m;
    }


}

