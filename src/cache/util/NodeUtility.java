package cache.util;

import java.util.Optional;

public class NodeUtility {

	private Node head;
	private Node tail;

	public void pushFront(Node node) {
		Node pre = node.getPre();
		if(pre != null) {
			pre.setNext(node.getNext());
		}
		Node next = node.getNext();
		if(next != null) {
			next.setPre(node.getPre());
		}
		
		Optional.ofNullable(head).ifPresent(n -> {
			node.setNext(n);
			n.setPre(node);
		});
		head = node;
		if(tail == null) tail = node;
	}
	
	public Node popTail() {
		Node preTail = tail.getPre();
		tail.setPre(null);
		preTail.setNext(null);
		return tail = preTail;
	}
	
	public String retriveHeadToTail() {
		Node node = head;
		StringBuilder sb = new StringBuilder();
		while(node != null) {
			sb.append(node.getValue());
			sb.append("\n");
			node = node.getNext();
		}
		return sb.toString();
	}
	
}
