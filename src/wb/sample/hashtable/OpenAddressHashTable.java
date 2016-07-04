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
			if(entry != null && !entry.isDeleted()){
				newTable.put(entry.key, entry.value);			
			}
		}
		hashTable = newTable.hashTable;
		tableSize = newTable.tableSize;
	}
	/*
	 * Adds a new key-value pair to the hash table;
	 */
	public V put(K key, V value){
		int hash = getHash(key);
		int index = hash;
		Node<K, V> newNode = new Node<>(key, value, hash);
		//check for collisions
		while(hashTable[index] != null){
			//if collision occurs, check if node has been deleted
			//otherwise see if keys match
			if(key.equals(hashTable[index].key)){
				V oldValue = hashTable[index].value;
				hashTable[index] = newNode;
				return oldValue;
			} else if(hashTable[index].isDeleted()){
				break;
			} else {
				index++;
				if(index == tableSize);
				index = 0;
			}
		}
		//if the iteration finds an unused space, insert new node into that space.
		hashTable[index] = newNode;
		size++;
		if(size > loadFactor * tableSize){
			resize(2 * size);
		}
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
		int hash = getHash(key);
		int index = hash;
		
		while(hashTable[index] != null){
			//if collision occurs, check if node has been deleted
			//otherwise see if keys match
			if(hashTable[index].isDeleted() || !key.equals(hashTable[index].key)){
				index++;
				if(index == tableSize) index = 0;
			} else if(key.equals(hashTable[index].key)){
				 return hashTable[index].value;
			}
		}
		
		return null;
	}
	

	
	public V remove(K key){
		int hash = getHash(key);
		int index = hash;
		
		
		while(hashTable[index] != null){
			
			if(key.equals(hashTable[index].key)){
				V removedValue = hashTable[index].value;
				hashTable[index].delete();
				size--;
				return removedValue;
			} else {
				index++;
				if(index == tableSize);
				index = 0;
			}
		}
		//if the iteration finds an unused space, insert new node into that space.
		
		return null;

	}
	
	/* Methods to implement 
	 
	
	public boolean containsKey(K key){
		//TODO return true if hash table contains K as a key
	}
	
	public boolean containsValue(V value){
		//TODO return true if one or more keys points to value
	}
	*/
	
	public int size(){
		return size;
	}
	
	static class Node<K, V> {
		final K key;
		V value;
		final int hash;
		private boolean deleted = false;
		
		public Node(K k, V v, int h){
			key = k;
			value = v;
			hash = h;
		}
		
		public void delete(){
			value = null;
			deleted = true;
		}
		
		public boolean isDeleted(){
			return deleted;
		}
	}
}
