package wb.sample.hashtable;

public class ChainingHashTable<K, V> {
	
	private int tableSize;	
	private int loadFactor = 10;
	private int size = 0;
	private Node<K, V>[] hashTable;
	
	//constructors
	public ChainingHashTable(){
		this(16);
	}
	
	public ChainingHashTable(int size){
		this.tableSize = size;
		hashTable = new Node[size];
		
	}
	
	private int getHash(K key){
		int hash = key.hashCode() % tableSize;
		if(hash < 0) hash += tableSize;
		return hash;
	}
	
	private void resize(int newSize){
		ChainingHashTable<K, V> newTable = new ChainingHashTable<>(newSize);
		for(Node<K, V> entry : hashTable){
			while(entry != null){
				newTable.put(entry.key, entry.value);
				entry = entry.next;
			}
		}
		hashTable = newTable.hashTable;
		tableSize = newTable.tableSize;
	}
	
	public V put(K key, V value){
		int hash = getHash(key);
		/*
		 *If key already exists in the map, the current value of that key
		 *will be returned and the new value will be paired with the key.
		 */
		for(Node<K, V> entry = hashTable[hash]; entry != null; entry = entry.next){
			if((hash == entry.hash) && key.equals(entry.key)){
				V oldValue = entry.value;
				entry.value = value;
				return oldValue;
			}
		}
		/*
		 *If no key was found in the for loop, a new key is added.
		 */
		Node<K,V> entry = new Node<>(key, value, hashTable[hash], hash);
		hashTable[hash] = entry;
		size++;
		if(size >= tableSize * loadFactor){
			resize(size);
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
		
		for(Node<K, V> entry = hashTable[hash]; entry != null; entry = entry.next){
			if(key.equals(entry.key)){
				return entry.value;		
			}
		}
		//if no entry is found
		return null;
	}
	

	
	public V remove(K key){
		int hash = getHash(key);
		Node<K, V> previous = null;
		V value = null;
		
		for(Node<K, V> node = hashTable[hash]; node != null; node = node.next){
			if((hash == node.hash) && key.equals(node.key)){
				if(previous != null){
					value = node.value;
					previous.next = node.next;
				}else {
					hashTable[hash] = node.next;
				}
				size--;
			} else {
				previous = node;
			}
		}
		return value;
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
		Node<K,V> next;
		final int hash;
		
		public Node(K k, V v, Node<K, V> n, int h){
			key = k;
			value = v;
			next = n;
			hash = h;
		}
	}
}
