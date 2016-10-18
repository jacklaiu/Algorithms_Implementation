package jacklaiu.search;

/**
 * 基于二叉查找树的符号表
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {
	//二叉查找树根节点
	private Node root;
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int N;
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	public int size() {
		return size(root);
	}
	public int size(Node x) {
		if(x == null) {
			return 0;
		}else {
			return x.N;
		}
	}
	public Value get(Key key) {
		return null;
	}
	/**
	 * 在以x节点为根节点的字数中查找并返回key所对应的值
	 * 如果找不到则返回null
	 * @param x 根节点
	 * @param key 键
	 * @return 值
	 */
	public Value get(Node x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)      return get(x.left, key);
		else if(cmp > 0) return get(x.right, key);
		else return x.val;
	}
	/**
	 * 找到key，找到则更新他的值，否则为它创建一个新的节点
	 * @param key 键
	 * @param val 值
	 */
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	/**
	 * 如果key存在于以x为根节点的字数中则更新它的值
	 * 否则将以key和val为键值对的新节点插入到该子树中
	 * @param x 根节点
	 * @param key 键
	 * @param val 值
	 * @return
	 */
	private Node put(Node x, Key key, Value val) {
		if(x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0)      x.left = put(x.left, key, val);
		else if(cmp > 0) x.right = put(x.right, key,val);
		else             x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	private Key min() {
		return min(root).key;
	}
	private Node min(Node x) {
		if(x.left == null) return x;
		else return min(x.left);
	}
	private Key max() {
		return max(root).key;
	}
	private Node max(Node x) {
		if(x.right != null) return max(x.right);
		else return x;
	}
	private Key floor(Key key) {
		return floor(root, key).key;
	}
	private Node floor(Node x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		else if(cmp < 0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t != null) return t;
		else 		  return x;
	}
	private Key celling(Key key) {
		return celling(root, key).key;
	}
	private Node celling(Node x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		else if(cmp > 0) return celling(x.right, key);
		Node t = celling(x.left, key);
		if(t != null) return t;
		else          return x;
	}
	private int rank(Key key) {
		return rank(root, key);
	}
	private int rank(Node x, Key key) {
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank(x.left, key);
		else if(cmp > 0) return 1 + size(x.left) + rank(x.right, key);
		else return size(x.left);
	}
}
