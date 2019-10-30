package AED.Assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MyHashMap{
	 ArrayList<linkedList> arr;
	int n;
	public MyHashMap() {
        arr = new ArrayList<linkedList>();
        n=10;
        for(int i =0;i<n;i++) {
        	arr.add(null);
        }
    }
	
	class linkedList{
		int key;
		int value;
		linkedList next;
		public linkedList(int key,int value) {
			this.key = key;
			this.value = value;
			
		}
	}
	 /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = hashCode(key);
        linkedList head = arr.get(hashKey); 
   	 linkedList firstNode = new linkedList(key, value);
   	 linkedList newNode = null;
        if(arr.get(hashKey) == null) {
        	 arr.set(hashKey, firstNode);
        }
        else {
       while(head!=null) {
    	   if(head.key == key) {
    		   head.value = value;
    		   return;
    	   }
    	   newNode = head;
    	   head = head.next;
       }
        newNode.next = firstNode;
  // 	 arr.set(hashKey, firstNode);
    }
    }
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int val = hashCode(key);
    	linkedList head = arr.get(val);
    	while(head!=null) {
    		if(head.key == key) {
    			return head.value;
    		}
    		head = head.next;
    		
    	}
    	return -1;
    
    
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int val = hashCode(key);    
    	linkedList head = arr.get(val);
    	linkedList prev = null;
    	while(head!=null) {
    		if(head.key==key) {
    			if(prev!=null) {
    				prev.next = head.next;
    			}
    			else {
    				arr.set(val, head.next);
    			}
    			return;	
    		}
    		prev=head;
    		head = head.next;
    	}
    
    	}
	
	public int hashCode(int key ) {
		return key%n;
	}
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(20, 1);          
		hashMap.put(21, 2);         
		System.out.println(hashMap.get(20));            // returns 1
		System.out.println(hashMap.get(21));            // returns -1 (not found)
		hashMap.put(21, 1);          // update the existing value
		System.out.println(hashMap.get(21));            // returns 1 
		hashMap.remove(21);          // remove the mapping for 2
		System.out.println(hashMap.get(21));            // returns -1 (not found) 
	}
	
}
