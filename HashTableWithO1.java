package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class HashTableWithO1 {

	private HashMap<Integer, Integer> hashMap;
	private ArrayList<Integer> keys;
	private HashMap<Integer, Integer> keyIndexMap;

	public HashTableWithO1(){
		hashMap = new HashMap<Integer, Integer>();
		keys = new ArrayList<Integer>();
		keyIndexMap = new HashMap<Integer, Integer>();
	}
	
	public int get(int key){
		return hashMap.get(key);
	}
	
	public void set(int key, int num){
	
		if (!hashMap.containsKey(key)){
			
			keys.add(key);
			keyIndexMap.put(key, keys.size() - 1);
			
		}
		
		hashMap.put(key, num);
	}
	
	public int getRandom(){
		
		Random rand = new Random();
		int keyIndex = rand.nextInt(keys.size());
		int key = keys.get(keyIndex);
		return hashMap.get(key);
		
	}
	
	public void delete(int key){
		
		if (!hashMap.containsKey(key)){
			return;
		}
		
		int N = keys.size();
		int keyIndex = keyIndexMap.get(key);
		exchValue(keys, keyIndex, N - 1);
		keyIndexMap.put(keys.get(keyIndex), keyIndex);
		keys.remove(N - 1);
		keyIndexMap.remove(key);
		hashMap.remove(key);
	
	}
	
	private void exchValue(ArrayList<Integer> arraylist, int i, int j){
		int temp = arraylist.get(i);
		arraylist.set(i, arraylist.get(j));
		arraylist.set(j, temp);
	}
}
