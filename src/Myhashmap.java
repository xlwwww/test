import java.util.HashMap;
import java.util.Map;

public class Myhashmap<K,V>{
public class Node<K,V> {
    private int hash;
    private K key;
    private V value;
    private Node<K,V> next;
}

    private Node[] table; //桶
    private int size;
    private int length=16;
    private double loadFactor = 0.75;
    public Myhashmap(){
        table = new Node[length];
        this.size = 0;
    }
    public Myhashmap(int initialSize){
        table = new Node[initialSize];
        this.size = 0;
    }
    public Myhashmap(int initialSize,double loadFactor){
        table = new Node[initialSize];
        this.loadFactor = loadFactor;
        this.size = 0;
    }
    public void put(K key,V value){
        int index = Hash(key);
        //创建新节点
        Node<K,V> newn = new Node<>();
        newn.value = value;
        newn.key = key;
        newn.hash = index;
        //创建遍历节点
        Node tmp = table[index];
        Node last = tmp;
        boolean flag = false;
        if (tmp==null){
            table[index] = newn;
        } else{
            while(tmp!=null){
                if(tmp.key.equals(key)){
                    flag = true;
                    tmp.value = value;
                    break;
                } else {
                    last = tmp;
                    tmp = tmp.next;
                }
            }
            if (flag==false){
                last.next=newn;
            }
        }
        size ++;
        if((double)size/length>loadFactor){
            table = resize(table);
        }
    }
    private Node[] resize(Node[] list){
        Node[] newtable = new Node[length*2];
        System.arraycopy(list,0,newtable,0,length);
        length = length*2;
        return newtable;
    }
    private int Hash(K key) {
        int h = key.hashCode();
        h = h ^ (h>>>16);
        return h &(length-1);
    }
    public V get(K key){
        int index = Hash(key);
        Node tmp = table[index];
        while(tmp !=null){
            if (tmp.key.equals(key)){
                return (V)tmp.value;
            } else {
                tmp = tmp.next;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<table.length;i++){
            Node tmp = table[i];
            while (tmp!=null){
                sb.append(tmp.key+" "+tmp.value+"\n");
                tmp = tmp.next;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Myhashmap<Integer,String> map = new Myhashmap<>();
        map.put(1,"abc");
        map.put(17,"def");
        map.put(8,"daslk");
        map.put(1,"asdfadf");
       // System.out.print(map.get(1));
        System.out.print(map);
    }
}