package old.hashing;

import java.util.LinkedList;

public class CustomHashMap {

    public static void main(String[] args) {
        final CustomMap<Integer, Integer> customMap = new CustomMap<>(1);
        customMap.put(1,2);
        customMap.put(1,1);
        customMap.put(1,1);
        customMap.put(3,7);
        customMap.put(3,customMap.get(3) + 4);
        customMap.remove(2);
        System.out.println(customMap.get(2));
        System.out.println(customMap.get(3));
        customMap.remove(3);
        System.out.println(customMap.get(3));
        System.out.println(customMap.get(1));
        System.out.println(customMap.get(1));
        customMap.remove(1);
        System.out.println(customMap.get(1));
    }
}


class CustomMap<K,V>{

    private int size;
    private int capacity;
    LinkedList<CustomPair<K, V>> linkedLists[];

    CustomMap(int size){
        this.size = size;
        this.linkedLists = new LinkedList[size];
        this.capacity = 0;
        initializeLinkList(linkedLists);
    }


    public void put(K key, V value){
        if(isMapCapacityFull())
            increaseMapCapacity();
        int index = getArrayPosition(key);
        LinkedList<CustomPair<K,V>> customMaps = linkedLists[index];
        for (int i=0; i<customMaps.size(); i++){
            if(customMaps.get(i).getKey() == key) {
                capacity++;
                customMaps.get(i).setValue(value);
                return;
            }
        }


        this.linkedLists[index].add(new CustomPair<K,V>(key, value));
        capacity++;
    }

    private void increaseMapCapacity() {
        this.size *= 2;
        LinkedList<CustomPair<K, V>> newLinkedLists[] = new LinkedList[this.size];
        for (int i=0; i<this.capacity; i++)
            newLinkedLists[i] = this.linkedLists[i];

        for(int i= this.capacity; i<this.size; i++)
            newLinkedLists[i] = new LinkedList<>();

        linkedLists = newLinkedLists;
    }

    private boolean isMapCapacityFull() {
        return this.capacity == this.size;
    }

    public LinkedList<CustomPair<K,V>>[] entrySet(){
        return linkedLists;
    }

    private int getArrayPosition(K key) {
        int hashValue = getHashValue(key);
        return hashValue % size;
    }

    public V get(K key){
        int index = getArrayPosition(key);
        for (int i =0; i <linkedLists[index].size(); i++){
            if(linkedLists[index].get(i).getKey() == key)
                return linkedLists[index].get(i).getValue();
        }
        return null;
    }

    public void remove(K key){
        int index = getArrayPosition(key);
        int i=-1;
        for (i=0; i<linkedLists[index].size(); i++) {
            if(linkedLists[index].get(i).getKey() == key) {
                linkedLists[index].remove(i);
                return;
            }
        }
    }

    private int getHashValue(K key) {
        return key.hashCode();
    }

    private void initializeLinkList(LinkedList<CustomPair<K, V>>[] linkedLists) {
        for(int i= 0; i<linkedLists.length; i++)
            linkedLists[i] = new LinkedList<>();
    }

}

class CustomPair<K,V>{
    private K key;
    private V value;


    public CustomPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}