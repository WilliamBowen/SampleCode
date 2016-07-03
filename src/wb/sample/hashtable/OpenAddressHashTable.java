package wb.sample.hashtable;

import wb.sample.hashtable.ChainingHashTable.Node;

public class OpenAddressHashTable<K, V> {
	private int tableSize;	
	private double loadFactor = 0.75;
	private int size = 0;
	private Node<K, V>[] hashTable;
	
	//constructors
	public OpenAddressHashTable(){
		this(16);
	}
	
	public OpenAddressHashTable(int size){
		this.tableSize = size;
		hashTable = new Node[size];
		
	}
	
	private int getHash(K key){
		int hash = key.hashCode() % tableSize;
		if(hash < 0) hash += tableSize;
		return hash;
	}
	
	private void resize(int newSize){
		OpenAddressHashTable<K, V> newTable = new OpenAddressHashTable<>(newSize);
		for(Node<K, V> entry : hashTable){
			if(entry != null){
				newTable.put(entry.key, entry.value);			
			}
		}
		hashTable = newTable.hashTable;
		tableSize = newTable.tableSize;
	}
	
	public V put(K key, V value){
		//TODO implement open addressing put
		return null;
	}
	/*
	 * Removes all entries from hash table
	 */
	public void clear(){
		for(int i = 0; i < tableSize; i++){
			hashTable[i] = null;
		}
		size = 0;
	}
	
	/*
	 * Returns true if size equals zero
	 */
	public boolean isEmpty(){
		if(size == 0) return true;
		else return false;
	}
	
	public V get(K key){
		//TODO implement open addressing get method
		return null;
	}
	

	
	public V remove(K key){
		//TODO implement open addressing remove method
		return null;
	}
	
	/* Methods to implement 
	 
	
	public boolean containsKey(K key){
		//TODO return true if hash table contains K as a key
	}
	
	public boolean containsValue(V value){
		//TODO return true if one or more keys points to 
	}
	*/
	
	public int size(){
		return size;
	}
	
	static class Node<K, V> {
		final K key;
		V value;
		final int hash;
		
		public Node(K k, V v, int h){
			key = k;
			value = v;
			hash = h;
		}
	}
}
