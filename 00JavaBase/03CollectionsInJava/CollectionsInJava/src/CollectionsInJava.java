import java.util.*;

public class CollectionsInJava {

    private static ArrayList<Item> arrayList = new ArrayList<>();
    private static Vector<Item> vector = new Vector<>();
    private static LinkedList<Item> linkedList = new LinkedList<>();
    private static HashSet<Item> hashSet = new HashSet<>();
    private static LinkedHashSet<Item> linkedHashSet = new LinkedHashSet<>();
    private static TreeSet<Item> treeSet = new TreeSet<>();
    private static HashMap<Item, Integer> hashMap = new HashMap<>();
    private static Hashtable<Item, Integer> hashTable = new Hashtable<>();
    private static TreeMap<Item, Integer> treeMap = new TreeMap<>();
    private static LinkedHashMap<Item,Integer> linkedHashMap=new LinkedHashMap<>();
    private static Properties properties = new Properties();

    public static void main(String[] args) {
        Add();
        Read();
    }

    private static void Add() {
        Item item = new Item(1);
        arrayList.add(item);
        vector.add(item);
        linkedList.add(item);
        hashSet.add(item);
        linkedHashSet.add(item);
        treeSet.add(item);
        hashMap.put(item, 1);
        hashTable.put(item, 1);
        treeMap.put(item, 1);
        linkedHashMap.put(item,1);
        properties.setProperty("item", "test");
    }

    private static void Read() {
        Item item = arrayList.get(0);
        System.out.println(item);
        item = vector.get(0);
        System.out.println(item);
        item = linkedList.get(0);
        for (Item i : hashSet) {
            item = i;
        }
        for (Item i : linkedHashSet) {
            item = i;
        }
        for (Item i : treeSet) {
            item = i;
        }
        for (Item i : hashSet) {
            item = i;
        }
        int index = hashMap.get(item);
        System.out.println(index);
        index = hashTable.get(item);
        System.out.println(index);
        index = treeMap.get(item);
        System.out.println(index);
        index=linkedHashMap.get(item);
        System.out.println(index);
        String value = properties.getProperty("item");
        System.out.println(value);
    }


}
