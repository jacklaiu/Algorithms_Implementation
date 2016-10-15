package jacklaiu.search;

/**
 * 顺序查找，基于无序链表
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
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
		//查找给定的键，返回相关联的值
		//return the value which is related to the key
		public Value get(Key key) {
			for(Node x = first; x != null; x = x.next) {
				if(key.equals(x.key)) {
					return x.val;
				}
			}
			return null;
		}
		//查找给定得键，找到则更新值，否则在表中新建节点
		public void put(Key key, Value val) {
			for(Node x = first; x != null; x = x.next) {
				if(key.equals(x.key)) {
					x.val = val;
					return;
				}
			}
			first = new Node(key, val, first);
		}
	}
}
