package cache.util;

public class Node<V> {
	
	private Node<V> pre;
	private Node<V> next;
	private V value;
	
	public Node() { }
	
	public Node(V value) {
		this.value = value;
	}
	
	public Node<V> getPre() {
		return pre;
	}
	
	public void setPre(Node<V> pre) {
		this.pre = pre;
	}
	
	public Node<V> getNext() {
		return next;
	}
	
	public void setNext(Node<V> next) {
		this.next = next;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
}
