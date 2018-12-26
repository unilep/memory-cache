package util;

public class Node {
	
	private Node pre;
	private Node next;
	private Object value;
	
	public Node() { }
	
	public Node(Object value) {
		this.value = value;
	}
	
	public Node getPre() {
		return pre;
	}
	
	public void setPre(Node pre) {
		this.pre = pre;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
	
}
