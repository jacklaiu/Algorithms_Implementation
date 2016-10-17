package jacklaiu.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 顺序查找（基于无序链表）
 * @author jacklaiu
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value> {
	private Node first;
	private class Node {
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, SequentialSearchST<Key, Value>.Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	@SuppressWarnings("unchecked")
	public Key[] keys() {
		List<Object> list = new ArrayList<Object>();
		for(Node x = first; x != null; x = x.next) {
			list.add(x.key);
		}
		Object[] objs = new Object[list.size()];
		return (Key[])objs;
	}
	public boolean contains(Key key) {
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) {
				return true;//命中
			}
		}
		return false;
	}
	public Value get(Key key) {
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) {
				return x.val;//命中
			}
		}
		return null;//未命中
	}
	public void put(Key key, Value val) {
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) {
				x.val = val;
				return;//命中，更新
			}
		}
		first = new Node(key, val, first);//未命中，新建节点
	}

}
