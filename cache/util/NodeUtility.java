package cache.util;

public class NodeUtility<V> {

	private Node<V> head;
	private Node<V> tail;
	
	public NodeUtility() {
		tail = head = new Node<V>();
	}

	public void pushFront(Node<V> node) {
		Node<V> garbage = tail.getPre();
		garbage.setNext(null);
		garbage.setPre(null);
		
		Node<V> currentHeadNext = head.getNext();
		node.setNext(currentHeadNext);
		head.setNext(node);
	}
	
}
