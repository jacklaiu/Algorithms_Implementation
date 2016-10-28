package jacklaiu.search;

import jacklaiu.utils.StdOut;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] vals;
	private int N;
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	public int size() {
		return N;
	}
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) return vals[i];
		else return null;
	}
	//基于迭代的rank
	public int rank(Key key) {
		int lo = 0;
		int hi = N-1;
		while(lo <= hi) {
			int mid = lo + (hi - lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0)      hi = mid - 1;
			else if(cmp > 0) hi = mid + 1;
			else return mid;
		}
		return lo;
	}
	public int rank(Key key, int lo, int hi) {
		if(hi < lo) return lo;
		int mid = lo + (hi - lo)/2;
		int cmp = key.compareTo(keys[mid]);
		if(cmp < 0) return rank(key, lo, mid - 1);
		else if(cmp > 0) return rank(key, lo, mid + 1);
		else return mid;
	}
	public void put(Key key, Value val) {
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for(int j = N; j > i; j--) {
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	private boolean isEmpty() {
		if(keys.length == 0) return true;
		else return false;
	}
}
