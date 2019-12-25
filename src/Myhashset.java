import java.util.HashMap;
import java.util.Map;

public class Myhashset<K> {
    Map obj;
    static final Object C = new Object();
    public Myhashset(){
        obj = new HashMap<>();
    }

    public void add(K key){
        obj.put(key,C);
    }
    public int size(){
        return obj.size();
    }
}
